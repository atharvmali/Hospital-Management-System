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

public class SearchDoctor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	
	JComboBox <Integer>comboBox ;
	
	Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    
    int id;
    
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
					SearchDoctor frame = new SearchDoctor();
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
	rs=st.executeQuery("select * from doctor");
	while(rs.next())
	{
	comboBox.addItem(rs.getInt("did"));
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
	public SearchDoctor() {
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
		lblNewLabel_1.setBounds(286, 56, 568, 71);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SEARCH DOCTOR");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(330, 139, 505, 41);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(166, 215, 255));
		panel.setBounds(6, 221, 848, 445);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 76, 792, 346);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_3 = new JLabel("Select Doctor Id:");
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
					ps=con.prepareStatement("select * from doctor where did=?");

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
					rs=st.executeQuery("select * from doctor");
					table.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
					}
				
			}
		});
		btnLD.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnLD.setBounds(530, 29, 280, 27);
		panel.add(btnLD);
		
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
