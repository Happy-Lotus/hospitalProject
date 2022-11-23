package hospital;

import java.util.ArrayList;
import java.util.List;
import facade.DataEngineInterface;
import mgr.Manageable;

public class ReservationMgr implements DataEngineInterface {
    public static ReservationMgr reserMgr = null;
    static ArrayList<Reservation> reservations = new ArrayList<>();
    private ReservationMgr() {}
    public static ReservationMgr getInstance() {
        if (reserMgr == null)
            reserMgr = new ReservationMgr();
        return reserMgr;
    }
    public void addReservation(Reservation reser) {
        reservations.add(reser);
    }
    private String[] headers = {"날짜", "이름", "나이", "성별", "증상", "의사"};
    @Override
    public String[] getColumnNames() {
        return headers;
    }
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 6;
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