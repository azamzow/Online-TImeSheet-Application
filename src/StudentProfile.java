import java.awt.BorderLayout;
import java.awt.EventQueue;
 
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.ibex.nestedvm.util.Seekable.InputStream;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import com.toedter.calendar.JDateChooser;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
 
public class StudentProfile extends JFrame {
 
                private JPanel contentPane;
    private javax.swing.JTable searchTable;
    private javax.swing.JComboBox<String> tableCombo;
    private javax.swing.JTable charTable;
    private static int stID;
   
    
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    PreparedStatement stmt = null;
 
                /**
                * Launch the application.
                */
               
                Connection connection = null;
                private JTable table;
                private JTextField textFieldName;
                private JTextField textFieldEmail;
                private JTextField textFieldID;
                private JTextField textFieldPhoneNumber;
                private JTextField textFieldPassword;
                private JTextField textFieldclock_in;
                private JTextField textFieldclock_out;
                /**
                * Create the frame.
                */
               
                public StudentProfile(int a) {
                                addWindowListener(new WindowAdapter() {
                                                @Override
                                                public void windowOpened(WindowEvent arg0) {
                                                                try {
                                                        String sql = "SELECT * FROM Students WHERE sID = ?";
                                                        pst = connection.prepareStatement(sql);
                                                        pst.setInt(1,stID);
                                                       
                                                        rs = pst.executeQuery();
                                                       
                                                                    while(rs.next()) {
                                                                        String ID = rs.getString("sID");
                                                                        textFieldID.setText(ID);
                                                                                               
                                                                        String Name = rs.getString("Name");
                                                                        textFieldName.setText(Name);
                                                                       
                                                                        String Email = rs.getString("Email");
                                                                        textFieldEmail.setText(Email);
                                                                       
                                                                        String Pass = rs.getString("sPassword");
                                                                        textFieldPassword.setText(Pass);
                                                                       
                                                                        String Number = rs.getString("PhoneNumber");
                                                                        textFieldPhoneNumber.setText(Number);
                                                                       
                                                                        
//                                                                        Blob imageBlob = resultSet.getBlob(yourBlobColumnIndex);
//                                                                        InputStream binaryStream = imageBlob.getBinaryStream(0, imageBlob.length());
                                                                        
//                                                                        byte[] imageBytes = person_image.getBytes(1, (int) person_image.length());
//                                                                        InputStream binaryStream = person_image.getBinaryStream(yourBlobColumnIndex);
               
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
                                contentPane.setBackground(Color.GRAY);
                               
                                contentPane.setForeground(new Color(255, 204, 51));
                                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                                setContentPane(contentPane);
                                contentPane.setLayout(null);
                                stID=a;
                                JButton button = new JButton("Exit");
                                button.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button.setForeground(Color.BLUE);
                                button.setBackground(Color.ORANGE);
                                button.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane = new JPanel();
                                                                if (JOptionPane.showConfirmDialog(contentPane, "Confirm if you want to Exit", "Login Systems",
                                                                                                JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
                                                                                System.exit(0);
                                                                }
                                                }
                                });
                                button.setBounds(602, 6, 92, 29);
                                contentPane.add(button);
                               
                                JButton button_1 = new JButton("Search");
                                button_1.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                button_1.setForeground(Color.BLUE);
                                button_1.setBackground(Color.ORANGE);
                                button_1.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                contentPane.setVisible(false);
                                                               
                                                                SearchProfileStudent searchPS = new SearchProfileStudent(stID);
                                                               
                                                                searchPS.setVisible(true);
                                                                dispose();//this will DISPOSE OFF Current Window
                                                }
                                });
                                button_1.setBounds(34, 6, 103, 29);
                                contentPane.add(button_1);
                               
                                JLabel lblemail = new JLabel("Email");
                                lblemail.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblemail.setForeground(new Color(255, 204, 51));
                                lblemail.setBounds(40, 197, 148, 31);
                                contentPane.add(lblemail);
                               
                                JLabel lblid = new JLabel("Student ID");
                                lblid.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblid.setForeground(new Color(255, 204, 51));
                                lblid.setBounds(40, 143, 226, 30);
                                contentPane.add(lblid);
                               
                                JSeparator separator = new JSeparator();
                                separator.setBounds(34, 119, 631, 20);
                                contentPane.add(separator);
                               
                                table = new JTable();
                                table.setBounds(34, 115, 263, -69);
                                contentPane.add(table);
                               
                                JLabel lblname = new JLabel("Name");
                                lblname.setForeground(Color.ORANGE);
                                lblname.setFont(new Font("Gabriola", Font.BOLD, 45));
                                lblname.setBounds(30, 47, 157, 66);
                                contentPane.add(lblname);
                               
                                JLabel lblphone = new JLabel("Phone Number");
                                lblphone.setForeground(new Color(255, 204, 51));
                                lblphone.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblphone.setBounds(37, 240, 260, 30);
                                contentPane.add(lblphone);
                               
                                textFieldName = new JTextField();
                                textFieldName.setBounds(206, 58, 232, 43);
                                contentPane.add(textFieldName);
                                textFieldName.setColumns(10);
                               
                                textFieldEmail = new JTextField();
                                textFieldEmail.setColumns(10);
                                textFieldEmail.setBounds(278, 185, 232, 43);
                                contentPane.add(textFieldEmail);
                               
                                textFieldID = new JTextField();
                                textFieldID.setColumns(10);
                                textFieldID.setBounds(278, 142, 232, 43);
                                contentPane.add(textFieldID);
                               
                                textFieldPhoneNumber = new JTextField();
                                textFieldPhoneNumber.setColumns(10);
                                textFieldPhoneNumber.setBounds(278, 228, 232, 43);
                                contentPane.add(textFieldPhoneNumber);
                               
                                JButton btnUpdate = new JButton("Update");
                                btnUpdate.setBackground(Color.ORANGE);
                                btnUpdate.setForeground(Color.BLUE);
                                btnUpdate.setFont(new Font("Levenim MT", Font.PLAIN, 13));
                                btnUpdate.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query="Update Students set sID ='"+textFieldID.getText()+"', Email ='"+textFieldEmail.getText()+"', PhoneNumber = '"+textFieldPhoneNumber.getText()+"', sPassword = '"+textFieldPassword.getText()+"', Name = '"+textFieldName.getText()+"' where sID ='"+textFieldID.getText()+"'";
                                                                                PreparedStatement pst = connection.prepareStatement(query);
                                                                   
                                                                                pst.execute();
                                                                               
                                                                                JOptionPane.showMessageDialog(null, "Data Updated");
                                                                               
                                                                                pst.close();
                                           
                                                                }catch(Exception ex) {
                                                                                ex.printStackTrace();;
                                                                }
                                                }
                                });
                                btnUpdate.setBounds(559, 519, 117, 29);
                                contentPane.add(btnUpdate);
                               
                                JButton btnDeleteProfile = new JButton("Delete Profile");
                                btnDeleteProfile.setFont(new Font("Levenim MT", Font.PLAIN, 12));
                                btnDeleteProfile.setForeground(Color.BLUE);
                                btnDeleteProfile.setBackground(Color.ORANGE);
                                btnDeleteProfile.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                try {
                                                                                String query="delete from Students where sID = '"+textFieldID.getText()+"'";
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
                                btnDeleteProfile.setBounds(559, 478, 117, 29);
                                contentPane.add(btnDeleteProfile);
                               
                                JLabel lblPassword = new JLabel("Password");
                                lblPassword.setForeground(new Color(255, 204, 51));
                                lblPassword.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblPassword.setBounds(40, 282, 204, 30);
                                contentPane.add(lblPassword);
                               
                                textFieldPassword = new JTextField();
                                textFieldPassword.setColumns(10);
                                textFieldPassword.setBounds(278, 270, 232, 43);
                                contentPane.add(textFieldPassword);
                               
                                JLabel lblClockInout = new JLabel("TimeStamp");
                                lblClockInout.setForeground(new Color(255, 204, 51));
                                lblClockInout.setFont(new Font("Gabriola", Font.BOLD, 30));
                                lblClockInout.setBounds(40, 324, 204, 30);
                                contentPane.add(lblClockInout);
                               
                                JDateChooser dateChooser = new JDateChooser();
                                dateChooser.setDateFormatString("dd/MM/yyyy");
                                dateChooser.setBounds(278, 318, 232, 43);
                                contentPane.add(dateChooser);
                               
                                JButton btnAddClockOut = new JButton("Add TimeStamp");
                                btnAddClockOut.setBackground(Color.ORANGE);
                                btnAddClockOut.setForeground(Color.BLUE);
                                btnAddClockOut.addActionListener(new ActionListener() {
                                                public void actionPerformed(ActionEvent e) {
                                                                Date date = dateChooser.getDate();
                                                    String dateInput = new SimpleDateFormat("yyyy-MM-dd").format(date);
                                                    
                                                                String sql = "INSERT INTO `TimeStamp` (`sID`, `date`, `clock_in`, `clock_out`) VALUES  (?,?,?,?)";
                                                    try {
                                                     stmt = connection.prepareStatement(sql);
                                                     stmt.setString(1, textFieldID.getText());
                                                     stmt.setString(2, dateInput);
                                                     stmt.setString(3, textFieldclock_in.getText());
                                                     stmt.setString(4, textFieldclock_out.getText());
                                                     stmt.executeUpdate();
                                                                JOptionPane.showMessageDialog(null, "TimeStamp Updated.");
                                                    } catch (Exception ex) {
                                                                                JOptionPane.showMessageDialog(null, ex.getMessage());
                                                    }
                                                }
                                });
                                btnAddClockOut.setFont(new Font("Levenim MT", Font.PLAIN, 10));
                                btnAddClockOut.setBounds(512, 405, 130, 29);
                                contentPane.add(btnAddClockOut);
                               
                                textFieldclock_in = new JTextField();
                                textFieldclock_in.setText("00:00am");
                                textFieldclock_in.setBounds(386, 368, 124, 33);
                                contentPane.add(textFieldclock_in);
                                textFieldclock_in.setColumns(10);
                               
                                textFieldclock_out = new JTextField();
                                textFieldclock_out.setText("00:00pm");
                                textFieldclock_out.setColumns(10);
                                textFieldclock_out.setBounds(386, 401, 124, 33);
                                contentPane.add(textFieldclock_out);
                               
                                JLabel lblClockIn = new JLabel("Clock IN");
                                lblClockIn.setFont(new Font("Levenim MT", Font.BOLD, 11));
                                lblClockIn.setForeground(Color.ORANGE);
                                lblClockIn.setBounds(327, 376, 61, 16);
                                contentPane.add(lblClockIn);
                               
                                JLabel lblClockOut = new JLabel("Clock OUT");
                                lblClockOut.setFont(new Font("Levenim MT", Font.BOLD, 11));
                                lblClockOut.setForeground(Color.ORANGE);
                                lblClockOut.setBounds(312, 409, 76, 16);
                                contentPane.add(lblClockOut);
                               
                                JLabel label8=new JLabel("");
 
                                Image img1=new ImageIcon(this.getClass().getResource("/profilelogo.png")).getImage();
                                label8.setIcon(new ImageIcon(img1));
                                label8.setBounds(31, 349, 245, 243);
                                getContentPane().add(label8);
                                
                        		JLabel lblProfilePic = new JLabel("");
                        		lblProfilePic.setVerticalAlignment(SwingConstants.TOP);
                        		lblProfilePic.setBounds(462, 13, 130, 100);
                        		contentPane.add(lblProfilePic);
                        		
                        		JButton btnBrowse = new JButton("Browse for Picture");
                        		btnBrowse.setToolTipText("Click to browse for your profile picture which will be shown above");
                        		btnBrowse.setBounds(529, 122, 147, 51);
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
                        						String query = ("Update Students set sPic =? where sID ='"+textFieldID.getText()+"'");
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