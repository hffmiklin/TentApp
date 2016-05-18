package com.example.hannah.tentapp.androidsqlite;

/**
 * Created by Emeli on 2016-05-18.
 */
public class Exam {
    //private variables
    int _id;
    String _course_nr;
    String _course_name;
    String _date;
    String _time_start;
    String _time_end;
    String _aid;
    String _building;
    String _address;
    String _room;
    String _reg_open;
    String _reg_close;

    //Empty contructor
    public Exam(){

    }
    //constructor
    public Exam(int id,
                String course_nr,
                String course_name,
                String date,
                String time_start,
                String time_end,
                String aid,
                String building,
                String address,
                String room,
                String reg_open,
                String reg_close){

        this._id = id;
        this._course_nr = course_nr;
        this._course_name = course_name;
        this._date = date;
        this._time_start = time_start;
        this._time_end = time_end;
        this._aid = aid;
        this._building = building;
        this._address = address;
        this._room = room;
        this._reg_open = reg_open;
        this._reg_close = reg_close;
    }
}
