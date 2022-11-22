package hospital;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import facade.UIData;
import mgr.Manageable;

public class Patient implements Manageable, UIData {
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub

	}
	@Override
	public String[] getUiTexts() {
		String[] texts = new String[6];
		texts[0] = patientCode;
		texts[1] = name;
		texts[2] = birth;
		texts[3] = ""+age;
		texts[4] = phone;
		texts[5] = address;
		return null;
	}

	// 환자코드 / 이름/ 성별/ 생년월일/ 전화번호/ 주소(동만)
	String patientCode;
	String name;
	String birth;
	int age;
	int month;
	String gender;
	String phone;
	String address="";
	ArrayList<Reception> receptionList = new ArrayList<Reception>();
	LinkedHashMap<String,String> vaccinationList = new LinkedHashMap<String,String>();
	@Override
	public void read(Scanner scan) {
		patientCode = scan.next();
		name = scan.next();
		gender = scan.next();
		birth = scan.next();

		LocalDateTime now = LocalDateTime.now();
		age = now.getYear()-Integer.parseInt("20"+birth.substring(0,2));

		month = 12*age + now.getMonthValue()-Integer.parseInt(birth.substring(2,4));

		phone = scan.next();
		address = scan.next();
		/*while(true){
			 	String temp = scan.next();
	            if(temp.equals("0")){
	                break;
	            }
	            address+=temp+" ";
		}*/
		for(int i = 0;i<Main.VaccinationMgr.mList.size();i++) {
			Vaccination vac = (Vaccination)Main.VaccinationMgr.getMlist().get(i);
			for(int j = 1;j<=vac.getNumber();j++)
			{
				vaccinationList.put(vac.getVaccine()+" "+j+"차","X");
			}
		}
	}
	void addReception(Reception r) {
		receptionList.add(r);
	}

	/*void addVaccination(Vaccination v){
		String vName = v.getVaccine();
		int vNum =
		vaccinationList.put(vac.getVaccine()+" "+j+"차","X")
	}*/

	protected String getBirth() {
		return birth;
	}

	protected LinkedHashMap<String, String> getVaccinationList() {
		return vaccinationList;
	}

	protected int getAge(){
		return age;
	}

	protected String getGender() {
		return gender;
	}

	protected int getMonth() {
		return month;
	}
	@Override
	public void print()
	{
		if(age <=3)
		{
			System.out.format("[%s] %s(%s, 만 %d세(%d개월)) : (연락처) %s (주소) %s\n",
					patientCode, name, gender, age, month, phone, address);
		}
		else {
			System.out.format("[%s] %s(%s, 만 %d세) : (연락처) %s (주소) %s\n",
					patientCode, name, gender, age, phone, address);
		}

		System.out.print("[진료기록] ");
		for(Reception r : receptionList) {
			r.printR();
		}
		System.out.println();
	}
	public void printD() {
		System.out.format("[%s] %s(%s, 만 %2s)\n\t", patientCode, name, gender, age);
	}
	@Override
	public boolean matches(String kwd)
	{
		if(kwd.equals(patientCode))
			return true;
		if(name.equals(kwd))
			return true;
		if(phone.equals(kwd))
			return true;
		if(address.equals(kwd))
			return true;

		return false;
	}
}
