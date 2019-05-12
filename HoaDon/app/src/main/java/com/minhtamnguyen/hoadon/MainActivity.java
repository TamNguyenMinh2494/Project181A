package com.minhtamnguyen.hoadon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button BT;
    EditText Soluong, Dongia,Khachhang,Tenhang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BT = (Button)findViewById(R.id.BtnInhoadon);
        Soluong = (EditText)findViewById(R.id.EdtSoluong);
        Dongia = (EditText) findViewById(R.id.EdtDongia);
        Khachhang = (EditText)findViewById(R.id.EdtTenkhachhang);
        Tenhang = (EditText)findViewById(R.id.EdtTenhang);
        BT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent
                        (MainActivity.this,activity_hoadon.class);
                int SL = Integer.parseInt(Soluong.getText().toString());
                Double DG = Double.parseDouble(Dongia.getText().toString());
                String KH = Khachhang.getText().toString();
                String TH = Tenhang.getText().toString();

                Bundle bundle = new Bundle();

                bundle.putString("KH1",KH);
                bundle.putString("TH1",TH);
                bundle.putInt("SL1",SL);
                bundle.putDouble("DG1",DG);

                intent.putExtra("MyPackage",bundle);
                //chạy activity
                startActivity(intent);
            }
        });
    }
}
