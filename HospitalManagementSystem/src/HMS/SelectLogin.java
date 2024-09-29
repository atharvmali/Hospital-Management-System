package HMS;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;

public class SelectLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectLogin frame = new SelectLogin();
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
	public SelectLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(55, 31, 256, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Login Panel");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(323, 111, 371, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/navbg.png"));
		lblNewLabel_2.setFont(new Font(".AppleSystemUIFont", Font.PLAIN, 45));
		lblNewLabel_2.setBounds(281, 31, 563, 68);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(171, 210, 255));
		panel.setBounds(6, 193, 838, 473);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Login As");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.BOLD, 25));
		lblNewLabel_3.setBounds(361, 29, 120, 36);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/admin1.png"));
		lblNewLabel_4.setBounds(24, 104, 262, 273);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/doc1.png"));
		lblNewLabel_5.setBounds(309, 104, 216, 273);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/patient.png"));
		lblNewLabel_6.setBounds(563, 104, 256, 273);
		panel.add(lblNewLabel_6);
		
		JButton btnAL = new JButton("ADMIN LOGIN");
		btnAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AdminLogin obj = new AdminLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnAL.setBounds(72, 407, 117, 42);
		panel.add(btnAL);
		
		JButton btnDL = new JButton("DOCTOR LOGIN");
		btnDL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorLogin obj = new DoctorLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDL.setBounds(344, 407, 133, 42);
		panel.add(btnDL);
		
		JButton btnPL = new JButton("PATIENT LOGIN");
		btnPL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PatientLogin obj = new PatientLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnPL.setBounds(635, 407, 133, 42);
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
