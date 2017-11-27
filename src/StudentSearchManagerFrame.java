import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
 
import net.proteanit.sql.DbUtils;
 
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
 
public class StudentSearchManagerFrame extends JFrame {
 
                private JPanel contentPane;
                private JTable table;
                private JScrollPane scrollPane;
                private static int stID;
 
                /**
                * Launch the application.
                */

                Connection connection = null;
                /**
                * Create the frame.
                */
                public StudentSearchManagerFrame() {
                               
                               
                                connection = sqliteConnections.dbConnector();
                                //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                setBounds(600, 600, 525, 300);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.LIGHT_GRAY);
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);

                                JButton btnLoadManagersData = new JButton("Load Managers Data");
                                btnLoadManagersData.setFont(new Font("Levenim MT", Font.BOLD, 13));
                                btnLoadManagersData.setForeground(Color.ORANGE);
                                btnLoadManagersData.setBackground(Color.BLUE);
                                btnLoadManagersData.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query = "select m.Manager_Name, m.Email, m.ContactNumber\n" +
                                                                                                                "from Managers as m, Students as s\n" +
                                                                                                                "where s.mID = m.mID and s.sID = ?";
                                                                                PreparedStatement pst= connection.prepareStatement(query);
                                                                                pst.setInt(1,stID);
                                                                                ResultSet rs = pst.executeQuery();
                                                                                table.setModel(DbUtils.resultSetToTableModel(rs));
                                                                               
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();
                                                                }
                                                }
                                });
                                btnLoadManagersData.setBounds(53, 24, 378, 29);
                                contentPane.add(btnLoadManagersData);
                               
                                scrollPane = new JScrollPane();
                                scrollPane.setBounds(6, 89, 482, 172);
                                contentPane.add(scrollPane);
                               
                                table = new JTable();
                                scrollPane.setViewportView(table);
                }
 
               
                public StudentSearchManagerFrame(int a) {
                                stID=a;
                               
                                connection = sqliteConnections.dbConnector();
                                //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                setBounds(600, 600, 525, 300);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.LIGHT_GRAY);
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);

                                JButton btnLoadManagersData = new JButton("Load Managers Data");
                                btnLoadManagersData.setFont(new Font("Levenim MT", Font.BOLD, 13));
                                btnLoadManagersData.setForeground(Color.ORANGE);
                                btnLoadManagersData.setBackground(Color.BLUE);
                                btnLoadManagersData.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query = "select m.Manager_Name, m.Email, m.ContactNumber\n" +
                                                                                                                "from Managers as m, Students as s\n" +
                                                                                                                "where s.mID = m.mID and s.sID = ?";
                                                                                PreparedStatement pst= connection.prepareStatement(query);
                                                                                pst.setInt(1,stID);
                                                                                ResultSet rs = pst.executeQuery();
                                                                                table.setModel(DbUtils.resultSetToTableModel(rs));
                                                                               
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();
                                                                }
                                                }
                                });
                                btnLoadManagersData.setBounds(16, 48, 378, 29);
                                contentPane.add(btnLoadManagersData);
                               
                                scrollPane = new JScrollPane();
                                scrollPane.setBounds(6, 89, 482, 172);
                                contentPane.add(scrollPane);
                               
                                table = new JTable();
                                scrollPane.setViewportView(table);
                }
 
}