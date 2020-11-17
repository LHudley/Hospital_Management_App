package hospital.management;
import ProjectPackage.ConnectionClass;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.Point;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class AddPatient {

	private JFrame frame;
	private JTextField txtId;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JTextField txtdob;
	private JTextField txtMore;
	private Connection con = null;
	private Statement st = null;

	/**
	 * Launch the application.
	 */
	public static void addpt() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient window = new AddPatient();
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
	public AddPatient() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setLocation(new Point(280, 170));
		frame.setBounds(280, 190, 810,530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddClose = new JButton("CLOSE");
		btnAddClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				 hm.homeScreen();
			  
			}
			
		});
		btnAddClose.setBackground(new Color(255, 0, 0));
		btnAddClose.setForeground(new Color(255, 255, 255));
		btnAddClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAddClose.setBounds(665, 463, 89, 23);
		frame.getContentPane().add(btnAddClose);
		
		JLabel lblNewLabel = new JLabel("Patient Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(114, 54, 120, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(114, 104, 120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(114, 154, 120, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(114, 204, 120, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("D.O.B");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(114, 259, 120, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(114, 310, 120, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(114, 360, 120, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		txtId = new JTextField();
		txtId.setBounds(295, 52, 272, 20);
		frame.getContentPane().add(txtId);
		txtId.setColumns(10);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(295, 102, 272, 20);
		frame.getContentPane().add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setBounds(295, 152, 272, 20);
		frame.getContentPane().add(txtLast);
		txtLast.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(295, 358, 272, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(295, 308, 272, 20);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtdob = new JTextField();
		txtdob.setBounds(295, 257, 272, 20);
		frame.getContentPane().add(txtdob);
		txtdob.setColumns(10);
		
		JComboBox comboBoxGender = new JComboBox();
		comboBoxGender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBoxGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBoxGender.setBounds(295, 201, 272, 22);
		frame.getContentPane().add(comboBoxGender);
		
		JLabel lblNewLabel_7 = new JLabel("Additional Info:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(114, 408, 120, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		txtMore = new JTextField();
		txtMore.setBounds(295, 406, 272, 20);
		frame.getContentPane().add(txtMore);
		txtMore.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientId = txtId.getText();
				String firstnm = txtFirst.getText();
				String lastnm = txtLast.getText();
				String gender = (String) comboBoxGender.getSelectedItem();
				String address = txtAddress.getText();
				String phone = txtPhone.getText();
				String adob = txtdob.getText();
				String more = txtMore.getText();
				
				try {
					Connection con = ConnectionClass.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("insert into patient(patientId, firstname,lastname,gender,dob,phone, address,info) values ('" + patientId + "', '" + firstnm + "', '" + lastnm + "','" + gender + "','" + adob + "','" + phone + "','" + address + "', '" + more + "')");
					JOptionPane.showMessageDialog(null, "Patient Added Successfully");
					AddPatient ap = new AddPatient();
					 ap.addpt();
				}
				catch(Exception a ) {
					JOptionPane.showMessageDialog(null, "Data not in correct format");
				}

			}
		});
		btnSave.setBackground(Color.RED);
		btnSave.setForeground(Color.WHITE);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(295, 464, 89, 23);
		frame.getContentPane().add(btnSave);
	}
}
