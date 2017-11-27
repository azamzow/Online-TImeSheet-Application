import java.sql.*;
import javax.swing.*;
public class sqliteConnections {
	Connection conn=null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:/Users/averyzamzow/Desktop/Desktop/ClassWork/Fall2017/DataBase/Project.db");
			JOptionPane.showMessageDialog(null, "Connection Succsessull");
			return conn;
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
