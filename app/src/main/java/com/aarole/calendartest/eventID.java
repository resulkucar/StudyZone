package com.aarole.calendartest;

import java.util.concurrent.atomic.AtomicInteger;

public class eventID {

    private static int id = 10000;

    public static int getID(){
        id++;
        return id;
    }
}
