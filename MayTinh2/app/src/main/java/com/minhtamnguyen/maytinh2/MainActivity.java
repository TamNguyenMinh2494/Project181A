package com.minhtamnguyen.maytinh2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //khởi tạo biến ban đầu để ánh xạ
    Button BT;
    EditText N1,N2;
    TextView KQ;
    Spinner Spi;
    String Arr[]={"+","-","*","/"};
    int ViTri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        Taospinner();
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                KQ.setText(""+Tinh());
            }
        });
    }

    void Anhxa() {
        BT=findViewById(R.id.BtnKq);
        N1=findViewById(R.id.EdtN1);
        N2=findViewById(R.id.EdtN2);
        KQ=findViewById(R.id.TxtKq);
        Spi=findViewById(R.id.spinnerPhepTinh);
    }

    void Taospinner() {

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,Arr);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Spi.setAdapter(adapter);
        Spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ViTri = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ViTri = -1;
            }
        });
    }
    double Tinh() {

        double X1=Double.parseDouble(N1.getText().toString());
        double X2=Double.parseDouble(N2.getText().toString());
        double Z=0;
        switch (ViTri) {
            case 0: Z=X1+X2; break;
            case 1: Z=X1-X2; break;
            case 2: Z=X1*X2; break;
            case 3:
                if (X2==0)
                    Z=0;
                else
                    Z=X1/X2; break;
        }
        return Z;
    }
}