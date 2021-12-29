package java_DBMS_project;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.EventQueue;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainPage extends JFrame {

	JFrame frame;
	String source_name;
	String dest_name;
	String day;
	int no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage();
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
	public void get_source()
	{
		
	}
	public MainPage() {
	
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
				
		frame = new JFrame();
		frame.setBounds(100, 100, 756, 584);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Ticketing System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(212, 29, 334, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(63, 137, 85, 21);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(490, 137, 56, 21);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Day");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(76, 253, 62, 31);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("No. of Passengers");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(394, 253, 159, 31);
		frame.getContentPane().add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(158, 419, 140, 36);
		frame.getContentPane().add(btnNewButton);
	
		
		String source[]={"AHEMDABAD","DELHI","MUMBAI"}; 
		JComboBox<Object> comboBox = new JComboBox<Object>(source);
		comboBox.setBounds(158, 133, 159, 36);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				source_name = (String) comboBox.getItemAt(comboBox.getSelectedIndex());					
		}
		});		 
		
		String days[]={"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"}; 
		JComboBox<Object> comboBox_1 = new JComboBox<Object>(days);
		comboBox_1.setBounds(158, 249, 159, 35);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				day = (String) comboBox_1.getItemAt(comboBox_1.getSelectedIndex());					
		}
		});		
		
		String dest[]={"AHEMDABAD","DELHI","MUMBAI"}; 
		JComboBox<Object> comboBox_2 = new JComboBox<Object>(dest);
		comboBox_2.setBounds(563, 138, 147, 31);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dest_name = (String) comboBox_2.getItemAt(comboBox_2.getSelectedIndex());				
			}
		});
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(563, 253, 78, 29);
		frame.getContentPane().add(spinner);
		
		
		JButton btnNewButton_1 = new JButton("Proceed");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(373, 419, 115, 36);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				no = (int) spinner.getValue();
				PassengerDetails pd;
				try {
					pd = new PassengerDetails(source_name,dest_name,day,no);
					pd.frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();			
			}
		});
	}
}
