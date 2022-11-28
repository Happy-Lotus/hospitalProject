package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import hospital.Main;
import hospital.PatientMgr;
import hospital.ReceptionMgr;
import hospital.ReceptionOfPatientMgr;
import hospital.ReservationMgr;
import hospital.ReservationOfPatientMgr;


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
    static Main hospitalMain = Main.getInstance();

    public static void main(String args[]) {
        GUIMain main = new GUIMain();
        main.showFrameTest();
        startGUI();
        main.start = new startPage();
        // main.login = new Login();  로그인창 보이기
        //main.showFrameTest();
        //main.login.setMain(main);


    }
    public void showFrameTest(){
        hospitalMain.run();
        //메뉴창 띄우기
    }
    public static void startGUI() {
        // 이벤트 처리 스레드를 만들고
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

}