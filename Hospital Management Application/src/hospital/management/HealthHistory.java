package hospital.management;
import ProjectPackage.ConnectionClass;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;


public class HealthHistory  {

	private JFrame frame;
	private JTextField txtHisPtId;
	private JTextField txtSymptoms;
	private JTextField txtDiag;
	private JTextField txtMed;
	private JLabel lblTiming;
	private JComboBox comboBoxTiming;
	private JLabel lblNewLabel_1;
	public int flag = 0;
	private Connection con = null;
	private Statement st = null;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void healthhis() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthHistory window = new HealthHistory();
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
	public HealthHistory () {
		initialize();
		



	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setLocation(new Point(280, 170));
		frame.getContentPane().setLocation(new Point(280, 170));
		frame.setBounds(280, 190, 810,530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnClose = new JButton("Close");
		btnClose.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home hm = new Home();
				 hm.homeScreen();
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnClose.setForeground(Color.WHITE);
		btnClose.setBackground(Color.RED);
		btnClose.setBounds(665, 473, 89, 23);
		frame.getContentPane().add(btnClose);
		
		JLabel lblNewLabel = new JLabel("Patient Id");
		lblNewLabel.setBounds(216, 68, 89, 14);
		frame.getContentPane().add(lblNewLabel);
		
		txtHisPtId = new JTextField();
		txtHisPtId.setBounds(331, 65, 131, 20);
		frame.getContentPane().add(txtHisPtId);
		txtHisPtId.setColumns(10);
		

		JLabel lblNewLabel_1 = new JLabel("Patient Doesn't Exist!");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(259, 108, 266, 23);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pd = txtHisPtId.getText();
				try {
					Connection con = ConnectionClass.getCon();
					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					ResultSet rs = st.executeQuery("select * from patient where patientId = '" + pd + "'" );
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					if(!rs.first()) {
						lblNewLabel_1.setVisible(true);

						
					}
					else {
						lblNewLabel_1.setVisible(false);
						txtHisPtId.setEditable(false);
						flag = 1;
					}
				}
				catch(Exception a) {

					JOptionPane.showMessageDialog(null, "Connection Error");
					
				}
			}
		});
		btnSearch.setBounds(529, 64, 89, 23);
		frame.getContentPane().add(btnSearch);
		

		
		JLabel lblNewLabel_2 = new JLabel("Symptoms");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(71, 248, 80, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Diagnosis");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(71, 286, 80, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Medication");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(71, 323, 80, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		txtSymptoms = new JTextField();
		txtSymptoms.setBounds(188, 246, 183, 20);
		frame.getContentPane().add(txtSymptoms);
		txtSymptoms.setColumns(10);
		
		txtDiag = new JTextField();
		txtDiag.setBounds(188, 284, 183, 20);
		frame.getContentPane().add(txtDiag);
		txtDiag.setColumns(10);
		
		txtMed = new JTextField();
		txtMed.setBounds(188, 321, 183, 20);
		frame.getContentPane().add(txtMed);
		txtMed.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Med. Refill?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(397, 252, 89, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblTiming = new JLabel("Timing");
		lblTiming.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTiming.setBounds(397, 287, 89, 14);
		frame.getContentPane().add(lblTiming);
		lblTiming.setVisible(false);

		JComboBox comboBoxTiming = new JComboBox();
		comboBoxTiming.setModel(new DefaultComboBoxModel(new String[] {"Urgent", "Scheduled"}));
		comboBoxTiming.setBounds(529, 283, 89, 22);
		frame.getContentPane().add(comboBoxTiming);
		comboBoxTiming.setVisible(false);

		
		JCheckBox chckbxRefill = new JCheckBox("YES");
		chckbxRefill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbxRefill.isSelected()) {
					lblTiming.setVisible(true);
					comboBoxTiming.setVisible(true);
				}
				else {
					lblTiming.setVisible(false);
					comboBoxTiming.setVisible(false);
				}
			}
		});
		chckbxRefill.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxRefill.setBounds(521, 248, 97, 23);
		frame.getContentPane().add(chckbxRefill);
		
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag == 1) {
					
					String patientId = txtHisPtId.getText();
					String symptoms = txtSymptoms.getText();
					String diagnosis = txtDiag.getText();
					String medication = txtMed.getText();
					String timing;
					String refill;
					
					if(chckbxRefill.isSelected()) {
						
						refill = "YES";
						timing = (String)comboBoxTiming.getSelectedItem();
					}
					else {
						refill = "NO";
						timing = "";
					}
						
					try {
						Connection con = ConnectionClass.getCon();
						Statement st = con.createStatement();
						st.executeUpdate("insert into patientreport(patientId, symptoms, diagnosis, medicine, refill, timing) values('" + patientId + "','" + symptoms + "','" + diagnosis + "','" + medication + "','" + refill + "','" + timing + "')" );
						JOptionPane.showMessageDialog(null, "Update Successful");
						
					}
					catch(Exception b) {
						JOptionPane.showInputDialog(this, b);
					}
				
				}
				else {
					JOptionPane.showMessageDialog(null, "Patient field is empty");;
				}
			}
		
				
			
		});
		btnSave.setForeground(Color.WHITE);
		btnSave.setBackground(Color.RED);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSave.setBounds(295, 473, 89, 23);
		frame.getContentPane().add(btnSave);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 142, 708, 58);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Patient Id", "First Name", "Last Name", "Gender", "DOB", "Phone", "Address", "Info"
			}
		));
        table.setFillsViewportHeight(true);
		

	}


	
}
