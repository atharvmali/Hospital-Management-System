package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;

public class DoctorProfile extends JFrame {

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
	private JComboBox comboBoxName;
	
	Connection con;
	PreparedStatement ps, ps1, pst;
	ResultSet rs;
	
	String name, gender, spec, email;
	int id, age, exp, mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorProfile frame = new DoctorProfile();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public void fillComboBox() {
		
		try {
			
			con=SQLConnection.connectDb();
			String query = "select * from doctor";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBoxName.addItem(rs.getString("dname"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public DoctorProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(45, 30, 256, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(286, 30, 566, 85);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DOCTOR PROFILE");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(325, 116, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 180, 888, 486);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(174, 131, 185, 31);
		panel.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtName.setBounds(371, 133, 329, 31);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Age:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_4.setBounds(174, 185, 185, 31);
		panel.add(lblNewLabel_4);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAge.setBounds(371, 187, 329, 29);
		panel.add(txtAge);
		txtAge.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_5.setBounds(174, 233, 185, 31);
		panel.add(lblNewLabel_5);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtGender.setBounds(371, 236, 329, 29);
		panel.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Specialization:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(174, 283, 185, 31);
		panel.add(lblNewLabel_6);
		
		txtSpec = new JTextField();
		txtSpec.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtSpec.setBounds(371, 286, 329, 29);
		panel.add(txtSpec);
		txtSpec.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Experience:");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(174, 333, 185, 31);
		panel.add(lblNewLabel_7);
		
		txtExp = new JTextField();
		txtExp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtExp.setBounds(371, 333, 329, 35);
		panel.add(txtExp);
		txtExp.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_8.setBounds(174, 385, 185, 26);
		panel.add(lblNewLabel_8);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtMobile.setBounds(371, 380, 329, 31);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Email:");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_9.setBounds(174, 434, 185, 31);
		panel.add(lblNewLabel_9);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtEmail.setBounds(371, 436, 329, 31);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Id:");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_10.setBounds(174, 79, 185, 31);
		panel.add(lblNewLabel_10);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtId.setColumns(10);
		txtId.setBounds(371, 81, 329, 31);
		panel.add(txtId);
		
		comboBoxName = new JComboBox();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					con=SQLConnection.connectDb();
					String query = "select * from doctor where dname = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, (String)comboBoxName.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						txtId.setText(rs.getString("did"));
						txtName.setText(rs.getString("dname"));
						txtAge.setText(rs.getString("dage"));
						txtGender.setText(rs.getString("dgender"));
						txtSpec.setText(rs.getString("dspec"));
						txtExp.setText(rs.getString("dexp"));
						txtMobile.setText(rs.getString("dmobile"));
						txtEmail.setText(rs.getString("demail"));
					}
					
					pst.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		comboBoxName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxName.setBounds(323, 6, 235, 53);
		panel.add(comboBoxName);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorPanel obj = new DoctorPanel();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
		
		fillComboBox();
	}
}
