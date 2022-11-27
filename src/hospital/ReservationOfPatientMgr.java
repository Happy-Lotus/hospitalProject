package hospital;

import java.util.ArrayList;
import java.util.List;

import facade.DataEngineInterface;
import mgr.Manageable;

public class ReservationOfPatientMgr implements DataEngineInterface{
    private static ReservationOfPatientMgr rsMgr = null;
    private ReservationOfPatientMgr() {};

    public static ReservationOfPatientMgr getInstance() {
        if(rsMgr == null)
            rsMgr = new ReservationOfPatientMgr();
        return rsMgr;
    }
    List<ReservationOfPatient> rsList;
    public void setPatient(Patient pati) {
        rsList = pati.rsList;
    }
    private String[] headers = {"예방접종날짜", "환자코드", "접종 백신", "담당의사"};

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
        for (ReservationOfPatient rs: rsList)
            result.add(rs);
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
