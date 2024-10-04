package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class DoctorRegistration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtGender;
	private JTextField txtSpec;
	private JTextField txtExp;
	private JTextField txtMobile;
	private JTextField txtEmail;
	private JTextField un;
	private JPasswordField pw;
	
	Connection con;
	PreparedStatement ps, ps1;
	
	String name, gender, spec, email, username, password;
	int id, age, exp, mobile, id2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorRegistration frame = new DoctorRegistration();
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
	public DoctorRegistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(45, 56, 256, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(284, 56, 610, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("REGISTER AS DOCTOR");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 888, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(33, 60, 90, 31);
		panel.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtName.setBounds(216, 62, 225, 31);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(33, 111, 90, 31);
		panel.add(lblNewLabel_4);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAge.setBounds(216, 114, 225, 29);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(33, 161, 103, 31);
		panel.add(lblNewLabel_5);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtGender.setBounds(216, 155, 225, 38);
		panel.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Specialization:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(33, 204, 185, 31);
		panel.add(lblNewLabel_6);
		
		txtSpec = new JTextField();
		txtSpec.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtSpec.setBounds(216, 205, 225, 29);
		panel.add(txtSpec);
		txtSpec.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Experience:");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(33, 248, 185, 31);
		panel.add(lblNewLabel_7);
		
		txtExp = new JTextField();
		txtExp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtExp.setBounds(216, 248, 225, 35);
		panel.add(txtExp);
		txtExp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(33, 302, 185, 26);
		panel.add(lblNewLabel_8);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtMobile.setBounds(216, 302, 225, 31);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Email:");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(33, 347, 185, 31);
		panel.add(lblNewLabel_9);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtEmail.setBounds(216, 349, 225, 31);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnNewButton = new JButton("REGISTER DOCTOR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id = Integer.parseInt(txtId.getText());
				name = txtName.getText();
				age = Integer.parseInt(txtAge.getText());
				gender = txtGender.getText();
				spec = txtSpec.getText();
				exp = Integer.parseInt(txtExp.getText());
				mobile = Integer.parseInt(txtMobile.getText());
				email = txtEmail.getText();
				
				id2 = Integer.parseInt(txtId.getText());
				username = un.getText();
				password = pw.getText();
								
				try {
					con = SQLConnection.connectDb();
					
					ps = con.prepareStatement("insert into doctor values(?,?,?,?,?,?,?,?)");
					ps1 = con.prepareStatement("insert into doctorUPI values(?, ?, ?)");
					
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setInt(3, age);
					ps.setString(4, gender);
					ps.setString(5, spec);
					ps.setInt(6, exp);
					ps.setInt(7, mobile);
					ps.setString(8, email);
					
					ps1.setInt(1, id2);
					ps1.setString(2, username);
					ps1.setString(3, password);
					
					ps.executeUpdate();
					ps1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Registraion Complete");
					
					dispose();
					DoctorLogin obj = new DoctorLogin();
					obj.setVisible(true);
					
					
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		btnNewButton.setBounds(331, 395, 272, 44);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_10 = new JLabel("Id:");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(33, 17, 90, 31);
		panel.add(lblNewLabel_10);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtId.setColumns(10);
		txtId.setBounds(216, 19, 225, 31);
		panel.add(txtId);
		
		JLabel lblNewLabel_11 = new JLabel("User name:");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_11.setBounds(484, 17, 137, 31);
		panel.add(lblNewLabel_11);
		
		un = new JTextField();
		un.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		un.setColumns(10);
		un.setBounds(633, 19, 225, 31);
		panel.add(un);
		
		JLabel lblNewLabel_12 = new JLabel("Password:");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_12.setBounds(484, 60, 137, 31);
		panel.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/doc1.png"));
		lblNewLabel_13.setBounds(568, 126, 225, 267);
		panel.add(lblNewLabel_13);
		
		pw = new JPasswordField();
		pw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		pw.setBounds(633, 60, 225, 31);
		panel.add(pw);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationPage obj = new RegistrationPage();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}
}
