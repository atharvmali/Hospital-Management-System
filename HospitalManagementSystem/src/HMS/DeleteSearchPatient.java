package HMS;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteSearchPatient extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
private JTable table;
	
	JComboBox <Integer>comboBox ;
	
	Connection con;
    Statement st;
    PreparedStatement ps, ps1;
    ResultSet rs;
    
    int id;
    
    
    
    public void RefreshPage() {
    	
    	try {
			con=SQLConnection.connectDb();
			st=con.createStatement();
			rs=st.executeQuery("select * from patient");
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
					DeleteSearchPatient frame = new DeleteSearchPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fillCombobox()
	{
	try {
	con=SQLConnection.connectDb();
	st=con.createStatement();
	rs=st.executeQuery("select * from patient");
	while(rs.next())
	{
	comboBox.addItem(rs.getInt("pid"));
	}
	}
	catch(Exception e1)
	{
	JOptionPane.showMessageDialog(null, e1);
	}
	}


	/**
	 * Create the frame.
	 */
	public DeleteSearchPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 700);
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
		lblNewLabel_1.setBounds(286, 56, 598, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE / UPDATE PATIENT");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 878, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 76, 830, 346);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Select Patient Id:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(34, 33, 172, 16);
		panel.add(lblNewLabel_3);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		comboBox.setBounds(218, 22, 134, 38);
		panel.add(comboBox);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {

					con=SQLConnection.connectDb();
					st=con.createStatement();
					id=(int) comboBox.getSelectedItem();
					ps=con.prepareStatement("select * from patient where pid=?");

					ps.setInt(1,id);
					rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));

					}
					catch(Exception e1)
					{
					JOptionPane.showMessageDialog(null, e1);
					}
				
			}
		});
		btnSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnSearch.setBounds(377, 29, 117, 27);
		panel.add(btnSearch);
		
		JButton btnLD = new JButton("Load Doctor Data");
		btnLD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con=SQLConnection.connectDb();
					st=con.createStatement();
					rs=st.executeQuery("select * from patient");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					}
				
			}
		});
		btnLD.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLD.setBounds(635, 31, 221, 27);
		panel.add(btnLD);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int action = JOptionPane.showConfirmDialog(null, "Do You Really Want To Delete?", "Delete", JOptionPane.YES_NO_OPTION);
				if(action == 0) {
				try {
					con=SQLConnection.connectDb();
					id=(int) comboBox.getSelectedItem();
					
					ps=con.prepareStatement("delete from patient WHERE pid=?;");
					ps1=con.prepareStatement("delete from patientUPI WHERE pid=?");

					ps.setInt(1,id);
					ps1.setInt(1, id);
					
					ps.executeUpdate();
					ps1.executeUpdate();
					
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
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnDelete.setBounds(506, 31, 117, 27);
		panel.add(btnDelete);
		
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
		
		
		fillCombobox();
		RefreshPage();
	}
}
