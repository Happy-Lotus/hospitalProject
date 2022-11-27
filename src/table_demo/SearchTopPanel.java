package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SearchTopPanel extends JPanel {
    //검색 탭의 상단 패널 구성하기
    JTextField kwdTextField = new JTextField("", 20);
    void setupTopPane(TableSelectionDemo tableDemo) {
        JPanel topPane = new JPanel();
        topPane.setBackground(Color.WHITE);
        topPane.add(kwdTextField, BorderLayout.CENTER);
        JButton search = new JButton("검색");
        topPane.add(search, BorderLayout.LINE_END);
        add(topPane, BorderLayout.PAGE_START);


        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("검색")) {
                    tableDemo.loadData(kwdTextField.getText());
                }
            }
        });
    }
}
