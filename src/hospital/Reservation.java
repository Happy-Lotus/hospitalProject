package hospital;

import facade.UIData;
import mgr.Manageable;

import java.util.List;

import java.util.Random;
import java.util.Scanner;

public class Reservation implements Manageable, UIData {
    String date;
    String patientCode;
    Patient patient;
    String name;
    String symptom="";
    Doctor doctor = null;
    String doctorName;
	public List<ReservationOfPatient> rsList;

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
        doctorName = scan.next();
        doctor = (Doctor)Main.doctorMgr.find(doctorName);

        if (doctor == null) {
            Random random = new Random();
            System.out.println("일치하는 의사가 없습니다. 의사를 자동 배정합니다.");
            int index = random.nextInt(Main.doctorMgr.mList.size());
            doctor = (Doctor) Main.doctorMgr.getMlist().get(index);
        }

        String[] words = symptom.split(" ");
        String vName = words[0];
        int vNum = Integer.parseInt(words[1].substring(0, 1));
        if (Main.VaccinationMgr.find(vName) != null) {
            patient.getVaccinationList().put(vName + " " + vNum + "차", date);
        }
        else {
            System.out.println(vName + " 백신은 없습니다.");
        }

        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            patient.addRervation(this);
        }
    }

    public Reservation() {
    }

    public Reservation(Object[] row) {
        date = (String) row[0];
        patientCode = (String) row[1];
        patient = (Patient) Main.patientMgr.find(patientCode);
        if(patient == null){
           /* System.out.println("해당 환자코드와 일치하는 환자가 없습니다. 등록이 필요합니다.");
            patient = new Patient();
            patient.read(scan);*/ //해당환자에 대한 입력 진행.
        }
        name = (String) row[2];
        symptom = (String) row[3];
        String [] words = symptom.split(" ");
        if(Main.VaccinationMgr.find(words[0]) != null){
            patient.getVaccinationList().put(words[0]+" "+words[1]+"차",date);
        }

        if (Main.reservationMgr.find((String)row[4])== null) {
            Random random = new Random();
            System.out.println("일치하는 의사가 없습니다. 의사를 자동 배정합니다.");
            int index = random.nextInt(Main.doctorMgr.mList.size());
            doctor = (Doctor)Main.doctorMgr.getMlist().get(index);
            this.doctorName = doctor.name;
        
        }else {
        doctorName = (String) row[4];
        }
       
        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            patient.addRervation(this);
        }
    }

    public String getDoctorName() {
        return doctorName;
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
        texts[4] = doctorName;

        return texts;
    }

    @Override
    public void print() {
        System.out.format("[%s] %s(%s, 만 %d세(%d개월)) : %s 담당의사 %s\n",
                date, name, patient.gender, patient.age, patient.month, symptom, doctor.name);
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name))
            return true;
        if (kwd.equals(patientCode))
            return true;
        if (kwd.equals(""+patient.getAge()))
            return true;
        if (kwd.equals(patient.gender) && kwd.length() == 1)
            return true;
        if (kwd.equals(doctor.getName()))
            return true;
        if (symptom.contains(kwd))
            return true;
        return false;
    }
}
