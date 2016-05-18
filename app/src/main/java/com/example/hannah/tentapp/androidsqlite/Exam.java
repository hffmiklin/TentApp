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
    String _registered;

    //Empty contructor
    public Exam(){

    }
    //constructor for courseList
    public Exam(String course_nr,
                String course_name){

        this._course_nr = course_nr;
        this._course_name = course_name;
    }
    //constructor for courseDateList
    public Exam(String date){

        this._date = date;
    }
    //constructor for courseTimeList 
    public Exam(String time_start,
                String time_end){

        this._time_start = time_start;
        this._time_end = time_end;
    }
    //constructor for courseAidList
    public Exam(String aid){

        this._aid = aid;
    }
    // constructor for coursePlaceList
    public Exam(String building,
                String room){
                    
        this._building = building;
        this._room = room;
    }
    //constructor for courseRegIntervalList
    public Exam(String reg_open,
                String reg_close){
        
        this._reg_open = reg_open;
        this._reg_close = reg_close;
    }
    //constructor for courseRegYesNoList
    public Exam(String registered){
        
        this._registered = registered;
    }
    
    // getters
    public String getCourseNr() {
        return this.course_nr;
    }
    public String getCourseName() {
        return this.course_name;
    }
    public String getDate() {
        return this.date;
    }
    public String getTimeStart() {
        return this.time_start;
    }
    public String getTimeEnd() {
        return this.time_end;
    }
    public String getAid() {
        return this.aid;
    }
    public String getBuilding() {
        return this.building;
    }
    public String getRoom() {
        return this.room;
    }
    public String getRegOpen() {
        return this.reg_open;
    }
    public String getRegClose() {
        return this.reg_close;
    }
    public String getRegistered() {
        return this.registered;
    }
}
