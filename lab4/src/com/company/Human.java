package com.company;

public abstract class Human {
    /**
     * Human is a super class
     */
    private String name;
    private int age;
    private String gender;
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setName(String name) {
        this.name = name;
    }
    protected Human(String name, int age, String gender){
        this.name=name;
        this.age=age;
        this.gender=gender;
    }
    /**
     * Method for print objects Human type
     */
    public String toString(){
        return  name+"\t"+age+"\t"+gender;
    }
}
