package table_demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import hospital.Main;
import hospital.ReceptionMgr;
import mgr.Manageable;

public class DoctorDetail{
	JFrame jframe = new JFrame();
	JPanel jpanel = new JPanel();
	private JPanel receptionPane;

	//ReceptionMgr rMgr = new ReceptionMgr();
	TableSelectionDemo receptionTable = new TableSelectionDemo();
	
	public void doctor1() {
		jframe.setTitle("<김가을 의사> 정보");
		JLabel jlabel = new JLabel("[D1111] 김가을(여) 35세 전화번호 : 010-1111-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));
		//List<Manageable> patientList = rMgr.search("김가을");
		
		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);
		
		receptionTable.tableTitle = "ReceptionOfDoctor";
		receptionTable.addComponentsToPane(ReceptionMgr.getInstance());
		receptionPane.add(receptionTable, BorderLayout.CENTER);
		 
	    jpanel.add(jlabel);
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(receptionPane,BorderLayout.CENTER);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public void doctor2() {
		jframe.setTitle("<김해연 의사> 정보");
		JLabel jlabel = new JLabel("[D2222] 김해연(여) 35세 전화번호 : 010-2222-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));
		
		//List<Manageable> patientList = rMgr.search("김가을");
		
		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);
		
		receptionTable.tableTitle = "ReceptionOfDoctor";
		receptionTable.addComponentsToPane(ReceptionMgr.getInstance());
		receptionPane.add(receptionTable, BorderLayout.CENTER);
		 
	    jpanel.add(jlabel);
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(receptionPane,BorderLayout.CENTER);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public void doctor3() {
		jframe.setTitle("<김희연 의사> 정보");
		JLabel jlabel = new JLabel("[D3333] 김희연(여) 35세 전화번호 : 010-3333-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));
		
		//List<Manageable> patientList = rMgr.search("김가을");
		
		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);
		
		receptionTable.tableTitle = "ReceptionOfDoctor";
		receptionTable.addComponentsToPane(ReceptionMgr.getInstance());
		receptionPane.add(receptionTable, BorderLayout.CENTER);
		 
	    jpanel.add(jlabel);
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(receptionPane,BorderLayout.CENTER);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public void doctor4() {
		jframe.setTitle("<이소윤 의사> 정보");
		JLabel jlabel = new JLabel("[D4444] 이소윤(여) 35세 전화번호 : 010-4444-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));
		
		//List<Manageable> patientList = rMgr.search("김가을");
		
		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);
		
		receptionTable.tableTitle = "ReceptionOfDoctor";
		receptionTable.addComponentsToPane(ReceptionMgr.getInstance());
		receptionPane.add(receptionTable, BorderLayout.CENTER);
		 
	    jpanel.add(jlabel);
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(receptionPane,BorderLayout.CENTER);
		jframe.pack();
		jframe.setVisible(true);
	}
	
	public void doctor5() {
		jframe.setTitle("<현지현 의사> 정보");
		JLabel jlabel = new JLabel("[D5555] 현지현(여) 35세 전화번호 : 010-5555-1234");
		jlabel.setFont(new Font("수성돋움체", Font.PLAIN, 11));
		jpanel.setBackground(new Color(147, 251, 206));
		
		//List<Manageable> patientList = rMgr.search("김가을");
		
		receptionPane = new JPanel(new BorderLayout());
		receptionPane.setBackground(Color.WHITE);
		
		receptionTable.tableTitle = "ReceptionOfDoctor";
		receptionTable.addComponentsToPane(ReceptionMgr.getInstance());
		receptionPane.add(receptionTable, BorderLayout.CENTER);
		 
	    jpanel.add(jlabel);
		jframe.add(jpanel,BorderLayout.NORTH);
		jframe.add(receptionPane,BorderLayout.CENTER);
		jframe.pack();
		jframe.setVisible(true);
	}
}
