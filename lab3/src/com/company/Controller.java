package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Method controller of class Controller - get info from cmd and change model
 */
public class Controller {
    public static boolean flag;
    public static void controller(){
        String name = "", signLog="";
        try {
            File file = new File("config.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            name = reader.readLine();
            signLog = reader.readLine();
            View.view("\nКонфигурация заружена");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        if(signLog.equals("true"))
        {
            View.view("Запись данных в лог файл осуществляется");
            flag = true;
            LogClass.writeLog("Программа запущена пользователем "+name, flag);
        }
        else
        {
            View.view("Запись данных в лог не осущетсвляется");
            flag = false;
        }
        View.view("\n"+"Добро пожаловать "+name+"!");
        printMenu();
        Scanner in = new Scanner(System.in);
        String men;
        int menu;
        while (true) {
            View.view("Введите пункт меню: ");
            try {
                men = in.nextLine();
                menu = Integer.parseInt(men);
                if (menu < 0 || menu > 8) throw new Exception();
            } catch (Exception e) {
                menu = -1;
            }
            switch (menu) {
                case 1:
                    Model.saveToFile();
                    break;
                case 2:
                    Model.readFromFile();
                    break;
                case 3:
                    Model.removeFromFile();
                    break;
                case 4:
                    Model.replaceInFile();
                    break;
                case 5:
                    createStuPar("fileStu.txt", "filePar.txt");
                    break;
                case 6:
                    createParStu("fileStu.txt", "filePar.txt");
                    break;
                case 7:
                    createBotCpar("fileBot.txt", "fileCpar.txt");
                    break;
                case 8:
                    createCparBot("fileBot.txt", "fileCpar.txt");
                    break;
                case 0:
                    LogClass.writeLog("Завершение программы", flag);
                    System.exit(0);
                default:
                    View.view("Допустимый диапазон 0 - 8! ");
            }
        }
    }

    public static void printMenu() {
        View.view("Меню:");
        View.view("1 - Запись данных в файл ");
        View.view("2 - Чтение данных из файла ");
        View.view("3 - Удаление данных из файла ");
        View.view("4 - Замена данных в файле ");
        View.view("5 - Создать пару Студент-Родитель ");
        View.view("6 - Создать пару Родитель-Студент ");
        View.view("7 - Создать пару Ботаник-Крутой родитель ");
        View.view("8 - Создать пару Крутой родитель-Ботаник ");
        View.view("0 - Заверешние программы ");
    }

    public static void printType() {
        View.view("1 - Студент ");
        View.view("2 - Родитель ");
        View.view("3 - Ботаник ");
        View.view("4 - Крутой родитель ");
    }

    /**
     * Methods create of class Main - create pair with some objects
     */
    public static void createStuPar(String fileName1, String fileName2) {
        ArrayList<Student> listStu = Student.readStu(fileName1);
        ArrayList<Parent> listPar = Parent.readPar(fileName2);
        for(int i=0; i<listStu.size(); i++){
            for(int j=0; j<listPar.size(); j++){
                int count =0;
                for(int k=0; k<3; k++){
                    if(listStu.get(i).getPatron().charAt(k) ==  listPar.get(j).getName().charAt(k)) count++;
                }
                if(count==3) View.view("Пара Студент-Родитель: "+"\n"+listStu.get(i)+"\n"+listPar.get(j)+"\n");
            }
        }
    }

    public static void createParStu(String fileName1, String fileName2) {
        ArrayList<Student> listStu = Student.readStu(fileName1);
        ArrayList<Parent> listPar = Parent.readPar(fileName2);
        for(int i=0; i<listStu.size(); i++){
            for(int j=0; j<listPar.size(); j++){
                int count =0;
                for(int k=0; k<3; k++){
                    if(listPar.get(j).getName().charAt(k)==listStu.get(i).getPatron().charAt(k)) count++;
                }
                if(count==3) View.view("Пара Родитель-Студент: "+"\n"+listPar.get(j)+"\n"+listStu.get(i)+"\n");
            }
        }
    }

    public static void createBotCpar(String fileName1, String fileName2) {
        ArrayList<Botan> listBot = Botan.readBot(fileName1);
        ArrayList<CoolParent> listCpar = CoolParent.readCpar(fileName2);
        for(int i=0; i<listBot.size(); i++){
            for(int j=0; j<listCpar.size(); j++){
                if(listCpar.get(j).getMoney()==Math.pow(10, listBot.get(i).getGrade()))
                    View.view("Пара Ботаник-Крутой родитель: "+"\n"+listBot.get(i)+"\n"+listCpar.get(j)+"\n");
            }
        }
    }

    public static void createCparBot(String fileName1, String fileName2) {
        ArrayList<Botan> listBot = Botan.readBot(fileName1);
        ArrayList<CoolParent> listCpar = CoolParent.readCpar(fileName2);
        for(int i=0; i<listBot.size(); i++){
            for(int j=0; j<listCpar.size(); j++){
                if(listBot.get(i).getGrade()==Math.log10(listCpar.get(j).getMoney()))
                    View.view("Пара Крутой родитель-Ботаник: "+"\n"+listCpar.get(j)+"\n"+listBot.get(i)+"\n");
            }
        }
    }
}

