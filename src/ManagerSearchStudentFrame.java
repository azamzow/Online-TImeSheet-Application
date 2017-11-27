import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.border.EmptyBorder;
 
import net.proteanit.sql.DbUtils;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
 
public class ManagerSearchStudentFrame extends JFrame {
 
                private JPanel contentPane;
                private JTable table;
                private static int mID;
 
                /**
                * Launch the application.
                */

                Connection connection = null;
                private JTextField txtManID;
 
                /**
                * Create the frame.
                */
                public ManagerSearchStudentFrame() {
                               
                                connection = sqliteConnections.dbConnector();
//                                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                setBounds(850, 850, 650, 550);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.LIGHT_GRAY);
                                contentPane.setForeground(UIManager.getColor("TextArea.selectionBackground"));
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                               
                                JButton buttonSearch = new JButton("Load Students Data");
                                buttonSearch.setForeground(Color.BLUE);
                                buttonSearch.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                buttonSearch.setBackground(Color.ORANGE);
                                buttonSearch.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query = "select s.sID, s.Name, s.Email, s.PhoneNumber, t.date, t.clock_in, t.clock_out\n" +
                                                                                                                "from Students as s, TimeStamp as t\n" +
                                                                                                                "where s.sID = t.sID and s.mID = ?";
                                                                                PreparedStatement pst= connection.prepareStatement(query);
                                                                                pst.setInt(1,mID);
                                                                                ResultSet rs = pst.executeQuery();
                                                                                table.setModel(DbUtils.resultSetToTableModel(rs));
                                                                               
                                                                               
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();
                                                                }
                                                }
                                });
                                buttonSearch.setBounds(138, 36, 362, 29);
                                contentPane.add(buttonSearch);
                               
                                JScrollPane scrollPane = new JScrollPane();
                                scrollPane.setBounds(6, 92, 638, 380);
                                contentPane.add(scrollPane);
                               
                                table = new JTable();
                                scrollPane.setViewportView(table);
                               
                }
                public ManagerSearchStudentFrame(int a) {
                	mID=a;
                    
                    connection = sqliteConnections.dbConnector();
//                    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    setBounds(850, 850, 650, 550);
                    contentPane = new JPanel();
                    contentPane.setBackground(Color.LIGHT_GRAY);
                    contentPane.setForeground(UIManager.getColor("TextArea.selectionBackground"));
                    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                    setContentPane(contentPane);
                    contentPane.setLayout(null);
                   
                    JButton buttonSearch = new JButton("Load Students Data");
                    buttonSearch.setForeground(Color.BLUE);
                    buttonSearch.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                    buttonSearch.setBackground(Color.ORANGE);
                    buttonSearch.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                                    try {
                                                                    String query = "select s.sID, s.Name, s.Email, s.PhoneNumber, t.date, t.clock_in, t.clock_out\n" +
                                                                                                    "from Students as s, TimeStamp as t\n" +
                                                                                                    "where s.sID = t.sID and s.mID = ?";
                                                                    PreparedStatement pst= connection.prepareStatement(query);
                                                                    pst.setInt(1,mID);
                                                                    ResultSet rs = pst.executeQuery();
                                                                    table.setModel(DbUtils.resultSetToTableModel(rs));
                                                                   
                                                                   
                                                    }catch(Exception ex) {
                                                                    ex.printStackTrace();
                                                    }
                                    }
                    });
                    buttonSearch.setBounds(138, 36, 362, 29);
                    contentPane.add(buttonSearch);
                   
                    JScrollPane scrollPane = new JScrollPane();
                    scrollPane.setBounds(6, 92, 638, 380);
                    contentPane.add(scrollPane);
                   
                    table = new JTable();
                    scrollPane.setViewportView(table);
                   
    }
}