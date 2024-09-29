package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AddUpdatePatient extends JFrame {

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
	private JTextField un;
	private JPasswordField pw;
	
	Connection con;
	PreparedStatement ps, ps1;
	
	String name, DOB, gender, bloodGroup, email, address, username, password;
	int id, mobile, id2;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUpdatePatient frame = new AddUpdatePatient();
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
	public AddUpdatePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 715);
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
		lblNewLabel_1.setBounds(287, 56, 597, 80);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("ADD / UPDATE PATIENT");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 878, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(35, 31, 107, 30);
		panel.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtId.setBounds(178, 31, 263, 30);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("DOB:");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(35, 124, 120, 30);
		panel.add(lblNewLabel_4);
		
		txtDOB = new JTextField();
		txtDOB.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtDOB.setBounds(178, 124, 263, 30);
		panel.add(txtDOB);
		txtDOB.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Gender:");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(35, 166, 120, 30);
		panel.add(lblNewLabel_5);
		
		txtGender = new JTextField();
		txtGender.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtGender.setBounds(178, 166, 263, 30);
		panel.add(txtGender);
		txtGender.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Blood Group:");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(35, 217, 134, 30);
		panel.add(lblNewLabel_6);
		
		txtBG = new JTextField();
		txtBG.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtBG.setBounds(178, 217, 263, 30);
		panel.add(txtBG);
		txtBG.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(35, 269, 120, 30);
		panel.add(lblNewLabel_7);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtEmail.setBounds(178, 269, 263, 30);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Mobile No:");
		lblNewLabel_8.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(35, 316, 120, 30);
		panel.add(lblNewLabel_8);
		
		txtMobile = new JTextField();
		txtMobile.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtMobile.setBounds(178, 316, 263, 30);
		panel.add(txtMobile);
		txtMobile.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Address:");
		lblNewLabel_9.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(35, 358, 120, 30);
		panel.add(lblNewLabel_9);
		
		txtAddress = new JTextField();
		txtAddress.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtAddress.setBounds(178, 358, 263, 30);
		panel.add(txtAddress);
		txtAddress.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD PATIENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				id = Integer.parseInt(txtId.getText());
				name = txtName.getText();
				DOB = txtDOB.getText();
				gender = txtGender.getText();
				bloodGroup = txtBG.getText();
				email = txtEmail.getText();
				mobile = Integer.parseInt(txtMobile.getText());
				address = txtAddress.getText();
				
				id2 = Integer.parseInt(txtId.getText());
				username = un.getText();
				password = pw.getText();
								
				try {
					con = SQLConnection.connectDb();
					
					ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?)");
					ps1 = con.prepareStatement("insert into patientUPI values(?, ?, ?)");
					
					ps.setInt(1, id);
					ps.setString(2, name);
					ps.setString(3, DOB);
					ps.setString(4, gender);
					ps.setString(5, bloodGroup);
					ps.setString(6, email);
					ps.setInt(7, mobile);
					ps.setString(8, address);
					
					ps1.setInt(1, id2);
					ps1.setString(2, username);
					ps1.setString(3, password);
					
					ps.executeUpdate();
					ps1.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Values Inserted");
					
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(222, 412, 167, 43);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE PATIENT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con=SQLConnection.connectDb();
					if(txtId.getText().equals("")) 
					{
					JOptionPane.showMessageDialog(null, "Enter Patient ID");
					}
					
					id = Integer.parseInt(txtId.getText());
					name = txtName.getText();
					DOB = txtDOB.getText();
					gender = txtGender.getText();
					bloodGroup = txtBG.getText();
					email = txtEmail.getText();
					mobile = Integer.parseInt(txtMobile.getText());
					address = txtAddress.getText();
					
					id2 = Integer.parseInt(txtId.getText());
					username = un.getText();
					password = pw.getText();
					
					ps1=con.prepareStatement("UPDATE patient SET pname=? , pdob=? , pgender=? , pblood=?, pemail=?, pmobile=?, paddress=? WHERE pid=?;");
					ps = con.prepareStatement("UPDATE patientUPI SET pusername=?, ppassword=? WHERE pid=?");
					
					ps1.setString(1,name);
					ps1.setString(2, DOB);
					ps1.setString(3, gender);
					ps1.setString(4, bloodGroup);
					ps1.setString(5, email);
					ps1.setInt(6, mobile);
					ps1.setString(7, address);
					ps1.setInt(8, id);
					
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setInt(3, id2);
					
					ps1.executeUpdate();
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Updated");

					} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					}
				
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setBounds(457, 412, 204, 43);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_10 = new JLabel("Name:");
		lblNewLabel_10.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_10.setBounds(35, 83, 107, 29);
		panel.add(lblNewLabel_10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtName.setBounds(178, 73, 263, 39);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("User name:");
		lblNewLabel_11.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(462, 31, 114, 30);
		panel.add(lblNewLabel_11);
		
		un = new JTextField();
		un.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		un.setColumns(10);
		un.setBounds(588, 31, 263, 30);
		panel.add(un);
		
		JLabel lblNewLabel_12 = new JLabel("Password:");
		lblNewLabel_12.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(462, 83, 114, 30);
		panel.add(lblNewLabel_12);
		
		pw = new JPasswordField();
		pw.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		pw.setBounds(588, 83, 263, 29);
		panel.add(pw);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/patient.png"));
		lblNewLabel_13.setBounds(537, 134, 263, 246);
		panel.add(lblNewLabel_13);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel obj = new AdminPanel();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}
}
