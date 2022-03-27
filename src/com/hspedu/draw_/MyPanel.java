package com.hspedu.draw_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksSize = 3;
    public MyPanel() {
        hero = new Hero(400,400,0);
        hero.setSpeed(5);
        for (int i = 0; i < 3; i++) {
            EnemyTank tank = new EnemyTank((100 * (i + 1)), 0);
            tank.setDirect(2);
            enemyTanks.add(tank);
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),1);
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank tank = enemyTanks.get(i);
            drawTank(tank.getX(),tank.getY(),g,tank.getDirect(),0);
        }


    }
///
    public void drawTank(int x,int y,Graphics g,int direct,int type) {

        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }

        switch (direct) {
            case 0:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(30 + x,y,10,60,false);
                g.fill3DRect(10 + x,y + 10,20,40,false);
                g.fillOval(10 + x,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20,y);
                break;
            case 1:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(10 + x,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20,x + 60,y + 20);
                break;
            case 2:
                g.fill3DRect(x,y,10,60,false);
                g.fill3DRect(30 + x,y,10,60,false);
                g.fill3DRect(10 + x,y + 10,20,40,false);
                g.fillOval(10 + x,y + 20,20,20);
                g.drawLine(x + 20,y + 30,x + 20,y + 60);
                break;
            case 3:
                g.fill3DRect(x,y,60,10,false);
                g.fill3DRect(x,y + 30,60,10,false);
                g.fill3DRect(10 + x,y + 10,40,20,false);
                g.fillOval(x + 20,y + 10,20,20);
                g.drawLine(x + 30,y + 20,x,y + 20);
                break;
            default:
                System.out.println("wrong");
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            hero.moveUp();
            hero.setDirect(0);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            hero.moveRight();
            hero.setDirect(1);
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            hero.moveDown();
            hero.setDirect(2);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            hero.moveLeft();
            hero.setDirect(3);
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
