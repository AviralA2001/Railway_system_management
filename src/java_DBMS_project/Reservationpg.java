package java_DBMS_project;
import java.sql.*;
//import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Reservationpg extends JFrame {

	private JPanel contentPane;
	static String[] pass_name = new String[10];
	static String[] pass_gender = new String[10];
	static int[] pass_age = new int[10];
	static int pass_no;
	static String travel_day;
	static String Train_name_final;

	String sc_name = new String();
	String ds_name = new String();
    int train_no;
	int cost;
	int total;
	int pnr;
	
	public Reservationpg(String name[],String gender[], int age[], int no,String day, String Train_name) throws Exception {
		
		// TODO Auto-generated method stub
		
		pass_no=no;
		Train_name_final = Train_name;
		travel_day = day;
		for(int l=1;l<=pass_no;l++)
		{
			pass_name[l] = name[l];
			pass_gender[l] = gender[l];
			pass_age[l] = age[l];
		}
		
		String Url="jdbc:mysql://localhost:3306/Railway1?autoReconnect=true&useSSL=false";
		String Uname="root";
		String pwd="Nischhal1!";
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from TRAIN where TRAIN_NAME = '";
		
		
		Connection con = DriverManager.getConnection(Url,Uname,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query+Train_name_final+"';");
		String train_name = new String();
		while(rs.next()) {
		cost = rs.getInt(travel_day);
		sc_name=rs.getString("SOURCE1");
		ds_name=rs.getString("DEST1");
		train_no=rs.getInt("TRAIN_NO");	
		}
		Statement st_1 = con.createStatement();
		ResultSet rs_1 = st_1.executeQuery("SELECT MAX(PNR) FROM PASSENGER");
		while(rs_1.next())
			{
			pnr=rs_1.getInt(1);
			}
		
		
		pnr = pnr+1;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 724, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("E-TICKET RESERVATION");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(261, 10, 220, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1 = new JLabel("Train No: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(102, 99, 72, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_O_P = new JLabel(String.valueOf(train_no));
		lblNewLabel_1_1_O_P.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_O_P.setBounds(180, 99, 72, 17);
		contentPane.add(lblNewLabel_1_1_O_P);
		
		JLabel lblNewLabel_1_2 = new JLabel("Source: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(102, 132, 72, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_O_P = new JLabel(sc_name);
		lblNewLabel_1_2_O_P.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2_O_P.setBounds(180, 132, 72, 17);
		contentPane.add(lblNewLabel_1_2_O_P);
		
		JLabel lblNewLabel_1_3 = new JLabel("Train Name: ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(468, 99, 72, 17);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_O_P = new JLabel(Train_name_final);
		lblNewLabel_1_3_O_P.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3_O_P.setBounds(545, 99, 200, 17);
		contentPane.add(lblNewLabel_1_3_O_P);
		
		JLabel lblNewLabel_1_4 = new JLabel("Destination: ");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(468, 132, 72, 17);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_4_O_P = new JLabel(ds_name);
		lblNewLabel_1_4_O_P.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_4_O_P.setBounds(545, 132, 72, 17);
		contentPane.add(lblNewLabel_1_4_O_P);
		
		JLabel lblNewLabel_1_5 = new JLabel("PNR NO");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_5.setBounds(32, 231, 72, 17);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Name");
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_6.setBounds(175, 231, 72, 17);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Gender");
		lblNewLabel_1_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_7.setBounds(469, 231, 72, 17);
		contentPane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_1_8 = new JLabel("Age");
		lblNewLabel_1_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_8.setBounds(640, 231, 72, 17);
		contentPane.add(lblNewLabel_1_8);
		
		JLabel[] lblNewLabel_1_6_O_P = new JLabel[pass_no+1];
		JLabel[] lblNewLabel_1_7_O_P = new JLabel[pass_no+1];
		JLabel[] lblNewLabel_1_8_O_P = new JLabel[pass_no+1];
		JLabel[] lblNewLabel_1_5_O_P = new JLabel[pass_no+1];
		
		for (int i=1;i<=pass_no;i++)
		{
			lblNewLabel_1_5_O_P[i] = new JLabel(String.valueOf(pnr));
			lblNewLabel_1_5_O_P[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1_5_O_P[i].setBounds(32, 231+(i*20), 72, 17);
			contentPane.add(lblNewLabel_1_5_O_P[i]);
			
			lblNewLabel_1_6_O_P[i] = new JLabel(pass_name[i]);
			lblNewLabel_1_6_O_P[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1_6_O_P[i].setBounds(175, 231+(i*20), 72, 17);
			contentPane.add(lblNewLabel_1_6_O_P[i]);
			
			lblNewLabel_1_7_O_P[i] = new JLabel(pass_gender[i]);
			lblNewLabel_1_7_O_P[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1_7_O_P[i].setBounds(469, 231+(i*20), 72, 17);
			contentPane.add(lblNewLabel_1_7_O_P[i]);
			
			lblNewLabel_1_8_O_P[i] = new JLabel(String.valueOf(pass_age[i]));
			lblNewLabel_1_8_O_P[i].setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_1_8_O_P[i].setBounds(640, 231+(i*20), 72, 17);
			contentPane.add(lblNewLabel_1_8_O_P[i]);
		}
		
		JLabel lblPassengerDetails = new JLabel("       Passenger Details");
		lblPassengerDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPassengerDetails.setBounds(261, 167, 220, 54);
		contentPane.add(lblPassengerDetails);
		
		total = cost * pass_no;
		
		JLabel lblTotalFare = new JLabel("Total Fare: ");
		lblTotalFare.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalFare.setBounds(32, 346, 220, 54);
		contentPane.add(lblTotalFare);
		
		JLabel lblTotalFare_O_P = new JLabel(String.valueOf(total));
		lblTotalFare_O_P.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTotalFare_O_P.setBounds(110, 346, 220, 54);
		contentPane.add(lblTotalFare_O_P);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Sitka Display", Font.BOLD, 13));
		btnConfirm.setBounds(555, 404, 94, 35);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Statement st_input = con.createStatement();
						
						for(int x=1;x<=pass_no;x++)
						{
							String query = "INSERT INTO PASSENGER VALUES ("+pnr+", '"+pass_name[x]+"', "+pass_age[x]+", '"+sc_name+"', '"+ds_name+"', "+train_no+");";
							st_input.executeUpdate(query);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(btnConfirm, "Ticket Confirmed");
		}
	});
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.WHITE);
		btnExit.setFont(new Font("Sitka Display", Font.BOLD, 13));
		btnExit.setBounds(408, 404, 94, 35);
		contentPane.add(btnExit);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservationpg frame = new Reservationpg(pass_name,pass_gender,pass_age,pass_no,travel_day,Train_name_final);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
}

