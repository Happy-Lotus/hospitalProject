package hospital;

import facade.UIData;
import mgr.Manageable;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Reservation extends Reception implements Manageable, UIData {
    String date;
    String patientCode;
    Patient patient;
    String name;
    String symptom="";

    Doctor doctor = null;

    Reservation() {
    }

    public Reservation(Object[] row) {
        date = (String) row[0];
        patientCode = (String) row[1];
        name = (String) row[1];
        symptom = (String) row[3];
        doctor.name = (String) row[4];
    }

    @Override
    public void read(Scanner scan) {
        date = scan.next();
        patientCode = scan.next();
        patient = (Patient) Main.patientMgr.find(patientCode);
        if (patient == null) {
            System.out.println("해당 환자코드와 일치하는 환자가 없습니다. 등록이 필요합니다.");
            patient = new Patient();
            patient.read(scan);
        }
        name = scan.next();
        String temp;
        while(true){
            temp = scan.next();
            if(temp.contains("차")){
                symptom+=temp;
                break;
            }
            symptom+=temp+" ";
        }

        doctor = (Doctor) Main.doctorMgr.find(scan.next());

        if (doctor == null) {
            Random random = new Random();
            System.out.println("일치하는 의사가 없습니다. 의사를 자동 배정합니다.");
            int index = random.nextInt(Main.doctorMgr.mList.size());
            doctor = (Doctor) Main.doctorMgr.getMlist().get(index);
        }

        String[] words = symptom.split(" ");
            String vName = words[0];
            int vNum = Integer.parseInt(words[1].substring(0, 1));
            System.out.println(vName + vNum);
            if (Main.VaccinationMgr.find(vName) != null) {
                patient.getVaccinationList().put(vName + " " + vNum + "차", date);
            } else {
                System.out.println(vName + " 백신은 없습니다.");
            }
        }


    @Override
    public void set(Object[] uitexts) {

    }
    @Override
    public String[] getUiTexts() {

        String[] texts = new String[5];

            texts[0] = date;
            texts[1] = patientCode;
            texts[2] = name;
            texts[3] = symptom;
            texts[4] = doctor.getName();
            return texts;
    }

    @Override
    public void print() {
    	
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name))
            return true;
        if (kwd.equals(patientCode))
            return true;
        if (kwd.equals(""+patient.getAge()))
            return true;
        if (kwd.equals(gender) && kwd.length() == 1)
            return true;
        if (kwd.equals(doctor.getName()))
            return true;
        if (symptom.contains(kwd))
            return true;
        return false;
    }
}