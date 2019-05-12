package com.minhtamnguyen.projecta.Chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.minhtamnguyen.projecta.Database_And_Adapter.MyDatabase;
import com.minhtamnguyen.projecta.Database_And_Adapter.Student;
import com.minhtamnguyen.projecta.R;



import java.util.ArrayList;

public class Chart_QuantityOfStudent extends AppCompatActivity {
    MyDatabase DbHelper;
    ArrayList<Student> StudentList;


    PieChart pieChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_quantityofstudent);


        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        //pieChart.setExtraOffsets(5, 10, 5, 5);
        pieChart.setDragDecelerationFrictionCoef(0.99f); // độ xoay của hình tròn

        pieChart.setDrawHoleEnabled(true); //cai lỗ ở giữa vòng tròn
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(61f);

        pieChart.animateX(1000, Easing.EasingOption.EaseInCirc );

        CountIT();
        CountEnglish();
        CountTourist();

        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(countit, "IT"));
        yValues.add(new PieEntry(countEnglish, "English"));
        yValues.add(new PieEntry(countTourist, "Tourist"));

        PieDataSet dataSet = new PieDataSet(yValues, "");
        dataSet.setSliceSpace(3);
        //dataSet.setSelectionShift(5);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);


        PieData data = new PieData(dataSet);
        data.setValueTextSize(10);
        data.setValueTextColor(Color.YELLOW);
        data.setValueFormatter(new PercentFormatter());

        pieChart.setData(data);
        pieChart.setCenterText("Major");
        pieChart.setCenterTextSize(20);
        pieChart.setCenterTextColor(Color.BLACK);

    }
    int countit;
    private void CountIT() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorIT();
        for (int i = 0; i < StudentList.size(); i++) {
            countit++;
        }

    }

    int countEnglish;

    private void CountEnglish() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorEnglish();
        for (int i = 0; i < StudentList.size(); i++) {
            countEnglish++;
        }

    }

    int countTourist;

    private void CountTourist() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorTourist();
        for (int i = 0; i < StudentList.size(); i++) {
            countTourist++;
        }
    }
}