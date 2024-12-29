
package quizapplication;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{
    
    JButton rules , back ;
    JTextField tfname;
    Login (){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/qt.jpg"));
        Image scaledImage = i1.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        // Add the scaled image to JLabel
        JLabel image = new JLabel(scaledIcon);
        image.setBounds(0, 0, 600, 500);
        add(image);
        
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/qt.jpg"));
//        JLabel image = new JLabel (i1);
//        image.setBounds(0 , 0 , 600 , 500);
//        add(image);
        
        JLabel heading = new JLabel ("    Brain Bolt");
        heading.setBounds(750 , 60 , 300 , 45);
        heading.setFont(new Font ("Viner Hand ITC " , Font.BOLD , 40));
        heading.setForeground(new Color (30 , 144 , 254));
        add(heading);
        
        JLabel name = new JLabel ("Enter Your Name :");
        name.setBounds(810 , 150 , 300 , 20);
        name.setFont(new Font ("Mongolian Baiti " , Font.BOLD , 18));
        name.setForeground(new Color (30 , 144 , 254));
        add(name);
        
        tfname = new JTextField ();
        tfname.setBounds(735 , 200 , 300 , 25);
        tfname.setFont(new Font ("Times New Roman " , Font.BOLD , 20));
        add(tfname);
        
        rules = new JButton ("Rules");
        rules.setBounds(735 , 270 , 120 , 30);
        rules.setFont(new Font ("Mongolian Baiti " , Font.BOLD , 20));
        rules.setBackground(new Color (30 , 144 , 254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton ("Back");
        back.setBounds(915 , 270 , 120 , 30);
        back.setFont(new Font ("Mongolian Baiti " , Font.BOLD , 20));
        back.setBackground(new Color (30 , 144 , 254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        
        setSize(1200 , 500);
        setLocation (60 , 200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae ){
        if (ae.getSource() == rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules(name);
            
        }else if (ae.getSource() == back){
            setVisible(false);
            
        }
        
    }
    
    public static void main (String [] arg){
        
        new Login();
        
    }
    
}
