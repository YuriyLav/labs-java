package com.company.Controller;
import com.company.ExceptionClass;
import com.company.Human;
import com.company.Model.Model;
import com.company.View.View;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
/**
 * @author Yuriy
 * @version 0.0.1
 */
public class Controller {
    /**
     * Controller
     * Add and change objects
     */
    public void start(){
        Integer[] size = new Integer[]{10, 100, 1000, 10000, 100000};
        for (Integer count : size) {
            ArrayList<Integer> time = new ArrayList<>();
            for(int i=0; i<4;i++) {
                time.add(0);
            }
            View.write_info("Start program: " + new Date());
            ArrayList<Human> array1 = Model.randomArray(count, time);
            Model.ChangeArray(array1, count / 10, time);
            View.write_info("Add total count: " + count);
            View.write_info("Add total time: " + time.get(0));
            View.write_info("Add median time: " + time.get(1));
            View.write_info("Set total count: " + count/10);
            View.write_info("Set total time: " + time.get(2));
            View.write_info("Set median time: " + time.get(3));
            View.write_info("Finish program: " + new Date());
        }
        for (Integer count : size) {
            ArrayList<Integer> time1 = new ArrayList<>();
            for(int i=0; i<4;i++) {
                time1.add(0);
            }
            View.write_info("Start program: " + new Date());
            HashMap<Integer, Human> array2 = Model.randomHashMap(count, time1);
            Model.ChangeHashMap(array2, count / 10, time1);
            View.write_info("Put total count: " + count);
            View.write_info("Put total time: " + time1.get(0));
            View.write_info("Put median time: " + time1.get(1));
            View.write_info("Replace total count: " + count/10);
            View.write_info("Replace total time: " + time1.get(2));
            View.write_info("Replace median time: " + time1.get(3));
            View.write_info("Finish program: " + new Date());
        }
        View.write_info("Всего ошибок: "+ ExceptionClass.count_exception);
    }
}
