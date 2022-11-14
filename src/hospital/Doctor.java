package hospital;

import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;
import mgr.Manager;

public class Doctor implements Manageable
{
	//�ǻ��ڵ� �ǻ��̸� ���� ����ó ����
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
	/*
	 [�ǻ��ڵ�] �ǻ��̸� : �ǻ翬��ó
	 [���� ȯ��] ȯ���̸� : �������� - �ð���
	 */
	@Override
	public void print() {
		System.out.format("[%s] %s : %s\n", code, name, phone);
		for(Patient p : patientList)
			p.print();
	}
	//���� Ŭ�������� ����� �� �̸� �Է� �޾Ƽ� patient find�Ͽ� �����ϰ�,
	//��ü�� �����Ͽ� addPatient (10���� ���ΰ��� Order Ŭ���� ����)
	void addPatient(Patient pati)
	{
		patientList.add(pati);
	}
	@Override
	public boolean matches(String kwd) {
		if(name.equals(kwd))
			return true;
		for(Patient p : patientList)
		{
			if(p.matches(kwd))
				return true;
		}
		return false;
	}
}
