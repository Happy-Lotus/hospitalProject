package hospital;
import facade.UIData;
import mgr.Manageable;
import java.util.Scanner;

public class Reception implements Manageable, UIData {

    String date;
    Patient patient;
    String name;
    String birth;
    String gender;
    String symptom="";
    Doctor doctor = null;

    @Override
    public void read(Scanner scan) {
        date = scan.next();
        String patientCode = scan.next();
        patient = (Patient) Main.patientMgr.find(patientCode);
        if (patient == null) {
            //patient 클래스에서 등록 진행
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

        if(temp.substring(0,2).equals("백신")){
            String[]words = symptom.split(" ");

            for(int i =1; i<words.length;i+=2){
                String vName = words[i];
                int vNum = Integer.parseInt(words[i+1]);
                if((Vaccination)Main.VaccinationMgr.find(vName)!=null){
                    patient.vaccinationList.add(vNum-1,date);
                }
            }
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

    public void addReception(Reservation v){
        Main.receptionMgr.mList.add(v);
    }

    @Override
    public String[] getUiTexts() {
        String[] texts = new String[6];
        texts[0] = date;
        texts[1] = name;
        texts[2] = gender;
        texts[3] = ""+patient.age;
        texts[4] = symptom;
        texts[5] = doctor.name;
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