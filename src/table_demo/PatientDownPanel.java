package table_demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import hospital.Patient;
import hospital.PatientMgr;

public class PatientDownPanel extends JPanel {
    JTextField patientEdits[] = new JTextField[6];
    void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
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
                    data.addRow(texts); //테이블에 행을 추가
                    Patient s = new Patient(texts);
                    PatientMgr.mgr.addPatient(s);
                }
            }
        });
    }

}
