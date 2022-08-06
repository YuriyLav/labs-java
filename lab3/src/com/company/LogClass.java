package com.company;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
/**
 *
 * Class LogClass required to work with the log file
 */
public class LogClass {
    public static void writeLog(String info, boolean flag){
        if(flag){
            try {
                OutputStream f = new FileOutputStream("log.txt", true);
                OutputStreamWriter writer = new OutputStreamWriter(f);
                BufferedWriter out = new BufferedWriter(writer);
                LocalTime time = LocalTime.now();
                out.write(time.format(DateTimeFormatter.ofPattern("H:mm:ss"))+"  -  "+info+"\n");
                out.flush();
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
