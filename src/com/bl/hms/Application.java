package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {
//    DoctorRepo doctorRepo = DoctorRepo.getInstance();
//    PatientRepo patientRepo = PatientRepo.getInstance();
//    AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
    Patient patient = new Patient();
    Doctor doctor = new Doctor();
    Appointment appointment = new Appointment();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int exit = 13;
        int option;
        UserInterface userInterface = UserInterface.getInstance();
        Application application = new Application();

        do{
            option = userInterface.ShowMainMenu();
            application.handleUserSelection(option);
        }while (option != exit);
    }

    void handleUserSelection(int option) {
        DoctorRepo doctorRepo = DoctorRepo.getInstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();

        UserInterface userInterface = UserInterface.getInstance();
        switch (option) {
            case 1:
                addDoctor();
                break;
            case 2:
                break;
            case 3:
                System.out.println("Enter the doctor id to remove that doctor");
                String id = scanner.nextLine();
                Doctor doctor  = doctorRepo.get(id);
                doctorRepo.removeMethod(doctor);
                break;
            case 4:
                List lstDoc = doctorRepo.getDoctorList();
                userInterface.printAllDoctor(lstDoc);
                break;
            case 5:
                addPatient();
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                List lstPatient = patientRepo.getPatientList();
                userInterface.printAllPatient(lstPatient);
                break;
            case 9:
                addAppointment();
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                List lstAppointment = appointmentRepo.getAppointmentList();
                userInterface.printAllAppointment(lstAppointment);
                break;
            case 13:
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
        }
    }

    void addDoctor() {

        DoctorRepo doctorRepo = DoctorRepo.getInstance();

        System.out.println("Enter Doctor Name :");
        doctor.docName = scanner.nextLine();

        System.out.println("Enter Doctor Specialization :");
        doctor.specialization = scanner.nextLine();

        System.out.println("Enter Doctor Email ID :");
        doctor.emailID = scanner.nextLine();

        System.out.println("Enter Doctor ID :");
        doctor.id = scanner.nextLine();

        System.out.println("Enter Doctor Mobile Name :");
        doctor.mobNo = scanner.nextLong();

        doctor.availability = new HashMap<>();;
        doctor.availability.put(Doctor.WeekDays.SUNDAY,"10 AM to 12 PM");
        doctor.availability.put(Doctor.WeekDays.MONDAY,"12 PM to 2 PM");
        doctor.availability.put(Doctor.WeekDays.TUESDAY,"2 PM to 4 PM");
        doctor.availability.put(Doctor.WeekDays.WEDNESDAY,"4 PM to 6 PM");
        doctor.availability.put(Doctor.WeekDays.THURSDAY,"6 PM to 8 PM");
        doctor.availability.put(Doctor.WeekDays.FRIDAY,"8 PM to 10 PM");
        doctor.availability.put(Doctor.WeekDays.SATURDAY,"10 PM to 12 AM");

        doctorRepo.add(doctor);
    }

    void addPatient() {

        System.out.println("Enter Patient Name :");
        patient.name = scanner.nextLine();

        System.out.println("Enter Patient Email ID :");
        patient.emailID = scanner.nextLine();

        System.out.println("Enter Patient Disease :");
        patient.disease = scanner.nextLine();

        System.out.println("Enter the Patient Address :");
        patient.address = scanner.nextLine();

        System.out.println("Enter the Patient ID :");
        patient.patientId = scanner.nextLine();

        System.out.println("Enter Patient Age :");
        patient.age = scanner.nextLong();

        System.out.println("Enter Patient Mobile Name :");
        patient.mobNo = scanner.nextLong();

        System.out.println("1.Male \n2.Female \n3.Others :");
        int option = scanner.nextInt();

        patient.info = new HashMap<>();

        switch (option) {
            case 1:
                patient.info.put(Patient.Gender.MALE,"MALE");
                break;
            case 2:
                patient.info.put(Patient.Gender.FEMALE,"FEMALE");
                break;
            case 3:
                patient.info.put(Patient.Gender.OTHERS,"OTHERS");
                break;
            default:
                System.out.println("Wrong Option..!");
                break;
        }
        PatientRepo patientRepo = PatientRepo.getInstance();
        patientRepo.addPatient(patient);
    }

    void addAppointment() {

        DoctorRepo doctorRepo = DoctorRepo.getInstance();
        PatientRepo patientRepo = PatientRepo.getInstance();
        AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();

        System.out.println("Enter the AppointmentId :");
        appointment.appointmentId = scanner.nextLine();

        System.out.println("Enter Doctor ID :");
        doctor.id = scanner.nextLine();

        if (!doctorRepo.isDoctorAvailable(doctor.id)) {
            System.out.println("Doctor Available");
            return;
        }

        System.out.println("Enter the PatientId :");
        patient.patientId = scanner.nextLine();

        if (!patientRepo.isPatientAvailable(patient.patientId)) {
            System.out.println("Patient Available");
            return;
        }

        System.out.println("Enter the RoomNumber :");
        appointment.roomNumber = scanner.nextLong();

        System.out.println("Enter the Appointment Date like dd-MMM-yyyy");
        Scanner scanner2 = new Scanner(System.in);
        appointment.appointmentDate = scanner2.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        try {
            Date date = formatter.parse(appointment.appointmentDate);
        } catch (ParseException e) {
            e.printStackTrace(); //Print Exception in Details
        }

        appointmentRepo.addAppointment(appointment);
    }
}
