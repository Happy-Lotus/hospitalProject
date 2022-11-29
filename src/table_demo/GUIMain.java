package table_demo;
import javax.swing.JFrame;
import hospital.Main;

public class GUIMain {
    // 싱글톤 패턴 적용 부분
    private static GUIMain main = null;
    startPage start;
    private GUIMain() {}
    public static GUIMain getInstance() {
        if (main == null)
            main = new GUIMain();
        return main;
    }
    // 엔진의 인스턴스를 편리를 위해 변수에 저장한다
    public static Main hospitalMain = Main.getInstance();
    public static void main(String args[]) {
        main = getInstance();
        hospitalMain.run();
        startGUI();

        main.start = new startPage();

    }


    public static void startGUI() {
        // 이벤트 처리 스레드를 만들고
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                main.createAndShowGUI();
            }
        });
    }
    /**
     * GUI를 생성하여 보여준다. 스레드 안전을 위하여
     * 이 메소드는 이벤트 처리 스레드에서 불려져야 한다.
     */
    static JFrame mainFrame = new JFrame("병원 환자 관리 프로그램");
    private void createAndShowGUI() {
        //mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        PatientTab.startGUI();
        ReceptionTab.startGUI();
        ReservationTab.startGUI();
        DoctorTab.startGUI();
    }
}