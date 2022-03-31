package com.hspedu.draw_;

public class Bullet implements Runnable{
    private int bx;
    private int by;
    private int direct;
    private int speed = 7;
    MyPanel myPanel = new MyPanel();

    public Bullet(int x, int y, int direct) {
        this.bx = x;
        this.by = y;
        this.direct = direct;
    }

    public int getBx() {
        return bx;
    }

    public void setBx(int bx) {
        this.bx = bx;
    }

    public int getBy() {
        return by;
    }

    public void setBy(int by) {
        this.by = by;
    }

    public Bullet(int by) {
        this.by = by;
    }

    @Override
    public void run() {
        while (true) {
            if(!((bx > 0 && bx < 1000) && (by > 0 && by <750))){
                return;
            }
            switch (direct) {
                case 0:
                    by -= speed;
                    break;
                case 1:
                    bx += speed;
                    break;
                case 2:
                    by += speed;
                    break;
                case 3:
                    by -= speed;
                    break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            myPanel.repaint();

        }
    }

}
