// Importing necessary classes from the javax.swing package
package com.cquinto.cqpomodorotimer;
import javax.swing.*;

public class Main extends JFrame {

    // Declaring a JLayeredPane for managing components in layers
    protected JLayeredPane layeredPane;

    // Constructor for the Main class
    public Main() {
        setTitle("CQ Pomodoro Timer");
        setSize(800, 600);
        setResizable(false); // Making the JFrame not resizable
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // When the User Clicked Close, The Window will Close
        layeredPane = new JLayeredPane(); // Creating a JLayeredPane to manage layers of components
        setContentPane(layeredPane); // Setting the content pane of the JFrame to the JLayeredPane

        //Default UI at Start Up
        LightUI lightUI = new LightUI(); // Creating an instance of the LightUI class
        lightUI.setUpLightUI(layeredPane);

        setVisible(true); // Setting the JFrame to be visible
    }

    // Main method to launch the application
    public static void main(String[] args) {
        // Using SwingUtilities.invokeLater to run the GUI code on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Creating an instance of the Main class to start the application
                new Main();
            }
        });
    }
}
