package hospital.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Hospital_Mng {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField Jpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String [] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Hospital_Mng window = new Hospital_Mng();
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
	public Hospital_Mng() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);
		frame.setBounds(0, 0, 1366, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panel.setBounds(41, 74, 523, 379);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(SystemColor.desktop);
		lblNewLabel_2.setBounds(23, 162, 109, 33);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(SystemColor.desktop);
		lblNewLabel_3.setBounds(23, 222, 109, 33);
		panel.add(lblNewLabel_3);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUsername.setBounds(184, 162, 270, 36);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				  if (txtUsername.getText().equals("admin") && Jpassword.getText().equals("admin")){
				  
					  Home hm = new Home();
					  hm.homeScreen();
				  } 
				  else {
				  JOptionPane.showMessageDialog(null, "Incorrect Username and/or Password");
				  }
				 
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(255, 0, 0));
		btnLogin.setBounds(184, 309, 89, 23);
		panel.add(btnLogin);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText("");
				Jpassword.setText("");
			}
		});
		btnClear.setBackground(new Color(255, 0, 0));
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(283, 309, 89, 23);
		panel.add(btnClear);
		
		Jpassword = new JPasswordField();
		Jpassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Jpassword.setBounds(184, 222, 270, 38);
		panel.add(Jpassword);
		
		JLabel lblNewLabel = new JLabel("BetterPath EHR System");
		lblNewLabel.setBounds(10, 45, 503, 45);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(new Color(109, 146, 199));
		
		JButton btnNewButton = new JButton("CLOSE");
		btnNewButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(382, 309, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\b2she\\Desktop\\Hosp_Manag_Images\\pexels-gustavo-fring-4173239.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1366, 768);
		frame.getContentPane().add(lblNewLabel_1);
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
