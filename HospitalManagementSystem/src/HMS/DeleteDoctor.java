package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class DeleteDoctor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	
	Connection con;
	PreparedStatement ps, ps1;
    Statement st;
    ResultSet rs;

	int id;
	private JTable table;
	
	
	 public void RefreshPage() {
	    	
	    	try {
				con=SQLConnection.connectDb();
				st=con.createStatement();
				rs=st.executeQuery("select * from doctor");
				table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1);
				}
	    	
	    }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDoctor frame = new DeleteDoctor();
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
	public DeleteDoctor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 700);
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
		lblNewLabel_1.setBounds(290, 56, 564, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE DOCTOR");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 889, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Id:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(213, 37, 42, 31);
		panel.add(lblNewLabel_3);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		txtId.setColumns(10);
		txtId.setBounds(284, 39, 162, 31);
		panel.add(txtId);
		
		JButton btnNewButton = new JButton("DELETE DOCTOR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete?", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
				try {
					con=SQLConnection.connectDb();
					if(txtId.getText().equals(""))
					{
					JOptionPane.showMessageDialog(null, "Enter Doctor Id");

					}
					id=Integer.parseInt(txtId.getText());
					ps1=con.prepareStatement("delete from doctor WHERE did=?;");
					ps=con.prepareStatement("delete from doctorUPI WHERE did=?");

					ps1.setInt(1,id);
					ps.setInt(1, id);
					
					ps1.executeUpdate();
					ps.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Data Deleted");
					}
				
				catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				RefreshPage();
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(497, 36, 208, 39);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 91, 877, 348);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
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
		
		RefreshPage();
	}
}
