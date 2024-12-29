
package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Queue;
import java.util.LinkedList;
   

public class ReviewWindow extends JFrame implements ActionListener {

    JButton backButton;
    private Queue<String> answers; // This will store the user's answers.

    // Constructor to receive answers from Score class
    ReviewWindow(Queue<String> answers) {
        this.answers = answers;

        setBounds(200, 150, 950, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Set background image (same as in Score class or any image you prefer)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/review.jpg")); // Replace with your image path
        Image i2 = i1.getImage().getScaledInstance(750, 550, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 600, 550);
        add(image);

        // Add a heading label
        JLabel heading = new JLabel("Your Answers:");
        heading.setBounds(650, 50, 600, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(Color.BLACK);
        add(heading);

        // Display answers from the queue
        int yPos = 150;
        for (String answer : answers) {
            JLabel answerText = new JLabel(answer);
            answerText.setBounds(650, yPos, 600, 30);
            answerText.setFont(new Font("Tahoma", Font.PLAIN, 18));
            answerText.setForeground(Color.BLACK);
            add(answerText);
            yPos += 40;
        }

        // Add the "Back" button to go back to the Score window
        backButton = new JButton("Back");
        backButton.setBounds(130, 364, 340, 45);
        backButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
        backButton.setBackground(new Color(255, 99, 71));
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        image.add(backButton);

        setVisible(true);
    }

    // Action listener for the back button
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Score("User", 0, answers); // Reopen the Score window (you may need to pass correct arguments)
    }

    public static void main(String[] args) {
        // Just for testing, create an example queue and open the ReviewWindow
        Queue<String> testAnswers = new LinkedList<>();
        testAnswers.add("A");
        testAnswers.add("C");
        testAnswers.add("B");

        new ReviewWindow(testAnswers); // Open the ReviewWindow with example answers
    }
}
