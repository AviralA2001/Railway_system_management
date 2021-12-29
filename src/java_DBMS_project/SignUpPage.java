package java_DBMS_project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class SignUpPage extends JFrame {

	JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_6;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	private void initialize() {
			
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 16));
		frame.setBounds(100, 100, 664, 508);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(51, 81, 66, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(166, 78, 191, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContact.setBounds(51, 126, 66, 23);
		frame.getContentPane().add(lblContact);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCity.setBounds(51, 213, 66, 23);
		frame.getContentPane().add(lblCity);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(51, 259, 66, 23);
		frame.getContentPane().add(lblAge);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(51, 300, 66, 23);
		frame.getContentPane().add(lblGender);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserName.setBounds(51, 345, 90, 23);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(51, 378, 90, 23);
		frame.getContentPane().add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(166, 123, 191, 26);
		frame.getContentPane().add(textField_1);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(166, 217, 191, 26);
		frame.getContentPane().add(textField_3);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_6.setColumns(10);
		textField_6.setBounds(166, 342, 191, 26);
		frame.getContentPane().add(textField_6);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 382, 191, 27);
		frame.getContentPane().add(passwordField);
		
		String gender[]={"Male","Female","Other"};     
		JComboBox<Object> cb = new JComboBox<Object>(gender);
		cb.setBounds(166, 300, 66, 32);
		frame.getContentPane().add(cb);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(166, 259, 66, 31);
		frame.getContentPane().add(spinner);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(457, 153, 113, 37);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			Loginpg mg;
			try {
				mg = new Loginpg();
				mg.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
		
		
		JButton btnNewButton_1 = new JButton("Register");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(457, 213, 113, 41);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String Url="jdbc:mysql://localhost:3306/Railway1?autoReconnect=true&useSSL=false";
				String Uname="root";
				String pwd="Nischhal1!";
				
				String name, city, gender, username, pwd_1;
				int contact;
				int age;
				int j=0;
				int i=0;
				name = textField.getText();
				city = textField_3.getText();
				gender = (String) cb.getItemAt(cb.getSelectedIndex());
				age = (int) spinner.getValue();
				contact = Integer.parseInt(textField_1.getText());
				username = textField_6.getText();
				pwd_1 = passwordField.getText();
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
	
					Connection con = DriverManager.getConnection(Url,Uname,pwd);
					Statement st = con.createStatement();
					Statement pst = con.createStatement();
					String query = "select * from LOGIN";
					
					
					ResultSet rs = st.executeQuery(query);
					String[] name_exist = new String[10];
					String[] pwd_exist = new String[10];	
					while(rs.next()) {
					name_exist[i]=(String) rs.getString("USERNAME");
					pwd_exist[i]=(String) rs.getString("PASSWORD1");
					if(username.equals(name_exist[i]))
					{
						JOptionPane.showMessageDialog(btnNewButton_1, "Username Taken");
						j=1;
					}
					i++;
					}
					if (j==0)
							{
						String query_1 = "insert into login values ('" + username + "','" + pwd_1 + "')";
						st.executeUpdate(query_1);
						String query_2 = "insert into USER1 value('" + username + "','" + name + "','" + city + "'," + contact + ","+ age + ",'"+gender+"')"; 
						pst.executeUpdate(query_2);
							}
					
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
				
			
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Sign Up Page");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(235, 10, 185, 58);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
