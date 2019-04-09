package com.aarole.calendartest;

public interface randomPicker {

    int total = 4;

    static Object random(Object[] a){
        int random = (int) (Math.random()*total);
        return a[random];
    }
}
