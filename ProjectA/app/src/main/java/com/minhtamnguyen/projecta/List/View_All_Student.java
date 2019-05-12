package com.minhtamnguyen.projecta.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.minhtamnguyen.projecta.Database_And_Adapter.AdapterStudent;
import com.minhtamnguyen.projecta.Database_And_Adapter.MyDatabase;
import com.minhtamnguyen.projecta.Database_And_Adapter.Student;
import com.minhtamnguyen.projecta.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class View_All_Student extends AppCompatActivity {
    Context context;
    ListView listView;
    ArrayList<Student> StudentList;
    AdapterStudent adapter;
    MyDatabase DBHelper;
    @Override
    protected void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.listview);

        listView = findViewById(R.id.ListView);
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
        StudentList = DBHelper.getListProduct(); // Ctrl + B
        //Init adapter
        adapter = new AdapterStudent(this, StudentList);
        //Set adapter for listview
        listView.setAdapter(adapter);
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
}
