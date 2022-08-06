package com.company.Controller;

import com.company.Model;
import com.company.View;
import java.util.Scanner;

public class Controller {
    public static void controller() {
        boolean success = false;
        while (!success){
            View.view("Введите адрес получателя: ");
            Scanner in = new Scanner(System.in);
            String email=in.nextLine();
            View.view("Введите тему письма: ");
            String head = in.nextLine();
            View.view("Введите текст письма: ");
            String text = in.nextLine();
            View.view("Выберите кодировку текста: ");
            View.view("1 - UTF-8\n" + "2 - cp1251\n" + "3 - ASCII");
            String coding = in.nextLine();
            success = Model.sendMail(email, head, text, coding);
        }
    }
}
