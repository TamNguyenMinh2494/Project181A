package com.minhtamnguyen.calculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    EditText EdtKQ;
    double Sotruoc=0,Sosau=0, KQ=0;
    String Toantu = " ",Toanhang="0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtKQ = findViewById(R.id.EdtKQ);
        int [] Arr= {R.id.Bnt0,R.id.Bnt1,R.id.Bnt2,R.id.Bnt3,R.id.Bnt4,R.id.Bnt5,
                R.id.Bnt6,R.id.Bnt7,R.id.Bnt8,R.id.Bnt9, R.id.BntBang,R.id.BntTru,
                R.id.BntCham,R.id.BntChia,R.id.BntCong,R.id.BntNhan,R.id.BntDel};
        for (int id:Arr){
            View v = findViewById(id);
            v.setOnClickListener(this);
        }
    }
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.BntCong: Toantu="+";
                                Sotruoc = Double.parseDouble(Toanhang);
                                Toanhang="0";
                                break;
            case R.id.BntTru: Toantu="-";
                                Sotruoc = Double.parseDouble(Toanhang);
                                Toanhang="0";
                                break;
            case R.id.BntNhan: Toantu="*";
                                Sotruoc = Double.parseDouble(Toanhang);
                                Toanhang="0";
                                break;
            case R.id.BntChia: Toantu="/";
                                Sotruoc = Double.parseDouble(Toanhang);
                                Toanhang="0";
                                break;
            case R.id.BntDel: EdtKQ.setText("");
                                Toanhang = "0";
                                Sotruoc = Sosau = KQ = 0;
                                break;
            case R.id.BntBang: Sosau = Double.parseDouble(Toanhang);
                                if(Toantu == "+")
                                    KQ = Sotruoc + Sosau;
                                if (Toantu == "-")
                                    KQ = Sotruoc - Sosau;
                                if(Toantu == "*")
                                    KQ = Sotruoc * Sosau;
                                if(Toantu == "/") {
                                    if (Sosau == 0)
                                        KQ = 0;
                                    else KQ = Sotruoc / Sosau;
                                }
                                Toanhang = Double.toString(KQ);
                                EdtKQ.setText(Toanhang);
                                break;
            default: if (Toanhang.equals("0"))
                        Toanhang="";
                        Toanhang += ((Button)v).getText().toString();
                        EdtKQ.setText(Toanhang);
        }
    }
}
