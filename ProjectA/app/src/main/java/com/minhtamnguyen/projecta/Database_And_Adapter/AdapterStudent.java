package com.minhtamnguyen.projecta.Database_And_Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.minhtamnguyen.projecta.R;

import java.util.ArrayList;

public class AdapterStudent extends BaseAdapter {
    Context context;
    ArrayList<Student> StudentList = new ArrayList<Student>();

    public AdapterStudent(Context context,  ArrayList<Student> list) {
        this.context = context;
        this.StudentList = list;
    }


    @Override
    public int getCount() {
        return StudentList.size();
    }

    @Override
    public Object getItem(int position) {
        return StudentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = View.inflate(context, R.layout.custom_listview, null);
        TextView txtNo = row.findViewById(R.id.textViewNo);
        TextView txtID = row.findViewById(R.id.textViewID);
        TextView txtLastName = row.findViewById(R.id.textViewFirstName);
        TextView txtFirstName = row.findViewById(R.id.textViewLastName);
        TextView txtDoB = row.findViewById(R.id.textViewDayofBirth);
        TextView textGender = row.findViewById(R.id.textViewSex);
        TextView txtMajor = row.findViewById(R.id.textViewMajor);
        TextView txtEng = row.findViewById(R.id.textViewEnglish);
        TextView txtMath = row.findViewById(R.id.textViewMath);
        TextView txtIT = row.findViewById(R.id.textViewIT);
        TextView txtAverage = row.findViewById(R.id.textViewAverage);
        TextView txtRank = row.findViewById(R.id.textViewRank);

        Student student = StudentList.get(position);
        txtNo.setText(String.valueOf(student.getNo() + ""));
        txtID.setText("ID: "+student.getID());
        txtLastName.setText("Name: "+student.getLastName());
        txtFirstName.setText(" "+student.getFirstName());
        txtDoB.setText("Date: "+student.getDayOfBirth());
        textGender.setText("Gender: "+student.getGender());
        txtMajor.setText("Major: "+student.getMajor());
        txtEng.setText("English: "+String.valueOf(student.getEngLish() + ""));
        txtMath.setText("Math: "+String.valueOf(student.getMath() + ""));
        txtIT.setText("IT: "+String.valueOf(student.getIT() + ""));
        txtAverage.setText("Avg: "+ String.valueOf(student.getAverage()));
        txtRank.setText("Rank: "+String.valueOf(student.Rank()));
        return row;
    }
}

