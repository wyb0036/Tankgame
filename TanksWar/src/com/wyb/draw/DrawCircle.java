package com.wyb.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author 王耶啵
 * @version 1.0
 */

public class DrawCircle extends JFrame{

    //定义一个面板
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        //初始化面板
        MyPanel mp = new MyPanel();
        //把面板放入到窗口
        this.add(mp);
        this.setSize(500,500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//定义一个画板
class MyPanel extends JPanel{
    //1. MyPanel 对象是一个画板
    //2. Graphics 是一支画笔
    //3. Graphics 提供很多绘图方法
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("方法paint被调用！！！！");
        g.drawOval(40,40,200,200);

        //绘制不同图形
        //直线
        g.drawLine(10,10,100,10);
        //矩形边框
        g.drawRect(20,40,40,100);
        //填充矩形
        g.fillRect(100,20,50,80);
        //画图片
        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/xhs.png"));
        g.drawImage(image,50,200,200,200,this);
        //画坦克
        g.setColor(Color.ORANGE);
        g.fillRect(250,100,15,55);
        g.fillRect(285,100,15,55);
        g.fillRect(250,115,35,30);
        g.drawOval(255,118,10,10);
        g.drawLine(275,100,275,118);
    }
}
