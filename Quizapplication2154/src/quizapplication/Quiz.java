
package quizapplication;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.Queue;

public class Quiz extends JFrame implements ActionListener {

    String[][] questions = {
        {"What is the capital of France?", "Paris", "London", "Rome", "Berlin", "A"},
        {"Which programming language is known as 'write once, run anywhere'?", "Python", "C++", "Java", "Ruby", "C"},
        {"What is the largest planet in our solar system?", "Earth", "Mars", "Jupiter", "Saturn", "C"},
        {"Who wrote 'Hamlet'?", "Shakespeare", "Dickens", "Chaucer", "Austen", "A"},
        {"Which element has the chemical symbol O?", "Gold", "Oxygen", "Silver", "Osmium", "B"}
    };

    // Queue to store user answers
    Queue<String> userAnswersQueue = new LinkedList<>();
    int currentQuestion = 0; // Track the current question index
    int score = 0;

    JLabel questionLabel, option1, option2, option3, option4;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup optionsGroup;
    JButton next, submit;

    Quiz() {
        setBounds(50, 45, 1200, 750);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/test.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(1200, 392, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Add the scaled image to the JLabel
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 1200, 392);
        add(image);

        // Question Label
        questionLabel = new JLabel("");
        questionLabel.setBounds(100, 450, 700, 50);
        questionLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
        add(questionLabel);

        // Option Buttons
        opt1 = new JRadioButton("");
        opt1.setBounds(170 , 520 , 600 , 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font ("Dialog" , Font.PLAIN , 20 ));
        add(opt1);

        opt2 = new JRadioButton("");
        opt2.setBounds(170 , 560 , 600 , 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font ("Dialog" , Font.PLAIN , 20 ));
        add(opt2);

        opt3 = new JRadioButton("");
        opt3.setBounds(170 , 600 , 600 , 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font ("Dialog" , Font.PLAIN , 20 ));
        add(opt3);

        opt4 = new JRadioButton("");
        opt4.setBounds(170 , 640 , 600 , 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font ("Dialog" , Font.PLAIN , 20 ));
        add(opt4);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(opt1);
        optionsGroup.add(opt2);
        optionsGroup.add(opt3);
        optionsGroup.add(opt4);

        // Next Button
        next = new JButton("Next");
        next.setBounds(800 , 550 , 200 , 40);
        next.setFont(new Font ("Tohoma" , Font.PLAIN , 22));
        next.setBackground(new Color(30, 144, 254));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        // Submit Button
        submit = new JButton("Submit");
        submit.setBounds(800 , 620 , 200 , 40);
        submit.setFont(new Font ("Tohoma" , Font.PLAIN , 22));
        submit.setBackground(new Color(30, 144, 254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        displayQuestion();

        setVisible(true);
    }

    public void displayQuestion() {
        // Set question and options from the 2D array
        questionLabel.setText((currentQuestion + 1) + ". " + questions[currentQuestion][0]);
        opt1.setText(questions[currentQuestion][1]);
        opt2.setText(questions[currentQuestion][2]);
        opt3.setText(questions[currentQuestion][3]);
        opt4.setText(questions[currentQuestion][4]);
        optionsGroup.clearSelection();
    }
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        // Save user's answer to the queue
        String userAnswer = "";
        if (opt1.isSelected()) userAnswer = "A";
        else if (opt2.isSelected()) userAnswer = "B";
        else if (opt3.isSelected()) userAnswer = "C";
        else if (opt4.isSelected()) userAnswer = "D";

        userAnswersQueue.add(userAnswer);  // Add to queue

        // Check answer and calculate score
        if (userAnswer.equals(questions[currentQuestion][5])) {
            score += 10; // Assign 10 points for a correct answer
        }

        currentQuestion++;

        // Disable "Next" on the last question and enable "Submit"
        if (currentQuestion == questions.length) {
            next.setEnabled(false); // Disable "Next"
            submit.setEnabled(true); // Enable "Submit"
        } else {
            displayQuestion(); // Show the next question
        }
    } else if (ae.getSource() == submit) {
        // Handle quiz submission
        setVisible(false);
        new Score("User", score, userAnswersQueue); // Pass score and queue to Score class
    }
}


    




    public static void main(String[] args) {
        new Quiz();
    }
}
