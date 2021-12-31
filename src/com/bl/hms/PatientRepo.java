package com.bl.hms;

import java.util.*;

public class PatientRepo {
    public static PatientRepo instance;
    Set <Patient>patientList = new HashSet();
    UserInterface userInterface = UserInterface.getInstance();

    public static PatientRepo getInstance(){
        if( instance == null ){
            instance = new PatientRepo();
        }
        return instance;
    }
    void addPatient() {
        Patient patient = userInterface.addPatient();
        patientList.add(patient);
    }

    Set getPatientList() {
        return  patientList;
    }

    public boolean isPatientAvailable(String patientID){
//        for (int i = 0; i < patientList.size(); i++ ){
//            if( patientList.get(i).patientId.equals(doctorId)){
//                return true;
//            }
//        }
//        return false;

        for (Patient patient : patientList) {
            if (patient.patientId.equals(patientID)) {
                return true;
            }
        }
        return false;
    }

    public Patient getPatient(String patientID) {
//        for (int i = 0; i < patientList.size(); i++) {
//            if (patientList.get(i).patientId.equals(patientID)) {
//                return patientList.get(i);
//            }
//        }
//        return null;

        for (Patient patient : patientList) {
            if (patient.patientId.equals(patientID)) {
                return patient;
            }
        }
        return null;
    }

    public void remove(Patient patientRemove) {
        patientList.remove(patientRemove);
    }
}

