package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hospital.Main;
import hospital.ReceptionMgr;
public class ReceptionTab{
    private static ReceptionTab receptionTab = null;
    ReceptionTab() {}
    public static ReceptionTab getInstance() {
        if (receptionTab == null)
            receptionTab = new ReceptionTab();
        return receptionTab;
    }

    public static void startGUI() {
        Main hospitalmain = Main.getInstance();
        ReceptionTab.getInstance().createAndShowReception();
    }
    public JFrame receptionFrame = new JFrame("");
    private void createAndShowReception()
    {
        setupReceptionPane();

        receptionFrame.setBounds(100,100,720,600);
        receptionFrame.setBackground(Color.WHITE);
        receptionFrame.setTitle("진료현황");
        receptionFrame.getContentPane().add(receptionPane);
        receptionFrame.setLocationRelativeTo(null); // 창이 가운데 생성되도록

        receptionTop.backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MenuPage start = new MenuPage();
                receptionFrame.dispose();
            }
        });
    }

    private JPanel receptionPane;
    TableSelectionDemo receptionTable = new TableSelectionDemo();
    SearchTopPanel receptionTop = new SearchTopPanel();  // 검색과 상세보기 버튼을 가진 패널
    ReceptionDownPanel receptionDown = new ReceptionDownPanel();
    private void setupReceptionPane() {
        receptionPane = new JPanel(new BorderLayout());
        receptionPane.setBackground(Color.WHITE);

        receptionTop.setBackground(new Color(147, 251, 206));
        receptionDown.setBackground(Color.WHITE);
        //Create and set up the content pane.
        receptionTable.tableTitle = "reception";
        receptionTable.addComponentsToPane(ReceptionMgr.getInstance());  // 싱글톤

        receptionTop.setupTopPane(receptionTable);
        receptionPane.add(receptionTop, BorderLayout.NORTH);
        receptionPane.add(receptionTable, BorderLayout.CENTER);

        receptionDown.setupDownPane(receptionTable);
        receptionPane.add(receptionDown, BorderLayout.SOUTH);
    }
}