package com.company;
/**
 * Human is an abstract class from which the Parent Student CoolParent and Botan classes are inherited
 */
public class Human {
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

    protected  Human(){

    }
    public String toString(){
        return  name+" "+age+" "+gender;
    }
}
