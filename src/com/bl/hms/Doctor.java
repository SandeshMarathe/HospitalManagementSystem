package com.bl.hms;

import java.util.Map;

public class Doctor {

    public static Doctor instance;

//    public static Doctor getInstance(){
//        if(instance == null){
//            instance = new Doctor();
//        }
//        return instance;
//    }

    enum WeekDays{
        SUNDAY, MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    String docName;
    String specialization;
    String emailID;
    String id;
    long mobNo;
    Map<WeekDays,String> availability;

    @Override
    public String toString() {
        return "Doctor{" +
                "docName='" + docName + '\n' +
                ", specialization='" + specialization + '\n' +
                ", emailID='" + emailID + '\n' +
                ", id='" + id + '\n' +
                ", mobNo=" + mobNo + '\n' +
                ", availability=" + availability + '\n' +
                '}';
    }
}


