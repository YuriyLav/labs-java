package com.company.View;
import com.company.LogClass;
/**
 * @author Yuriy
 * @version 0.0.1
 */
public class View {
    /**
     * View
     * print objects to console and write info on the disk
     * @param str (String)
     */
    public static void write_info(String str){
        LogClass.writeLog(str);
    }
    public static void print(String str){
        System.out.println(str);
    }
}
