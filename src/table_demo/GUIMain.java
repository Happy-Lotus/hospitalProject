package table_demo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Hospital.Main;
import Hospital.Patient;
import Hospital.Reception;
import Hospital.Vaccination;
import Hospital.VaccinationMgr;
import mgr.Manageable;

public class GUIMain extends JFrame {
	DefaultTableModel model;
	JTable table;
	JScrollPane scroll;

	String title[] = { "백신종류", "1차", "2차", "3차", "추4차", "추5차", "추6차" };
	String data[][] = { { "BCG" }, { "HepB" }, { "DTaP" }, { "Tdap" }, { "IPV" }, { "Hib" }, { "PCV" }, { "MMR" },
			{ "VAR" }, { "HepA" }, { "IJEV" }, { "LJEV" }, { "RV1" }, { "RV5" } };

	public GUIMain() {
		setTitle("예방접종현황");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		model = new DefaultTableModel(title, 14);
		table = new JTable(model);

		scroll = new JScrollPane(table);
		add(scroll);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				table.setValueAt(data[i][j], i, j); // data값을 i번 행, j번 열에 넣어라
			}
		}

		String name;
		Scanner scan = new Scanner(System.in);
		name = scan.next();
		
		/*ArrayList<Reception> rlist = new ArrayList<>();
		rlist = Main.VaccinationMgr.getMlist();
		for(int i = 0;i<Main.VaccinationMgr.mList.size();i++) {
			Vaccination vac = (Vaccination)Main.VaccinationMgr.getMlist().get(i);
			
		}*/
		/*LinkedHashMap<String, String> patientVacList = ((Patient) p1).getVaccinationList();
		Set<String> keyset = patientVacList.keySet();*/
			
		for(int i = 0;i<Main.receptionMgr.mList.size();i++) {
			Reception r = (Reception) Main.receptionMgr.getMlist().get(i);
			if(r.matches(name)) {
				for (int k = 0; k < data.length; k++) {
						if (r.matches(data[k][0])) {
							for (int j = 1; j <= 6; j++) {
								table.setValueAt("O", k, j);
							}
						}
					}
				}
		}
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new GUIMain();
	}
}
