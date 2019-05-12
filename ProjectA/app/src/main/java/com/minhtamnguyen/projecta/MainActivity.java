package com.minhtamnguyen.projecta;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.minhtamnguyen.projecta.Chart.Chart;

public class MainActivity extends AppCompatActivity {
    ImageView List;

    ImageView ID;

    ImageView Statistical;

    ImageView Exit;

    ImageView Chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = findViewById(R.id.imageViewList);

        List.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v) {
                Intent intent = new Intent(MainActivity.this, com.minhtamnguyen.projecta.List.List.class);
                startActivity(intent);
            }
        });


        ID = findViewById(R.id.imageViewID);
        ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.minhtamnguyen.projecta.ID.ID.class);
                startActivity(intent);
            }
        });

        Statistical = findViewById(R.id.imageViewSta);
        Statistical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.minhtamnguyen.projecta.Statistical.Statistical.class);
                startActivity(intent);
            }
        });

        Chart = findViewById(R.id.imageViewChart);
        Chart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.minhtamnguyen.projecta.Chart.Chart.class);
                startActivity(intent);
            }
        });

        Exit = findViewById(R.id.imageExit);
        Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Do you want to exit app?");
                builder.setMessage("Select one of the buttons below");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setCancelable(false); //bấm ngoài hộp thoại vẫn k thoát hộp thoại
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed(); //this function to exit app
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });

    }
}
