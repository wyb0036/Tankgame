package com.wyb.TankGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 王耶啵
 * @version 1.0
 */

public class MyPanel extends JPanel implements KeyListener {

    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTanksSize = 3;
    public MyPanel() {
        myTank = new MyTank(100, 100);
        myTank.setSpeed(5);
//        enemyTank = new EnemyTank(300, 100);
        for (int i = 0; i < enemyTanksSize; i++) {
        enemyTanks.add(new EnemyTank(i*100,0));
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), 0);
//        drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
        }
    }

    /**
     * @param x      坦克横坐标
     * @param y      坦克竖坐标
     * @param g      画笔
     * @param direct 坦克方向
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.orange);
                break;
        }

        switch (direct) {
            //W
            case 0:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
                //D
            case 1:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x , y+ 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
                //S
            case 2:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
                //A
            case 3:
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x , y+ 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x , y + 20);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_D){
//            System.out.println("朱贱鱼是SB");
            myTank.setDirect(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);
            myTank.moveUP();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
