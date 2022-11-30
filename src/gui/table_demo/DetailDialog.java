package gui.table_demo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import facade.UIData;
import gui.main.GUIMain;
import hospital.Main;
import hospital.patient.Patient;
import hospital.reservation.ReservationMgr;

import java.awt.BorderLayout;
import java.util.List;

public class DetailDialog extends javax.swing.JDialog {
	DefaultTableModel tableModel;
	String[] itemDetails;
	String[] patientDetails;
	DefaultTableModel model;
	int selectedIndex = -1;
	JTable table;
	JScrollPane scroll;

	ReservationMgr rMgr = new ReservationMgr();

	String title[] = { "백신종류", "1차", "2차", "3차", "추4차", "추5차", "추6차" };
	String data[][] = { { "BCG" }, { "HepB" }, { "DTaP" }, { "Tdap" }, { "IPV" }, { "Hib" }, { "PCV" }, { "MMR" },
			{ "VAR" }, { "HepA" }, { "IJEV" }, { "LJEV" }, { "RV1" }, { "RV5" } };

	JLabel details[] = new JLabel[5];

	DetailDialog(String[] texts) {
		super(GUIMain.mainFrame);
		itemDetails = texts;
	}

	void setup() {
		setTitle("예방접종현황");

		JPanel pane = new JPanel(new BorderLayout());
		model = new DefaultTableModel(title, 14);
		table = new JTable(model);

		scroll = new JScrollPane(table);
		add(scroll);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				table.setValueAt(data[i][j], i, j); // data값을 i번 행, j번 열에 넣어라
			}
		}

		tableModel = new DefaultTableModel(rMgr.getColumnNames(), 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		List<?> reservationList = rMgr.search(itemDetails[0]);
		Patient patient = (Patient)Main.patientMgr.find(itemDetails[0]);

		tableModel.setRowCount(0);
		for (Object r : reservationList) {
			tableModel.addRow(((UIData) r).getUiTexts());
		}

		JTable jtable = new JTable();
		jtable = new JTable(tableModel);
		for(int k=0; k<reservationList.size(); k++) {
			String symtom = (String) jtable.getValueAt(k, 3);

			if (symtom.contains("BCG")) {

				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("BCG 1차"), 0, 1);
			}

			if (symtom.contains("HepB")) {

				if (symtom.contains("3차"))
					//for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("HepB 3차"), 1, 3);
				//}
				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("HepB 2차"), 1, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("HepB 1차"), 1, 1);
			}

			if (symtom.contains("DTaP")) {

				if (symtom.contains("5차"))
					//for (int i = 1; i <= 5; i++) {
					table.setValueAt(patient.getVaccinationList().get("DTaP 5차"), 2, 5);
				//}
				if (symtom.contains("4차"))
					//for (int i = 1; i <= 4; i++) {
					table.setValueAt(patient.getVaccinationList().get("DTaP 4차"), 2, 4);
				//}
				if (symtom.contains("3차"))
					//for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("DTaP 3차"), 2, 3);
				//}
				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("DTaP 2차"), 2, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("DTaP 1차"), 2, 1);
			}

			if (symtom.contains("Tdap")) {

				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("Tdap/Td 1차"), 3, 1);
			}

			if (symtom.contains("IPV")) {

				if (symtom.contains("4차"))
					//	for (int i = 1; i <= 4; i++) {
					table.setValueAt(patient.getVaccinationList().get("IPV 4차"), 4, 4);
				//	}
				if (symtom.contains("3차"))
					//	for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("IPV 3차"), 4, 3);
				//	}
				if (symtom.contains("2차"))
					//	for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("IPV 2차"), 4, 2);
				//	}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("IPV 1차"), 4, 1);
			}

			if (symtom.contains("Hib")) {

				if (symtom.contains("4차"))
					//for (int i = 1; i <= 4; i++) {
					table.setValueAt(patient.getVaccinationList().get("Hib 4차"), 5, 4);
				//}
				if (symtom.contains("3차"))
					//for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("Hib 3차"), 5, 3);
				//}
				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("Hib 2차"), 5, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("Hib 1차"), 5, 1);
			}

			if (symtom.contains("PCV")) {

				if (symtom.contains("4차"))
					//	for (int i = 1; i <= 4; i++) {
					table.setValueAt(patient.getVaccinationList().get("PCV 4차"), 6, 4);
				//	}
				if (symtom.contains("3차"))
					//	for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("PCV 3차"), 6, 3);
				//	}
				if (symtom.contains("2차"))
					//	for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("PCV 2차"), 6, 2);
				//	}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("PCV 1차"), 6, 1);
			}

			if (symtom.contains("MMR")) {

				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("MMR 2차"), 7,  2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("MMR 1차"), 7, 1);
			}

			if (symtom.contains("VAR")) {

				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("VAR 1차"), 8, 1);
			}

			if (symtom.contains("HepA")) {

				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("HepA 2차"), 9, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("HepA 1차"), 9, 1);
			}

			if (symtom.contains("IJEV")) {

				if (symtom.contains("5차"))
					//for (int i = 1; i <= 5; i++) {
					table.setValueAt(patient.getVaccinationList().get("IJEV 5차"), 10, 56);
				//}
				if (symtom.contains("4차"))
					//for (int i = 1; i <= 4; i++) {
					table.setValueAt(patient.getVaccinationList().get("IJEV 4차"), 10, 4);
				//}
				if (symtom.contains("3차"))
					//for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("IJEV 3차"), 10, 3);
				//}
				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("IJEV 2차"), 10, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("IJEV 1차"), 10, 1);
			}

			if (symtom.contains("LJEV")) {

				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("LJEV 2차"), 11, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("LJEV 1차"), 11, 1);
			}

			if (symtom.contains("RV1")) {

				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("RV1 2차"), 12, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("RV1 2차"), 12, 1);
			}

			if (symtom.contains("RV5")) {

				if (symtom.contains("3차"))
					//for (int i = 1; i <= 3; i++) {
					table.setValueAt(patient.getVaccinationList().get("RV5 3차"), 13, 3);
				//}
				if (symtom.contains("2차"))
					//for (int i = 1; i <= 2; i++) {
					table.setValueAt(patient.getVaccinationList().get("RV5 2차"), 13, 2);
				//}
				if (symtom.contains("1차"))
					table.setValueAt(patient.getVaccinationList().get("RV5 1차"), 13, 1);
			}

		}
		pack();
		setVisible(true);
	}
}

