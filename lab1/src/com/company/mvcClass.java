package com.company;
import java.util.Scanner;
/**
 *
 * @author Yuriy
 * @version 0.0.1
 */
public class mvcClass {
    /**
     * Class Model initialize variables and realize logic of programm
     */
    public static class Model {
        private static boolean check = true;
        private static int left = 1, right = 100, num;
        private static int count = 0;
        public static void work() {
            View.print("Загадайте число от 1 до 100");
            while (check) {
                count++;
                num = (left + right) / 2;
                View.print("Ваше число " + num + "?" + " Если больше введите 1, если меньше введите 0, если равно введите 2");
                String temp =Controller.Scan();
                try {
                    int t = Integer.parseInt(temp);
                    if (t < 0 || t > 2) throw new Exception();
                } catch (Exception e) {
                    View.print("Неверный символ! Попробуйте еще");
                }
                if (temp.equals("2")) {
                    View.print("Вы загадали число " + num);
                    check=false;
                    break;
                } else if (temp.equals("1")) left=num+1;
                else if (temp.equals("0")) right=num-1;
                if (count >= 7) {
                    View.print("Вы нечестно играете!");
                    break;
                }
            }
        }
    }
    /**
     * Method print of class View - print string
     * String key-string for print
     */
    public static class View {
        public static void print(String key) {
            System.out.println(key);
        }
    }
    /**
     * Method work of class Controller - get info from cmd and change model
     */
    public static class Controller {
        static Scanner scan = new Scanner(System.in);
        public static String Scan(){
            String temp = scan.nextLine();
            return temp;
        }
    }
    /**
     * From method main programm is start
     * @param args arguments of cmd
     */
    public static void main(String[] args) {
        Model model = new Model();
        model.work();
    }
}