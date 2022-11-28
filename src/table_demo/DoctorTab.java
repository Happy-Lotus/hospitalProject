package table_demo;

import hospital.Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorTab {

	private static DoctorTab doctorTab = null;
	public DoctorTab() {}
	public static DoctorTab getInstance() {
		if (doctorTab == null)
			doctorTab = new DoctorTab();
		return doctorTab;
	}

	public static void startGUI() {
		Main hospitalmain = Main.getInstance();
		//hospitalmain.run();

		//PatientTab main = new PatientTab();
		//PatientTab.getInstance().createAndShowPatient();
		//GUIMain.hospitalMain.run();
		//getInstance();
		//doctorTab.createAndShowPatient();
		DoctorTab.getInstance().createAndShowPatient();
	}
	public JFrame doctorFrame = new JFrame("의사 정보");

	private void createAndShowPatient() {
		doctorFrame = new JFrame();
		doctorFrame.getContentPane().setBackground(new Color(248, 248, 255));
		doctorFrame.setTitle("의사 선택창");
		doctorFrame.setBounds(100, 100, 665, 536);
		doctorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		doctorFrame.getContentPane().setLayout(null);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDetail dd = new DoctorDetail();
				dd.doctor4("이소윤");
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("src\\image\\doctor4.jpg"));
		btnNewButton_1.setBounds(106, 280, 195, 135);
		doctorFrame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDetail dd = new DoctorDetail();
				dd.doctor5("현지현");
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("src\\image\\doctor5.jpg"));
		btnNewButton_2.setBounds(354, 280, 201, 135);
		doctorFrame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDetail dd = new DoctorDetail();
				dd.doctor1("김가을");
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("src\\image\\doctor1.jpg"));
		btnNewButton_3.setBounds(12, 73, 195, 135);
		doctorFrame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDetail dd = new DoctorDetail();
				dd.doctor2("김해연");
			}
		});
		btnNewButton_4.setIcon(new ImageIcon("src\\image\\doctor2.jpg"));
		btnNewButton_4.setBounds(230, 73, 195, 135);
		doctorFrame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorDetail dd = new DoctorDetail();
				dd.doctor3("김희연");
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("src\\image\\doctor3.jpg"));
		btnNewButton_5.setBounds(446, 73, 195, 135);
		doctorFrame.getContentPane().add(btnNewButton_5);

		JLabel lblNewLabel = new JLabel("김가을(35)");
		lblNewLabel.setFont(new Font("수성돋움체", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setBounds(74, 218, 61, 15);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(255, 255, 240));
		doctorFrame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("김해연(35)");
		lblNewLabel_1.setFont(new Font("수성돋움체", Font.PLAIN, 12));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setBackground(new Color(255, 255, 240));
		lblNewLabel_1.setBounds(300, 218, 61, 15);
		doctorFrame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("김희연(35)");
		lblNewLabel_2.setFont(new Font("수성돋움체", Font.PLAIN, 12));
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBackground(new Color(255, 255, 240));
		lblNewLabel_2.setBounds(516, 218, 61, 15);
		doctorFrame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("이소윤(35)");
		lblNewLabel_3.setFont(new Font("수성돋움체", Font.PLAIN, 12));
		lblNewLabel_3.setOpaque(true);
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setBackground(new Color(255, 255, 240));
		lblNewLabel_3.setBounds(171, 425, 61, 15);
		doctorFrame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("현지현(35)");
		lblNewLabel_4.setFont(new Font("수성돋움체", Font.PLAIN, 12));
		lblNewLabel_4.setOpaque(true);
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBackground(new Color(255, 255, 240));
		lblNewLabel_4.setBounds(429, 425, 61, 15);
		doctorFrame.getContentPane().add(lblNewLabel_4);
	}
}