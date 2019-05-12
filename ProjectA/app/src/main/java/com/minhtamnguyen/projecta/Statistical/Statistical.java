package com.minhtamnguyen.projecta.Statistical;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.minhtamnguyen.projecta.Database_And_Adapter.MyDatabase;
import com.minhtamnguyen.projecta.MainActivity;
import com.minhtamnguyen.projecta.R;
import com.minhtamnguyen.projecta.Database_And_Adapter.Student;

import java.util.ArrayList;

public class Statistical extends AppCompatActivity {
    int countIt,countEnglish,countTourist,countOutstanding,countExcellent,countAverage,countBad;
    MyDatabase DbHelper;
    ArrayList<Student> StudentList;
    TextView textViewITQuantity,textViewEnglishQuantity,textViewTouristQuantity,textViewOutstandingQuantity
            ,textViewExcellentQuantity,textViewAverageQuantity,textViewBadQuantity;
    Button btnBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistical_main);

        Mapping();
        ITQuantity();
        EnglishQuantity();
        TouristQuantity();
        OutstandingQuantity();
        ExcellentQuantity();
        AverageQuantity();
        BadQuantity();
    }

    public void Mapping() {
         textViewITQuantity = findViewById(R.id.textViewITQuantity);
         textViewEnglishQuantity = findViewById(R.id.textViewEnglishQuantity);
         textViewTouristQuantity = findViewById(R.id.textViewTouristQuantity);

         textViewOutstandingQuantity = findViewById(R.id.textViewOutstandingQuantity);
         textViewExcellentQuantity = findViewById(R.id.textViewExcellentQuantity);
         textViewAverageQuantity = findViewById(R.id.textViewAverageQuantity);
         textViewBadQuantity = findViewById(R.id.textViewBadQuantity);
         btnBack = findViewById(R.id.btnBack);
         btnBack.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 finish();
             }
         });
    }
    private void ITQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorIT();
        for (int i = 0; i < StudentList.size(); i++) {
            countIt++;
        }
        textViewITQuantity.setText("" + countIt);

    }
    private void EnglishQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorEnglish();
        for (int i = 0; i < StudentList.size(); i++) {
            countEnglish++;
        }
        textViewEnglishQuantity.setText("" + countEnglish);

    }
    private void TouristQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getOneMajorTourist();
        for (int i = 0; i < StudentList.size(); i++) {
            countTourist++;
        }
        textViewTouristQuantity.setText("" + countTourist);
    }
    private void OutstandingQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityOutstanding();
        for (int i = 0; i < StudentList.size(); i++) {
            countOutstanding++;
        }
        textViewOutstandingQuantity.setText("" + countOutstanding);
    }
    private void ExcellentQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityExcellent();
        for (int i = 0; i < StudentList.size(); i++) {
            countExcellent++;
        }
        textViewExcellentQuantity.setText("" + countExcellent);
    }
    private void AverageQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityAverage();
        for (int i = 0; i < StudentList.size(); i++) {
            countAverage++;
        }
        textViewAverageQuantity.setText("" + countAverage);
    }
    private void BadQuantity() {
        DbHelper = new MyDatabase(this);
        StudentList = DbHelper.getQuantityBad();
        for (int i = 0; i < StudentList.size(); i++) {
            countBad++;
        }
        textViewBadQuantity.setText("" + countBad);
    }

}
