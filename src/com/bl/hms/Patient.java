package com.bl.hms;

public class Patient {

    enum Gender{
        MALE, FEMALE, OTHERS
    }

    String name, address, emailID, disease, patientId;
    long mobNo, age;
    Gender gender;

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\n' +
                ", address='" + address + '\n' +
                ", emailID='" + emailID + '\n' +
                ", disease='" + disease + '\n' +
                ", patientId='" + patientId + '\n' +
                ", mobNo=" + mobNo + '\n' +
                ", age=" + age + '\n' +
                ", info=" + gender + '\n' +
                '}';
    }
}


