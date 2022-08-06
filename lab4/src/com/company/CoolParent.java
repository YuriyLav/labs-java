package com.company;

import com.company.View.View;

public class CoolParent extends Human{
    private int money;

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }
    public CoolParent(String name, int age, String gender, int money) {
        super(name, age, gender);
        this.money = money;
    }
    public String toString() {
        return super.toString() + "\t" + money;
    }
    /**
     * Method CreatePair of class CoolParent - create pair from CoolParent and botan
     */
    public void CreatePair(CoolParent[] c, Botan[] b){
        for(int i=0; i<2; i++){
            if(b[i].getGrade()==Math.log10(c[i].money)) View.print("Пара крутой родитель-ботаник: "+"\n"+c[i]+"\n"+b[i]+"\n");
        }
    }
}
