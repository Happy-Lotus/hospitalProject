package table_demo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Font;
import java.util.Arrays;


public class Login extends JFrame {
    /**
     *
     */

    private static final long serialVersionUID = 1L;

    private GUIMain main;
    private MenuPage mp;
    private JPanel contentPane;
    private JTextField idField;
    private JPasswordField passwordField;
    private boolean bLoginCheck;
    /**
     * Launch the application.
     */

    /**
     * Create the frame.
     */
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        ImageIcon logo = new ImageIcon("src\\image\\logo.png");
        Image logo1 = logo.getImage();  //ImageIcon을 Image로 변환.
        Image logo2 = logo1.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
        ImageIcon logobttnIcon = new ImageIcon(logo2); //Image로 ImageIcon 생성
        contentPane.setLayout(null);

        JLabel logoImg = new JLabel("");
        logoImg.setBounds(119, 38, 360, 282);
        logoImg.setIcon(logobttnIcon);

        contentPane.add(logoImg);

        JPanel loginpanel = new JPanel();
        loginpanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        loginpanel.setBackground(new Color(147, 251, 206));
        loginpanel.setBounds(161, 345, 280, 150);
        contentPane.add(loginpanel);
        loginpanel.setLayout(null);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(31, 20, 37, 25);
        loginpanel.add(idLabel);

        JLabel pwLabel = new JLabel("PW");
        pwLabel.setBounds(31, 55, 37, 25);
        loginpanel.add(pwLabel);

        idField = new JTextField();
        idField.setBounds(91, 20, 160, 25);
        loginpanel.add(idField);
        idField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(91, 55, 160, 25);
        loginpanel.add(passwordField);

        JButton resetButton = new JButton("Reset");
        resetButton.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
        resetButton.setBounds(27, 104, 91, 23);
        loginpanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                idField.setText("");
                passwordField.setText("");
            }
        });

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("나눔고딕 ExtraBold", Font.BOLD, 12));
        loginButton.setBounds(160, 104, 91, 23);
        loginpanel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLoginCheck();
            }
        });
    }
    public void isLoginCheck(){
        String id[] = {"admin","heeyeon","haeyeon","herbssssst","jihyeon","soyoon"};
        if(Arrays.asList(id).contains(idField.getText()) && new String(passwordField.getPassword()).equals("1234")){
            JOptionPane.showMessageDialog(null, "Success");
            bLoginCheck = true;

            // 로그인 성공이라면 메뉴창 뛰우기
            if(isLogin()){
                mp = new MenuPage();
                dispose();
            }
        }else{
            idField.setText("");
            passwordField.setText("");
            JOptionPane.showMessageDialog(null, "Faild");

        }
    }


    // mainProcess와 연동

    public void setMain(GUIMain main) {
        this.mp = mp;
    }


    public boolean isLogin() {
        return bLoginCheck;
    }

}