package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

public class Controller extends JPanel implements ActionListener, Runnable {
    Timer mainTimer = new Timer(20, this);
    String path = "road.png";
    URL imgURL = Controller.class.getResource(path);
    Image img = new ImageIcon(imgURL).getImage();
    Car car, car2;
    Thread carThread1 = new Thread(this);
    Thread carThread2 = new Thread(this);
    public Controller(){
        mainTimer.start();
        carThread1.start();
        carThread2.start();
    }
    public void paint(Graphics g){
        g.drawImage(img, 0, 0, null);
        g.drawImage(car.img, car.x, car.y, null);
        g.drawImage(car2.img2, car2.x, car2.y, null);
    }

    boolean flag = true;
    View view;
    public void actionPerformed (ActionEvent e){
        try {
            car.move(flag);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        try {
            car2.move(!flag);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        repaint();
//        view.paint(g, img, car, car2);
//        view.paint();
//        View.paint(g, img, car, car2);
    }
    @Override
    public void run() {
        int min = 10;
        int max = 30;
        int v1 = new Random().nextInt(max-min)+min;
        int v2 = new Random().nextInt(max-min)+min;
        car = new Car(30, 100, v1, this);
        car2 = new Car(30, 500, v2, this);
    }
}
