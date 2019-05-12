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

public class Chart_RankOfStudent extends AppCompatActivity {
    MyDatabase DbHelper;
    ArrayList<Student> StudentList;
    PieChart pieChartRank;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_rankofstudent);

        pieChartRank = findViewById(R.id.pieChart_Rank);
        pieChartRank.setUsePercentValues(true);
        pieChartRank.getDescription().setEnabled(false);
        //pieChartRank.setExtraOffsets(5, 10, 5, 5);
        pieChartRank.setDragDecelerationFrictionCoef(0.99f); // độ xoay của hình tròn

        pieChartRank.setDrawHoleEnabled(true); //cai lỗ ở giữa vòng tròn
        pieChartRank.setHoleColor(Color.WHITE);
        pieChartRank.setTransparentCircleRadius(61f);

        pieChartRank.animateX(1000, Easing.EasingOption.EaseInCirc );


        Outstanding();
        Excellent();
        Average();
        Bad();


        ArrayList<PieEntry> Value = new ArrayList<>();
        Value.add(new PieEntry(Outstanding, "Outstanding"));
        Value.add(new PieEntry(Excellent, "Excellent"));
        Value.add(new PieEntry(Average, "Average"));
        Value.add(new PieEntry(Bad, "Bad"));

        PieDataSet dataSetRank = new PieDataSet(Value, "");
        dataSetRank.setSliceSpace(3);
        //dataSet.setSelectionShift(5);
        dataSetRank.setColors(ColorTemplate.COLORFUL_COLORS);


        PieData dataRank = new PieData(dataSetRank);
        dataRank.setValueTextSize(10);
        dataRank.setValueTextColor(Color.BLUE);
        dataRank.setValueFormatter(new PercentFormatter());

        pieChartRank.setData(dataRank);
        pieChartRank.setCenterText("Student");
        pieChartRank.setCenterTextSize(20);
        pieChartRank.setCenterTextColor(Color.BLACK);
    }

    int Outstanding,Excellent,Average,Bad;
    private void Outstanding() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityOutstanding();
        for (int i = 0; i < StudentList.size(); i++) {
            Outstanding++;
        }

    }
    private void Excellent() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityExcellent();
        for (int i = 0; i < StudentList.size(); i++) {
            Excellent++;
        }

    }
    private void Average() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityAverage();
        for (int i = 0; i < StudentList.size(); i++) {
            Average++;
        }

    }
    private void Bad() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityBad();
        for (int i = 0; i < StudentList.size(); i++) {
            Bad++;
        }

    }
}
