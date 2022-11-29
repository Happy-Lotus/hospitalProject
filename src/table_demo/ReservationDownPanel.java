package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import hospital.*;

public class ReservationDownPanel extends JPanel{
    JTextField reservationEdits[] = new JTextField[5];
    void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
        downPane.setBackground(Color.WHITE);
        downPane.setLayout(new FlowLayout());
        for (int i = 0; i < 5; i++) {
            reservationEdits[i] = new JTextField("", 10);
            downPane.add(reservationEdits[i]);
        }

        JButton addReservation = new JButton("예약");
        downPane.add(addReservation, BorderLayout.LINE_END);
        add(downPane, BorderLayout.PAGE_END);

        DefaultTableModel data = (DefaultTableModel) (TableSelectionDemo.table.getModel());
        addReservation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("예약")) {
                    String[] texts = new String[5]; //편집창의 입력값 배열
                    for(int i=0; i<5; i++)
                    {
                        texts[i] = reservationEdits[i].getText();
                    }

                    String resultStr;
                    // 221216 P5556 라이언 HepB 3차 이소윤
                    // 환자 코드랑 백신 몇 차인지
                    if (Main.reservationMgr.find(texts[1]) != null && Main.reservationMgr.find(texts[3]) != null) {
                        resultStr = JOptionPane.showInputDialog("예약 내역이 이미 존재합니다. 다시 입력해주세요.");
                        texts[0] = resultStr;
                        resultStr = null;
                    }



                    data.addRow(texts); //테이블에 행을 추가
                    Reservation s = new Reservation(texts);
                    Main.reservationMgr.getMlist().add(s);

                    for(int i=0; i<6; i++)
                    {
                        reservationEdits[i].setText("");
                    }
                }
            }
        });
    }
}
