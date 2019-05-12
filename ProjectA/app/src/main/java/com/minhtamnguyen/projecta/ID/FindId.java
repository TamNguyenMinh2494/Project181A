package com.minhtamnguyen.projecta.ID;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import com.minhtamnguyen.projecta.Database_And_Adapter.AdapterStudent;
import com.minhtamnguyen.projecta.Database_And_Adapter.MyDatabase;
import com.minhtamnguyen.projecta.R;
import com.minhtamnguyen.projecta.Database_And_Adapter.Student;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

//Find an ID which user want to search in ID Icon on App

public class FindId extends AppCompatActivity {

    ListView listView;
    ArrayList<Student> StudentList;
    AdapterStudent adapter;


    AutoCompleteTextView autoCompleteID;
    ArrayList<Student> foundList;

    @Override
    protected void onCreate(Bundle saveInstanceState)
    {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.id);


        listView = findViewById(R.id.ListViewID);

        //create a arraylist like arraylist StudentList to dump database from StudentList to foundlist
        foundList = new ArrayList<>();
        //create adapter for foundlist
        adapter = new AdapterStudent(this, foundList);

        listView.setAdapter(adapter);

        autoCompleteID = findViewById(R.id.autoCompleteID);
        autoCompleteID.setAdapter(getAllId(this));

        autoCompleteID.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foundList.clear(); //mỗi lần hiển thị mới thì xóa cái list trước đó
                for (int i = 0; i < StudentList.size(); i++) {
                    if (StudentList.get(i).getID().equals(autoCompleteID.getText().toString())) {
                        foundList.add(StudentList.get(i));
                        break;
                    }
                }
                adapter.notifyDataSetChanged();
                //khi có sự thay đổi trong arraylist thì listview tự động cập nhật do adapter gắn với listview
            }
        });
    }

    private ArrayAdapter<String> getAllId(Context context)
    {
        ArrayList<String> list = new ArrayList<>();
        MyDatabase myDatabase = new MyDatabase(context);
        StudentList = myDatabase.getOneStudentAutoComplete();
        for (Student sv : StudentList) { //sử dụng foreach loop để lấy ID từ Student List đổ qua
            list.add(sv.getID());
        }
        return new ArrayAdapter<>(context, android.R.layout.simple_dropdown_item_1line, list);
    }
}
