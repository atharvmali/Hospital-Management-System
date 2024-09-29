package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PatientLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField un;
	
	
	Connection con;
	PreparedStatement ps;
	
	String username, password;
	private JPasswordField pw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientLogin frame = new PatientLogin();
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
	public PatientLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(53, 60, 244, 120);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(285, 60, 569, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome To Patient Login Panel");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 848, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("USERNAME:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(192, 211, 118, 25);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSWORD:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(192, 290, 118, 25);
		panel.add(lblNewLabel_4);
		
		un = new JTextField();
		un.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		un.setBounds(352, 202, 351, 44);
		panel.add(un);
		un.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				username = un.getText();
				password = pw.getText();
				
				try {
					con = SQLConnection.connectDb();
					String query = "select * from patientUPI where pusername = ? and ppassword = ? ";
					ps = con.prepareStatement(query);
					ps.setString(1, un.getText());
					ps.setString(2, pw.getText());
					
					ResultSet rs = ps.executeQuery();
					
					
					int count = 0;
					while(rs.next()) {
						count = count + 1;
					}
						
						if(count == 1) {
							JOptionPane.showMessageDialog(null, "Username and Password is Correct");
							PatientPanel obj = new PatientPanel();
							obj.setVisible(true);
							dispose();
						}
						
						else if(count > 1) {
							JOptionPane.showMessageDialog(null, "Username and Password is Duplicate");
						}
						
						else {
							JOptionPane.showMessageDialog(null, "Username and Password is Not Correct");
						}
						
						rs.close();
						ps.close();
						
					
				} catch(Exception e1) {
					
					JOptionPane.showMessageDialog(null, e1);

					
				}
				
			}
		});
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnLogin.setBounds(352, 369, 118, 44);
		panel.add(btnLogin);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/patient2.png"));
		lblNewLabel_5.setBounds(380, 25, 143, 165);
		panel.add(lblNewLabel_5);
		
		pw = new JPasswordField();
		pw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		pw.setBounds(352, 281, 351, 44);
		panel.add(pw);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectLogin obj = new SelectLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}
}
