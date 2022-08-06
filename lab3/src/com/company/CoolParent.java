package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CoolParent extends Human {
    private int money;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return this.money;
    }

    public CoolParent(String name, int age, String gender, int money) {
        super(name, age, gender);
        this.money = money;
    }

    public String toString() {
        String var10000 = super.toString();
        return var10000 + " " + money;
    }

    public void CreatePair(CoolParent[] c, Botan[] b) {
        for(int i = 0; i < 2; ++i) {
            if (b[i].getGrade() == Math.log10((double)c[i].money)) {
                System.out.println("Пара крутой родитель-ботаник: \n" + c[i] + "\n" + b[i] + "\n");
            }
        }

    }
    public static void saveCpar(String fileName, boolean Update) {
        //LogClass.writeLog("Запись данных в файл", Main.flag);
        Scanner in = new Scanner(System.in);
        System.out.println("Добавление объекта типа Крутой родитель: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите количество карманных денег: ");
        int money=in.nextInt();
        CoolParent cpar= new CoolParent(name, age, gender, money);
        try {
            OutputStream f = new FileOutputStream(fileName, Update);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(cpar.toString()+"\n");
            out.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<CoolParent> readCpar(String fileName) {
        ArrayList<CoolParent> listCPar = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] obj=line.split(" ");
            CoolParent cpar=new CoolParent(obj[0], Integer.parseInt(obj[1]), obj[2], Integer.parseInt(obj[3]));
            listCPar.add(cpar);
            while (line != null) {
                line = reader.readLine();
                if(line!=null){
                    obj=line.split(" ");
                    cpar=new CoolParent(obj[0], Integer.parseInt(obj[1]), obj[2], Integer.parseInt(obj[3]));
                    listCPar.add(cpar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listCPar;
    }
    public static void removeCpar(String fileName){
        ArrayList<CoolParent> listCPar = CoolParent.readCpar(fileName);
        System.out.println(listCPar);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объект данные которого необходимо удалить из файла: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите количество карманных денег: ");
        int money=in.nextInt();
        CoolParent cpar = new CoolParent(name, age, gender, money);
        int j;
        for(j=0; j<listCPar.size(); j++){
            if(listCPar.get(j).toString().equals(cpar.toString())) break;
        }
        listCPar.remove(j);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listCPar.size(); i++) {
                out.write(listCPar.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void replaceCpar(String fileName){
        ArrayList<CoolParent> listCpar = CoolParent.readCpar(fileName);
        System.out.println(listCpar);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите индекс объекта, которого необходимо заменить");
        int j=in.nextInt();
        System.out.println("Введите данные на которые необходимо заменить объект в файле: ");
        System.out.println("Введите имя: ");
        in.nextLine();
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите количество карманных денег: ");
        int money=in.nextInt();
        CoolParent cpar = new CoolParent(name, age, gender, money);
        listCpar.set(j, cpar);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listCpar.size(); i++) {
                out.write(listCpar.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
