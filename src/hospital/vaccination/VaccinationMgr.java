package hospital.vaccination;

import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;

public class VaccinationMgr implements DataEngineInterface {
	private static VaccinationMgr vMgr = null;

	private VaccinationMgr() {
	}

	public static VaccinationMgr getInstance() {
		if (vMgr == null)
			vMgr = new VaccinationMgr();
		return vMgr;
	}

	private String[] headers = { "vaccine name", "infections", "number of time", "times" };

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public String[] getColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void readAll(String filename) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Manageable> search(String kwd) {
		// TODO Auto-generated method stub
		return null;
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
