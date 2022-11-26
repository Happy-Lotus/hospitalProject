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
import hospital.Reservation;
import hospital.ReservationMgr;

public class ReservationDownPanel extends JPanel{
    JTextField reservationEdits[] = new JTextField[6];
    void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
        downPane.setLayout(new FlowLayout());
        for (int i = 0; i < 6; i++) {
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
                    String[] texts = new String[6]; //편집창의 입력값 배열
                    for(int i=0; i<6; i++)
                    {
                        texts[i] = reservationEdits[i].getText();
                    }
                    data.addRow(texts); //테이블에 행을 추가
                    Reservation s = new Reservation(texts);
                    ReservationMgr.reserMgr.addReservation(s);
                }
            }
        });
    }
}
