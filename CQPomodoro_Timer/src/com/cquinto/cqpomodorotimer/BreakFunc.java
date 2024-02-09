package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BreakFunc {
    PTimer pTimer; //Declaring the timer variable

    public BreakFunc(PTimer pTimer){ //Setting the value of the timer in this class to the intended timer
        this.pTimer = pTimer;
    }

    public void breakFunc(Timer timer, JButton breakButton){
        breakButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pTimer.resetTimer(5); //Sets the timer to 5 minutes (Break session)

                pTimer.timer.stop(); //Stops the timer
            }
        });

        breakButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                breakButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                breakButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }


}

