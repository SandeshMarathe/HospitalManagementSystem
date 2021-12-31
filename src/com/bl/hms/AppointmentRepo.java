package com.bl.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentRepo {
    private static AppointmentRepo instance;
    Set<Appointment> appointmentList = new HashSet();
    UserInterface userInterface = UserInterface.getInstance();

    AppointmentRepo(){
    }

    public static AppointmentRepo getInstance(){
        if ( instance == null){
            instance = new AppointmentRepo();
        }
        return instance;
    }

    void addAppointment() {
        Appointment appointment = userInterface.addAppointment();
        appointmentList.add(appointment);
    }

    Set<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public Appointment getAppointment(String appointmentID) {

//        for (int i = 0; i < appointmentList.size(); i++) {
//            if(appointmentList.get(i).appointmentId.equals(appointmentID)){
//                return appointmentList.get(i);
//            }
//        }
//        return null;

        for (Appointment appointment : appointmentList) {
            if (appointment.appointmentId.equals(appointmentID)) {
                return appointment;
            }
        }
        return null;
    }

    public void remove(Appointment appointment) {
        appointmentList.remove(appointment);
    }
}

