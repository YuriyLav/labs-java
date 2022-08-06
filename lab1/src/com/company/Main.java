package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Загадайте число от 1 до 100");
        int left=1, right=100, num;
        boolean check=true;
        int count=0;
        while(check) {
            count++;
            num = (left + right) / 2;
            System.out.println("Ваше число " + num + "?" + " Если больше введите 1, если меньше введите 0, если равно введите 2");
            String temp = scan.nextLine();
            System.out.println(temp);
            try {
                int t = Integer.parseInt(temp);
                System.out.println(t);
                if (t < 0 || t > 2) throw new Exception();
            } catch (Exception e) {
                System.out.println("Неверный символ! Попробуйте еще");
            }
            switch (temp) {
                case "2" -> {
                    System.out.println("Вы загадали число " + num);
                    check = false;
                }
                case "1" -> left = num + 1;
                case "0" -> right = num - 1;
            }
            if(count>=7) {
                System.out.println("Вы нечестно играете!");
                break;
            }
        }
        scan.close();
    }
}
/*public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean getCheck() {
            return check;
        }

        public void setCheck(boolean check) {
            this.check = check;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }*/
/*Model model;
        View view;
        public Controller(Model model, View view) {
            this.model = model;
            this.view = view;
        }*/