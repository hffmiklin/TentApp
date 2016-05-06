package com.example.hannah.tentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.*;

public class ExamList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_list);

        // TODO Import list of exams from database
        // hard coding list of strings instead of getting from db
        // just to see if "future" connection works
        List<String> courseList = new ArrayList<String>();
        courseList.add("TIG164 Interaktionsdesign");
        courseList.add("TIG015 Informationsteknologi och informationssystem");
        courseList.add("TIG016 Verksamheter och information");
        courseList.add("TIG058 Databaser och programmeringsteknik");
        courseList.add("TIG999 Harry Potter och hans världar");
        courseList.add("TIG059 Systemutvecklingsprojekt");
        courseList.add("TIG098 eBusiness och eGovernment");
        courseList.add("TIG162 Affärssystem");
        courseList.add("TIG163 Beslutsstödssystem");

    }
}
