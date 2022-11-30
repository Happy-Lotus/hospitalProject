package hospital.patient;
import java.util.ArrayList;
import java.util.List;
import facade.DataEngineInterface;
import hospital.Main;
import mgr.Manageable;
import mgr.Manager;

public class PatientMgr extends Manager implements DataEngineInterface {
	public static PatientMgr pMgr = null;
	static ArrayList<Patient> patients = new ArrayList<>();
	private PatientMgr() {
	}

	public static PatientMgr getInstance() {
		if(pMgr == null)
			pMgr = new PatientMgr();
		return pMgr;
	}

	public Patient initPatient(int index){
		return (Patient)Main.patientMgr.mList.get(index);
	}
	public Patient getPatient(String kwd){
		return (Patient) Main.patientMgr.find(kwd);
	}

	public void addPatient(Patient p){
		patients.add(p);
	}

	private String[] headers = {"환자코드", "이름", "성별","생년월일", "연락처", "주소" };

	//환자코드 / 이름/ 성별/ 생년월일/ 전화번호/ 주소(동만)
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 6;
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
		return Main.patientMgr.findAll(kwd);
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
