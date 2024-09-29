package HMS;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLConnection {
	
	static Connection con;

	public static Connection connectDb() throws IOException, SQLException, ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/HMS", "root", "mysqlroot");
//			JOptionPane.showMessageDialog(null, "Connection Successful");

		} catch(SQLDataException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		
		return con;
	}

}
