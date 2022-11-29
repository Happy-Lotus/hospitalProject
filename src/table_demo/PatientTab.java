package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import hospital.Main;
import hospital.PatientMgr;
import hospital.ReceptionOfPatientMgr;
import hospital.ReservationOfPatientMgr;

public class PatientTab {
    private static PatientTab patientTab = null;
    PatientTab() {}
    public static PatientTab getInstance() {
        if (patientTab == null)
            patientTab = new PatientTab();
        return patientTab;
    }
    public static void startGUI(){
        Main hospitalmain = Main.getInstance();
        //hospitalmain.run();

        //PatientTab main = new PatientTab();
        PatientTab.getInstance().createAndShowPatient();
    }
    public JFrame patientFrame = new JFrame("환자 정보");
    private void createAndShowPatient() {
        JTabbedPane patientJtab = new JTabbedPane();
        patientJtab.setBackground(Color.WHITE);

        setupPatientPane();
        setupVaccinationPane();

        patientJtab.add("환자", patientPane);
        patientJtab.add("예방접종현황", vaccinationPane);

        patientFrame.setBounds(100, 100, 720, 600);
        patientFrame.setBackground(Color.WHITE);
        patientFrame.add(patientJtab);
        patientFrame.pack();
        patientFrame.setLocationRelativeTo(null); // 창이 가운데 생성되도록
        //patientFrame.setVisible(true);

        patientTop.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPage start = new MenuPage();
                patientFrame.dispose();
            }
        });

        v_patientTop.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPage start = new MenuPage();
                patientFrame.dispose();
            }
        });
    }

    // 환자을 보여주는 패널 부분 - 위에는 검색과 JTable, 아래는 환자 등록
    private JPanel patientPane;
    TableSelectionDemo patientTable = new TableSelectionDemo();
    ReceptionOfPatientTableDemo rpListTable = new ReceptionOfPatientTableDemo();
    SearchTopPanel patientTop = new SearchTopPanel();
    PatientDownPanel patientDown = new PatientDownPanel();
    private void setupPatientPane() {
        patientPane = new JPanel(new BorderLayout());
        patientPane.setPreferredSize(new Dimension(720,600));

        patientTop.setBackground(new Color(147, 251, 206));
        patientDown.setBackground(Color.WHITE);

        patientTable.tableTitle = "ReceptionOfPatient";
        patientTable.addComponentsToPane(PatientMgr.getInstance());
        patientTable.setBounds(0,0,720,299);

        //맨 위에는 검색 창
        patientTop.setupTopPane(patientTable);
        patientPane.add(patientTop, BorderLayout.NORTH);
        //가운데 환자 리스트와 진료 기록 테이블 추가
        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        patientPane.add(center, BorderLayout.CENTER);
        center.setLayout(null);
        //맨 아래는 환자 등록 창
        patientDown.setupDownPane(patientTable);
        patientPane.add(patientDown, BorderLayout.SOUTH);

        //가운데 환자 리스트와 진료 기록 테이블 추가
        center.add(patientTable);
        rpListTable.tableTitle = "ReceptionOfPatientList";
        rpListTable.addComponentsToPane(ReceptionOfPatientMgr.getInstance());
        rpListTable.setBounds(0, 300, 720, 205);
        center.add(rpListTable);
    }
    //예방접종 현황 탭
    private JPanel vaccinationPane;
    TableSelectionDemo v_patientTable = new TableSelectionDemo();
    ReservationOfPatientTableDemo v_rListTable = new ReservationOfPatientTableDemo();
    VaccinationTopPanel v_patientTop = new VaccinationTopPanel();
    private void setupVaccinationPane() {
        //검색
        vaccinationPane = new JPanel(new BorderLayout());
        v_patientTop.setBackground(new Color(147, 251, 206));

        v_patientTop.setupTopPane(v_patientTable);
        vaccinationPane.add(v_patientTop, BorderLayout.NORTH);

        v_patientTable.tableTitle = "ReservationOfPatient";
        v_patientTable.addComponentsToPane(PatientMgr.getInstance());
        vaccinationPane.add(v_patientTable, BorderLayout.CENTER);

        v_rListTable.tableTitle = "ReservationOfPatientList";
        v_rListTable.addComponentsToPane(ReservationOfPatientMgr.getInstance());

        vaccinationPane.add(v_rListTable, BorderLayout.SOUTH);
    }
}