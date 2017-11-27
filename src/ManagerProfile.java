import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
 
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
 
public class ManagerProfile extends JFrame {
 
                private JPanel contentPane;
    private javax.swing.JTable searchTable;
    private javax.swing.JComboBox<String> tableCombo;
    private javax.swing.JTable charTable;
    private javax.swing.JButton updateplayerpass;
    private static int mID;
   
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
   
 
                Connection connection = null;
                private JTextField textFieldName;
                private JTextField textFieldEmail;
                private JTextField textFieldID;
                private JTextField textFieldPhoneNumber;
                private JTextField textFieldPassword;
               
                /**
                * Create the frame.
                */
               
                public ManagerProfile(int a) {
                                addWindowListener(new WindowAdapter() {
                                                @Override
                                                public void windowOpened(WindowEvent arg0) {
                                                                try {
                                                        String sql = "SELECT * FROM Managers WHERE mID = ?";
                                                        pst = connection.prepareStatement(sql);
                                                        pst.setInt(1,mID);
                                                       
                                                        rs = pst.executeQuery();
                                                       
                                                                    while(rs.next()) {
                                                                                                String ID = rs.getString("mID");
                                                                                                textFieldID.setText(ID);
                                                                                               
                                                                                                String Name = rs.getString("Manager_Name");
                                                                        textFieldName.setText(Name);
                                                                       
                                                                        String Email = rs.getString("Email");
                                                                        textFieldEmail.setText(Email);
                                                                       
                                                                        String Pass = rs.getString("mPassword");
                                                                        textFieldPassword.setText(Pass);
                                                                       
                                                                        String Number = rs.getString("ContactNumber");
                                                                        textFieldPhoneNumber.setText(Number);
 
                                                                    }
                                                    } catch (Exception ex ) {
                                                    JOptionPane.showMessageDialog(null, ex);
                                                }
                                                               
                                                }
                                });
                               
                                connection = sqliteConnections.dbConnector();
                                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                setBounds(500, 500, 700, 600);
                                contentPane = new JPanel();
                                contentPane.setBackground(Color.gray);
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                                mID=a;
                               
                                JButton button = new JButton("Exit");
                                button.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button.setBackground(Color.ORANGE);
                                button.setForeground(Color.BLUE);
                                button.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane = new JPanel();
                                                                if (JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to Exit", "Login Systems",
                                                                                                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                                                                                System.exit(0);
                                                                }
                                                }
                                });
                               
                                button.setBounds(601, 6, 93, 29);
                                contentPane.add(button);
                               
                                JButton btnSearch = new JButton("Search");
                                btnSearch.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnSearch.setForeground(Color.BLUE);
                                btnSearch.setBackground(Color.ORANGE);
                                btnSearch.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                	contentPane.setVisible(false);
                                    				dispose(); //this will DISPOSE OFF Current Window
                                    				SearchProfileManager searchPM = new SearchProfileManager(mID);
                                    				searchPM.setVisible(true);
                                                }
                                });
                                btnSearch.setBounds(6, 6, 103, 29);
                                contentPane.add(btnSearch);
                               
                                JSeparator separator = new JSeparator();
                                separator.setBounds(30, 141, 600, 29);
                                contentPane.add(separator);
                               
                                JLabel label = new JLabel("Name");
                                label.setForeground(Color.ORANGE);
                                label.setFont(new Font("Gabriola", Font.BOLD, 45));
                                label.setBounds(30, 71, 157, 66);
                                contentPane.add(label);
                               
                                textFieldName = new JTextField();
                                textFieldName.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                textFieldName.setColumns(10);
                                textFieldName.setBounds(210, 82, 232, 43);
                                contentPane.add(textFieldName);
                               
                                JLabel label_1 = new JLabel("Email");
                                label_1.setForeground(new Color(255, 204, 51));
                                label_1.setFont(new Font("Gabriola", Font.BOLD, 30));
                                label_1.setBounds(40, 199, 148, 31);
                                contentPane.add(label_1);
                               
                                JLabel lblManagerId = new JLabel("Manager ID");
                                lblManagerId.setForeground(new Color(255, 204, 51));
                                lblManagerId.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblManagerId.setBounds(40, 262, 226, 30);
                                contentPane.add(lblManagerId);
                               
                                JLabel label_3 = new JLabel("Phone Number");
                                label_3.setForeground(new Color(255, 204, 51));
                                label_3.setFont(new Font("Gabriola", Font.BOLD, 30));
                                label_3.setBounds(30, 316, 245, 30);
                                contentPane.add(label_3);
                               
                                textFieldEmail = new JTextField();
                                textFieldEmail.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                textFieldEmail.setColumns(10);
                                textFieldEmail.setBounds(278, 186, 232, 43);
                                contentPane.add(textFieldEmail);
                               
                                textFieldID = new JTextField();
                                textFieldID.setColumns(10);
                                textFieldID.setBounds(278, 249, 232, 43);
                                contentPane.add(textFieldID);
                               
                                textFieldPhoneNumber = new JTextField();
                                textFieldPhoneNumber.setColumns(10);
                                textFieldPhoneNumber.setBounds(278, 304, 232, 43);
                                contentPane.add(textFieldPhoneNumber);
                               
                                JButton button_2 = new JButton("Update");
                                button_2.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button_2.setForeground(Color.BLUE);
                                button_2.setBackground(Color.ORANGE);
                                button_2.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query="Update Managers set mID ='"+textFieldID.getText()+"', Email ='"+textFieldEmail.getText()+"', ContactNumber = '"+textFieldPhoneNumber.getText()+"', mPassword = '"+textFieldPassword.getText()+"', Manager_Name = '"+textFieldName.getText()+"' where mID ='"+textFieldID.getText()+"'";
                                                                                PreparedStatement pst = connection.prepareStatement(query);
                                                                                //add password
                                                                                pst.execute();
                                                                               
                                                                                JOptionPane.showMessageDialog(null, "Data Updated");
                                                                               
                                                                                pst.close();
                                           
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();;
                                                                }
                                                }
                                });
                                button_2.setBounds(559, 543, 117, 29);
                                contentPane.add(button_2);
                               
                                JButton btnDeleteProfile = new JButton("Delete Profile");
                                btnDeleteProfile.setFont(new Font("Levenim MT", Font.PLAIN, 12));
                                btnDeleteProfile.setBackground(Color.ORANGE);
                                btnDeleteProfile.setForeground(Color.BLUE);
                                btnDeleteProfile.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query="delete from Managers where mID = '"+textFieldID.getText()+"'";
                                                                                PreparedStatement pst = connection.prepareStatement(query);
                                                                               
                                                                                pst.execute();
                                                                               
                                                                                JOptionPane.showMessageDialog(null, "Data Deleted");
                                                                               
                                                                                pst.close();
                                                                               
                                                                                contentPane.setVisible(false);
                                                                                dispose(); //this will DISPOSE OFF Current Window
                                                                                DBProjectClass.main(null);
                                           
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();;
                                                                }
                                                }
                                });
                                btnDeleteProfile.setBounds(559, 502, 117, 29);
                                contentPane.add(btnDeleteProfile);
                               
                                JLabel lblPassword = new JLabel("Password");
                                lblPassword.setForeground(new Color(255, 204, 51));
                                lblPassword.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblPassword.setBounds(40, 382, 204, 30);
                                contentPane.add(lblPassword);
                               
                                textFieldPassword = new JTextField();
                                textFieldPassword.setColumns(10);
                                textFieldPassword.setBounds(278, 382, 232, 43);
                                contentPane.add(textFieldPassword);
 
                                JLabel label8=new JLabel("");
 
                                Image img1=new ImageIcon(this.getClass().getResource("/profilelogo.png")).getImage();
                                label8.setIcon(new ImageIcon(img1));
                                label8.setBounds(23, 369, 245, 243);
                                getContentPane().add(label8);
                                
                        		JLabel lblProfilePic = new JLabel("");
                        		lblProfilePic.setVerticalAlignment(SwingConstants.TOP);
                        		lblProfilePic.setBounds(462, 13, 141, 116);
                        		contentPane.add(lblProfilePic);
                        		
                        		JButton btnBrowse = new JButton("Browse for Picture");
                        		btnBrowse.setToolTipText("Click to browse for your profile picture which will be shown above");
                        		btnBrowse.setBounds(547, 155, 147, 51);
                        		contentPane.add(btnBrowse);
                        		btnBrowse.addActionListener(new ActionListener() 
                        		{
                        			public void actionPerformed(ActionEvent e) 
                        			{
                        				JFileChooser file = new JFileChooser();
                        				file.setCurrentDirectory(new File(System.getProperty("user.home")));
                        				FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images","jpg", "gif", "png");
                        				file.addChoosableFileFilter(filter);
                        				int result = file.showSaveDialog(null);
                        				if(result == JFileChooser.APPROVE_OPTION)
                        				{
                        					File selectedFile = file.getSelectedFile();
                        					String path = selectedFile.getAbsolutePath();
                        					int num_rows = 0;
                        					lblProfilePic.setIcon(ResizeImage(path));
                        					try
                        					{
                        						FileInputStream fis = new FileInputStream(selectedFile);
                        						ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        						byte[] buf = new byte [1024];
                        						byte[] person_image = null;
                        						for (int readNum; (readNum = fis.read(buf)) != -1;)
                        						{
                        							bos.write(buf, 0, readNum);
                        						}
                        						person_image = bos.toByteArray();
                        						fis.close();
                        						String query = ("Update Managers set mPic =? where mID ='"+textFieldID.getText()+"'");
                        						PreparedStatement pst = connection.prepareStatement(query);
                                             pst.setBytes(1, person_image);
//                                             JOptionPane.showMessageDialog(null, "Data Updated");

                                             pst.executeUpdate();
                     						if(num_rows>0)
                     						{
                     							JOptionPane.showMessageDialog(null, "Picture Updated.");
                     						}
                        						pst.close();
                        						connection.close();
                        					}catch(Exception ex){
                        						JOptionPane.showMessageDialog(null, ex.getMessage());
                        						}
                        					
                        				}
                        				
                        				else if(result == JFileChooser.CANCEL_OPTION){
                        					JOptionPane.showMessageDialog(null, "No file Selected.");
                        				}
                        			}
                        		});
                }

                        	public ImageIcon ResizeImage(String ImagePath)
                        	{
                        		ImageIcon ProfilePic = new ImageIcon(ImagePath);
                        		Image pic = ProfilePic.getImage();
                        		Image newImg = pic.getScaledInstance(130, 100, Image.SCALE_SMOOTH);
                        		ImageIcon image = new ImageIcon(newImg);
                        		return image;
                        	
                        	}
                }