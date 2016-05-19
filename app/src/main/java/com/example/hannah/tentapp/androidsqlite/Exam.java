package com.example.hannah.tentapp.androidsqlite;

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
    /*
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
*/
    //setters
    public void setCourseNr(String courseNr){
        this._course_nr = courseNr;
    }
    public void setCourseName(String courseName){
        this._course_name = courseName;
    }
    public void setDate(String date) {
        this._date = date;
    }
    public void setTimeStart(String timeStart){
        this._time_start = timeStart;
    }
    public void setTimeEnd(String timeEnd){
        this._time_end = timeEnd;
    }
    public void setAid(String aid){
        this._aid = aid;
    }
    public void setBuilding(String building){
        this._building = building;
    }
    public void setRoom(String room){
        this._room = room;
    }
    public void setRegOpen(String regOpen){
        this._reg_open = regOpen;
    }
    public void setRegClose(String regClose){
        this._reg_close = regClose;
    }
    public void setRegistered(String registered){
        this._registered = registered;
    }

    // getters
    public String getCourseNr() {
        return this._course_nr;
    }
    public String getCourseName() {
        return this._course_name;
    }
    public String getDate() {
        return this._date;
    }
    public String getTimeStart() {
        return this._time_start;
    }
    public String getTimeEnd() {
        return this._time_end;
    }
    public String getAid() {
        return this._aid;
    }
    public String getBuilding() {
        return this._building;
    }
    public String getRoom() {
        return this._room;
    }
    public String getRegOpen() {
        return this._reg_open;
    }
    public String getRegClose() {
        return this._reg_close;
    }
    public String getRegistered() {
        return this._registered;
    }
}
