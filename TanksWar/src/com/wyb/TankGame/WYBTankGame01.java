package com.wyb.TankGame;

import javax.swing.*;

/**
 * @author 王耶啵
 * @version 1.0
 */

public class WYBTankGame01 extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
    new WYBTankGame01();
    }

    public WYBTankGame01(){
        myPanel = new MyPanel();
        this.add(myPanel);
        this.addKeyListener(myPanel);
        this.setSize(1000,750);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
