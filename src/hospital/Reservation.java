package hospital;
import facade.UIData;
import mgr.Manageable;

import java.util.Random;
import java.util.Scanner;

public class Reservation extends Reception implements Manageable, UIData {
    String date;
    String patientCode;
    Patient patient;
    String name;
    String birth;
    String gender;
    String symptom="";
    Doctor doctor = null;

    Reservation(){	}

    public Reservation(Object[] row) {
        date = (String)row[0];
        patientCode = (String)row[1];
        name = (String)row[1];
        gender = (String)row[3];
        symptom = (String)row[4];
        doctor.name = (String)row[5];
    }

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
        gender = scan.next();
        String temp;
        while(true){
            temp = scan.next();
            if(temp.equals("0")){
                break;
            }
            symptom+=temp+" ";
        }
        symptom = symptom.strip();

        doctor = (Doctor)Main.doctorMgr.find(scan.next());

        if (doctor == null) {
            Random random = new Random();
            System.out.println("일치하는 의사가 없습니다. 의사를 자동 배정합니다.");
            int index = random.nextInt(Main.doctorMgr.mList.size());
            doctor = (Doctor)Main.doctorMgr.getMlist().get(index);
        }
    }

      /*if(symptom.startsWith("백신")) {
            String[] words = symptom.split(" ");

            for (int i = 1; i < words.length; i += 2) {
                String vName = words[i];
                int vNum = Integer.parseInt(words[i + 1].substring(0, 1));
                System.out.println(vName + vNum);
                if (Main.VaccinationMgr.find(vName)!=null) {
                    patient.getVaccinationList().put(vName + " " + vNum + "차", date);
                    System.out.println("====이름 : " + patient.name + "====");
                    patient.vaccinationPrint();
                } else {
                    System.out.println(vName+" 백신은 없습니다.");
                }
            }
            Main.receptionMgr.getMlist().add(this);
        }
    } */

    @Override
    public void set(Object[] uitexts) {

    }
    @Override
    public String[] getUiTexts() {
        String[] texts = new String[6];
        texts[0] = date;
        texts[1] = patientCode;
        texts[2] = name;
        texts[3] = gender;
        if(symptom.contains("백신")){
        	texts[4] = symptom;
        }
        texts[5] = doctor.getName();
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
