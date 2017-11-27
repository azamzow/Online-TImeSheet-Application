import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Image;
 
import javax.swing.UIManager;
 
import org.omg.CORBA.Request;
 
import java.awt.Color;
 
public class DBProjectClass {
 
                private JFrame frame;
                private JTextField txtIDLogin;
                private JTextField txtIDSignUp;
                private JButton btnSubmit;
                private JTextField txtEmail;
                private JPasswordField txtPasswordLogin;
                private JPasswordField txtPasswordSignUp;
                private JPasswordField txtPasswordSignUp2;
                private JButton btnReset;
                private JLabel lblEnterPassword;
                private JLabel label;
                private JLabel lblSetPassword;
                private JLabel lblConfirmPassword;
                private JLabel lblEnterEmail;
                private JButton button_1;
                private JLabel lblWorkingkats;
                private JLabel lblNewLabel;
                private JLabel label_1;
                private String username;
               
                public String getID() {
                                return txtIDLogin.getText();
                }
 
                /**
                * Launch the application.
                */
               
                public static void main(String[] args) {
                                EventQueue.invokeLater(new Runnable() {
                                                public void run() {
                                                                try {
                                                                                DBProjectClass window = new DBProjectClass();
                                                                                window.frame.setVisible(true);
                                                                } catch (Exception e) {
                                                                                e.printStackTrace();
                                                                }
                                                }
                                });
                }
 
                Connection connection = null;
               
                /**
                * Create the application.
                */
                public DBProjectClass() {
                                initialize();
                                connection = sqliteConnections.dbConnector();
                }
 
                /**
                * Initialize the contents of the frame.
                */

                private void initialize() {
                                frame = new JFrame();
                                frame.getContentPane().setBackground(Color.ORANGE);
                                frame.setBounds(500, 500, 700, 600);
                                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                frame.getContentPane().setLayout(null);
                               
                                JButton btnNewButton = new JButton("Login");
                                btnNewButton.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnNewButton.setForeground(Color.ORANGE);
                                btnNewButton.setBackground(Color.BLUE);
                                btnNewButton.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                String password = txtPasswordLogin.getText();
                                                    String username = txtIDLogin.getText();
                                                               
                                                                try {
                                                                                String query = "select * from Students where sID = ? and sPassword = ?";
                                                                                PreparedStatement psd = connection.prepareStatement(query);
                                                                                psd.setString(1, username );
                                                                                psd.setString(2, password );
                                                                                String query2 = "select * from Managers where mID = ? and mPassword = ?";
                                                                                PreparedStatement psd2 = connection.prepareStatement(query2);
                                                                                psd2.setString(1, username );
                                                                                psd2.setString(2, password );
                                                                               
                                                                                ResultSet rs = psd.executeQuery();
                                                                                ResultSet rs2 = psd2.executeQuery();
                                                                               
                                                                               
                                                                                if (rs2.next()) {
                                                                                                JOptionPane.showMessageDialog(null, "Manager User ID and Password is Correct");
                                                                                                txtPasswordLogin.setText(null);
                                                                                                txtIDLogin.setText(null);
                                                                                               
                                                                                                frame.dispose();
                                                                                                ManagerProfile mpr = new ManagerProfile(Integer.parseInt(username));
                                                                                                mpr.setVisible(true);
                                                                                               
                                                                                }
                                                                                else if (rs.next()) {
                                                                                                JOptionPane.showMessageDialog(null, "Student User ID and Password is Correct");
                                                                                                txtPasswordLogin.setText(null);
                                                                                                txtIDLogin.setText(null);
                                                                                                                               
                                                                                               
                                                                                                StudentProfile spr= new StudentProfile(Integer.parseInt(username));
                                                                               
                                                                                                spr.setVisible(true);
                                                                                                frame.dispose();
                                                                                               
                                                                                }
                                                                                else {
                                                                                                JOptionPane.showMessageDialog(null, "User ID and Password is Not Correct, Try again....");
                                                                                               
                                                                                                }
                                                                               
                                                                                rs.close();
                                                                                psd.close();
                                                                }catch(Exception ex) {
                                                                                JOptionPane.showMessageDialog(null, ex);
                                                                }
                                                }
                                });
                                btnNewButton.setBounds(395, 522, 117, 29);
                                frame.getContentPane().add(btnNewButton);
                               
                                JLabel lblLogin = new JLabel("Login");
                                lblLogin.setForeground(new Color(255, 204, 51));
                                lblLogin.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                                lblLogin.setBounds(464, 306, 61, 45);
                                frame.getContentPane().add(lblLogin);
                               
                                txtIDLogin = new JTextField();
                                txtIDLogin.setBounds(519, 381, 130, 26);
                                frame.getContentPane().add(txtIDLogin);
                                txtIDLogin.setColumns(10);
                               
                                JLabel lblSignUp = new JLabel("Sign Up");
                                lblSignUp.setForeground(new Color(255, 204, 51));
                                lblSignUp.setFont(new Font("Lucida Grande", Font.BOLD, 20));
                                lblSignUp.setBounds(119, 310, 93, 37);
                                frame.getContentPane().add(lblSignUp);
                               
                                txtIDSignUp = new JTextField();
                                txtIDSignUp.setBounds(143, 381, 130, 26);
                                frame.getContentPane().add(txtIDSignUp);
                                txtIDSignUp.setColumns(10);
                                btnSubmit = new JButton("SignUp");
                                btnSubmit.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnSubmit.setBackground(Color.BLUE);
                                btnSubmit.setForeground(Color.ORANGE);
                                btnSubmit.addActionListener(new ActionListener() {
                                	public void actionPerformed(ActionEvent e) {			
                        				
                        				if (txtPasswordSignUp.getText().equals(txtPasswordSignUp2.getText()) && txtIDSignUp.getText().contains("333"))
                        		        {
                        					int success = 0;
                        					try {
                        						String sql = "insert into Students (sID, sPassword, Email) values (?, ?, ?)";
                        						PreparedStatement psd = connection.prepareStatement(sql);
                        						psd = connection.prepareStatement(sql);
                        						psd.setString(1, txtIDSignUp.getText());
                        						psd.setString(2, txtPasswordSignUp.getText());
                        						psd.setString(3, txtEmail.getText());
                        						success = psd.executeUpdate();
                        						JOptionPane.showMessageDialog(null, "Player successfully added.");
                        					}catch(Exception ex) {
                        						JOptionPane.showMessageDialog(null, ex);
                        					}
                        					
                        					StudentProfile sp = new StudentProfile(Integer.parseInt(txtIDSignUp.getText()));
                                            sp.setVisible(true);
                                            frame.dispose();
                        					
                        		        }
                        				else if (txtPasswordSignUp.getText().equals(txtPasswordSignUp2.getText()) && txtIDSignUp.getText().contains("111"))
                        				{
                        					int success = 0;
                        					try {
                        						String sql2 = "insert into Managers (mID, mPassword, Email) values (?, ?, ?)";
                        						PreparedStatement psd2 = connection.prepareStatement(sql2);
                        						psd2 = connection.prepareStatement(sql2);
                        						psd2.setString(1, txtIDSignUp.getText());
                        						psd2.setString(2, txtPasswordSignUp.getText());
                        						psd2.setString(3, txtEmail.getText());
                        						success = psd2.executeUpdate();
                        						JOptionPane.showMessageDialog(null, "Player successfully added.");
                        						
                        					}catch(Exception ex) {
                        						JOptionPane.showMessageDialog(null, ex);
                        					}

                        					ManagerProfile mp = new ManagerProfile(Integer.parseInt(txtIDSignUp.getText()));
                                            mp.setVisible(true);
                                            frame.dispose();
                        		        }
                        				else
                        				{
                        					JOptionPane.showMessageDialog(null, "Invaliad Login", "Login Error", JOptionPane.ERROR_MESSAGE );
                        				}
                        				
                        			}																				
                        			
                        		});
                                btnSubmit.setBounds(17, 522, 117, 29);
                                frame.getContentPane().add(btnSubmit);
                               
                                txtEmail = new JTextField();
                                txtEmail.setBounds(143, 484, 130, 26);
                                frame.getContentPane().add(txtEmail);
                                txtEmail.setColumns(10);
                               
                                txtPasswordLogin = new JPasswordField();
                                txtPasswordLogin.setBounds(519, 447, 130, 26);
                                frame.getContentPane().add(txtPasswordLogin);
                               
                                txtPasswordSignUp = new JPasswordField();
                                txtPasswordSignUp.setBounds(143, 419, 130, 26);
                                frame.getContentPane().add(txtPasswordSignUp);
                               
                                txtPasswordSignUp2 = new JPasswordField();
                                txtPasswordSignUp2.setBounds(143, 447, 130, 26);
                                frame.getContentPane().add(txtPasswordSignUp2);
                               
                                btnReset = new JButton("Reset");
                                btnReset.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnReset.setForeground(Color.ORANGE);
                                btnReset.setBackground(Color.BLUE);
                                btnReset.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                txtIDLogin.setText(null);
                                                                txtPasswordLogin.setText(null);
                                                }
                                });
                                btnReset.setBounds(522, 522, 117, 29);
                                frame.getContentPane().add(btnReset);
                               
                                JSeparator separator = new JSeparator();
                                separator.setBounds(17, 108, 477, -1);
                                frame.getContentPane().add(separator);
                               
                                JSeparator separator_1 = new JSeparator();
                                separator_1.setBounds(6, 84, 1, 12);
                                frame.getContentPane().add(separator_1);
                               
                                JSeparator separator_2 = new JSeparator();
                                separator_2.setBounds(40, 282, 609, 16);
                                frame.getContentPane().add(separator_2);
                               
                                JSeparator separator_4 = new JSeparator();
                                separator_4.setBounds(354, 16, 17, 256);
                                frame.getContentPane().add(separator_4);
                               
                                JButton button = new JButton("Reset");
                                button.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button.setForeground(Color.ORANGE);
                                button.setBackground(Color.BLUE);
                                button.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                txtIDSignUp.setText(null);
                                                                txtPasswordSignUp.setText(null);
                                                                txtPasswordSignUp2.setText(null);
                                                                txtEmail.setText(null);
                                                               
                                                }
                                });
                                button.setBounds(146, 522, 117, 29);
                                frame.getContentPane().add(button);
                               
                                JLabel lblEnterId = new JLabel("Enter samID:");
                                lblEnterId.setFont(new Font("Gabriola", Font.PLAIN, 17));
                                lblEnterId.setForeground(Color.BLUE);
                                lblEnterId.setBounds(395, 387, 117, 16);
                                frame.getContentPane().add(lblEnterId);
                               
                                lblEnterPassword = new JLabel("Enter Password:");
                                lblEnterPassword.setFont(new Font("Gabriola", Font.PLAIN, 17));
                                lblEnterPassword.setForeground(Color.BLUE);
                                lblEnterPassword.setBounds(385, 450, 151, 16);
                                frame.getContentPane().add(lblEnterPassword);
                               
                                label = new JLabel("Enter samID:");
                                label.setFont(new Font("Dialog", Font.PLAIN, 17));
                                label.setForeground(Color.BLUE);
                                label.setBounds(25, 391, 109, 16);
                                frame.getContentPane().add(label);
                               
                                lblSetPassword = new JLabel("Set Password:");
                                lblSetPassword.setFont(new Font("Dialog", Font.PLAIN, 16));
                                lblSetPassword.setForeground(Color.BLUE);
                                lblSetPassword.setBounds(17, 422, 110, 16);
                                frame.getContentPane().add(lblSetPassword);
                               
                                lblConfirmPassword = new JLabel("Confirm Password:");
                                lblConfirmPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
                                lblConfirmPassword.setForeground(Color.BLUE);
                                lblConfirmPassword.setBounds(6, 451, 130, 16);
                                frame.getContentPane().add(lblConfirmPassword);
                               
                                lblEnterEmail = new JLabel("Enter Email:");
                                lblEnterEmail.setFont(new Font("Dialog", Font.PLAIN, 16));
                                lblEnterEmail.setForeground(Color.BLUE);
                                lblEnterEmail.setBounds(40, 488, 116, 16);
                                frame.getContentPane().add(lblEnterEmail);
                               
                                button_1 = new JButton("Exit");
                                button_1.setFont(new Font("Levenim MT", Font.PLAIN, 14));
                                button_1.setBackground(Color.BLUE);
                                button_1.setForeground(Color.ORANGE);
                                button_1.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                frame = new JFrame("Exit");
                                                                if (JOptionPane.showConfirmDialog(frame, "Confirm if you want to Exit", "Login Systems",
                                                                                                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                                                                                System.exit(0);
                                                                }
                                                }
                                });
                                button_1.setBounds(577, 11, 85, 21);
                                frame.getContentPane().add(button_1);
                               
                                lblWorkingkats = new JLabel("WorkingKats");
                                lblWorkingkats.setForeground(Color.BLUE);
                                lblWorkingkats.setFont(new Font("Dialog", Font.BOLD, 58));
                                lblWorkingkats.setBounds(271, 75, 391, 177);
                                frame.getContentPane().add(lblWorkingkats);
                               
                                JLabel label_2 = new JLabel("");
                                JLabel label_3=new JLabel("");
 
                                Image img1=new ImageIcon(this.getClass().getResource("/profilelogo.png")).getImage();
                                Image img = new ImageIcon(this.getClass().getResource("/sammylogo.png")).getImage();
                                label_3.setIcon(new ImageIcon(img1));
                                label_3.setBounds(271, 211, 283, 282);
                                label_2.setIcon(new ImageIcon(img));
                                label_2.setBounds(27, 0, 283, 282);
                                frame.getContentPane().add(label_3);
                               
                                frame.getContentPane().add(label_2);
                               
                                JLabel lblTheMeasureOf = new JLabel("The measure of a Life is its Service");
                                lblTheMeasureOf.setForeground(new Color(100, 149, 237));
                                lblTheMeasureOf.setHorizontalAlignment(SwingConstants.CENTER);
                                lblTheMeasureOf.setFont(new Font("Dialog", Font.PLAIN, 28));
                                lblTheMeasureOf.setBounds(154, 232, 544, 50);
                                frame.getContentPane().add(lblTheMeasureOf);
                               
                               
                }
}