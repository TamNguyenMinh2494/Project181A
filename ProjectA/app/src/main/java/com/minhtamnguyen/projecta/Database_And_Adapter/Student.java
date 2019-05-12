package com.minhtamnguyen.projecta.Database_And_Adapter;

import java.util.Comparator;

public class Student {
    private String No;
    private String ID;
    private String LastName;
    private String FirstName;
    private String DayOfBirth;
    private String Gender;
    private String Major;
    private double EngLish;
    private double Math;
    private double IT;
    public Student(String no, String ID, String lastName, String firstName, String dayOfBirth, String gender, String major, double engLish, double math, double IT) {
        No = no;
        this.ID = ID;
        LastName = lastName;
        FirstName = firstName;
        DayOfBirth = dayOfBirth;
        Gender = gender;
        Major = major;
        EngLish = engLish;
        Math = math;
        this.IT = IT;
    }


    public double getAverage() {
        return ((EngLish+Math+IT)/3);
    }

    public String Rank() //bad - average - outstanding
    {
        if(getAverage()>=8)
            return "Outstanding";
        else if (getAverage()>=6.5)
            return "Excellent";
        else if (getAverage()>=5)
            return "Average";
        else
            return "Bad";
    }

    public String getNo() {
        return No;
    }

    public void setNo(String no) {
        No = no;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        DayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public double getEngLish() {
        return EngLish;
    }

    public void setEngLish(double engLish) {
        EngLish = engLish;
    }

    public double getMath() {
        return Math;
    }

    public void setMath(double math) {
        Math = math;
    }

    public double getIT() {
        return IT;
    }

    public void setIT(double IT) {
        this.IT = IT;
    }




}
