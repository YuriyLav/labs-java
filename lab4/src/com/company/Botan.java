package com.company;

import com.company.View.View;

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
        return super.toString() + "\t" + grade;
    }
    /**
     * Method CreatePair of class Botan - create pair from CoolParent and botan
     */
    public void CreatePair(Botan[] b, CoolParent[] c){
        for(int i=0; i<2; i++){
            if(c[i].getMoney()==Math.pow(10, b[i].grade)) View.print("Пара ботаник-крутой родитель: "+"\n"+b[i]+"\n"+c[i]+"\n");
        }
    }
}
