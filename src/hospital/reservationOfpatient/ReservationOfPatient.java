package hospital.reservationOfpatient;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import facade.UIData;
import hospital.doctor.Doctor;
import hospital.patient.Patient;
import hospital.reservation.Reservation;
import mgr.Manageable;

public class ReservationOfPatient implements Manageable, UIData{
    Patient pati;
    Reservation reser;
    public ReservationOfPatient(Patient pati, Reservation reser) {
        this.pati = pati;
        this.reser = reser;
    }
    
    @Override
    public void set(Object[] uitexts) {
        // TODO Auto-generated method stub

    }
    //예방접종날짜, 환자코드, 백신, 담당의사
    @Override
    public String[] getUiTexts() {
        String[] texts = new String[4];
        texts[0] = reser.date;
        texts[1] = pati.patientCode;
        texts[2] = reser.symptom;
        texts[3] = reser.doctorName;
        return texts;
    }

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub

    }

    @Override
    public void print() {
        System.out.printf("(%s) %s : 담당의사 %s\n\t", reser.date, reser.symptom, reser.doctor.name);

    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        return false;
    }

}
