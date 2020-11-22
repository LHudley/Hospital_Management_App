package hospital.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import ProjectPackage.ConnectionClass;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PtUpdate {

	private JFrame frame;
	private JTextField txtPtId;
	private JTextField txtFirst;
	private JTextField txtLast;
	private JTextField txtdob;
	private JTextField txtPhone;
	private JTextField txtAddress;
	private JTextField txtInfo;
	private JTextField txtGender;

	/**
	 * Launch the application.
	 */
	public static void patientUpdate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtUpdate window = new PtUpdate();
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
	public PtUpdate() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.getContentPane().setLocation(new Point(280, 170));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient Id:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(114, 54,120, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(114, 104,120, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(114, 154,120, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(114, 204,120, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("DOB:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(114, 259,120, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(114, 310,120, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(114, 360,120, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Additional Info:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(114, 408,120, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		txtPtId = new JTextField();
		txtPtId.setBounds(295, 52, 137, 20);
		frame.getContentPane().add(txtPtId);
		txtPtId.setColumns(10);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(295, 102, 272, 20);
		frame.getContentPane().add(txtFirst);
		txtFirst.setColumns(10);
		
		txtLast = new JTextField();
		txtLast.setBounds(295, 152, 272, 20);
		frame.getContentPane().add(txtLast);
		txtLast.setColumns(10);
		
		txtdob = new JTextField();
		txtdob.setBounds(295, 257, 272, 20);
		frame.getContentPane().add(txtdob);
		txtdob.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(295, 308, 272, 20);
		frame.getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(295, 358, 272, 20);
		frame.getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(295, 406, 272, 20);
		frame.getContentPane().add(txtInfo);
		txtInfo.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientId = txtPtId.getText();
				String firstnm = txtFirst.getText();
				String lastnm = txtLast.getText();
				String gender = txtGender.getText();
				String address = txtAddress.getText();
				String phone = txtPhone.getText();
				String adob = txtdob.getText();
				String more = txtInfo.getText();
				
				try {
					Connection con = ConnectionClass.getCon();
					Statement st = con.createStatement();
					st.executeUpdate("update patient set firstname ='" + firstnm + "' ,lastname = '" + lastnm + "',gender = '" + gender + "', dob = '" + adob + "',phone = '" + phone + "', address = '" + address + "',info = '" + more + "' where patientId ='" + patientId + "'");
					JOptionPane.showMessageDialog(null, "Updated Successful");

				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Data not in correct format");

				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(295, 463, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				hm.homeScreen();
			}
			
		});
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(665, 463, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientId = txtPtId.getText();
				
				try {
					Connection con = ConnectionClass.getCon();
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = st.executeQuery("select * from patient where patientId = '" + patientId + "'");
					
						if(rs.next()) {
							txtFirst.setText(rs.getString(2));
							txtLast.setText(rs.getString(3));
							txtGender.setText(rs.getString(4));
							txtdob.setText(rs.getString(5));
							txtPhone.setText(rs.getString(6));
							txtAddress.setText(rs.getString(7));
							txtInfo.setText(rs.getString(8));
	
							txtPtId.setEditable(false);
							
							
						}
						else {
							JOptionPane.showMessageDialog(null, "Patient Id Doesnt Exist");
	
						}
					
				}
				catch(Exception e1 ) {
					JOptionPane.showMessageDialog(null, "Connection Error!");

				}
			}
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBounds(478, 51, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		txtGender = new JTextField();
		txtGender.setBounds(295, 202, 272, 20);
		frame.getContentPane().add(txtGender);
		txtGender.setColumns(10);
		frame.setLocation(new Point(280, 170));
		frame.setBounds(280, 190, 810,530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
