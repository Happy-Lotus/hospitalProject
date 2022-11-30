package hospital;

import java.util.Scanner;

import hospital.doctor.Doctor;
import hospital.patient.Patient;
import hospital.reception.Reception;
import hospital.reservation.Reservation;
import hospital.vaccination.Vaccination;
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
	public static Manager doctorMgr = new Manager();
	public static Manager patientMgr = new Manager();
	public static Manager receptionMgr = new Manager();
	public static Manager reservationMgr = new Manager();
	public static Manager VaccinationMgr = new Manager();
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
		

		reservationMgr.readAll("reservation.txt",new Factory(){
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
		System.out.println("\n=============== 전쳬 예약 리스트 =================");
		reservationMgr.printAll();
	}


	public static void main(String args[]) {
		Main m = new Main();
		m.run();
	}
}