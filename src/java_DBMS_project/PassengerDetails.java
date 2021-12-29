package java_DBMS_project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PassengerDetails extends JFrame {

	JFrame frame;
	
	static String source_name_1;
	static String dest_name_1;
	static String day_1;
	static int no_1;
	String Train_name;
	String[] name = new String[10];
	String[] pass_gender = new String[10];
	int[] age = new int[10];
	
	int l=1;
	private JTextField[] textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerDetails window = new PassengerDetails(source_name_1, dest_name_1,day_1,no_1);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	
	public PassengerDetails(String source_name, String dest_name, String day, int no) throws Exception {
		source_name_1 = source_name;
		dest_name_1 = dest_name;
		day_1 = day;
		no_1 = no;
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() throws Exception {
		
		
		int i = 0;
		int j=0;
		// TODO Auto-generated method stub
		String Url="jdbc:mysql://localhost:3306/Railway1?autoReconnect=true&useSSL=false";
		String Uname="root";
		String pwd="Nischhal1!";
		Class.forName("com.mysql.jdbc.Driver");
		String query = "select * from TRAIN";
		
		
		Connection con = DriverManager.getConnection(Url,Uname,pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		String[] train_name = new String[25];
		String[] sc_name = new String[25];
		String[] ds_name = new String[25];
		String[] train_name_final = new String[2];
		while(rs.next()) {
		train_name[i]=rs.getString("TRAIN_NAME");
		sc_name[i]=rs.getString("SOURCE1");
		ds_name[i]=rs.getString("DEST1");
		if(source_name_1.equals(sc_name[i]) && dest_name_1.equals(ds_name[i]))
		{
			train_name_final[j] = train_name[i];
			j++;
		}
		i++;
		}
	
		st.close();
		con.close();
				
		
		frame = new JFrame();
		frame.setBounds(100, 100, 756, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Enter Passenger Details");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(240, 23, 269, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Train");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(63, 133, 73, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		@SuppressWarnings("unchecked")
		JComboBox comboBox = new JComboBox(train_name_final);
		comboBox.setBounds(126, 136, 200, 27);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				Train_name = (String) comboBox.getItemAt(comboBox.getSelectedIndex());
			}
		});
		
		JLabel[] lblNewLabel_2 = new JLabel[no_1+1];
		JLabel[] lblNewLabel_2_1 = new JLabel[no_1+1];
		JLabel[] lblNewLabel_2_2 = new JLabel[no_1+1];		
		textField =  new JTextField[no_1+1];
		JSpinner[] spinner = new JSpinner[no_1+1];
		JComboBox[] comboBox_1 = new JComboBox[no_1+1];
		
		while(l <= no_1)
		{
			lblNewLabel_2[l] = new JLabel("Name");
			lblNewLabel_2[l].setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_2[l].setBounds(63,190+(l*30), 54, 27);
			frame.getContentPane().add(lblNewLabel_2[l]);
			
			textField[l] = new JTextField();
			textField[l].setBounds(126, 190+(l*30), 135, 27);
			frame.getContentPane().add(textField[l]);
			textField[l].setColumns(10);			
			
			lblNewLabel_2_1[l] = new JLabel("Gender");
			lblNewLabel_2_1[l].setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_2_1[l].setBounds(299,190+(l*30), 73, 27);
			frame.getContentPane().add(lblNewLabel_2_1[l]);
			
			lblNewLabel_2_2[l] = new JLabel("Age");
			lblNewLabel_2_2[l].setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNewLabel_2_2[l].setBounds(542,190+(l*30), 54, 27);
			frame.getContentPane().add(lblNewLabel_2_2[l]);
			
			spinner[l] = new JSpinner();
			spinner[l].setBounds(624,190+(l*30), 47, 27);
			frame.getContentPane().add(spinner[l]);
		
			String gender[]={"Male","Female","Other"};   
			comboBox_1[l] = new JComboBox(gender);
			comboBox_1[l].setBounds(382,190+(30*l), 108, 27);
			frame.getContentPane().add(comboBox_1[l]);
			l++;
		}		
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(167, 401, 108, 47);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			MainPage mg = new MainPage();
			mg.frame.setVisible(true);
			}
		});
		
		
		
		JButton btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnBookTicket.setBounds(384, 401, 156, 47);
		frame.getContentPane().add(btnBookTicket);
		btnBookTicket.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			for(int j=1;j<=no_1;j++)
			{
				age[j] = (int) spinner[j].getValue();
				name[j] = textField[j].getText();
				pass_gender[j] = (String) comboBox_1[j].getItemAt(comboBox_1[j].getSelectedIndex());
			}
	
			try {
				Reservationpg rg = new Reservationpg(name,pass_gender,age,no_1,day_1,Train_name);
				rg.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		
		
		
	}
	
	
}