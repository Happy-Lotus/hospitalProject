package hospital.vaccination;
import java.util.ArrayList;
import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;
public class Vaccination implements Manageable, UIData{

	String vaccine;
	String infection="";
	int number;
	VaccinationDetail detail;
	ArrayList<VaccinationDetail> details = new ArrayList<>();

	public void read(Scanner scan) {
		vaccine = scan.next();
		while(true){

			String temp = scan.next();
			if(temp.equals("0")){
				break;
			}
			infection +=temp+" ";
		}
		number = scan.nextInt();
		for(int i=0;i<number;i++){
			detail = new VaccinationDetail();
			detail.read(scan);
			details.add(detail);
		}
	}

	public String getVaccine() {
		return vaccine;
	}

	public String getInfection() {
		return infection;
	}

	public int getNumber() {
		return number;
	}

	public VaccinationDetail getDetail() {
		return detail;
	}

	public ArrayList<VaccinationDetail> getDetails() {
		return details;
	}

	public void print() {
		int i = 1;
		System.out.printf("%s - %s %d번\n", infection, vaccine,number);
		for(VaccinationDetail v : details){
			System.out.printf("%d차",i++);
			v.print();
		}
		System.out.println();
	}

	public boolean matches(String kwd) {
		if (infection.contains(kwd)) // ""일 때 true
			return true;
		if (vaccine.equals(kwd))
			return true;
		if((""+number).equals(kwd))
			return true;
		return false;
	}

	public boolean matches(String[] kwdArr) { // 개월 시기 match할 때 사용
		for (String kwd : kwdArr) {
			if (!detail.matches(kwd+"개월"))
				return false;
		}
		return true;
	}

	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getUiTexts() {
		int i = 1;

		String[] texts = new String[8];
		texts[0] = vaccine;
		texts[1] = infection;
		texts[2] = Integer.toString(number);

		for (VaccinationDetail v : details){
			texts[2 + i] = v.startTime + "~" + v.endTime;
			i++;
		}
		return texts;
	}
}
