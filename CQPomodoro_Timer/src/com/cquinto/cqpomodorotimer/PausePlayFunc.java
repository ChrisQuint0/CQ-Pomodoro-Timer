package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class PausePlayFunc {
    private boolean isTimerRunning; //Declaring the variable to check if the timer is running

    public void pausePlayFunc(Timer timer, JButton playPauseButton, ImageIcon scaledIcon, ImageIcon pauseIconScaled){
        playPauseButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(isTimerRunning){
                    timer.stop();
                    isTimerRunning = false;
                    playPauseButton.setIcon(scaledIcon); //Sets the icon to play icon
                }
                else {
                    timer.start();
                    playPauseButton.setIcon(pauseIconScaled); //Sets he icon to pause icon
                    isTimerRunning = true;
                }
            }
        });

        playPauseButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                playPauseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                playPauseButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }
}
