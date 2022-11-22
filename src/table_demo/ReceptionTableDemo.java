package table_demo;

import facade.DataEngineInterface;
import hospital.Patient;
import hospital.PatientMgr;
import hospital.ReceptionMgr;
/*
 * 진료 테이블는 환자 데이터를 클릭이 변경될 때마다 달라져야함
 * TableSelectionDemo 클래스에서 상속하여
 * 진료 기록을 다시 불러오는 부분을 loadData로 기능 추가함
 * 선택된 주문을
 */
@SuppressWarnings("serial")
public class ReceptionTableDemo extends TableSelectionDemo {
    ReceptionMgr receptionMgr = ReceptionMgr.getInstance();
    PatientMgr patientMgr = PatientMgr.getInstance();

    void init(DataEngineInterface mgr) {
        ((ReceptionMgr)mgr).setPatient(patientMgr.getPatient(0));
        super.init(mgr);
    }
    // 부모 클래스의 테이블 데이터 로드하는 부분을 오버라이드하여
    // 진료 기록의 경우 클릭된 환자의 번호를 이용하여 해당 진료 기록을 가져오도록
    // 미리 설정한 후 슈퍼의 loadData를 호출한다.
    void loadData(String kwd) {
        if(!kwd.equals("")) {
            Patient p = patientMgr.getPatient(Integer.parseInt(kwd));
            receptionMgr.setPatient(p);
        }
        super.loadData("");

    }
}
