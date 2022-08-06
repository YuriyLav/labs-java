package com.company.Model;
import com.company.*;
import com.company.View.View;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * @author Yuriy
 * @version 0.0.1
 */
public class Model {
    /**
     * create Human object
     * @return Human object
     */
    public static Human randomObject() {
//        String alphabet = "abcdefghijklmnopqrstuvwxyz";
//        int type = (int) (Math.random() * (3));
        int type = 0;
        int g = (int) (Math.random() * (2));
//        StringBuilder name = new StringBuilder();
//        for(int i=0; i<7; i++){
//            name.append(alphabet.charAt((int) (Math.random() * (25))));
//        }
        String name = "Unknown";
        int age = (int) (Math.random() * (90)+1);
        String gender;
        if(g==0){
            gender = "мужской";
        }
        else{
            gender = "женский";
        }
        //            StringBuilder patron = new StringBuilder();
//            for(int i=0; i<7; i++){
//                patron.append(alphabet.charAt((int) (Math.random() * (25))));
//            }
        String patron = "Unknown";
        return new Student(name, age, gender, patron);
        //        else if(type == 1){
//            return new Parent(name, age, gender);
//        }
//        else if(type == 2){
//            double grade = (int) (Math.random() * (25) + 1);
//            return new Botan(name, age, gender, grade);
//        }
//        else {
//            int money = (int) (Math.random() * (25) + 1);
//            return new CoolParent(name, age, gender, money);
//        }
        }
    /**
     * create random ArrayList<Human>
     * @param len length of array
     * @param time array for time processing of operations
     * @return ArrayList<Human>
     */
    public static ArrayList<Human> randomArray(int len, ArrayList<Integer> time){
        ArrayList<Human> arr = new ArrayList<>();
        View.write_info("ArrayList");
        try {
            for (int i = 0; i < len; i++) {
                Human obj = randomObject();
                int start = (int) System.nanoTime();
                arr.add(obj);
                int finish = (int) System.nanoTime();
                time.set(0, time.get(0) + (finish - start));
                View.write_info("add, ID: " + "= " + i + ", " + (finish - start));
            }
        } catch(ArrayIndexOutOfBoundsException exc){
            ExceptionClass.handling_exception(exc.getMessage());
        }
        time.set(1, time.get(0) / len);
        return arr;
    }
    /**
     * change ArrayList<Human>
     * @param len length of array
     * @param time array for time processing of operations
     * @param ar 10% objects of start array
     */
    public static void ChangeArray(ArrayList<Human> ar, int len, ArrayList<Integer> time) {
        ArrayList<Human> array = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            array.add(randomObject());
        }
        ArrayList<Integer> ind = new ArrayList<>();
        for(int i=0;i<len;i++){
            ind.add((int) (Math.random() * (ar.size()-1)));
        }
        try {
            for(int i=0;i<len;i++) {
                int start = (int) System.nanoTime();
                ar.set(ind.get(i), array.get(i));
                int finish = (int) System.nanoTime();
                time.set(2, time.get(2) + (finish - start));
                View.write_info("set, ID: " + "= " + ind.get(i) + ", " + (finish - start));
            }
        }catch(ArrayIndexOutOfBoundsException exc){
            ExceptionClass.handling_exception(exc.getMessage());
        }
        time.set(3, time.get(2)/len);
    }
    /**
     * create random HashMap<Integer, Human>
     * @param len length of array
     * @param time array for time processing of operations
     * @return HashMap<Integer, Human>
     */
    public static HashMap<Integer, Human> randomHashMap(int len, ArrayList<Integer> time) {
        HashMap<Integer, Human> arr = new HashMap<>();
        View.write_info("HashMap");
        try {
            for (int i = 0; i < len; i++) {
                Human obj = randomObject();
                int start = (int) System.nanoTime();
                arr.put(i, obj);
                int finish = (int) System.nanoTime();
                time.set(0, time.get(0) + (finish - start));
                View.write_info("put, ID: " + "= " + i + ", " + (finish - start));
            }
        }catch(ArrayIndexOutOfBoundsException exc){
            ExceptionClass.handling_exception(exc.getMessage());
        }
        time.set(1, time.get(0) / len);
        return arr;
    }
    /**
     * change HashMap<Integer, Human>
     * @param len length of array
     * @param time array for time processing of operations
     * @param hash 10% objects of start array
     */
    public static void ChangeHashMap(HashMap<Integer, Human> hash, int len, ArrayList<Integer> time) {
        HashMap<Integer, Human> array = new HashMap<>();
        for (int i = 0; i < len; i++) {
            array.put(i, randomObject());
        }
        ArrayList<Integer> ind = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            ind.add((int) (Math.random() * (hash.size() - 1)));
        }
        try {
            for (int i = 0; i < len; i++) {
                int start = (int) System.nanoTime();
                hash.replace(ind.get(i), hash.get(ind.get(i)), array.get(i));
                int finish = (int) System.nanoTime();
                time.set(2, time.get(2)+(finish-start));
                View.write_info("replace, ID: " +  "= " + ind.get(i) + ", " + (finish-start));
            }
        }catch(ArrayIndexOutOfBoundsException exc){
            ExceptionClass.handling_exception(exc.getMessage());
        }
        time.set(3, time.get(2)/len);
    }
}
