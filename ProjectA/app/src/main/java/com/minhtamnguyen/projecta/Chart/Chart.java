package com.minhtamnguyen.projecta.Chart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.minhtamnguyen.projecta.R;

public class Chart extends AppCompatActivity {
    Button btnChart_QuantityOfStudent;
    Button btnChart_RankOfStudent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_main);

        btnChart_QuantityOfStudent = findViewById(R.id.btnChart_QuantityOfStudent);
        btnChart_RankOfStudent = findViewById(R.id.btnChart_RankOfStudent);


        btnChart_QuantityOfStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chart.this, Chart_QuantityOfStudent.class);

                startActivity(intent);
            }
        });


        btnChart_RankOfStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chart.this,Chart_RankOfStudent.class);
                startActivity(intent);
            }
        });
    }

}
