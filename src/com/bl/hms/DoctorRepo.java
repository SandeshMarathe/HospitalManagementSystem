package com.bl.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DoctorRepo {
    public static DoctorRepo instance;
    private Set<Doctor> doctorList = new HashSet();

    DoctorRepo() {
    }

    public static DoctorRepo getInstance() {
        if (instance == null) {
            instance = new DoctorRepo();
        }
        return instance;
    }

    void addDoctor(Doctor doctor) {
        doctorList.add(doctor);
    }

    Set<Doctor> getDoctorList() {
        return doctorList;
    }

    public boolean isDoctorAvailable(String doctorID) {//10
//        for (int i = 0; i < doctorList.size(); i++) {
//            if (doctorList.get(i).id.equals(doctorID)) {
//                return true;
//            }
//        }
//        return false;

        for (Doctor doctor : doctorList) {
            if (doctor.id.equals(doctorID)) {
                return true;
            }
        }
        return false;
    }

    public Doctor getDoctor(String doctorID) {
//        for (int i = 0; i < doctorList.size(); i++) {
//            if (doctorList.get(i).id.equals(id)) {
//                return doctorList.get(i);
//            }
//        }
//        return null;

        for (Doctor doctor : doctorList) {
            if (doctor.id.equals(doctorID)) {
                return doctor;
            }
        }
        return null;
    }

    public void remove(Doctor doctor) {
        doctorList.remove(doctor);
    }
}



