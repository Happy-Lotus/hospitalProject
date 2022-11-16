package patient;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;
import mgr.Manager;

public class patientMgr extends Manager implements DataEngineInterface {
	private static patientMgr mgr = null;

	private patientMgr() {
	}

	public static patientMgr getInstance() {
		return mgr;
	}

	private String[] headers = { "�̸�", "����", "�������", "�ֹι�ȣ", "����", "��ȭ��ȣ", "�ּ�" };

//	�̸�, ����, �������, �ֹι�ȣ ���ڸ�, ����(������) , ��ȭ��ȣ, �ּ�
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
