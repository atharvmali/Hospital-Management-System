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

public class PatientProfile extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtDOB;
	private JTextField txtGender;
	private JTextField txtBG;
	private JTextField txtEmail;
	private JTextField txtMobile;
	private JTextField txtAddress;
	private JComboBox comboBoxName;

	Connection con;
	PreparedStatement ps, ps1, pst;
	ResultSet rs;
	
	String name, DOB, gender, bloodGroup, email, address;
	int id, mobile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientProfile frame = new PatientProfile();
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
			String query = "select * from patient";
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				comboBoxName.addItem(rs.getString("pname"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * Create the frame.
	 */
	public PatientProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(45, 33, 256, 124);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_1.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(287, 33, 597, 80);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PATIENT PROFILE");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 125, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 202, 888, 464);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(178, 108, 167, 30);
		panel.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtId.setBounds(357, 108, 340, 30);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DOB:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(178, 201, 167, 30);
		panel.add(lblNewLabel_4);
		
		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtDOB.setBounds(357, 201, 340, 30);
		panel.add(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(178, 243, 167, 30);
		panel.add(lblNewLabel_5);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtGender.setBounds(357, 243, 340, 30);
		panel.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(178, 285, 167, 30);
		panel.add(lblNewLabel_6);
		
		txtBG = new JTextField();
		txtBG.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtBG.setBounds(357, 285, 340, 30);
		panel.add(txtBG);
		txtBG.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(178, 327, 167, 30);
		panel.add(lblNewLabel_7);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtEmail.setBounds(357, 327, 340, 30);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(178, 369, 167, 30);
		panel.add(lblNewLabel_8);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtMobile.setBounds(357, 369, 340, 30);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(178, 411, 167, 30);
		panel.add(lblNewLabel_9);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAddress.setBounds(357, 411, 340, 30);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Name:");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(178, 155, 167, 29);
		panel.add(lblNewLabel_10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtName.setBounds(357, 150, 340, 39);
		panel.add(txtName);
		txtName.setColumns(10);
		
		comboBoxName = new JComboBox();
		comboBoxName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					con=SQLConnection.connectDb();
					String query = "select * from patient where pname = ?";
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, (String)comboBoxName.getSelectedItem());
					ResultSet rs = pst.executeQuery();
					
					while(rs.next()) {
						txtId.setText(rs.getString("pid"));
						txtName.setText(rs.getString("pname"));
						txtDOB.setText(rs.getString("pdob"));
						txtGender.setText(rs.getString("pgender"));
						txtBG.setText(rs.getString("pblood"));
						txtEmail.setText(rs.getString("pemail"));
						txtMobile.setText(rs.getString("pmobile"));
						txtAddress.setText(rs.getString("paddress"));
					}
					
					pst.close();
					
				} catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		comboBoxName.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		comboBoxName.setBounds(357, 48, 177, 27);
		panel.add(comboBoxName);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientPanel obj = new PatientPanel();
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
