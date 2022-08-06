package com.company;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;

public class Model {
    public static void model(){
        JFrame f = new JFrame("Гонки");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1500, 700);
        f.add(new Controller());
        f.setVisible(true);
    }
}
