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

public class DoctorPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPanel frame = new DoctorPanel();
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
	public DoctorPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/icon1.png"));
		lblNewLabel.setBounds(55, 31, 256, 117);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Doctor Panel");
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
		panel.setBounds(6, 193, 888, 443);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/dprofile.png"));
		lblNewLabel_4.setBounds(156, 48, 262, 273);
		panel.add(lblNewLabel_4);
		
		JButton btnAL = new JButton("DOCTOR PROFILE");
		btnAL.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnAL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				DoctorProfile obj = new DoctorProfile();
				obj.setVisible(true);
				dispose();
			
			}
		});
		btnAL.setBounds(211, 350, 153, 47);
		panel.add(btnAL);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/appointment.png"));
		lblNewLabel_3.setBounds(561, 103, 164, 177);
		panel.add(lblNewLabel_3);
		
		JButton btnApp = new JButton("APPOINTMENTS");
		btnApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DoctorAppointment obj = new DoctorAppointment();
				obj.setVisible(true);
			}
		});
		btnApp.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		btnApp.setBounds(545, 350, 153, 47);
		panel.add(btnApp);
		
		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorLogin obj = new DoctorLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("/Users/atharv/eclipse-workspace/HospitalManagementSystem/images/back.png"));
		btnBack.setBounds(6, 0, 32, 29);
		contentPane.add(btnBack);
	}
}
