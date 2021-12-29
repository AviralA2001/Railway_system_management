package java_DBMS_project;
//import java.awt.BorderLayout;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;


@SuppressWarnings("serial")
public class Loginpg extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpg frame = new Loginpg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Loginpg() throws Exception{
		int i = 0;
		// TODO Auto-generated method stub
		String Url="jdbc:mysql://localhost:3306/Railway1?autoReconnect=true&useSSL=false";
		String Uname="root";
		String pwd="Nischhal1!";
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from LOGIN";
		
		
		Connection con = DriverManager.getConnection(Url,Uname,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		String[] name = new String[10];
		String[] pwd_1 = new String[10];	
		while(rs.next()) {
		name[i]=(String) rs.getString("USERNAME");
		pwd_1[i]=(String) rs.getString("PASSWORD1");
		i++;
		}	
		st.close();
		con.close();
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(200, 200, 1200, 650);
	contentPane = new JPanel();
	contentPane.setBackground(SystemColor.menu);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblPassword = new JLabel("Password");
	lblPassword.setForeground(SystemColor.desktop);
	lblPassword.setFont(new Font("Sitka Subheading", Font.BOLD, 23));
	lblPassword.setBounds(650, 229, 197, 42);
	contentPane.add(lblPassword);
	

	
	JButton btnSignUp = new JButton("Sign UP");
	btnSignUp.setForeground(SystemColor.desktop);
	btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 26));
	btnSignUp.setBackground(new Color(255, 255, 255));
	btnSignUp.setBounds(786, 469, 169, 42);
	contentPane.add(btnSignUp);
	btnSignUp.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SignUpPage sg = new SignUpPage();
			sg.frame.setVisible(true);	
		}
	});
	
	JLabel lblLoginId = new JLabel("Login ID");
	lblLoginId.setForeground(Color.BLACK);
	lblLoginId.setFont(new Font("Sitka Subheading", Font.BOLD, 23));
	lblLoginId.setBounds(650, 155, 197, 42);
	contentPane.add(lblLoginId);
	
	JTextArea txtrSampleName = new JTextArea();
	txtrSampleName.setFont(new Font("Monospaced", Font.PLAIN, 20));
	txtrSampleName.setBackground(SystemColor.text);
	txtrSampleName.setBounds(831, 153, 236, 42);
	contentPane.add(txtrSampleName);
	
	
	passwordField = new JPasswordField();
	passwordField.setBounds(831, 229, 236, 30);
	contentPane.add(passwordField);

	
	JButton btnNewButton = new JButton("Login");
	btnNewButton.setBackground(SystemColor.text);
	btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 26));
	btnNewButton.addActionListener(new ActionListener() {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			String username;
			username = txtrSampleName.getText();
			String password;
			password = passwordField.getText();
			
			int j=0;
			for(int i=0;i<10;i++)
			{
				
				if(password.equals(pwd_1[i]) && username.equals(name[i]))
					
				{
					dispose();
					MainPage mg = new MainPage();
					mg.frame.setVisible(true);
					j=1;
					break;
					
				}
			
		}
			if(j==0)
			{
				JOptionPane.showMessageDialog(btnNewButton, "Wrong PWD");
			}
		}
		});
	btnNewButton.setBounds(797, 354, 109, 42);
	contentPane.add(btnNewButton);
	
	JLabel lblNewLabel = new JLabel("Welcome To Train E-Registration Site");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblNewLabel.setBounds(704, 61, 482, 30);
	contentPane.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel("New label");
	lblNewLabel_1.setIcon(new ImageIcon("D:\\FJP\\bg.jpg"));
	lblNewLabel_1.setBounds(0, 10, 601, 593);
	contentPane.add(lblNewLabel_1);
	
	JLabel lblDontHaveAn = new JLabel("Don't have an account? ");
	lblDontHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 18));
	lblDontHaveAn.setBounds(739, 417, 253, 30);
	contentPane.add(lblDontHaveAn);
}
}

	
