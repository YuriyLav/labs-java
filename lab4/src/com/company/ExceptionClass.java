package com.company;

import com.company.View.View;
/**
 * @author Yuriy
 * @version 0.0.1
 */
public class ExceptionClass {
    public static int count_exception = 0;
    /**
     * Handling exceptions and counting number of exceptions
     * @param exc String
     */
    public static void handling_exception(String exc){
        View.write_info(exc);
        count_exception++;
    }
}
