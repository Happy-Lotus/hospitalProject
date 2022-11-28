package table_demo;

import facade.DataEngineInterface;
import hospital.Patient;
import hospital.PatientMgr;

import hospital.ReservationOfPatientMgr;

@SuppressWarnings("serial")
public class ReservationOfPatientTableDemo extends TableSelectionDemo{
    ReservationOfPatientMgr rsMgr = ReservationOfPatientMgr.getInstance();
    PatientMgr patientMgr = PatientMgr.getInstance();

    void init(DataEngineInterface mgr) {
        ((ReservationOfPatientMgr)mgr).setPatient(patientMgr.getPatient(0));
        super.init(mgr);
    }
    // 부모 클래스의 테이블 데이터 로드하는 부분을 오버라이드하여
    // 진료 기록의 경우 클릭된 환자의 번호를 이용하여 해당 진료 기록을 가져오도록
    // 미리 설정한 후 슈퍼의 loadData를 호출한다.
    void loadData(String kwd) {
        if(!kwd.equals("")) {
            Patient p = patientMgr.getPatient(Integer.parseInt(kwd));
            rsMgr.setPatient(p);
        }
        super.loadData("");

    }
}
