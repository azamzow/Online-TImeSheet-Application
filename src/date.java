//package DBImages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.toedter.calendar.JDateChooser;

//import Connect.DBConnection;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class date extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
//	private Connection connection;
	private PreparedStatement stmt;
	private ResultSet rs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					date window = new date();
				    window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection = null;

	/**
	 * Create the frame.
	 */
	public date() {
		initialize();
		connection = sqliteConnections.dbConnector();
	}
		
		/**
		  * Initialize the contents of the frame.
		  */
	public void query(String query) {
		Connection connection = null;
		Statement st = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/Users/averyzamzow/Desktop/Desktop/ClassWork/Fall2017/DataBase/Project.db");
			st = connection.createStatement();
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Query Executed");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
	private void initialize() {
		  frame = new JFrame();
		  frame.setBounds(100, 100, 376, 194);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.getContentPane().setLayout(null);

		  JDateChooser dateChooser = new JDateChooser();
		  dateChooser.setDateFormatString("dd/MM/yyyy");
		  dateChooser.setBounds(48, 28, 145, 23);
		  frame.getContentPane().add(dateChooser);

		  JLabel lblDate = new JLabel("");
		  lblDate.setBounds(48, 82, 145, 19);
		  frame.getContentPane().add(lblDate);

		  JButton btnAdd = new JButton("Add");
		  btnAdd.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {

		    Date date = dateChooser.getDate();
		    String dateInput = new SimpleDateFormat("yyyy-MM-dd").format(date);

//		    lblDate.setText(dateInput);
		    
		    String sql = "INSERT INTO `Students`.`date` (`date`) VALUES  (?)";
		    try {
		     stmt = connection.prepareStatement(sql);
		     stmt.setString(1, dateInput);
		     stmt.executeUpdate();
		    } catch (Exception e) {
		    		JOptionPane.showMessageDialog(null, e.getMessage());
		    }

		   }
		  });
		  btnAdd.setBounds(203, 28, 89, 23);
		  frame.getContentPane().add(btnAdd);

		  JButton btnShow = new JButton("Show");
		  btnShow.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent arg0) {
		    String sql = "SELECT * FROM Students.date";
		    try {
		     stmt = connection.prepareStatement(sql);
		     rs = stmt.executeQuery();
		     while(rs.next()){
		      String date = new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("date"));
		      lblDate.setText(date);
		     }
		     
		    } catch (Exception e) {
		     // TODO: handle exception
		    }
		   }
		  });
		  btnShow.setBounds(203, 78, 89, 23);
		  frame.getContentPane().add(btnShow);

		 }

}
