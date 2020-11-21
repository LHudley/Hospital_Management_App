package hospital.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Point;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ProjectPackage.ConnectionClass;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class PtHistory {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void patientHist() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PtHistory window = new PtHistory();
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
	public PtHistory() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		
		frame.setSize(new Dimension(280, 170));
		frame.getContentPane().setLocation(new Point(280, 170));
		frame.setUndecorated(true);
		frame.setBounds(280, 190, 810,530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 53, 708, 289);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Table1", "Table2", "Table3", "Table4"
			}
		));
        table.setFillsViewportHeight(true);
        
        JButton btnClose = new JButton("CLOSE");
        btnClose.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Home hm = new Home();
				 hm.homeScreen();
        	}
        });
        btnClose.setForeground(Color.WHITE);
        btnClose.setBackground(Color.RED);
        btnClose.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnClose.setBounds(665, 433, 89, 23);
        frame.getContentPane().add(btnClose);
        
        JButton btnNewButton = new JButton("INFO");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        				try {
        					Connection con = ConnectionClass.getCon();
        					Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        					ResultSet rs = st.executeQuery("select distinct patient.*, patientreport.symptoms, patientreport.diagnosis, patientreport.medicine, patientreport.refill, patientreport.timing from patient inner join patientreport where patient.patientId = patientreport.patientId" );
        					table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
        					table.setModel(DbUtils.resultSetToTableModel(rs));

        				}
        				catch(Exception e1) {
        					JOptionPane.showMessageDialog(null, "Connection Error");
        				}
        			
        	}
        });
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnNewButton.setBounds(46, 395, 89, 23);
        frame.getContentPane().add(btnNewButton);

	}
}
