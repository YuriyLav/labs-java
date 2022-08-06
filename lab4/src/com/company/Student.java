package com.company;

import com.company.View.View;

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

    public String toString() {
        return super.toString() + "\t" + patron;
    }
    public void CreatePair(Student s, Parent p){
        if(s.patron.equals(p.getName())) System.out.println("Пара студент-родитель: "+"\n"+s+"\n"+p);
    }
    /**
     * Method CreatePair of class Student - create pair from student and parent
     */
    public void CreatePair(Student[] s, Parent[] p){
        for(int i=0; i<3; i++){
            if(s[i].patron.regionMatches(1, p[i].getName(), 1, 3)) View.print("Пара студент-родитель: "+"\n"+s[i]+"\n"+p[i]+"\n");
        }
    }

}
