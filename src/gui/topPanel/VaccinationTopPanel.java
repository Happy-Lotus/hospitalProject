package gui.topPanel;

import javax.swing.*;

import gui.table_demo.TableSelectionDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VaccinationTopPanel extends JPanel {
    public JTextField kwdTextField = new JTextField("", 20);
    ImageIcon back = new ImageIcon("src/image/back.png");
    Image img = back.getImage();
    Image changeImg = img.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
    ImageIcon changelogo = new ImageIcon(changeImg);
    public JButton backButton = new JButton(changelogo);

    public void setupTopPane(TableSelectionDemo tableDemo) {
        JPanel topPane = new JPanel();
        topPane.setBackground(new Color(147, 251, 206));
        backButton.setBounds(12, 10, 23, 23);
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
