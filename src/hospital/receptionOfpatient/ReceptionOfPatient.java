package hospital.receptionOfpatient;

import java.util.Scanner;

import facade.UIData;
import hospital.patient.Patient;
import hospital.reception.Reception;
import mgr.Manageable;

public class ReceptionOfPatient implements Manageable, UIData{
    Patient pati;
    Reception rece;

    public ReceptionOfPatient(Patient pati, Reception rece) {
        this.pati = pati;
        this.rece = rece;
    }
    @Override
    public void set(Object[] uitexts) {
        // TODO Auto-generated method stub

    }
    //"진료날짜", "환자코드", "증상","담당의사"
    @Override
    public String[] getUiTexts() {
        String[] texts = new String[5];
        texts[0] = rece.date;
        texts[1] = pati.patientCode;
        texts[2] = rece.symptom;
        texts[3] = rece.doctor.name;
        return texts;
    }

    @Override
    public void read(Scanner scan) {
        // TODO Auto-generated method stub

    }

    @Override
    public void print() {
        System.out.printf("(%s) %s : 담당의사 %s\n\t", rece.date, rece.symptom, rece.doctor.name);
    }

    @Override
    public boolean matches(String kwd) {
        // TODO Auto-generated method stub
        return false;
    }

}
