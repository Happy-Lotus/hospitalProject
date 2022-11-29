package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import facade.UIData;
import hospital.Main;
import hospital.ReceptionMgr;

public class DoctorDetail extends TableSelectionDemo {
	DefaultTableModel tableModel;
	JFrame jframe = new JFrame();
	JPanel jpanel = new JPanel();
	private JPanel receptionPane;
	static Main hospitalMain = Main.getInstance();

	public void run() {
		hospitalMain.run();
	}

	ReceptionMgr rMgr = new ReceptionMgr();
	TableSelectionDemo receptionTable = new TableSelectionDemo();

	public void doctor1(String name) {
		jframe.setTitle("<김가을 의사> 정보");
		JLabel jlabel = new JLabel("[D1111] 김가을(여) 35세 전화번호 : 010-1111-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));

		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);

		receptionTable.tableTitle = "ReceptionOfDoctor";
		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> patientList = rMgr.search(name);
		tableModel.setRowCount(0);
		for (Object r : patientList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		receptionPane.add(jtable, BorderLayout.CENTER);

		jpanel.add(jlabel);
		jframe.add(jpanel, BorderLayout.NORTH);
		jframe.add(receptionPane, BorderLayout.CENTER);
		jframe.pack();
		jframe.setLocation(580, 60);
		jframe.setVisible(true);
	}

	public void doctor2(String name) {
		jframe.setTitle("<김해연 의사> 정보");
		JLabel jlabel = new JLabel("[D2222] 김해연(여) 35세 전화번호 : 010-2222-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));

		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);

		receptionTable.tableTitle = "ReceptionOfDoctor";
		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> patientList = rMgr.search(name);
		tableModel.setRowCount(0);
		for (Object r : patientList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		receptionPane.add(jtable, BorderLayout.CENTER);

		jpanel.add(jlabel);
		jframe.add(jpanel, BorderLayout.NORTH);
		jframe.add(receptionPane, BorderLayout.CENTER);
		jframe.pack();
		jframe.setLocation(580, 60);
		jframe.setVisible(true);
	}

	public void doctor3(String name) {
		jframe.setTitle("<김희연 의사> 정보");
		JLabel jlabel = new JLabel("[D3333] 김희연(여) 35세 전화번호 : 010-3333-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));

		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);

		receptionTable.tableTitle = "ReceptionOfDoctor";
		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> patientList = rMgr.search(name);
		tableModel.setRowCount(0);
		for (Object r : patientList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		receptionPane.add(jtable, BorderLayout.CENTER);

		jpanel.add(jlabel);
		jframe.add(jpanel, BorderLayout.NORTH);
		jframe.add(receptionPane, BorderLayout.CENTER);
		jframe.pack();
		jframe.setLocation(580, 60);
		jframe.setVisible(true);
	}

	public void doctor4(String name) {
		jframe.setTitle("<이소윤 의사> 정보");
		JLabel jlabel = new JLabel("[D4444] 이소윤(여) 35세 전화번호 : 010-4444-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));

		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);

		receptionTable.tableTitle = "ReceptionOfDoctor";
		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> patientList = rMgr.search(name);
		tableModel.setRowCount(0);
		for (Object r : patientList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		receptionPane.add(jtable, BorderLayout.CENTER);

		jpanel.add(jlabel);
		jframe.add(jpanel, BorderLayout.NORTH);
		jframe.add(receptionPane, BorderLayout.CENTER);
		jframe.pack();
		jframe.setLocation(580, 60);
		jframe.setVisible(true);
	}

	public void doctor5(String name) {
		jframe.setTitle("<현지현 의사> 정보");
		JLabel jlabel = new JLabel("[D5555] 현지현(여) 35세 전화번호 : 010-5555-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));

		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);

		receptionTable.tableTitle = "ReceptionOfDoctor";
		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> patientList = rMgr.search(name);
		tableModel.setRowCount(0);
		for (Object r : patientList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}
		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		receptionPane.add(jtable, BorderLayout.CENTER);

		jpanel.add(jlabel);
		jframe.add(jpanel, BorderLayout.NORTH);
		jframe.add(receptionPane, BorderLayout.CENTER);
		jframe.pack();
		jframe.setLocation(580, 60);
		jframe.setVisible(true);
	}
}