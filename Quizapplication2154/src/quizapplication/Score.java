
package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;

public class Score extends JFrame implements ActionListener {
    JButton reviewButton;
    JButton playAgainButton;
    Queue<String> answers;

    // Constructor for full functionality
    Score(String name, int score, Queue<String> answers) {
        this.answers = answers; // Store answers for later use
        setupUI(name, score);
    }

    // Simplified constructor for standalone testing
    Score(String name, int score) {
        this.answers = new LinkedList<>(); // Placeholder for testing
        this.answers.add("Answer 1");
        this.answers.add("Answer 2");
        this.answers.add("Answer 3");
        setupUI(name, score);
    }

    // Setup UI shared by both constructors
    private void setupUI(String name, int score) {
        setBounds(300, 150, 750, 600);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Set image as background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/scoer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(750, 550, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 750, 550);
        add(image);

        // Add components on top of the image
        JLabel heading = new JLabel("Thank You " + name + " For Playing Brain Bolt");
        heading.setBounds(100, 50, 600, 40);
        heading.setFont(new Font("Tahoma", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        image.add(heading);

        JLabel lblscore = new JLabel("Your Score is: " + score);
        lblscore.setBounds(275, 260, 300, 30);
        lblscore.setFont(new Font("Tahoma", Font.BOLD, 26));
        lblscore.setForeground(Color.YELLOW);
        image.add(lblscore);

        playAgainButton = new JButton("Play Again!");
        playAgainButton.setBounds(200, 342, 340, 85);
        playAgainButton.setFont(new Font("Tahoma", Font.BOLD, 30));
        playAgainButton.setBackground(new Color(128, 0, 128));
        playAgainButton.setForeground(Color.WHITE);
        playAgainButton.addActionListener(this);
        image.add(playAgainButton);

        reviewButton = new JButton("Review");
        reviewButton.setBounds(200, 430, 340, 40);
        reviewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        reviewButton.setBackground(new Color(255, 165, 0));
        reviewButton.setForeground(Color.WHITE);
        reviewButton.addActionListener(this);
        image.add(reviewButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == playAgainButton) {
            setVisible(false);
            new Login(); // Assuming Login is the class for the login screen
        } else if (ae.getSource() == reviewButton) {
            setVisible(false);
            new ReviewWindow(answers); // Open the review window to show answers
        }
    }

    public static void main(String[] args) {
        // For standalone testing
        new Score("Test User", 50);
    }
}
