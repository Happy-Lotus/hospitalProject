package gui.topPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gui.table_demo.TableSelectionDemo;

@SuppressWarnings("serial")
public class SearchTopPanel extends JPanel {
    // 검색 탭의 상단 패널 구성하기
    public JTextField kwdTextField = new JTextField("", 20);
    ImageIcon back = new ImageIcon("src/image/back.png");
    Image img = back.getImage();
    Image changeImg = img.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
    ImageIcon changelogo = new ImageIcon(changeImg);
    public JButton backButton = new JButton(changelogo);

    public void setupTopPane(TableSelectionDemo tableDemo) {
        JPanel topPane = new JPanel();
        topPane.setBackground(new Color(147, 251, 206));

        backButton.setBounds(12, 6, 23, 23);
        backButton.setBackground(Color.WHITE);
        topPane.add("West", backButton);

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