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
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
public class SearchProfileManager extends JFrame {
 
      private JPanel contentPane;
      private static int mID;
 
      /**
      * Launch the application.
      */
//      public static void main(String[] args) {
//            EventQueue.invokeLater(new Runnable() {
//                  public void run() {
//                        try {
//                              SearchProfileManager frame = new SearchProfileManager();
//                              frame.setVisible(true);
//                        } catch (Exception e) {
//                              e.printStackTrace();
//                        }
//                  }
//            });
//      }
     
      /**
      * Create the frame.
      */
     
      public SearchProfileManager(int a) {
    	  mID=a;
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(500, 500, 700, 600);
            contentPane = new JPanel();
            contentPane.setBackground(Color.gray);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
           
            JLabel label = new JLabel("Welcome to WorkingKats!");
            label.setForeground(Color.ORANGE);
            label.setFont(new Font("Dialog", Font.BOLD, 32));
            label.setBounds(6, 33, 457, 154);
            contentPane.add(label);
           
            JLabel label_1 = new JLabel("Choose an option!");
            label_1.setForeground(Color.LIGHT_GRAY);
            label_1.setFont(new Font("Dialog", Font.PLAIN, 30));
            label_1.setBounds(166, 157, 394, 110);
            contentPane.add(label_1);
           
            JSeparator separator = new JSeparator();
            separator.setBounds(41, 267, 571, 16);
            contentPane.add(separator);
           
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
            button.setBounds(597, 6, 97, 29);
            contentPane.add(button);
           
            JLabel label_3 = new JLabel("Go to Profile");
            label_3.setForeground(Color.LIGHT_GRAY);
            label_3.setFont(new Font("Dialog", Font.BOLD, 25));
            label_3.setBounds(461, 309, 175, 110);
            contentPane.add(label_3);
           
            JLabel label_4 = new JLabel("Search for Students");
            label_4.setForeground(Color.LIGHT_GRAY);
            label_4.setFont(new Font("Dialog", Font.BOLD, 25));
            label_4.setBounds(52, 306, 265, 89);
            contentPane.add(label_4);
           
            JLabel label_5 = new JLabel(" in your departments");
            label_5.setForeground(Color.LIGHT_GRAY);
            label_5.setFont(new Font("Dialog", Font.BOLD, 25));
            label_5.setBounds(41, 364, 304, 89);
            contentPane.add(label_5);
           
            JButton button_1 = new JButton("Search");
            button_1.setBackground(Color.ORANGE);
            button_1.setFont(new Font("Levenim MT", Font.PLAIN, 13));
            button_1.setForeground(Color.BLUE);
            button_1.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
//                        contentPane.setVisible(false);
//                        dispose(); //this will DISPOSE OFF Current Window
                        ManagerSearchStudentFrame mssf = new ManagerSearchStudentFrame(mID);
                        mssf.setVisible(true);
                  }
            });
            button_1.setBounds(91, 464, 117, 29);
            contentPane.add(button_1);
           
            JButton button_2 = new JButton("Profile");
            button_2.setForeground(Color.BLUE);
            button_2.setFont(new Font("Levenim MT", Font.PLAIN, 13));
            button_2.setBackground(Color.ORANGE);
            button_2.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        contentPane.setVisible(false);
                        dispose(); //this will DISPOSE OFF Current Window
                        ManagerProfile mp = new ManagerProfile(mID);
                        mp.setVisible(true);
                  }
            });
            button_2.setBounds(496, 464, 117, 29);
            contentPane.add(button_2);
           
            JLabel label_2 = new JLabel("");
            Image img = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
            label_2.setIcon(new ImageIcon(img));
            label_2.setBounds(436, 6, 258, 262);
            contentPane.add(label_2);
           
            JButton btnBack = new JButton("Logout");
            btnBack.setBackground(Color.ORANGE);
            btnBack.setForeground(Color.BLUE);
            btnBack.setFont(new Font("Levenim MT", Font.PLAIN, 13));
            btnBack.addActionListener(new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                        contentPane.setVisible(false);
                        dispose(); //this will DISPOSE OFF Current Window
                        DBProjectClass.main(null);
                  }
            });
            btnBack.setBounds(6, 6, 103, 29);
            contentPane.add(btnBack);
 
}}