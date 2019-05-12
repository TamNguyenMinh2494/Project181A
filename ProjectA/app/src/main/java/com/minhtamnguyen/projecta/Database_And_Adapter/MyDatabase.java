package com.minhtamnguyen.projecta.Database_And_Adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static final String DBNAME = "MyDatabase.db";
    public static final String DBLOCATION = "/data/data/com.minhtamnguyen.projecta/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;

    public MyDatabase(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }

    //activity_xemdanhsach
    public ArrayList<Student> getListProduct() {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    //FindId class
    public ArrayList<Student> getOneStudent(String id) {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE ID =\'"+id+"\' ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    public ArrayList<Student> getOneStudentAutoComplete() {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);

            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    //findMajor
    public ArrayList<Student> getOneMajorIT() {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE Major ='IT' ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    public ArrayList<Student> getOneMajorEnglish () {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE Major ='English' ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    /*public ArrayList<Student> getOneMajor (String Majorname) {
        String Sql= "SELECT * FROM Data WHERE Major= ";
        Sql+= Majorname;
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery(Sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }*/

    public ArrayList<Student> getOneMajorTourist() {
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE Major ='Tourist' ", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            student = new Student(cursor.getString(0), cursor.getString(1), cursor.getString(2)
                    , cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    //get top n of IT major
    public ArrayList<Student> getTopnIT(String n){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT *, (IT+English+Math)/3 as Average FROM Data WHERE Average>=5 and Major='IT' ORDER BY Average DESC LIMIT '"+n+"'",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }
    //get top n english
    public ArrayList<Student> getTopnEnglish(String n){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT *, (IT+English+Math)/3 as Average FROM Data WHERE Average>=5 and Major='English' ORDER BY Average DESC LIMIT '"+n+"' ",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }
    //get top n tourist
    public ArrayList<Student> getTopnTourist(String n){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT *, (IT+English+Math)/3 as Average FROM Data WHERE Average>=5 and Major='Tourist' ORDER BY Average DESC LIMIT '"+n+"' ",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

    //get quantity of outstanding's student
    public ArrayList<Student> getQuantityOutstanding(){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE ((IT+English+Math)/3)>=8 ",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }
    //get quantity of excellent's student
    public ArrayList<Student> getQuantityExcellent(){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE ((IT+English+Math)/3)<8 and ((IT+English+Math)/3)>=6.5 ",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }
    //get quantity of average's student
    public ArrayList<Student> getQuantityAverage(){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE ((IT+English+Math)/3)<6.5 and ((IT+English+Math)/3)>=5 ",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }
    //get quantity of bad's student
    public ArrayList<Student> getQuantityBad(){
        Student student = null;
        ArrayList<Student> StudentList = new ArrayList<>();
        openDatabase();
        Cursor cursor = mDatabase.rawQuery("SELECT * FROM Data WHERE ((IT+English+Math)/3)<5",null);
        cursor.moveToFirst();
        while ((!cursor.isAfterLast())){
            student = new Student(cursor.getString(0),cursor.getString(1),cursor.getString(2),
                    cursor.getString(3), cursor.getString(4), cursor.getString(5),
                    cursor.getString(6), cursor.getDouble(7), cursor.getDouble(8),
                    cursor.getDouble(9));
            StudentList.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        closeDatabase();
        return StudentList;
    }

}
