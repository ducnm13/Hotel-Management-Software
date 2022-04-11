/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.team3.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");
    static final SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("dd/MM/yyyy");
    public static Date toDate(String date, String ... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMAT.applyPattern(pattern[0]);
            }
            if (date == null) {
                return DateHelper.now();
            }
            return DATE_FORMAT.parse(date);
        }
        catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String ... pattern) {
        if (pattern.length > 0) {
            DATE_FORMAT.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMAT.format(date);
    }
    
        public static String toString2(Date date, String ... pattern) {
        if (pattern.length > 0) {
            DATE_FORMAT2.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = DateHelper.now();
        }
        return DATE_FORMAT2.format(date);
    }

    public static Date now() {
        return new Date();
    }

    public static Date adddays(Date date, int days) {
        date.setTime(date.getTime() + (long)(days * 24 * 60 * 60 * 1000));
        return date;
    }

    public static Date add(int days) {
        Date now = DateHelper.now();
        now.setTime(now.getTime() + (long)(days * 25 * 60 * 60 * 1000));
        return now;
    }
    
}
