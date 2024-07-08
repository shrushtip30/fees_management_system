package fees_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Add_Page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel_parent;
	private JTextField txt_receipt;
	private JTextField txt_date;
	private JTextField txt_received;
	private JTextField txt_year;
	private JTextField txt_adm;
	private JTextField txt_transaction;
	private JTextField txt_bank;
	private JTextField txt_head;
	private JTextField txt_amount1;
	private JTextField txt_amount2;
	private JTextField txt_amount3;
	private JTextField txt_total;
	private JTextField txt_total_words;
	private JTextField txt_cheque;
	private JComboBox Box;
	private JComboBox Box_1;
	private JLabel lbl_dd;
	private JLabel lbl_cheque;
	private JLabel lbl_transaction;
	private JLabel lbl_bank;
	private JLabel lbl_tw;
	private JTextField txt_dd;
	
	private JTextField txt_head2;
	private JTextField txt_heads3;
	String rcpt,date,received,year,adm,transaction,bank,head,cheque,dd,heads2,heads3,amt1,amt2,amt3,total,tw;
	float amount,amount2,amount3,t=0;
	String status="failed";
	
	/**
	 * Launch the application.
	 */
	public String insertData() {
		int c=0;
		int cheque_no = 0;
        int transaction_no = 0;
        int dd_no = 0;
        String bank_name = "";
		int reciept=Integer.parseInt(txt_receipt.getText().trim());
		String student_name=txt_received.getText();
		String payment_mode=Box.getSelectedItem().toString();
		if(!txt_cheque.getText().trim().isEmpty()) {
			cheque_no=Integer.parseInt(txt_cheque.getText().trim());
			bank_name=txt_bank.getText();
			c=1;
		}
		if(!txt_transaction.getText().trim().isEmpty()) {
			transaction_no=Integer.parseInt(txt_transaction.getText().trim());
			bank_name=txt_bank.getText();
			c=1;
		}
		if(!txt_dd.getText().trim().isEmpty()) {
			dd_no=Integer.parseInt(txt_dd.getText().trim());
			bank_name=txt_bank.getText();
			c=1;
		}
		
		String courses=Box_1.getSelectedItem().toString();
		float total_amount=Float.parseFloat(txt_total.getText().trim());
		String date=txt_date.getText();
		float amount1=Float.parseFloat(txt_amount1.getText().trim());
		float amount2=Float.parseFloat(txt_amount2.getText().trim());
		float amount3=Float.parseFloat(txt_amount3.getText().trim());
		String total_in_words=txt_total_words.getText();
		String head1=txt_head.getText();
		String head2=txt_head2.getText();
		String head3=txt_heads3.getText();
		int year=Integer.parseInt(txt_year.getText().trim());
		int adm_no=Integer.parseInt(txt_adm.getText().trim());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			PreparedStatement p=con1.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			p.setInt(1,reciept);
			p.setString(2,student_name);
			p.setString(3,payment_mode);
			p.setInt(4,cheque_no);
			p.setInt(5,transaction_no);
			p.setString(6,bank_name);
			p.setInt(7,dd_no);
			p.setString(8,courses);
			p.setFloat(9,total_amount);
			p.setString(10,date);
			p.setFloat(11,amount1);
			p.setFloat(12,amount2);
			p.setFloat(13,amount3);
			p.setString(14,total_in_words);
			p.setString(15,head1);
			p.setString(16,head2);
			p.setString(17,head3);
			p.setInt(18,year);
			p.setInt(19,adm_no);
			
			int row=p.executeUpdate();
			if(row==1) {
				status="success";
			}
			else {
				status="failed";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	public int getreceipt() {
		int rno=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			PreparedStatement p=con1.prepareStatement("Select max(reciept_no) from fees_details");
			ResultSet rs=p.executeQuery();
			if(rs.next()) {
				rno=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rno+1;
	}
	public void fillComboBox() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			PreparedStatement p=con1.prepareStatement("Select cname from course");
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				Box_1.addItem(rs.getString("cname"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
boolean validation() {
		
		
		rcpt=txt_receipt.getText();
		date=txt_date.getText();
		received=txt_received.getText();
		year=txt_year.getText();
		adm=txt_adm.getText();
		transaction=txt_transaction.getText();
		bank=txt_bank.getText();
		cheque=txt_cheque.getText();
		head=txt_head.getText();
		dd=txt_dd.getText();
		heads2=txt_head2.getText();
		heads3=txt_heads3.getText();
		amt1=txt_amount1.getText();
		amt2=txt_amount2.getText();
		amt3=txt_amount3.getText();
		total=txt_total.getText();
		tw=txt_total_words.getText();
		if(rcpt.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter receipt no.");
			return false;
		}
		if(date.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter date");
			return false;
		}
		if(received.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter received from");
			return false;
		}
		if(year.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter year");
			return false;
		}
		if(adm.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter admission no.");
			return false;
		}
		if(Box.getSelectedIndex()==3 ||Box.getSelectedIndex()==4 ) {
			if(transaction.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter transaction id");
			return false;
		}
			if(bank.equals("")) {
				JOptionPane.showMessageDialog(this,"please enter bank name");
				return false;
			}
		}
		if(Box.getSelectedIndex()==1) {
			if(bank.equals("")) {
			JOptionPane.showMessageDialog(this,"please enter bank name");
			return false;
		}
		if(cheque.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter cheque no");
			return false;
		}
		}
		if(Box.getSelectedIndex()==2) {
			if(dd.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter dd no");
			return false;
		}
			if(bank.equals("")) {
				JOptionPane.showMessageDialog(this,"please enter bank name");
				return false;
			}
		}
		
		
		if(head.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 1");
			return false;
		}
		if(heads2.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 2");
			return false;
		}
		if(heads3.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 3");
			return false;
		}
		if(amt1.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 1");
			return false;
		}
		if(amt2.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 1");
			return false;
		}
		if(amt3.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the fees details in row 1");
			return false;
		}
		if(total.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the total fees");
			return false;
		}
		if(tw.equals("")) {
			JOptionPane.showMessageDialog(this, "please enter the total fees in words");
			return false;
		}
		
		
			
		
		return true;
		
	}
	private void updateTotal() {
    t = amount + amount2 + amount3;
    txt_total.setText(String.valueOf(t));
    
    
	}
	public void displayCash() {
		lbl_dd.setVisible(false);
		lbl_cheque.setVisible(false);
		lbl_transaction.setVisible(false);
		lbl_bank.setVisible(false);
		
		txt_dd.setVisible(false);
		txt_cheque.setVisible(false);
		txt_transaction.setVisible(false);
		txt_bank.setVisible(false);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Page frame = new Add_Page();
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
	public Add_Page() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 800);
		panel_parent = new JPanel();
		panel_parent.setBackground(new Color(0, 206, 209));
		panel_parent.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);


		setContentPane(panel_parent);
		panel_parent.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 267, 833);
		panel_parent.add(panel);
		panel.setLayout(null);
		
		
		JButton btn_home = new JButton(" Home");
		btn_home.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_home.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_home.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Home_page l=new Home_page();
				l.setVisible(true);
				Add_Page.this.dispose();
			}
		});
		btn_home.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\home.png"));
		btn_home.setBackground(new Color(0, 139, 139));
		btn_home.setForeground(new Color(248, 248, 255));
		btn_home.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_home.setBounds(21, 70, 228, 65);
		panel.add(btn_home);
		
		JButton btn_search_record = new JButton("Search Record");
		btn_search_record.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_search_record.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_search_record.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Search_Page l=new Search_Page();
				l.setVisible(true);
				Add_Page.this.dispose();
				
			}
		});
		btn_search_record.setForeground(new Color(248, 248, 255));
		btn_search_record.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\search2.png"));
		btn_search_record.setForeground(new Color(248, 248, 255));
		btn_search_record.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_search_record.setBackground(new Color(0, 139, 139));
		btn_search_record.setBounds(21, 163, 228, 70);
		panel.add(btn_search_record);
		
		JButton btn_view = new JButton("View All Record");
		btn_view.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_view.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_view.setBackground(c);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				View_records l=new View_records();
				l.setVisible(true);
				Add_Page.this.dispose();
			}
		});
		
		btn_view.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\view all record.png"));
		btn_view.setForeground(new Color(248, 248, 255));
		btn_view.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_view.setBackground(new Color(0, 139, 139));
		btn_view.setBounds(21, 287, 228, 70);
		panel.add(btn_view);
		
		JButton btn_back = new JButton("Back");
		btn_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_back.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_back.setBackground(c);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Home_page l=new Home_page();
				l.setVisible(true);
				Add_Page.this.dispose();
			}
		});
		
		btn_back.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\back1.png"));
		btn_back.setForeground(new Color(248, 248, 255));
		btn_back.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_back.setBackground(new Color(0, 139, 139));
		btn_back.setBounds(21, 392, 228, 70);
		panel.add(btn_back);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_logout.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_logout.setBackground(c);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Page.this.dispose();
			}
		});
		
		btn_logout.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\logout.png"));
		btn_logout.setForeground(new Color(248, 248, 255));
		btn_logout.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_logout.setBackground(new Color(0, 139, 139));
		btn_logout.setBounds(21, 506, 228, 70);
		panel.add(btn_logout);
		
		JLabel lbl_receipt = new JLabel("Receipt No : ");
		lbl_receipt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_receipt.setBounds(293, 28, 122, 27);
		panel_parent.add(lbl_receipt);
		
		txt_receipt = new JTextField();
		txt_receipt.setBounds(381, 32, 96, 23);
		panel_parent.add(txt_receipt);
		txt_receipt.setColumns(10);
		
		JLabel lbl_mode = new JLabel("Mode of Payment :");
		lbl_mode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_mode.setBounds(293, 84, 122, 27);
		panel_parent.add(lbl_mode);
		
		JLabel lbl_date = new JLabel("Date :");
		lbl_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_date.setBounds(663, 37, 87, 18);
		panel_parent.add(lbl_date);
		
		txt_date = new JTextField();
		txt_date.setBounds(717, 33, 147, 21);
		panel_parent.add(txt_date);
		txt_date.setColumns(10);
		
		JLabel lbl_received = new JLabel("Received from:");
		lbl_received.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_received.setBounds(293, 235, 108, 27);
		panel_parent.add(lbl_received);
		
		txt_received = new JTextField();
		txt_received.setBounds(411, 238, 261, 25);
		panel_parent.add(txt_received);
		txt_received.setColumns(10);
		
		JLabel lbl_year = new JLabel("Year :");
		lbl_year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_year.setBounds(293, 286, 56, 27);
		panel_parent.add(lbl_year);
		
		txt_year = new JTextField();
		txt_year.setBounds(373, 289, 147, 25);
		panel_parent.add(txt_year);
		txt_year.setColumns(10);
		
		JLabel lbl_course = new JLabel("Course :");
		lbl_course.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course.setBounds(293, 337, 168, 27);
		panel_parent.add(lbl_course);
		
		JLabel lbl_adm = new JLabel("Admission No :");
		lbl_adm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_adm.setBounds(652, 290, 108, 18);
		panel_parent.add(lbl_adm);
		
		txt_adm = new JTextField();
		txt_adm.setBounds(755, 286, 109, 27);
		panel_parent.add(txt_adm);
		txt_adm.setColumns(10);
		
		Box = new JComboBox();
		Box.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Box.getSelectedIndex()==1) {
					lbl_cheque.setVisible(true);
					txt_cheque.setVisible(true);
					lbl_bank.setVisible(true);
					txt_bank.setVisible(true);
				}
				else if(Box.getSelectedIndex()==2) {
					lbl_dd.setVisible(true);
					txt_dd.setVisible(true);
					lbl_bank.setVisible(true);
					txt_bank.setVisible(true);
				}
				else if(Box.getSelectedIndex()==3) {
					lbl_transaction.setVisible(true);
					txt_transaction.setVisible(true);
					lbl_bank.setVisible(true);
					txt_bank.setVisible(true);
				}
			}
		});
		Box.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Box.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Cheque", "DD", "Net Banking", "UPI ID"}));
		Box.setBounds(432, 89, 96, 21);
		panel_parent.add(Box);
		
		
		lbl_cheque = new JLabel("Cheque No :");
		lbl_cheque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cheque.setBounds(293, 133, 108, 27);
		panel_parent.add(lbl_cheque);
		
		txt_transaction = new JTextField();
		txt_transaction.setBounds(421, 134, 222, 27);
		panel_parent.add(txt_transaction);
		txt_transaction.setColumns(10);
		
		lbl_dd = new JLabel("DD :");
		lbl_dd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dd.setBounds(293, 133, 122, 27);
		panel_parent.add(lbl_dd);
		
		lbl_transaction = new JLabel("Transaction No :");
		lbl_transaction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_transaction.setBounds(293, 133, 122, 27);
		panel_parent.add(lbl_transaction);
		
		lbl_bank = new JLabel("Bank Name :");
		lbl_bank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_bank.setBounds(293, 183, 108, 18);
		panel_parent.add(lbl_bank);
		
		txt_bank = new JTextField();
		txt_bank.setBounds(421, 178, 222, 27);
		panel_parent.add(txt_bank);
		txt_bank.setColumns(10);
		JPanel panel_child = new JPanel();
		panel_child.setBackground(new Color(0, 206, 209));
		panel_child.setBounds(285, 215, 716, 572);
		panel_parent.add(panel_child);
		panel_child.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 172, 706, 28);
		panel_child.add(separator);
		
		JLabel lbl_course_1 = new JLabel("Sr No :");
		lbl_course_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_1.setBounds(10, 172, 168, 27);
		panel_child.add(lbl_course_1);
		
		JLabel lbl_course_2 = new JLabel("Heads");
		lbl_course_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_2.setBounds(253, 172, 168, 27);
		panel_child.add(lbl_course_2);
		
		JLabel lbl_course_3 = new JLabel("Amount");
		lbl_course_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_3.setBounds(516, 171, 190, 27);
		panel_child.add(lbl_course_3);
		
		txt_head = new JTextField();
		txt_head.setColumns(10);
		txt_head.setBounds(160, 210, 261, 25);
		panel_child.add(txt_head);
		
		txt_amount1 = new JTextField();
		
		txt_amount1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount=Float.parseFloat(txt_amount1.getText());
				updateTotal();
				
			}
		});
		txt_amount1.setColumns(10);
		txt_amount1.setBounds(495, 210, 168, 27);
		panel_child.add(txt_amount1);
		
		txt_amount2 = new JTextField();
		
		txt_amount2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount2=Float.parseFloat(txt_amount2.getText());
				updateTotal();
			}
		});
		txt_amount2.setColumns(10);
		txt_amount2.setBounds(495, 270, 168, 27);
		panel_child.add(txt_amount2);
		
		txt_amount3 = new JTextField();
		
		txt_amount3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount3=Float.parseFloat(txt_amount3.getText());
				updateTotal();
			}
		});
		txt_amount3.setColumns(10);
		txt_amount3.setBounds(495, 321, 168, 27);
		panel_child.add(txt_amount3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(495, 358, 168, 2);
		panel_child.add(separator_1);
		
		txt_total = new JTextField();
				
		txt_total.setColumns(10);
		txt_total.setBounds(495, 377, 168, 27);
		panel_child.add(txt_total);
		updateTotal();
		
		
		
		
		
		
		lbl_tw= new JLabel("Total in words");
		lbl_tw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tw.setBounds(10, 384, 109, 20);
		panel_child.add(lbl_tw);
		
		txt_total_words = new JTextField();
		txt_total_words.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_total_words.setText(NumberConverter.convert((int)t));
			}
		});
		txt_total_words.setBounds(110, 377, 335, 27);
		panel_child.add(txt_total_words);
		txt_total_words.setColumns(10);
		
		
		Box_1 = new JComboBox();
		
		Box_1.setBounds(86, 124, 355, 26);
		panel_child.add(Box_1);
		Box_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Box_1.setMaximumRowCount(20);
		fillComboBox();
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(495, 467, 168, 2);
		panel_child.add(separator_2);
		
		JLabel lblNewLabel_1 = new JLabel("Receiver Signature");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(516, 479, 168, 27);
		panel_child.add(lblNewLabel_1);
		txt_head2 = new JTextField();
		txt_head2.setBounds(160, 270, 261, 24);
		panel_child.add(txt_head2);
		txt_head2.setColumns(10);
		JButton btn_print = new JButton("Print");
		btn_print.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(validation()==true) {
					JOptionPane.showMessageDialog(Add_Page.this,"validation successful");
					String rs=insertData();
					if(rs.equals("success")) {
						JOptionPane.showMessageDialog(Add_Page.this,"Data inserted successfully");
					}
					else {
						JOptionPane.showMessageDialog(Add_Page.this,"Data insertion failed");
					}
				}
			}
		});
		
		btn_print.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_print.setBounds(531, 516, 85, 21);
		panel_child.add(btn_print);
		
		
		
		txt_heads3 = new JTextField();
		txt_heads3.setBounds(160, 325, 261, 23);
		panel_child.add(txt_heads3);
		txt_heads3.setColumns(10);
		
		txt_cheque = new JTextField();
		txt_cheque.setBounds(424, 133, 219, 25);
		panel_parent.add(txt_cheque);
		txt_cheque.setColumns(10);
		
		txt_dd = new JTextField();
		txt_dd.setBounds(424, 135, 219, 23);
		panel_parent.add(txt_dd);
		txt_dd.setColumns(10);
		displayCash();
		int receipt=getreceipt();
		txt_receipt.setText(Integer.toString(receipt));
	}
}
