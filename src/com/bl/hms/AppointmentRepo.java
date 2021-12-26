package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class AppointmentRepo {

    public static AppointmentRepo instance;

    List appointmentList = new ArrayList();

    private AppointmentRepo(){

    }

    public static AppointmentRepo getInstance()
    {
        if (instance == null){
            instance = new AppointmentRepo();
        }
        return instance;
    }

    void addAppointment(Appointment apt) {
        appointmentList.add(apt);
    }

    List getAppointmentList()
    {
        return appointmentList;
    }
}
