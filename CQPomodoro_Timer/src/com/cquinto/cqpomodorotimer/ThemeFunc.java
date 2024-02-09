package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class ThemeFunc {

    DarkUI toggleDark = new DarkUI(); //Gets the instance of the DarkUI class
    LightUI toggleLight = new LightUI(); //Gets the instance of the DarkUI class

    public void toggleTheme(JLayeredPane layeredPane, JButton themeButton, boolean lightMode){
        themeButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(lightMode){ //If the user clicks the button and currently in the light mode state, the UI will become dark
                    layeredPane.removeAll(); //Removes all the layers in the layered pane
                    toggleDark.setUpDarkUI(layeredPane); //Sets the Dark UI after removal
                }
                else{ //If the user clicks the button and currently not in the light mode state, the UI will become light
                    layeredPane.removeAll();
                    toggleLight.setUpLightUI(layeredPane);
                }
            }
        });

        themeButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                themeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                themeButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}

