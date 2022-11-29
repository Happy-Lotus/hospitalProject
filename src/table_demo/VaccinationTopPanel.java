package table_demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccinationTopPanel extends JPanel {
    JTextField kwdTextField = new JTextField("", 20);
    ImageIcon back = new ImageIcon("src/image/back.png");
    Image img = back.getImage();
    Image changeImg = img.getScaledInstance(30, 31, Image.SCALE_SMOOTH);
    ImageIcon changelogo = new ImageIcon(changeImg);
    JButton backButton = new JButton(changelogo);

    void setupTopPane(TableSelectionDemo tableDemo) {
        JPanel topPane = new JPanel();
        topPane.setBackground(new Color(147, 251, 206));
        // backButton.setOpaque(false);
        backButton.setBounds(12, 10, 30, 31);
        backButton.setBackground(Color.WHITE);
        topPane.add(backButton, BorderLayout.PAGE_START);

        JButton detail = new JButton("예방접종현황");
        topPane.add(detail, BorderLayout.LINE_START);
        topPane.add(kwdTextField, BorderLayout.CENTER);
        JButton search = new JButton("검색");
        topPane.add(search, BorderLayout.LINE_END);
        add(topPane, BorderLayout.PAGE_START);

        detail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("예방접종현황")) {
                    tableDemo.showDetail();
                }
            }
        });
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand().equals("검색")) {
                    tableDemo.loadData(kwdTextField.getText());
                }
            }
        });
    }
}
