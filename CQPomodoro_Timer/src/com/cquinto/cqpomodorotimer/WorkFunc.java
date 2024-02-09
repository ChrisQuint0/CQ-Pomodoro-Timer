package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WorkFunc{
    PTimer pTimer; //Declares the pTimer variable in this scope

    public WorkFunc(PTimer pTimer){ //Sets the timer variable to the intended timer in the Ptimer class
        this.pTimer = pTimer;
    }

    public void workFunc(Timer timer, JButton workButton){
        workButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                pTimer.resetTimer(25); //Resets the timer to 25 minutes (Work Session)
            }
        });

        workButton.addMouseListener(new MouseAdapter() { //Turns the cursor to a hand pointer
            @Override
            public void mouseEntered(MouseEvent e) {
                // Set the cursor to hand when mouse enters the button
                workButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Set the default cursor when mouse exits the button
                workButton.setCursor(Cursor.getDefaultCursor());
            }
        });
    }

}

