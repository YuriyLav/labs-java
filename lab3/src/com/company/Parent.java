package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Parent extends Human{
    public Parent(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String toString() {
        return super.toString();
    }
    public void CreatePair(Parent[] p, Student[] s){
        for(int i=0; i<3; i++){
            if(p[i].getName().regionMatches(1, s[i].getPatron(), 1, 3)) System.out.println("Пара родитель-студент: "+"\n"+p[i]+"\n"+s[i]+"\n");
        }
    }
    public static void savePar(String fileName, boolean Update) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добавление объекта типа Родитель: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        Parent par=new Parent(name, age, gender);
        try {
            OutputStream f = new FileOutputStream(fileName, Update);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(par.toString()+"\n");
            out.flush();

        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Parent> readPar(String fileName) {
        ArrayList<Parent> listPar = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] obj=line.split(" ");
            Parent par=new Parent(obj[0], Integer.parseInt(obj[1]), obj[2]);
            listPar.add(par);
            while (line != null) {
                line = reader.readLine();
                if(line!=null){
                    obj=line.split(" ");
                    par=new Parent(obj[0], Integer.parseInt(obj[1]), obj[2]);
                    listPar.add(par);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listPar;
    }
    public static void removePar(String fileName){
        ArrayList<Parent> listPar = Parent.readPar(fileName);
        System.out.println(listPar);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объект данные которого необходимо удалить из файла: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        Parent par = new Parent(name, age, gender);
        int j;
        for(j=0; j<listPar.size(); j++){
            if(listPar.get(j).toString().equals(par.toString())) break;
        }
        listPar.remove(j);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listPar.size(); i++) {
                out.write(listPar.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void replacePar(String fileName){
        ArrayList<Parent> listPar = Parent.readPar(fileName);
        System.out.println(listPar);
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
        Parent par = new Parent(name, age, gender);
        listPar.set(j, par);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listPar.size(); i++) {
                out.write(listPar.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
