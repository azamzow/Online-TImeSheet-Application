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
 
public class StudentSearchDepartmentFrame extends JFrame {
 
                private JPanel contentPane;
 
                /**
                * Launch the application.
                */
                public static void main(String[] args) {
                                EventQueue.invokeLater(new Runnable() {
                                                public void run() {
                                                                try {
                                                                                StudentSearchDepartmentFrame frame = new StudentSearchDepartmentFrame();
                                                                                frame.setVisible(true);
                                                                } catch (Exception e) {
                                                                                e.printStackTrace();
                                                                }
                                                }
                                });
                }
                Connection connection = null;
                private JTable table;
                /**
                * Create the frame.
                */
                public StudentSearchDepartmentFrame() {
                               
                                connection = sqliteConnections.dbConnector();
                                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                setBounds(700, 700, 500, 400);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.LIGHT_GRAY);
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                               
                                /*JButton button = new JButton("Back");
                                button.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane.setVisible(false);
                                                                dispose(); //this will DISPOSE OFF Current Window
                                                                SearchProfileStudent searchPM = new SearchProfileStudent();
                                                                searchPM.setVisible(true);
                                                }
                                });
                                button.setBounds(291, 6, 103, 29);
                                contentPane.add(button);*/
                               
                                JButton btnLoadAllDepartments = new JButton("Load All Departments ");
                                btnLoadAllDepartments.setFont(new Font("Levenim MT", Font.BOLD, 13));
                                btnLoadAllDepartments.setForeground(Color.ORANGE);
                                btnLoadAllDepartments.setBackground(Color.BLUE);
                                btnLoadAllDepartments.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query = "select *\n" +
                                                                                                                "from Departments";
                                                                                PreparedStatement pst= connection.prepareStatement(query);
                                                                                ResultSet rs = pst.executeQuery();
                                                                                table.setModel(DbUtils.resultSetToTableModel(rs));
                                                                               
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();
                                                                }
                                                }
                                });
                                btnLoadAllDepartments.setBounds(6, 40, 378, 29);
                                contentPane.add(btnLoadAllDepartments);
                               
                                JScrollPane scrollPane = new JScrollPane();
                                scrollPane.setBounds(6, 70, 468, 291);
                                contentPane.add(scrollPane);
                               
                                table = new JTable();
                                scrollPane.setViewportView(table);
                }
 
}