package com.minhtamnguyen.projecta;

import com.minhtamnguyen.projecta.Database_And_Adapter.Student;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest{

    @Test
    public void testView() throws Exception {
        Student student = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("102003969",student.getID());

        Student student1 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("Nguyễn Nhã",student1.getLastName());
        Student student2 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("Ái",student2.getFirstName());
        Student student3 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("16/01/1999",student3.getDayOfBirth());
        Student student4 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("Nữ",student4.getGender());
        Student student5 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("IT",student5.getMajor());
        Student student6 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals( 5.0,student6.getEngLish());
        Student student7 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals(6.0,student7.getMath());
        Student student8 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals(5.0,student8.getIT());
        Student student9 = new Student("1","102003969","Nguyễn Nhã","Ái"
                ,"16/01/1999","Nữ","IT",5.0,6.0,5.0);
        assertEquals("1",student9.getNo());
    }
}