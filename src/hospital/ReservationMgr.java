package hospital;

import java.util.ArrayList;
import java.util.List;
import facade.DataEngineInterface;
import mgr.Manageable;

public class ReservationMgr implements DataEngineInterface {
    public static ReservationMgr reserMgr = null;
    static ArrayList<Reservation> reservations = new ArrayList<>();
    public ReservationMgr() {}
    public static ReservationMgr getInstance() {
        if (reserMgr == null)
            reserMgr = new ReservationMgr();
        return reserMgr;
    }
    public void addReservation(Reservation reser) {
        reservations.add(reser);
    }
    private String[] headers = {"예방접종날짜", "환자코드", "이름", "백신", "의사"};
    @Override
    public String[] getColumnNames() {
        return headers;
    }
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 5;
    }
    @Override
    public void readAll(String filename) {
        // TODO Auto-generated method stub
    }
    @Override
    public List<Manageable> search(String kwd) {
        // TODO Auto-generated method stub
        return Main.reservationMgr.findAll(kwd);
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