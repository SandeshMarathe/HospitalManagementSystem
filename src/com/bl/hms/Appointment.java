package com.bl.hms;

public class Appointment {

    String patientId, appointmentId, appointmentDate, doctorId;
    long roomNumber;

    @Override
    public String toString() {
        return "Appointment{" +
                "patientId='" + patientId + '\'' +
                ", appointmentId='" + appointmentId + '\'' +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", roomNumber=" + roomNumber +
                '}';
    }
}


