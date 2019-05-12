package com.minhtamnguyen.projecta.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.minhtamnguyen.projecta.Database_And_Adapter.AdapterStudent;
import com.minhtamnguyen.projecta.Database_And_Adapter.MyDatabase;
import com.minhtamnguyen.projecta.R;
import com.minhtamnguyen.projecta.Database_And_Adapter.Student;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class List_Major extends Activity {
    Context context;
    ListView listView;
    ArrayList<Student> StudentList;
    AdapterStudent adapter;
    MyDatabase DBHelper;

    Spinner spin;
    String Arr[] = {"IT","English","Tourist"};
    int position_major ;
    Button btnGo;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.major);

        btnGo = findViewById(R.id.btnGoMajor);
        spin = findViewById(R.id.spinnerListMajor);
        CreateSpinner();
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Show_List_Major();
            }
        });
    }
    private void CreateSpinner() {
        ArrayAdapter<String> adapter_list_major = new ArrayAdapter<String>
                (List_Major.this, android.R.layout.simple_spinner_item, Arr);

        adapter_list_major.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);

        spin.setAdapter(adapter_list_major);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position_major=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                position_major = -1;
            }
        });
    }
    private boolean copyDatabase(Context context) {
        try {

            InputStream inputStream = context.getAssets().open(MyDatabase.DBNAME);
            String outFileName = MyDatabase.DBLOCATION + MyDatabase.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[]buff = new byte[1024];
            int length = 0;
            while ((length = inputStream.read(buff)) > 0) {
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.w("MainActivity","DB copied");
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private void Show_List_Major(){
        switch (position_major){
            case 0 : {
                listView = findViewById(R.id.ListViewListMajor);
                DBHelper = new MyDatabase(this);


                File database = getApplicationContext().getDatabasePath(MyDatabase.DBNAME);
                if (false == database.exists()) {
                    DBHelper.getReadableDatabase();
                    //Copy db
                    if (copyDatabase(this)) {
                        Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                //Get product List in db when db exists
                StudentList = DBHelper.getOneMajorIT(); // Ctrl + B
                //Init adapter
                adapter = new AdapterStudent(this, StudentList);
                //Set adapter for listview
                listView.setAdapter(adapter);
            }break;
            case 1: {
                listView = findViewById(R.id.ListViewListMajor);
                DBHelper = new MyDatabase(this);


                File database = getApplicationContext().getDatabasePath(MyDatabase.DBNAME);
                if (false == database.exists()) {
                    DBHelper.getReadableDatabase();
                    //Copy db
                    if (copyDatabase(this)) {
                        Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                //Get product List in db when db exists
                StudentList = DBHelper.getOneMajorEnglish(); // Ctrl + B
                //Init adapter
                adapter = new AdapterStudent(this, StudentList);
                //Set adapter for listview
                listView.setAdapter(adapter);
            }break;
            case 2: {
                listView = findViewById(R.id.ListViewListMajor);
                DBHelper = new MyDatabase(this);


                File database = getApplicationContext().getDatabasePath(MyDatabase.DBNAME);
                if (false == database.exists()) {
                    DBHelper.getReadableDatabase();
                    //Copy db
                    if (copyDatabase(this)) {
                        Toast.makeText(this, "Copy database succes", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Copy data error", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                //Get product List in db when db exists
                StudentList = DBHelper.getOneMajorTourist(); // Ctrl + B
                //Init adapter
                adapter = new AdapterStudent(this, StudentList);
                //Set adapter for listview
                listView.setAdapter(adapter);
            }break;
        }
    }

}
