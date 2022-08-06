package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Botan extends Human{
    private double grade;

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public double getGrade() {
        return grade;
    }
    public Botan(String name, int age, String gender, double grade) {
        super(name, age, gender);
        this.grade = grade;
    }
    public String toString() {
        return super.toString() + " " + grade;
    }
    public void CreatePair(Botan[] b, CoolParent[] c){
        for(int i=0; i<2; i++){
            if(c[i].getMoney()==Math.pow(10, b[i].grade)) System.out.println("Пара ботаник-крутой родитель: "+"\n"+b[i]+"\n"+c[i]+"\n");
        }
    }
    public static void saveBot(String fileName, boolean Update) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добавление объекта типа Ботаник: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите среднюю оценку: ");
        double grade=in.nextDouble();
        Botan bot = new Botan(name, age, gender, grade);
        try {
            OutputStream f = new FileOutputStream(fileName, Update);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(bot.toString()+"\n");
            out.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Botan> readBot(String fileName) {
        ArrayList<Botan> listBot = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] obj=line.split(" ");
            Botan bot=new Botan(obj[0], Integer.parseInt(obj[1]), obj[2], Double.parseDouble(obj[3]));
            listBot.add(bot);
            while (line != null) {
                line = reader.readLine();
                if(line!=null){
                    obj=line.split(" ");
                    bot=new Botan(obj[0], Integer.parseInt(obj[1]), obj[2], Double.parseDouble(obj[3]));
                    listBot.add(bot);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listBot;
    }
    public static void removeBot(String fileName){
        ArrayList<Botan> listBot = Botan.readBot(fileName);
        System.out.println(listBot);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объект данные которого необходимо удалить из файла: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите среднюю оценку: ");
        double grade=in.nextDouble();
        Botan par = new Botan(name, age, gender, grade);
        int j;
        for(j=0; j<listBot.size(); j++){
            if(listBot.get(j).toString().equals(par.toString())) break;
        }
        listBot.remove(j);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listBot.size(); i++) {
                out.write(listBot.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void replaceBot(String fileName){
        ArrayList<Botan> listBot= Botan.readBot(fileName);
        System.out.println(listBot);
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
        System.out.println("Введите среднюю оценку: ");
        double grade=in.nextDouble();
        Botan bot = new Botan(name, age, gender, grade);
        listBot.set(j, bot);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listBot.size(); i++) {
                out.write(listBot.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
