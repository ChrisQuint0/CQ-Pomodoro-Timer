package com.cquinto.cqpomodorotimer;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class PTimer {
    //Variables
    Timer timer;
    private JLabel timerLabel;
    int minutes;
    int seconds;
    boolean isTimerRunning;
    boolean onBreak;

    private int sessionCount;
    private Clip clip;

    //Constructor for the timer
    public PTimer(){
        onBreak = false;
        sessionCount = 0;
        minutes = 25;
        seconds = 0;
    }

    public void timer(JLayeredPane layeredPane, JButton playPauseButton, ImageIcon scaledIcon){
        //Displays the timer to the screen
        timerLabel = new JLabel("25:00"); //Timer Display set to 25:00 initially
        timerLabel.setBounds(250, 240, 400, 118); //Timer Display Positioning

        //Sets the font of the timer (Font type, font size)
        try{
            Font timerFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/assets/Fonts/static/LeagueSpartan-Bold.ttf"));
            timerFont = timerFont.deriveFont(Font.PLAIN, 120);
            timerLabel.setFont(timerFont);
        } catch(FontFormatException | IOException e){
            e.printStackTrace();
        }

        timerLabel.setForeground(Color.WHITE); //Sets the color of the timer display(White)

        //Timer
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(minutes == 0 && seconds == 0){ //If the timer is done
                    playAudio("resources/assets/Audio/TimerDone.wav"); //Play the notification audio
                    timer.stop();
                    playPauseButton.setIcon(scaledIcon);

                    if(!onBreak){ //The timer finished a session
                        sessionCount++; //Add the session count by 1

                        Object[] options = {"Start Break"}; //Array for custom button message for notification. Instead of "OK", it's set to "Start break"
                        JOptionPane.showOptionDialog(null, sessionCount + " Session Completed!", "Well Done!",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]); //Sets the notification message
                    }
                    else { //If the timer finished a break
                        Object[] options = {"Start Work"}; //Array for custom button message for notification. Instead of "OK", it's set to "Start Work"
                        JOptionPane.showOptionDialog(null, "Break Completed, Time for Work", "Get Back to Work",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                    }

                    if(sessionCount % 4 == 0){ //Every four completed work sessions, the user will be rewarded with a long break
                        resetTimer(20); //Break is 20 minutes
                        onBreak = true;
                    }
                    else {
                        if(!onBreak){
                            resetTimer(5); //If the user has not completed four sessions yet, the user will be rewarded with a short break after every work session
                            timer.stop();
                            onBreak = true;
                        }
                        else{
                            resetTimer(25); //After a break it goes back to work session
                            onBreak = false;
                        }
                    }
                }
                else{
                    updateTimerLabel(); //Updates the timer label
                    if(seconds == 0){
                        minutes--; //If seconds = 0 the minutes will be decreased
                        seconds = 59;
                    }
                    else{
                        seconds--; //Continuously decreases the timer as the timer runs
                    }
                }
            }
        });

        isTimerRunning = false;

        layeredPane.add(timerLabel, Integer.valueOf(2)); //Adds the timer display to the layered pane

        updateTimerLabel(); //Updates the timer label

    }
    private void updateTimerLabel(){ //Formats the timer label to the formatted time
        String formattedTime = String.format("%02d:%02d", minutes, seconds);
        timerLabel.setText(formattedTime);
    }
    public void resetTimer(int  newMinutes){ //Method responsible for resetting the timer to the desired minutes
        minutes = newMinutes;
        seconds = 0;
        updateTimerLabel(); //Calls the method to update the timer label to the newMinutes
    }

    private void playAudio(String filePath) { //Plays the notification audio
        try {
            File audioFile = new File(filePath); //Loads the filePath
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile); //Gets the audio input stream

            clip = AudioSystem.getClip(); //Gets the clip
            clip.open(audioStream); //Opens it
            clip.start(); //Starts it
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) { //Exception handling for errors
            ex.printStackTrace();
        }
    }
}

