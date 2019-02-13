package com.example.lenovo.thescient;

public class Event_objects {
    String mdetails;
    String mdate;
    String mtime;
    public Event_objects(String details, String date, String time){
        mdetails = details;
        mdate = date;
        mtime = time;
    }

    public String getMdetails(){
        return mdetails;
    }
    public String getMdate(){
        return mdate;
    }
    public String getMtime(){
        return mtime;
    }
}
