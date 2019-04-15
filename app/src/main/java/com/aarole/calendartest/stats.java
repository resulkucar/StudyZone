package com.aarole.calendartest;
import android.graphics.Color;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aarole.calendartest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

public class stats extends AppCompatActivity {

    PieChart pieChart ;
    ArrayList<Entry> entries ;
    ArrayList<String> PieEntryLabels ;
    PieDataSet pieDataSet ;
    PieData pieData ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats);

        pieChart = (PieChart) findViewById(R.id.chart1);

        entries = new ArrayList<>();

        PieEntryLabels = new ArrayList<String>();

        AddValuesToPIEENTRY();

        AddValuesToPieEntryLabels();

        pieDataSet = new PieDataSet(entries, "");

        pieData = new PieData(PieEntryLabels, pieDataSet);

        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        pieChart.setData(pieData);

        pieChart.animateY(1000);

    }

    public void AddValuesToPIEENTRY(){

        entries.add(new BarEntry(8, 0));
        entries.add(new BarEntry(1f, 1));
        entries.add(new BarEntry(1f, 2));
        entries.add(new BarEntry(1f, 3));

    }

    public void AddValuesToPieEntryLabels(){

        PieEntryLabels.add("Math");
        PieEntryLabels.add("Calculus");
        PieEntryLabels.add("Programming");
        PieEntryLabels.add("English");

    }
}