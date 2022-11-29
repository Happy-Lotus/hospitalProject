package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import hospital.Main;
import hospital.Patient;

public class PatientDownPanel extends JPanel {
    JTextField patientEdits[] = new JTextField[6];
    void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
        downPane.setBackground(Color.WHITE);
        downPane.setLayout(new FlowLayout());
        for (int i = 0; i < 6; i++) {
            patientEdits[i] = new JTextField("", 10);
            downPane.add(patientEdits[i]);
        }

        JButton addPatient = new JButton("등록");
        downPane.add(addPatient, BorderLayout.LINE_END);
        add(downPane, BorderLayout.PAGE_END);

        DefaultTableModel data = (DefaultTableModel) (TableSelectionDemo.table.getModel());
        addPatient.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("등록")) {
                    String[] texts = new String[6]; //편집창의 입력값 배열
                    for(int i=0; i<6; i++)
                    {
                        texts[i] = patientEdits[i].getText();
                    }
                    String resultStr;

                    if(Main.patientMgr.find(texts[0])!=null){
                        resultStr = JOptionPane.showInputDialog("환자코드가 이미 존재합니다. 다시 입력해주세요.");
                        texts[0] = resultStr;
                        resultStr = null;
                    }
                    if(Main.patientMgr.find(texts[0])!=null && Main.patientMgr.find(texts[1])!=null){
                        resultStr = JOptionPane.showInputDialog("이름이 이미 존재합니다. 다시 입력해주세요.");
                        texts[1] = resultStr;
                        resultStr = null;
                    }
                    if(Main.patientMgr.find(texts[4])!=null){
                        resultStr = JOptionPane.showInputDialog("해당 휴대폰 번호를 가진 환자가 이미 존재합니다. 다시 입력해주세요.");
                        texts[4] = resultStr;
                        resultStr = null;
                    }
                    Patient s = new Patient(texts);
                    data.addRow(texts); //테이블에 행을 추가
                    Main.patientMgr.getMlist().add(s);

                    for(int i=0; i<6; i++)
                    {
                        patientEdits[i].setText("");
                    }
                }
            }
        });
    }

}
