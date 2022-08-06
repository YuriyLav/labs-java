package com.company;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Car {
    String path = "car.jpg";
    URL imgURL = Car.class.getResource(path);
    Image img = new ImageIcon(imgURL).getImage();
    String path1 = "car2.jpg";
    URL imgURL1 = Car.class.getResource(path1);
    Image img2 = new ImageIcon(imgURL1).getImage();
    int v;
    int x;
    int y;
    Controller road;

    public Car(int x, int y, int v, Controller road){
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }
    public void move(boolean flag) throws InterruptedException {
        String s="";
        x+=v;
        if(x>1400){
            v = 0;
            if(flag) s = "Победила белая машина! ";
            else
                s = "Победила черная машина! ";
            JOptionPane.showMessageDialog(null, s);
            Controller road = new Controller();
            road.carThread1.join();
            road.carThread2.join();
            System.exit(1);
        }
    }
}
