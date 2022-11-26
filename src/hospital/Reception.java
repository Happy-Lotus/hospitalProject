package hospital;
import facade.UIData;
import mgr.Manageable;

import java.util.Random;
import java.util.Scanner;

public class Reception implements Manageable, UIData {
    String date;
    String patientCode;
    Patient patient;
    String name;
    String birth;
    String gender;
    String symptom="";
    Doctor doctor = null;
    String doctorName;

    @Override
    public void read(Scanner scan) {
        date = scan.next();
        patientCode = scan.next();
        patient = (Patient)Main.patientMgr.find(patientCode);
        if (patient == null) {
            System.out.println("해당 환자코드와 일치하는 환자가 없습니다. 등록이 필요합니다.");
            patient = new Patient();
            patient.read(scan);
        }
        name = scan.next();
        gender = patient.gender;
        birth = patient.birth;
        String temp;
        while(true){
            temp = scan.next();
            if(temp.equals("0")){
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
            doctor = (Doctor)Main.doctorMgr.getMlist().get(index);
        }

        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            doctor.addPatient(patient);
        }
        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            patient.addReception(this);
        }
    }

    Reception(){	}

    public Reception(Object[] row) {
        date = (String)row[0];
        patientCode = (String)row[1];
        name = (String)row[2];
        symptom = (String)row[3];
        doctorName = (String)row[4];
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
        if(symptom.contains("백신")){
            texts[3] = "백신";
        }
        else{
            texts[3] = symptom;
        }
        texts[4] = doctor.name;
        return texts;
    }

    @Override
    public void print() {
        if(patient.age <=3)
        {
            System.out.format("[%s] %s(%s, 만 %d세(%d개월)) : %s 담당의사 %s\n",
                    date, name, patient.gender, patient.age, patient.month, symptom, doctor.name);
        }
        else {
            System.out.format("[%s] %s(%s, 만 %d세) : %s 담당의사 %s\n",
                    date, name, patient.gender, patient.age, symptom, doctor.name);
        }
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name))
            return true;
        if (kwd.equals(patientCode))
            return true;
        if (kwd.equals("" + patient.getAge()))
            return true;
        if (kwd.equals(gender) && kwd.length() == 1)
            return true;
        if (kwd.equals(doctor.getName()))
            return true;
        if (symptom.contains(kwd))
            return true;
        if(date.equals(kwd))
            return true;
        return false;
    }
}