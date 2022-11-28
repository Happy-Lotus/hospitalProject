package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hospital.Main;
import hospital.ReservationMgr;


public class ReservationTab {
    private static ReservationTab reservationTab = null;
    ReservationTab() {}
    public static ReservationTab getInstance() {
        if (reservationTab == null)
            reservationTab = new ReservationTab();
        return reservationTab;
    }

    public static void startGUI() {
        Main hospitalmain = Main.getInstance();
        hospitalmain.run();

        ReservationTab.getInstance().createAndShowReservation();
    }
    public JFrame reservationFrame = new JFrame("예약");
    private void createAndShowReservation() {
        setupResevationPane();

        reservationFrame.setBounds(100, 100, 720, 600);
        reservationFrame.setBackground(Color.WHITE);
        reservationFrame.add(reservationPane);
        reservationFrame.pack();
        //reservationFrame.setVisible(true);
    }
    //예방접종 예약 탭
    private JPanel reservationPane;
    TableSelectionDemo reservationTable = new TableSelectionDemo();
    SearchTopPanel reservationTop = new SearchTopPanel();
    ReservationDownPanel reservationDown = new ReservationDownPanel();
    private void setupResevationPane() {
        reservationPane = new JPanel(new BorderLayout());
        reservationPane.setPreferredSize(new Dimension(720,600));

        reservationTop.setBackground(new Color(147, 251, 206));
        reservationDown.setBackground(Color.WHITE);
        //Create and set up the content pane.
        reservationTable.tableTitle = "reservation";
        reservationTable.addComponentsToPane(ReservationMgr.getInstance());  // 싱글톤
        reservationTop.setupTopPane(reservationTable);
        reservationPane.add(reservationTop, BorderLayout.NORTH);
        reservationPane.add(reservationTable, BorderLayout.CENTER);

        reservationDown.setupDownPane(reservationTable);
        reservationPane.add(reservationDown, BorderLayout.SOUTH);
    }
}
