package fees_management_system;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Signup_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txt_firstname;
	private JTextField txt_lastname;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JPasswordField txt_con_password;
	private JTextField txt_dob;
	private JTextField txt_contact;
	
	String fname,lname,uname,password,con_pass,contact_no,dob;
	int id=0;
	private JLabel lbl_password_error;
	private JLabel lbl_contact_error;

	/**
	 * Launch the application.
	 */
	public int getId(){
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			String sql="select max(id) from sign_up";
			Statement st=con1.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()) {
				id=rs.getInt(1);
				id++;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	boolean validation() {
		
		
		fname=txt_firstname.getText();
		lname=txt_lastname.getText();
		uname=txt_username.getText();
		password=txt_password.getText();
		con_pass=txt_con_password.getText();
		contact_no=txt_contact.getText();
		dob=txt_dob.getText();
		if(fname.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter firstname");
			return false;
		}
		if(lname.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter lastname");
			return false;
		}
		if(uname.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter username");
			return false;
		}
		if(password.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter password");
			return false;
		}
		if(con_pass.equals("")) {
			JOptionPane.showMessageDialog(this,"please confirm password");
			return false;
		}
		if(contact_no.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter contact no.");
			return false;
		}
		if(dob.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter date of birth");
			return false;
		}
		if(!password.equals(con_pass)) {
			JOptionPane.showMessageDialog(this, "Password not matched");
			return false;
		}
		
		
		return true;
		
	}
	public void check_password() {
		password=txt_password.getText();
		if(password.length()<7) {
			lbl_password_error.setText("password length should be 8 digits");
		}
		else {
			lbl_password_error.setText("");
		}
		
	}
	public void check_contact() {
		contact_no=txt_contact.getText();
		if(contact_no.length()<9) {
			lbl_contact_error.setText("contact number should be 10 digits");
		}
		else {
			lbl_contact_error.setText("");
		}
	}
	void insertDetails() {
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			String sql="insert into sign_up values(?,?,?,?,?,?,?)";
			PreparedStatement stmt=con1.prepareStatement(sql);
			stmt.setInt(1,getId());
			stmt.setString(2,fname);
			stmt.setString(3,lname);
			stmt.setString(4,uname);
			stmt.setString(5,password);
			stmt.setString(6,dob);
			stmt.setString(7,contact_no);
			int i=stmt.executeUpdate();
			if(i>0) {
				JOptionPane.showMessageDialog(this,"record inserted");
			}
			else {
				JOptionPane.showMessageDialog(this,"record not inserted");;
			}
			
			
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup_page frame = new Signup_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Signup_page() {
		getContentPane().setFont(new Font("Algerian", getContentPane().getFont().getStyle() | Font.BOLD, getContentPane().getFont().getSize()));
		
		setAlwaysOnTop(true);
		setLocationByPlatform(true);
		getContentPane().setBackground(new Color(0, 206, 209));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 591);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 128));
		panel.setBounds(0, 0, 734, 118);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\signup.png"));
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Georgia", lblNewLabel.getFont().getStyle() | Font.BOLD, 60));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setBounds(24, 165, 124, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name :");
		lblNewLabel_1_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(24, 208, 124, 25);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username:");
		lblNewLabel_1_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(24, 254, 124, 25);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Password :");
		lblNewLabel_1_3.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(24, 295, 124, 25);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Confirm Password:");
		lblNewLabel_1_4.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(24, 337, 173, 25);
		getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("DOB:");
		lblNewLabel_1_5.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(24, 379, 124, 25);
		getContentPane().add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Contact No :");
		lblNewLabel_1_6.setForeground(new Color(248, 248, 255));
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_6.setBounds(24, 420, 124, 25);
		getContentPane().add(lblNewLabel_1_6);
		
		txt_firstname = new JTextField();
		txt_firstname.setBounds(206, 165, 189, 26);
		getContentPane().add(txt_firstname);
		txt_firstname.setColumns(10);
		
		txt_lastname = new JTextField();
		txt_lastname.setBounds(206, 208, 189, 26);
		getContentPane().add(txt_lastname);
		txt_lastname.setColumns(10);
		
		txt_username = new JTextField();
		txt_username.setBounds(206, 254, 189, 26);
		getContentPane().add(txt_username);
		txt_username.setColumns(10);
		
		txt_password = new JPasswordField();
		txt_password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				check_password();
			}
		});
		
		txt_password.setBounds(206, 295, 189, 26);
		getContentPane().add(txt_password);
		
		txt_con_password = new JPasswordField();
		txt_con_password.setBounds(207, 337, 188, 25);
		getContentPane().add(txt_con_password);
		
		txt_dob = new JTextField();
		txt_dob.setBounds(206, 379, 146, 26);
		getContentPane().add(txt_dob);
		txt_dob.setColumns(10);
		
		txt_contact = new JTextField();
		txt_contact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				check_contact();
			}
		});
		txt_contact.setBounds(206, 424, 146, 26);
		getContentPane().add(txt_contact);
		txt_contact.setColumns(10);
		
		JButton signup = new JButton("Sign Up");
		signup.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\signup.png"));
		signup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validation()) {
					insertDetails();
				}
			}
		});
		
		signup.setForeground(new Color(0, 0, 0));
		signup.setBackground(new Color(0, 139, 139));
		signup.setBounds(28, 487, 151, 31);
		getContentPane().add(signup);
		
		JButton login = new JButton("Login");
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_page l=new Login_page();
				l.setVisible(true);
				Signup_page.this.dispose();
			}
		});
		
		login.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\login.png"));
		login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		login.setBackground(new Color(0, 139, 139));
		login.setBounds(312, 487, 133, 31);
		getContentPane().add(login);
		
		lbl_password_error= new JLabel("");
		lbl_password_error.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_password_error.setForeground(new Color(255, 0, 0));
		lbl_password_error.setBounds(405, 270, 319, 23);
		getContentPane().add(lbl_password_error);
		
		lbl_contact_error = new JLabel("");
		lbl_contact_error.setForeground(new Color(255, 0, 0));
		lbl_contact_error.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_contact_error.setBounds(373, 369, 332, 19);
		getContentPane().add(lbl_contact_error);
		
		
		
	}
}
