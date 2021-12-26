package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class DoctorRepo {

    private static DoctorRepo instance;
    private List <Doctor> doctorList = new ArrayList();

    private DoctorRepo() {

    }

    public static DoctorRepo getInstance(){
        if (instance == null) {
            instance = new DoctorRepo();
        }
        return instance;
    }

    void add(Doctor doctor) {
        doctorList.add(doctor);
    }

    List getDoctorList() {
        return doctorList;
    }

    void removeMethod(Doctor doctor){
        doctorList.remove(doctor);
    }

    public Doctor get(String id){
        for (int i = 0; i < doctorList.size(); i++){
            if (doctorList.get(i).id.equals(id)){
                return doctorList.get(i);

            }
        }
        return null;
    }

    public boolean isDoctorAvailable(String id) {
        for (Doctor doctor : doctorList){

            if (doctor.id.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
