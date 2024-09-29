package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class RegistrationPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPage frame = new RegistrationPage();
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
	public RegistrationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(55, 31, 256, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Registration Page");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(323, 111, 478, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_2.setBounds(280, 31, 614, 68);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(171, 210, 255));
		panel.setBounds(6, 193, 888, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Register As");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel_3.setBounds(361, 29, 164, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/doc1.png"));
		lblNewLabel_5.setBounds(100, 104, 216, 273);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/patient.png"));
		lblNewLabel_6.setBounds(563, 104, 256, 273);
		panel.add(lblNewLabel_6);
		
		JButton btnDL = new JButton("DOCTOR ");
		btnDL.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnDL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorRegistration obj = new DoctorRegistration();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDL.setBounds(100, 407, 216, 44);
		panel.add(btnDL);
		
		JButton btnPL = new JButton("PATIENT");
		btnPL.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnPL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientRegistration obj = new PatientRegistration();
				obj.setVisible(true);
				dispose();
			}
		});
		btnPL.setBounds(563, 407, 256, 44);
		panel.add(btnPL);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}

}
