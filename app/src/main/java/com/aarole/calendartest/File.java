package com.aarole.calendartest;

import android.content.Context;

import java.util.ArrayList;

public abstract class File {
    public abstract void writeData(ArrayList<String> items, Context context);
    public abstract ArrayList<String> readData(Context context);
}
