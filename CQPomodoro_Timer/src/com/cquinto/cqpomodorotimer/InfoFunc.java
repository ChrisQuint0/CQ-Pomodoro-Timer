package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InfoFunc {

    JLabel backgroundLabel; //Declaring the variable of the info to be displayed (The info is also an image)
    JLabel backgroundLabelDark;
    boolean infoOn; //Boolean for switching checks

    public void infoFunc(JButton infoButton, JLayeredPane layeredPane, boolean lightMode){ //Gets the lightMode boolean to the LightUI/ DarkUI class
        infoButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if (infoOn) { // If info is currently displayed, remove it
                    if(lightMode){
                        layeredPane.remove(backgroundLabel); //Removes the info image
                        infoOn = false;
                    }
                    else{
                        layeredPane.remove(backgroundLabelDark);
                        infoOn = false;
                        System.out.println("Info Removed Dark");
                    }

                } else { // If info is not displayed, show it
                    if(lightMode){ //If lightMode = true, display the lightMode info
                        ImageIcon backgroundImage = new ImageIcon("resources/assets/CQP Info.png");
                        backgroundLabel = new JLabel(backgroundImage);
                        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
                        layeredPane.add(backgroundLabel, Integer.valueOf(3));
                        infoOn = true;
                    }
                    else{ //If lightMode is false, display the darkMode info
                        ImageIcon backgroundImageDark = new ImageIcon("resources/assets/CQP Info Dark.png");
                        backgroundLabelDark = new JLabel(backgroundImageDark);
                        backgroundLabelDark.setBounds(0, 0, backgroundImageDark.getIconWidth(), backgroundImageDark.getIconHeight());
                        layeredPane.add(backgroundLabelDark, Integer.valueOf(3));
                        infoOn = true;
                    }


                }

                // Revalidating and repaint after modifying the layeredPane
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

        infoButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                infoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                infoButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
