package gui.downPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import gui.table_demo.TableSelectionDemo;
import hospital.*;
import hospital.patient.Patient;
import hospital.reception.Reception;


public class ReceptionDownPanel extends JPanel {
    JTextField receptionEdits[] = new JTextField[5];
    public void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
        downPane.setBackground(Color.WHITE);
        downPane.setLayout(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            receptionEdits[i] = new JTextField("", 10);
            downPane.add(receptionEdits[i]);
        }

        JButton addReception = new JButton("접수");
        downPane.add(addReception, BorderLayout.LINE_END);
        add(downPane, BorderLayout.PAGE_END);

        DefaultTableModel data = (DefaultTableModel) (TableSelectionDemo.table.getModel());
        addReception.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("접수")) {
                    String[] texts = new String[5]; //편집창의 입력값 배열
                    for(int i=0; i<5; i++)
                    {
                        texts[i] = receptionEdits[i].getText();
                    }

                    String resultStr;
                    Patient patient = (Patient)Main.patientMgr.find(texts[1]);

                    if(patient == null){ // 환자리스트에 환자코드와 일치하는 환자가 없음.
                        if ( Main.patientMgr.find(texts[2]) == null) { //만약 그 환자의 이름도 리스트에 없는 경우
                            JOptionPane.showMessageDialog(null, "환자 등록 먼저 해주시길 바랍니다. " +
                                    "해당 환자 코드는 존재하지 않습니다. ");
                            for (int i = 0; i < 5; i++) {
                                receptionEdits[i].setText("");
                            }

                        }else if(!(((Patient)(Main.patientMgr.find(texts[2]))).getPatientCode().equals(texts[2]))){ //이름은 있는데 환자 코드와 일치하지 않는경우
                            resultStr = JOptionPane.showInputDialog("환자 코드와 이름이 일치하지 않습니다. 환자 코드를 다시 입력해주세요.");
                            texts[1] = resultStr;
                            Reception recept = (Reception) Main.receptionMgr.find(resultStr);
                            texts[2] = recept.getName();

                        

                            Reception r = new Reception(texts);
                            if(Main.receptionMgr.find(texts[4]) == null){
                                texts[4] = r.getDoctorName();
                            }

                            data.addRow(texts); //테이블에 행을 추가
                            Main.receptionMgr.getMlist().add(r);

                            for(int i=0; i<5; i++)
                            {
                                receptionEdits[i].setText("");
                            }
                        }
                    }else if(patient != null){
                        String name = patient.getName();
                        if(!(name.equals(texts[2]))){ //이름은 있는데 환자 코드와 일치하지 않는경우

                            resultStr = JOptionPane.showInputDialog("환자 코드와 이름이 일치하지 않습니다. 환자 코드를 다시 입력해주세요.");
                            texts[1] = resultStr;
                            Reception recept = (Reception) Main.receptionMgr.find(resultStr);
                            texts[2] = recept.getName();
                        }

                        Reception r = new Reception(texts);
                        if(Main.receptionMgr.find(texts[4]) == null){
                            texts[4] = r.getDoctorName();
                        }

                        data.addRow(texts); //테이블에 행을 추가
                        Main.receptionMgr.getMlist().add(r);

                        for(int i=0; i<5; i++)
                        {
                            receptionEdits[i].setText("");
                        }
                    }
                }
            }
        });
    }
}

