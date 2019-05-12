package com.minhtamnguyen.projecta.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.minhtamnguyen.projecta.R;

public class List extends AppCompatActivity {

    Button btnPrintAllStudent;
    Button btnPrintAllMajor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main);
    btnPrintAllStudent = findViewById(R.id.btnPrintAll);
    btnPrintAllMajor = findViewById(R.id.btnPrintMajor);

    btnPrintAllStudent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(List.this, View_All_Student.class); //show all student in List icon
            startActivity(intent);
        }
    });


    btnPrintAllMajor.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(List.this,List_Major.class); //Go to List_Major do Spinner with details
            startActivity(intent);
        }
    });
    }
}
