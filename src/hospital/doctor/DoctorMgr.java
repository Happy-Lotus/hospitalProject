package hospital.doctor;

import java.util.List;

import facade.DataEngineInterface;
import hospital.Main;
import mgr.Manageable;
import mgr.Manager;

public class DoctorMgr extends Manager implements DataEngineInterface {
	private static DoctorMgr dMgr = null;
	static List<Manageable> doctors = Main.doctorMgr.getMlist();
	private DoctorMgr() {}
	public static DoctorMgr getInstance() {
		if(dMgr == null)
			dMgr = new DoctorMgr();
		return dMgr;
	}

	public void addDoctor(Doctor d) {
		doctors.add(d);
	}
	private String[] headers = {"의사코드", "이름", "연락처"};

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return headers;
	}

	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return Main.doctorMgr.findAll(kwd);
	}

	@Override
	public void addNewItem(String[] uiTexts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String[] uiTexts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String kwd) {
		// TODO Auto-generated method stub

	}

}
