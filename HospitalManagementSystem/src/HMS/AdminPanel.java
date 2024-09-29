package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 700);
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
		lblNewLabel_1.setBounds(289, 56, 565, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome To Admin Panel");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 848, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/addDoctor.png"));
		lblNewLabel_3.setBounds(59, 165, 128, 128);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/updateDoctor.png"));
		lblNewLabel_4.setBounds(244, 165, 128, 128);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/deleteDoctor.png"));
		lblNewLabel_5.setBounds(452, 165, 128, 128);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/searchDoctor.png"));
		lblNewLabel_6.setBounds(656, 165, 128, 128);
		panel.add(lblNewLabel_6);
		
		JButton btnAD = new JButton("ADD DOCTOR");
		btnAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddDoctor obj = new AddDoctor();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnAD.setBounds(59, 69, 117, 41);
		panel.add(btnAD);
		
		JButton btnUD = new JButton("UPDATE DOCTOR");
		btnUD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UpdateDoctor obj = new UpdateDoctor();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnUD.setBounds(244, 69, 138, 41);
		panel.add(btnUD);
		
		JButton btnDD = new JButton("DELETE DOCTOR");
		btnDD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteDoctor obj = new DeleteDoctor();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDD.setBounds(452, 69, 138, 41);
		panel.add(btnDD);
		
		JButton btnSD = new JButton("SEARCH DOCTOR");
		btnSD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SearchDoctor obj = new SearchDoctor();
				obj.setVisible(true);
				dispose();
				
			}
		});
		btnSD.setBounds(656, 69, 138, 41);
		panel.add(btnSD);
		
		JButton btnAP = new JButton("ADD PATIENT");
		btnAP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUpdatePatient obj = new AddUpdatePatient();
				obj.setVisible(true);
				dispose();
			}
		});
		btnAP.setBounds(59, 355, 117, 41);
		panel.add(btnAP);
		
		JButton btnUP = new JButton("UPDATE PATIENT");
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddUpdatePatient obj = new AddUpdatePatient();
				obj.setVisible(true);
				dispose();
			}
		});
		btnUP.setBounds(244, 355, 138, 41);
		panel.add(btnUP);
		
		JButton btnDP = new JButton("DELETE PATIENT");
		btnDP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSearchPatient obj = new DeleteSearchPatient();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDP.setBounds(452, 355, 138, 41);
		panel.add(btnDP);
		
		JButton btnSP = new JButton("SEARCH PATIENT");
		btnSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteSearchPatient obj = new DeleteSearchPatient();
				obj.setVisible(true);
				dispose();
			}
		});
		btnSP.setBounds(656, 355, 138, 41);
		panel.add(btnSP);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin obj = new AdminLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}
}
