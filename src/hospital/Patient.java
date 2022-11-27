package hospital;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.time.LocalDateTime;
import facade.UIData;
import mgr.Manageable;

public class Patient implements Manageable, UIData {

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	Patient() { }
	//public Patient(){}
	public Patient(Object[] row) {
		patientCode = (String)row[0];
		name = (String)row[1];
		gender = (String)row[2];
		birth = (String)row[3];
		phone = (String)row[4];
		address = (String)row[5];
	}
	@Override
	public String[] getUiTexts() {
		String[] texts = new String[6];
		texts[0] = patientCode;
		texts[1] = name;
		texts[2] = gender;
		texts[3] = birth;
		texts[4] = phone;
		texts[5] = address;
		return texts;
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
	ArrayList<ReceptionOfPatient> rpList = new ArrayList<ReceptionOfPatient>();
	ArrayList<Reception> receptionList = new ArrayList<>();

	ArrayList<ReservationOfPatient> rsList = new ArrayList<>();
	ArrayList<Reservation> reservationList = new ArrayList<>();
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

		for(int i = 0;i<Main.VaccinationMgr.mList.size();i++) {
			Vaccination vac = (Vaccination)Main.VaccinationMgr.getMlist().get(i);
			for(int j = 1;j<=vac.getNumber();j++)
			{
				vaccinationList.put(vac.getVaccine()+" "+j+"차","X");
			}
		}
	}

	void addReception(Reception r)
	{
		receptionList.add(r);
		rpList.add(new ReceptionOfPatient(this, r));
	}
	void addRervation(Reservation r)
	{
		reservationList.add(r);
		rsList.add(new ReservationOfPatient(this, r));
	}

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

	void vaccinationPrint() {
		Set<String> keyset = vaccinationList.keySet();
		for(String key : keyset) {
			System.out.println(key + ":" + vaccinationList.get(key));

		}
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
		for(ReceptionOfPatient rp : rpList) {
			rp.print();
		}
		System.out.println();
		System.out.print("[예방접종기록] ");
		for(ReservationOfPatient rs : rsList) {
			rs.print();
		}
		System.out.println();
	}
	public void printD()
	{
		System.out.format("[%s] %s(%s, 만 %2s세)\n\t", patientCode, name, gender, age);
	}
	@Override
	public boolean matches(String kwd)
	{
		if(patientCode.contains(kwd))
			return true;
		if(name.contains(kwd))
			return true;
		if(birth.contains(kwd))
			return true;
		if(gender.contains(kwd))
			return true;
		if(phone.contains(kwd))
			return true;
		if(address.contains(kwd))
			return true;
		/*for(ReceptionOfPatient rp : rpList) {
			if(rp.rece.patientCode.matches(kwd))
				return true;
		}*/
		return false;
	}
}
