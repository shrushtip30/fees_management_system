package fees_management_system;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Login_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JLabel lblNewLabel = new JLabel("Log In");
	private JTextField text_username;
	private JTextField text_password;
	private JLabel lbl_error;

	/**
	 * Launch the application.
	 */
	void userVerification(String username,String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String user = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,user,pass);
			String sql="select * from sign_up where user_name=? and password=?";
			PreparedStatement pat=con1.prepareStatement(sql);
			pat.setString(1,username);
			pat.setString(2,password);
			ResultSet rs=pat.executeQuery();
			if(rs.next()) {
				JOptionPane.showMessageDialog(this,"Login successful");
				Home_page home=new Home_page();
				home.show();
				this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this,"wrong username and password");
			}
		}
		catch(Exception e) {
			
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page frame = new Login_page();
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
	public Login_page() {
		getContentPane().setBackground(new Color(0, 206, 209));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 500);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 560, 79);
		panel.setBackground(new Color(0, 145, 145));
		panel.setForeground(new Color(248, 248, 255));
		getContentPane().add(panel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\admin.png"));
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Georgia", lblNewLabel.getFont().getStyle() | Font.BOLD, 60));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_1.setBounds(22, 140, 140, 28);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_2.setForeground(new Color(248, 248, 255));
		lblNewLabel_2.setBounds(22, 215, 140, 28);
		getContentPane().add(lblNewLabel_2);
		
		text_username = new JTextField();
		text_username.setBounds(182, 140, 211, 29);
		getContentPane().add(text_username);
		text_username.setColumns(10);
		
		text_password = new JTextField();
		text_password.setBounds(182, 215, 211, 29);
		getContentPane().add(text_password);
		text_password.setColumns(10);
		
		JButton btn_login = new JButton("Login");
		btn_login.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\login.png"));
		btn_login.setForeground(new Color(0, 0, 0));
		btn_login.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_login.setBackground(new Color(0, 139, 139));
		btn_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username=text_username.getText();
				String password=text_password.getText();
				if(username.trim().equals("") || password.trim().equals("")) {
					lbl_error.setText("Please enter username and password");
				}
				else {
					userVerification(username,password);
				}
			}
		});
		btn_login.setBounds(22, 333, 113, 35);
		getContentPane().add(btn_login);
		
		JButton btn_signup = new JButton("Sign Up");
		btn_signup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Signup_page l=new Signup_page();
				l.setVisible(true);
				Login_page.this.dispose();
			}
		});
		
		btn_signup.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\signup.png"));
		btn_signup.setForeground(new Color(0, 0, 0));
		btn_signup.setBackground(new Color(0, 139, 139));
		btn_signup.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_signup.setBounds(200, 333, 151, 32);
		getContentPane().add(btn_signup);
		
		JButton btn_exit = new JButton("Exit");
		btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_page.this.dispose();
			}
		});
		btn_exit.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\exit.png"));
		btn_exit.setForeground(new Color(0, 0, 0));
		btn_exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_exit.setBackground(new Color(0, 139, 139));
		btn_exit.setBounds(422, 334, 107, 32);
		getContentPane().add(btn_exit);
		
		lbl_error = new JLabel("");
		lbl_error.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_error.setForeground(Color.RED);
		lbl_error.setBounds(22, 280, 420, 28);
		getContentPane().add(lbl_error);
	    setVisible(true);
	}
}
