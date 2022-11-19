package hospital;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class PatientMgr extends Manager implements DataEngineInterface {
	private static PatientMgr mgr = null;

	private PatientMgr() {
	}

	public static PatientMgr getInstance() {
		return mgr;
	}

	private String[] headers = { "이름", "성별", "생년월일", "주민번호", "개월", "전화번호", "주소" };

	//	이름, 성별, 생년월일, 주민번호 뒷자리, 나이(개월수) , 전화번호, 주소
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 7;
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
