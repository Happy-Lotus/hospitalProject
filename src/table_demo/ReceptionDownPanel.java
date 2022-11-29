package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import hospital.*;


public class ReceptionDownPanel extends JPanel {
    JTextField receptionEdits[] = new JTextField[5];
    void setupDownPane(TableSelectionDemo tableDemo) {
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
                    //220521 P1434 박서윤 코막힘 가래 있음 0 김해연
                    if(Main.receptionMgr.find(texts[0])!=null && Main.receptionMgr.find(texts[1])!=null){
                        resultStr = JOptionPane.showInputDialog("이미 해당 날짜에 접수가 되어있습니다. 환자 코드를 다시 입력해주세요.");

                        texts[1] = resultStr;
                        resultStr = null;
                    }


                    Reception r = new Reception(texts);
                    if(Main.receptionMgr.find(texts[4])== null){
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
        });
    }
}

