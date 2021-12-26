package com.bl.hms;

import java.util.ArrayList;
import java.util.List;

public class PatientRepo {

    public static PatientRepo instance;

    private List <Patient> patientList = new ArrayList();

    private PatientRepo(){

    }

    public static PatientRepo getInstance(){
        if (instance == null){
            instance = new PatientRepo();
        }
        return instance;
    }

    void addPatient(Patient p)
    {
        patientList.add(p);
    }

    List getPatientList()
    {
        return  patientList;
    }

    public boolean isPatientAvailable(String id) {
        for (Patient patient : patientList){

            if (patient.patientId.equals(id)) {
                return true;
            }
        }
        return false;
    }
}
