package com.hspedu.draw_;

import javax.swing.*;

public class HspTankGame01 extends JFrame{
    private MyPanel mp = null;
    public static void main(String[] args) {
        new HspTankGame01();
    }

    public HspTankGame01() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);
        this.setSize(1000,750);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

