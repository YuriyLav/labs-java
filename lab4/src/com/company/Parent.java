package com.company;

import com.company.View.View;

public class Parent extends Human{
    public Parent(String name, int age, String gender) {
        super(name, age, gender);
    }
    public String toString() {
        return super.toString();
    }
    /**
     * Method CreatePair of class Parent - create pair from student and parent
     */
    public void CreatePair(Parent[] p, Student[] s){
        for(int i=0; i<3; i++){
            if(p[i].getName().regionMatches(1, s[i].getPatron(), 1, 3)) View.print("Пара родитель-студент: "+"\n"+p[i]+"\n"+s[i]+"\n");
        }
    }
}
