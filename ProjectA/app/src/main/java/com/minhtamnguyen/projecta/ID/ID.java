package com.minhtamnguyen.projecta.ID;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.minhtamnguyen.projecta.R;

public class ID extends AppCompatActivity {
    Button btnMainID;
    Button btnMainMajor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_id_main);

        btnMainID = findViewById(R.id.btnMainID);
        btnMainMajor = findViewById(R.id.btnMainMajor);

        btnMainID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ID.this,FindId.class);
                startActivity(intent);
            }
        });

        btnMainMajor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ID.this, TopOfMajor.class);
                startActivity(intent);
            }
        });
    }
}
