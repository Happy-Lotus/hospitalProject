package hospital;

import java.util.ArrayList;
import java.util.Scanner;
import facade.UIData;
import mgr.Manageable;

public class Doctor implements Manageable, UIData
{
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	Doctor() { }
	//public Patient(){}
	public Doctor(Object[] row) {
		code = (String)row[0];
		name = (String)row[1];
		age = (Integer)row[2];
		gender = (String)row[3];
		phone = (String)row[4];
	}
	@Override
	public String[] getUiTexts() {
		String[] texts = new String[6];
		texts[0] = code;
		texts[1] = name;
		texts[2] = age+"";
		texts[3] = gender;
		texts[4] = phone;

		return texts;
	}
	//의사코드 의사이름 나이 연락처 성별
	String code;
	String name;
	int age;
	String gender;
	String phone;
	ArrayList<Patient> patientList = new ArrayList<Patient>();

	@Override
	public void read(Scanner scan) {
		code = scan.next();
		name = scan.next();
		age = scan.nextInt();
		phone = scan.next();
		gender = scan.next();
	}

	public String getName() {
		return name;
	}

	public void print() {
		System.out.format("[%s] %s : %s\n", code, name, phone);
		System.out.print("[진료환자] ");
		for(Patient p : patientList)
			p.printD();
		System.out.println();
	}

	//의사가 진료한 환자 리스트 저장
	void addPatient(Patient pati)
	{
		patientList.add(pati);
	}
	@Override
	public boolean matches(String kwd) {
		if(code.equals(kwd))
			return true;
		if(name.equals(kwd))
			return true;

		return false;
	}
}
