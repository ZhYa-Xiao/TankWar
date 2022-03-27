package com.hspedu.event_;

import javax.swing.*;

public class BallMove extends JFrame {
    MyPanel mp = null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        setSize(1000,1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}




