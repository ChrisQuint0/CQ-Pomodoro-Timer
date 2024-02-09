package com.cquinto.cqpomodorotimer;

import javax.swing.*;
import java.awt.*;

public class DarkUI{
    private JButton playPauseButton;
    private JButton workButton;
    private JButton breakButton;
    private JButton themeButton;
    private JButton infoButton;

    private ImageIcon playIcon;
    private ImageIcon pauseIcon;
    private ImageIcon workIcon;
    private ImageIcon breakIcon;
    private ImageIcon themeIcon;
    private ImageIcon infoIcon;

    public void setUpDarkUI(JLayeredPane layeredPane){
        //Getting the background image from the resources directory
        ImageIcon backgroundImage = new ImageIcon("resources/assets/CQP Background.png");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight()); //Background image positioning

        layeredPane.add(backgroundLabel, Integer.valueOf(1)); //Adding the background image to the layered pane

        //Getting the button images from the resources directory
        playIcon = new ImageIcon("resources/assets/playButton.png");
        pauseIcon = new ImageIcon("resources/assets/pauseButton.png");
        workIcon = new ImageIcon("resources/assets/workButton.png");
        breakIcon = new ImageIcon("resources/assets/breakButton.png");
        themeIcon = new ImageIcon("resources/assets/theme.png");
        infoIcon = new ImageIcon("resources/assets/info.png");


        //Scaling of button image icons to the intended size
        Image image = playIcon.getImage();
        Image scaledImage = image.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        Image pauseIconImage = pauseIcon.getImage();
        Image pauseIconScaledImage = pauseIconImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon pauseIconScaled = new ImageIcon(pauseIconScaledImage);

        Image workIconImage = workIcon.getImage();
        Image workIconScaledImage = workIconImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon workIconScaled = new ImageIcon(workIconScaledImage);

        Image breakIconImage = breakIcon.getImage();
        Image breakIconScaledImage = breakIconImage.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon breakIconScaled = new ImageIcon(breakIconScaledImage);

        Image themeIconImage = themeIcon.getImage();
        Image themeIconImageScaled = themeIconImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon themeIconScaled = new ImageIcon(themeIconImageScaled);

        Image infoIconImage = infoIcon.getImage();
        Image infoIconImageScaled = infoIconImage.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon infoIconScaled = new ImageIcon(infoIconImageScaled);

        //Setting the properties of the buttons(No border, no fill, just pure image icon)
        playPauseButton = new JButton(scaledIcon);
        playPauseButton.setBorder(BorderFactory.createEmptyBorder());
        playPauseButton.setContentAreaFilled(false);
        playPauseButton.setBorderPainted(false);

        workButton = new JButton(workIconScaled);
        workButton.setBorder(BorderFactory.createEmptyBorder());
        workButton.setContentAreaFilled(false);
        workButton.setBorderPainted(false);

        breakButton = new JButton(breakIconScaled);
        breakButton.setBorder(BorderFactory.createEmptyBorder());
        breakButton.setContentAreaFilled(false);
        breakButton.setBorderPainted(false);

        themeButton = new JButton(themeIconScaled);
        themeButton.setBorder(BorderFactory.createEmptyBorder());
        themeButton.setContentAreaFilled(false);
        themeButton.setBorderPainted(false);

        infoButton = new JButton(infoIconScaled);
        infoButton.setBorder(BorderFactory.createEmptyBorder());
        infoButton.setContentAreaFilled(false);
        infoButton.setBorderPainted(false);

        //Button positioning
        playPauseButton.setBounds(380, 495, 60, 60);
        workButton.setBounds(284, 495, 60, 60);
        breakButton.setBounds(476, 495, 60, 60);
        themeButton.setBounds(5, 5, 30, 30);
        infoButton.setBounds(750, 5, 30, 30);

        //Creating an instance of the Theme Button to make it functional
        ThemeFunc themeFunction = new ThemeFunc();
        themeFunction.toggleTheme(layeredPane, themeButton, false);

        //Creating an instance of the Timer to make it functional
        PTimer pomTimer = new PTimer();
        pomTimer.timer(layeredPane, playPauseButton, scaledIcon);

        //Creating an instance of the pause and play button to make it functional
        PausePlayFunc pausePlayFunction = new PausePlayFunc();
        pausePlayFunction.pausePlayFunc(pomTimer.timer, playPauseButton, scaledIcon, pauseIconScaled);

        //Creating an instance of the info button to make it functional
        InfoFunc infoFunction = new InfoFunc();
        infoFunction.infoFunc(infoButton, layeredPane, false);

        //Creating an instance of the break button to make it functional
        BreakFunc breakFunc = new BreakFunc(pomTimer);
        breakFunc.breakFunc(null, breakButton);

        //Creating an instance of the work button to make it functional
        WorkFunc workFunc = new WorkFunc(pomTimer);
        workFunc.workFunc(null, workButton);


        layeredPane.add(playPauseButton, Integer.valueOf(2));
        layeredPane.add(workButton, Integer.valueOf(2));
        layeredPane.add(breakButton, Integer.valueOf(2));
        layeredPane.add(themeButton, Integer.valueOf(2));
        layeredPane.add(infoButton, Integer.valueOf(4));
    }
}
