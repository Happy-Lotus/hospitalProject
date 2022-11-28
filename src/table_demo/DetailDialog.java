package table_demo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hospital.Main;
import hospital.Reservation;
import hospital.Vaccination;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

public class DetailDialog extends javax.swing.JDialog {
	String[] itemDetails;
	String[] patientDetails;
	DefaultTableModel model;
	int selectedIndex = -1;
	JTable table;
	JScrollPane scroll;
	String kwd;

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

		if (itemDetails[3].contains("BCG")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 0, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 0, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 0, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 0, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 0, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 0, 1);
		}

		if (itemDetails[3].contains("HepB")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 1, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 1, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 1, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 1, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 1, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 1, 1);
		}

		if (itemDetails[3].contains("DTaP")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 2, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 2, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 2, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 2, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 2, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 2, 1);
		}

		if (itemDetails[3].contains("Tdap")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 3, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 3, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 3, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 3, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 3, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 3, 1);
		}

		if (itemDetails[3].contains("IPV")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 4, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 4, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 4, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 4, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 4, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 4, 1);
		}

		if (itemDetails[3].contains("Hib")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 5, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 5, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 5, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 5, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 5, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 5, 1);
		}

		if (itemDetails[3].contains("PCV")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 6, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 6, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 6, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 6, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 6, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 6, 1);
		}

		if (itemDetails[3].contains("MMR")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 7, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 7, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 7, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 7, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 7,  i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 7, 1);
		}

		if (itemDetails[3].contains("VAR")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 8, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 8, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 8, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 8, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 8, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 8, 1);
		}

		if (itemDetails[3].contains("HepA")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 9, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 9, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 9, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 9, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 9, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 9, 1);
		}

		if (itemDetails[3].contains("IJEV")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 10, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 10, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 10, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 10, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 10, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 10, 1);
		}

		if (itemDetails[3].contains("LJEV")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 11, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 11, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 11, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 11, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 11, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 11, 1);
		}

		if (itemDetails[3].contains("RV1")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 12, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 12, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 12, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 12, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 12, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 12, 1);
		}

		if (itemDetails[3].contains("RV5")) {
			if (itemDetails[3].contains("6차"))
				for (int i = 1; i <= 6; i++) {
					table.setValueAt("O", 13, i);
				}
			if (itemDetails[3].contains("5차"))
				for (int i = 1; i <= 5; i++) {
					table.setValueAt("O", 13, i);
				}
			if (itemDetails[3].contains("4차"))
				for (int i = 1; i <= 4; i++) {
					table.setValueAt("O", 13, i);
				}
			if (itemDetails[3].contains("3차"))
				for (int i = 1; i <= 3; i++) {
					table.setValueAt("O", 13, i);
				}
			if (itemDetails[3].contains("2차"))
				for (int i = 1; i <= 2; i++) {
					table.setValueAt("O", 13, i);
				}
			if (itemDetails[3].contains("1차"))
				table.setValueAt("O", 13, 1);
		}
		pack();
		setVisible(true);
	}
}
