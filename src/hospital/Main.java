package hospital;

import java.util.Collections;
import java.util.Scanner;

import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class Main {
	private static Main hospitalMain = null;
	private Main() {}
	public static Main getInstance() {
		if (hospitalMain == null)
			hospitalMain = new Main();
		return hospitalMain;
	}
	Scanner scan = new Scanner(System.in);
	static Manager doctorMgr = new Manager();
	static Manager patientMgr = new Manager();
	static Manager receptionMgr = new Manager();
	static Manager reservationMgr = new Manager();
	static Manager VaccinationMgr = new Manager();

	public void run()
	{
		doctorMgr.readAll("doctor.txt",new Factory(){
			public Manageable create(){
				return new Doctor();
			}
		});
		VaccinationMgr.readAll("vaccination.txt",new Factory(){
			public Manageable create(){
				return new Vaccination();
			}
		});
		patientMgr.readAll("patient.txt",new Factory(){
			public Manageable create(){
				return new Patient();
			}
		});
		receptionMgr.readAll("reception.txt",new Factory(){
			public Manageable create(){
				return new Reception();
			}
		});


		reservationMgr.readAll("Reservation.txt",new Factory(){
			public Manageable create(){
				return new Reservation();
			}
		});
		System.out.println("\n================= 전체 의사 리스트 =================");
		doctorMgr.printAll();
		System.out.println("\n================= 전체 환자 리스트 =================");
		patientMgr.printAll();
		System.out.println("\n=============== 전체 접수 리스트 =================");
		receptionMgr.printAll();
		System.out.println("\n=============== 백신 전체 리스트 =================");
		VaccinationMgr.printAll();
		System.out.println("\n=============== 전체 접수(예약 포함) 리스트 =================");
		receptionMgr.printAll();
	}


	public static void main(String args[]) {
		Main m = new Main();
		m.run();
	}
}