package hospital;
import facade.UIData;
import mgr.Manageable;
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


    Reception(){	}
    public Reception(Object[] row) {
        date = (String)row[0];
        patientCode = (String)row[1];
        name = (String)row[2];
        symptom = (String)row[3];
        doctor.name = (String)row[4];
    }

    @Override
    public void read(Scanner scan) {
        date = scan.next();
        patientCode = scan.next();
        patient = (Patient)Main.patientMgr.find(patientCode);
        if (patient == null) {
            System.out.println("환자 비어있음");
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
        doctor = (Doctor)Main.doctorMgr.find(scan.next());

        if (doctor == null) {
            System.out.println("일치하는 의사가 없음");
            System.exit(0);
        }

        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            doctor.addPatient(patient);
        }
        if(patient.matches(patientCode)) {//신규환자일 경우 의사가 담당하는 patientList에 저장함. 아닐 경우 pass.
            patient.addReception(this);
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
    public void printR() {
        System.out.printf("(%s) %s : 담당의사 %s\n\t", date, symptom, doctor.name);
    }
    @Override
    public boolean matches(String kwd) {
        if (kwd.equals(name))
            return true;
        if (kwd.equals(""+patient.age))
            return true;
        if (kwd.equals(gender) && kwd.length() == 1)
            return true;
        if (kwd.equals(doctor.name))
            return true;
        return false;
    }
}

/*
    if (symptom.contains(kwd))
            return true;
    - 증상 키워드에 따라 출력하는 기능 필요시 추가
    if kwd="예방접종" kwd 따라 증상에 예방접종 저장되어있는 patient 출력
    */


/*
        name = patient.name;
        age = patient.age;
        gender = patient.gender;
        symptom = scan.nextLine();
        String kwd2 = scan.next();
        for(Doctor doctor :hospitalMain.doctorMgr.mList){
            if(doctor.matches(kwd2))
                if(doctor.patientList.contains(patient)){
                    this.doctor = doctor;
                    break;
                }
        }
 */