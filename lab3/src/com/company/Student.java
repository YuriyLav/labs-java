package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class Student extends Human{
    private String patron;
    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }
    public Student(String name, int age, String gender, String patron) {
        super(name, age, gender);
        this.patron = patron;
    }
    public Student(){

    }


    public String toString() {
        return super.toString() + " " + patron;
    }
    public void CreatePair(Student s, Parent p){
        if(s.patron==p.getName()) System.out.println("Пара студент-родитель: "+"\n"+s+"\n"+p);
    }
    /**
     * Method CreatePair of class Student - create pair from student and parent
     */
    public void CreatePair(Student[] s, Parent[] p){
        for(int i=0; i<3; i++){
            if(s[i].patron.regionMatches(1, p[i].getName(), 1, 3)) System.out.println("Пара студент-родитель: "+"\n"+s[i]+"\n"+p[i]+"\n");
        }
    }
    public static void saveStu(String fileName, boolean Update) {
        Scanner in = new Scanner(System.in);
        System.out.println("Добавление объекта типа Студент: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите отчество: ");
        String patron = in.nextLine();
        Student stu=new Student(name, age, gender, patron);
        try {
            OutputStream f = new FileOutputStream(fileName, Update);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            out.write(stu.toString()+"\n");
            out.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static ArrayList<Student> readStu(String fileName) {
        ArrayList<Student> listStu = new ArrayList<>();
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            String[] obj=line.split(" ");
            Student stu=new Student(obj[0], Integer.parseInt(obj[1]), obj[2], obj[3]);
            listStu.add(stu);
            while (line != null) {
                line = reader.readLine();
                if(line!=null){
                    obj=line.split(" ");
                    stu=new Student(obj[0], Integer.parseInt(obj[1]), obj[2], obj[3]);
                    listStu.add(stu);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listStu;
    }
    public static void removeStu(String fileName){
        ArrayList<Student> listStu = Student.readStu(fileName);
        System.out.println(listStu);
        Scanner in = new Scanner(System.in);
        System.out.println("Введите объект данные которого необходимо удалить из файла: ");
        System.out.println("Введите имя: ");
        String name = in.nextLine();
        System.out.println("Введите возраст: ");
        int age = in.nextInt();
        System.out.println("Введите пол: ");
        in.nextLine();
        String gender = in.nextLine();
        System.out.println("Введите отчество: ");
        String patron = in.nextLine();
        Student stu = new Student(name, age, gender, patron);
        int j;
        for(j=0; j<listStu.size(); j++){
            if(listStu.get(j).toString().equals(stu.toString())) break;
        }
        listStu.remove(j);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listStu.size(); i++) {
                out.write(listStu.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void replaceStu(String fileName){
        ArrayList<Student> listStu = Student.readStu(fileName);
        System.out.println(listStu);
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
        System.out.println("Введите отчество: ");
        String patron = in.nextLine();
        Student stu = new Student(name, age, gender, patron);
        listStu.set(j, stu);
        try {
            OutputStream f = new FileOutputStream(fileName, false);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            for (int i = 0; i < listStu.size(); i++) {
                out.write(listStu.get(i).toString()+"\n");
                out.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
