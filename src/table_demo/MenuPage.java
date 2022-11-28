package table_demo;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;

public class MenuPage {

    // static Login login;
    private static JFrame frame;
    static GUIMain main = GUIMain.getInstance();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPage.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/

        //showMenu();
    }

   /* public static void startGUI() {
        // 이벤트 처리 스레드를 만들고
        // 거기서 GUI를 생성하고 보여준다.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
                initialize();
            }
        });
    }*/

    /**
     * Create the application.
     */
    public MenuPage() {
        //	startGUI();

        initialize();
    }
/*
	public void showMenu(){
        login.dispose(); // 로그인창닫기
        frame.setVisible(true);
        initialize();
    }
  */
    /**
     * Initialize the contents of the frame.
     * setupReceptionPane();
     setupPatientPane();
     setupVaccinationPane();
     setupResevationPane();
     */
    public static void initialize() {
        frame = new JFrame("AH 소아과 관리 프로그램");
        frame.setBounds(100, 100, 440, 456);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setBackground(Color.WHITE);
        frame.getContentPane().add(menuPanel, BorderLayout.CENTER);
        menuPanel.setLayout(null);

        //JButton rcepButton = new JButton("접수");
        ImageIcon rb = new ImageIcon("src/image/접수.png");
        Image rb_img = rb.getImage();
        Image rb_changeImg = rb_img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon rb_changelogo = new ImageIcon(rb_changeImg);
        JButton rcepButton = new JButton(rb_changelogo);

        //homeButton.setOpaque(false);
        rcepButton.setBounds(87, 144, 97, 60);
        rcepButton.setBackground(new Color(147, 251, 206));

        menuPanel.add(rcepButton);
        frame.setVisible(true);

        rcepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ReceptionTab.getInstance().receptionFrame.setVisible(true);
            }
        });


        //JButton rcepButton = new JButton("예약");
        ImageIcon rv = new ImageIcon("src/image/예약.png");
        Image rv_img = rv.getImage();
        Image rv_changeImg = rv_img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon rv_changelogo = new ImageIcon(rv_changeImg);
        JButton rsvButton = new JButton(rv_changelogo);

        //homeButton.setOpaque(false);
        rsvButton.setBounds(237, 144, 97, 60);
        rsvButton.setBackground(new Color(147, 251, 206));

        menuPanel.add(rsvButton);
        frame.setVisible(true);

        rsvButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ReservationTab.getInstance().reservationFrame.setVisible(true);
            }
        });


        ImageIcon pt = new ImageIcon("src/image/환자.png");
        Image pt_img = pt.getImage();
        Image pt_changeImg = pt_img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon pt_changelogo = new ImageIcon(pt_changeImg);
        JButton patiButton = new JButton(pt_changelogo);

        //homeButton.setOpaque(false);
        patiButton.setBounds(237, 268, 97, 60);
        patiButton.setBackground(new Color(147, 251, 206));

        menuPanel.add(patiButton);
        frame.setVisible(true);

        patiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                PatientTab.getInstance().patientFrame.setVisible(true);
            }
        });

        ImageIcon dt = new ImageIcon("src/image/의사.png");
        Image dt_img = dt.getImage();
        Image dt_changeImg = dt_img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon dt_changelogo = new ImageIcon(dt_changeImg);
        JButton docButton = new JButton(dt_changelogo);

        //homeButton.setOpaque(false);
        docButton.setBounds(87, 268, 97, 60);
        docButton.setBackground(new Color(147, 251, 206));

        menuPanel.add(docButton);
        frame.setVisible(true);

        docButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                DoctorTab.getInstance().doctorFrame.setVisible(true);
            }
        });

        JLabel titelPanel = new JLabel("AH 소아과 관리 프로그램");
        titelPanel.setFont(new Font("수성돋움체", Font.BOLD, 18));
        titelPanel.setBounds(101, 46, 220, 65);
        menuPanel.add(titelPanel);

		/*
		JButton homeButton = new JButton(new ImageIcon("src/image/home.png"));
		homeButton.setText("Home");
		*/

        ImageIcon home = new ImageIcon("src/image/home.png");
        Image img = home.getImage();
        Image changeImg = img.getScaledInstance(48, 49,Image.SCALE_SMOOTH);
        ImageIcon changelogo = new ImageIcon(changeImg);
        JButton homeButton = new JButton(changelogo);

        //homeButton.setOpaque(false);
        homeButton.setBounds(12, 10, 48, 49);
        homeButton.setBackground(Color.WHITE);

        menuPanel.add(homeButton);

        JLabel lblNewLabel = new JLabel("접수");
        lblNewLabel.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        lblNewLabel.setBounds(115, 208, 35, 34);
        menuPanel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("예약");
        lblNewLabel_1.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        lblNewLabel_1.setBounds(269, 207, 35, 34);
        menuPanel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("의사");
        lblNewLabel_1_1.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        lblNewLabel_1_1.setBounds(116, 333, 35, 34);
        menuPanel.add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_1_1 = new JLabel("환자");
        lblNewLabel_1_1_1.setFont(new Font("수성돋움체", Font.PLAIN, 15));
        lblNewLabel_1_1_1.setBounds(269, 333, 35, 34);
        menuPanel.add(lblNewLabel_1_1_1);
        frame.setVisible(true);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startPage start = new startPage();
                frame.dispose();
            }
        });
        menuPanel.add(homeButton);
        frame.setVisible(true);
    }
}