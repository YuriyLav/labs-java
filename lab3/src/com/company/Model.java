package com.company;

import java.util.Scanner;
/**
 * Class Model initialize variables and realize logic of programm
 */
public class Model {
    public static boolean flag=Controller.flag;
    public static void printType() {
        View.view("1 - Студент ");
        View.view("2 - Родитель ");
        View.view("3 - Ботаник ");
        View.view("4 - Крутой родитель ");
    }
    /**
     * Method saveToFile of class Model - save info on disk
     */
        public static void saveToFile() {
            View.view("Объект какого типа вы хотите добавить?");
            printType();
            Scanner in = new Scanner(System.in);
            String men;
            int menu;
            View.view("Введите тип объекта: ");
            try {
                men = in.nextLine();
                menu = Integer.parseInt(men);
                if (menu < 1 || menu > 4) throw new Exception();
            } catch (Exception e) {
                menu = -1;
            }
            switch (menu) {
                case 1:
                    Student.saveStu("fileStu.txt", true);
                    break;
                case 2:
                    Parent.savePar("filePar.txt", true);
                    break;
                case 3:
                    Botan.saveBot("fileBot.txt", true);
                    break;
                case 4:
                    CoolParent.saveCpar("fileCpar.txt", true);
                    break;
                default:
                    View.view("Допустимый диапазон 1 - 4! ");
            }
            LogClass.writeLog("Запись данных в файл", flag);
        }
        /**
         * Method readFromFile of class Model - scan info from disk
         */
        public static void readFromFile(){
            View.view("Объекты какого типа вы хотите считать из файла?");
            printType();
            Scanner in = new Scanner(System.in);
            String men;
            int menu;
            View.view("Введите тип объекта: ");
            try {
                men = in.nextLine();
                menu = Integer.parseInt(men);
                if (menu < 1 || menu > 4) throw new Exception();
            } catch (Exception e) {
                menu = -1;
            }
            switch (menu) {
                case 1:
                    System.out.println(Student.readStu("fileStu.txt"));
                    break;
                case 2:
                    System.out.println(Parent.readPar("filePar.txt"));
                    break;
                case 3:
                    System.out.println(Botan.readBot("fileBot.txt"));
                    break;
                case 4:
                    System.out.println(CoolParent.readCpar("fileCpar.txt"));
                    break;
                default:
                    View.view("Допустимый диапазон 1 - 4! ");
            }
            LogClass.writeLog("Чтение данных из файла", flag);
        }
        /**
         * Method removeFromFile of class Model - delete info from disk
         */
        public static void removeFromFile(){
            View.view("Объект какого типа вы хотите удалить в файле?");
            printType();
            Scanner in = new Scanner(System.in);
            String men;
            int menu;
            View.view("Введите тип объекта: ");
            try {
                men = in.nextLine();
                menu = Integer.parseInt(men);
                if (menu < 1 || menu > 4) throw new Exception();
            } catch (Exception e) {
                menu = -1;
            }
            switch (menu) {
                case 1:
                    Student.removeStu("fileStu.txt");
                    break;
                case 2:
                    Parent.removePar("filePar.txt");
                    break;
                case 3:
                    Botan.removeBot("fileBot.txt");
                    break;
                case 4:
                    CoolParent.removeCpar("fileCpar.txt");
                    break;
                default:
                    View.view("Допустимый диапазон 1 - 4! ");
            }
        }
        /**
         * Method replaceInFile of class Model - replace info on disk
         */
        public static void replaceInFile() {
            View.view("Объект какого типа вы хотите заменить?");
            printType();
            Scanner in = new Scanner(System.in);
            String men;
            int menu;
            View.view("Введите тип объекта: ");
            try {
                men = in.nextLine();
                menu = Integer.parseInt(men);
                if (menu < 1 || menu > 4) throw new Exception();
            } catch (Exception e) {
                menu = -1;
            }
            switch (menu) {
                case 1:
                    Student.replaceStu("fileStu.txt");
                    break;
                case 2:
                    Parent.replacePar("filePar.txt");
                    break;
                case 3:
                    Botan.replaceBot("fileBot.txt");
                    break;
                case 4:
                    CoolParent.replaceCpar("fileCpar.txt");
                    break;
                default:
                    View.view("Допустимый диапазон 1 - 4! ");
            }
        }
    }
