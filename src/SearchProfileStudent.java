import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Color;
 
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class SearchProfileStudent extends JFrame {
 
                private JPanel contentPane;
                private static int stID;
 
                /**
                * Launch the application.
                */
                /*public static void main(String[] args) {
                                EventQueue.invokeLater(new Runnable() {
                                                public void run() {
                                                                try {
                                                                                SearchProfileStudent frame = new SearchProfileStudent();
                                                                                frame.setVisible(true);
                                                                } catch (Exception e) {
                                                                                e.printStackTrace();
                                                                }
                                                }
                                });
                }*/
 
                /**
                * Create the frame.
                */
                public SearchProfileStudent(int a) {
                                stID=a;
                                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                setBounds(500, 500, 700, 600);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.GRAY);
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                               
                                JLabel label = new JLabel("Welcome to WorkingKats!");
                                label.setForeground(Color.ORANGE);
                                label.setFont(new Font("Dialog", Font.BOLD, 32));
                                label.setBounds(6, 30, 520, 137);
                                contentPane.add(label);
                               
                                JLabel label_1 = new JLabel("Choose an option!");
                                label_1.setForeground(Color.LIGHT_GRAY);
                                label_1.setFont(new Font("Gabriola", Font.BOLD, 35));
                                label_1.setBounds(74, 136, 394, 110);
                                contentPane.add(label_1);
                               
                                JSeparator separator = new JSeparator();
                                separator.setBounds(16, 243, 643, 16);
                                contentPane.add(separator);
                               
                                JLabel label_2 = new JLabel("Search for Managers");
                                label_2.setForeground(Color.LIGHT_GRAY);
                                label_2.setFont(new Font("Dialog", Font.PLAIN, 24));
                                label_2.setBounds(26, 256, 265, 72);
                                contentPane.add(label_2);
                               
                                JButton button = new JButton("Search");
                                button.setBackground(Color.ORANGE);
                                button.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button.setForeground(Color.BLUE);
                                button.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                //contentPane.setVisible(false);
                                                                //dispose(); //this will DISPOSE OFF Current Window
                                                                StudentSearchManagerFrame ssmf = new StudentSearchManagerFrame(stID);
                                                                ssmf.setVisible(true);
                                                }
                                });
                                button.setBounds(74, 339, 117, 29);
                                contentPane.add(button);
                               
                                JSeparator separator_1 = new JSeparator();
                                separator_1.setBounds(151, 421, 367, 21);
                                contentPane.add(separator_1);
                               
                                JLabel label_3 = new JLabel("Go to Profile");
                                label_3.setForeground(Color.LIGHT_GRAY);
                                label_3.setFont(new Font("Dialog", Font.PLAIN, 28));
                                label_3.setBounds(245, 457, 237, 29);
                                contentPane.add(label_3);
                               
                               
                               
                                JButton button_1 = new JButton("Profile");
                                button_1.setBackground(Color.ORANGE);
                                button_1.setForeground(Color.BLUE);
                                button_1.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button_1.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane.setVisible(false);
                                                                dispose(); //this will DISPOSE OFF Current Window
                                                                StudentProfile sp = new StudentProfile(stID);
                                                                sp.setVisible(true);
                                                }
                                });
                                button_1.setBounds(263, 511, 117, 29);
                                contentPane.add(button_1);
                               
                                JLabel label_4 = new JLabel("Search for Departments ");
                                label_4.setForeground(Color.LIGHT_GRAY);
                                label_4.setFont(new Font("Dialog", Font.PLAIN, 24));
                                label_4.setBounds(394, 262, 300, 60);
                                contentPane.add(label_4);
                               
                                JButton button_2 = new JButton("Search");
                                button_2.setBackground(Color.ORANGE);
                                button_2.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button_2.setForeground(Color.BLUE);
                                button_2.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                //contentPane.setVisible(false);
                                                                //dispose(); //this will DISPOSE OFF Current Window
                                                                StudentSearchDepartmentFrame ssmf = new StudentSearchDepartmentFrame();
                                                                ssmf.setVisible(true);
                                                }
                                });
                                button_2.setBounds(469, 339, 117, 29);
                                contentPane.add(button_2);
                               
                                JLabel label_5 = new JLabel("");
                                Image img = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
                                label_5.setIcon(new ImageIcon(img));
                                label_5.setBounds(418, 9, 256, 250);
                                contentPane.add(label_5);
                               
                                JButton btnExit = new JButton("Exit");
                                btnExit.setBackground(Color.ORANGE);
                                btnExit.setForeground(Color.BLUE);
                                btnExit.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnExit.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane = new JPanel();
                                                                if (JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to Exit", "Login Systems",
                                                                                                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                                                                                System.exit(0);
                                                                }
                                                }
                                });
                                btnExit.setBounds(580, 6, 104, 29);
                                contentPane.add(btnExit);
                               
                                JButton button_3 = new JButton("Logout");
                                button_3.setBackground(Color.ORANGE);
                                button_3.setForeground(Color.BLUE);
                                button_3.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button_3.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane.setVisible(false);                   
                                                                dispose(); //this will DISPOSE OFF Current Window
                                                                DBProjectClass.main(null);
                                                }
                                });
                                button_3.setBounds(6, 6, 103, 29);
                                contentPane.add(button_3);
                               
                               
                }
               
}