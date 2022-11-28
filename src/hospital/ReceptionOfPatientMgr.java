package hospital;

import java.util.ArrayList;
import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;

public class ReceptionOfPatientMgr implements DataEngineInterface{
    private static ReceptionOfPatientMgr rpMgr = null;
    private ReceptionOfPatientMgr() {};

    public static ReceptionOfPatientMgr getInstance() {
        if(rpMgr == null)
            rpMgr = new ReceptionOfPatientMgr();
        return rpMgr;
    }
    List<ReceptionOfPatient> rpList;
    public void setPatient(Patient pati) {
        rpList = pati.rpList;
    }
    private String[] headers = {"진료날짜", "환자코드", "증상", "담당의사"};
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 0;
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
        List<Manageable> result = new ArrayList();
        for (ReceptionOfPatient rp: rpList)
            result.add(rp);
        return result;
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
