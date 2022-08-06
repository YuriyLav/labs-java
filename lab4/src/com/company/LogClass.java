package com.company;

import com.company.View.View;

import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
/**
 * @author Yuriy
 * @version 0.0.1
 */
public class LogClass {
    /**
     * Write some info on disk
     * @param info String
     */
    public static void writeLog(String info){
        try {
            OutputStream f = new FileOutputStream("log.txt", true);
            OutputStreamWriter writer = new OutputStreamWriter(f);
            BufferedWriter out = new BufferedWriter(writer);
            LocalTime time = LocalTime.now();
            out.write(time.format(DateTimeFormatter.ofPattern("H:mm:ss"))+"  -  "+info+"\n");
            out.flush();
        }
        catch (IOException ex) {
            View.print(ex.getMessage());
        }
    }
}