package hospital;
import facade.UIData;
import mgr.Manageable;

import java.util.*;

public class Reception implements Manageable, UIData {

    String date;
    String patientCode;
    Patient patient;
    String name;
    String birth;
    String gender;
    String symptom="";
    Doctor doctor = null;

    public Reception(Object[]row){
        date=(String)row[0];
        patientCode=(String)row[1];
        name=(String)row[2];
        symptom=(String)row[3];
        doctor.name = (String)row[4];
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
        gender = scan.next();
        birth = patient.birth;
        String temp;
        while(true){
            temp = scan.next();
            if(temp.equals("0")){
                break;
            }
            symptom+=temp+" ";
        }

        doctor = (Doctor)Main.doctorMgr.find(scan.next());

        if (doctor == null) {
            Random random = new Random();
            System.out.println("일치하는 의사가 없습니다. 의사를 자동 배정합니다.");
            int index = random.nextInt(Main.doctorMgr.getMlist().size());
            doctor = (Doctor)Main.doctorMgr.getMlist().get(index);
        }

        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            doctor.addPatient(patient);
        }
        if(patient.matches(patientCode)) {//환자코드와 patient가 일치할 경우 patient의 진료기록에 현재 진료기록을 저장함.
            patient.addReception(this);
        }
        if(symptom.substring(0,2).equals("백신")){
            String[]words = symptom.split(" ");

            for(int i =1; i<words.length-1;i+=2){
                String vName = words[i];
                int vNum = Integer.parseInt(words[i+1].substring(0,1));
                if(Main.VaccinationMgr.find(vName)!=null){
                    patient.vaccinationList.put(vName+" "+vNum+"차",date);
                }
                else {
                    System.out.println("해당되는 백신은 없습니다.");
                }
            }
        }
        Main.receptionMgr.getMlist().add(this);
    }

    @Override
    public void set(Object[] uitexts) {

    }

    /*public void addReception(Reservation v) {

        Main.receptionMgr.mList.add((Reception) v);
    }*/

    @Override
    public String[] getUiTexts() {
        String[] texts = new String[6];
        texts[0] = date;
        texts[1] = name;
        texts[2] = gender;
        texts[3] = ""+patient.getAge();
        texts[4] = symptom;
        texts[5] = doctor.getName();
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

    public void printR() {

        System.out.printf("(%s) %s : 담당의사 %s\n\t", date, symptom, doctor.name);
    }

    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name))
            return true;
        if (kwd.equals("" + patient.age))
            return true;
        if (kwd.equals(gender) && kwd.length() == 1)
            return true;
        if (kwd.equals(doctor.name))
            return true;
        if (symptom.contains(kwd))
            return true;
        return false;
    }
}