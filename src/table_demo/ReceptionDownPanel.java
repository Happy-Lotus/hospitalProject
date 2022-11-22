package table_demo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReceptionDownPanel extends JPanel {
    JTextField receptionEdits[] = new JTextField[5];
    void setupDownPane(TableSelectionDemo tableDemo) {
        JPanel downPane = new JPanel();
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

            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("접수")) {
                    String[] texts = new String[5]; //편집창의 입력값 배열
                    for(int i=0; i<5; i++)
                    {
                        texts[i] = receptionEdits[i].getText();
                    }
                    data.addRow(texts); //테이블에 행을 추가
                    Reception r = new Reception(texts);
                    ReceptionMgr.mgr.addReception(r);
                }
            }
        });
    }

}
