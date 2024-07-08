package fees_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JSeparator;

public class Print_Receipt extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel txt_no;
	
	private JLabel txt_bank;
	private JLabel txt_receipt;
	private JLabel txt_date;
	private JLabel txt_received;
	private JLabel txt_year;
	private JLabel txt_mode;
	private JLabel txt_adm;
	private JLabel txt_course;
	private JLabel txt_head1;
	private JLabel txt_head2;
	private JLabel txt_head3;
	private JLabel txt_amount1;
	private JLabel txt_amount2;
	private JLabel txt_amount3;
	private JLabel txt_total;
	private JLabel txt_tw;
	private JLabel lbl_cheque;
	private JLabel lbl_dd;
	private JLabel lbl_transaction;
	private JPanel panel_3;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public void getRecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			PreparedStatement p=con1.prepareStatement("Select * from fees_details order by reciept_no desc LIMIT 1 ");
			ResultSet rs=p.executeQuery();
			rs.next();
			txt_receipt.setText(rs.getString("reciept_no"));
			txt_mode.setText(rs.getString("payment_mode"));
			if(txt_mode.getText().equals("Cheque")) {
				txt_no.setText(rs.getString("cheque_no"));
				txt_bank.setText(rs.getString("bank_name"));
				lbl_cheque.setVisible(true);
				lbl_dd.setVisible(false);
				lbl_transaction.setVisible(false);
			}
			if(txt_mode.getText().equals("DD")) {
				txt_no.setText(rs.getString("dd_no"));
				txt_bank.setText(rs.getString("bank_name"));
				lbl_cheque.setVisible(false);
				lbl_dd.setVisible(true);
				lbl_transaction.setVisible(false);
			}
			if(txt_mode.getText().equals("Net Banking")) {
				txt_no.setText(rs.getString("transaction_no"));
				txt_bank.setText(rs.getString("bank_name"));
				lbl_cheque.setVisible(false);
				lbl_dd.setVisible(false);
				lbl_transaction.setVisible(true);
			}
			if(txt_mode.getText().equals("Cash")) {
				
				lbl_cheque.setVisible(false);
				lbl_dd.setVisible(false);
				lbl_transaction.setVisible(false);
			}
			if(txt_mode.getText().equals("UPI")) {
				txt_bank.setText(rs.getString("bank_name"));
				txt_no.setText(rs.getString("transaction_no"));
				lbl_cheque.setVisible(false);
				lbl_dd.setVisible(false);
				lbl_transaction.setVisible(true);
			}
			txt_date.setText(rs.getString("date"));
			txt_received.setText(rs.getString("student_name"));
			txt_year.setText(rs.getString("year"));
			txt_adm.setText(rs.getString("adm_no"));
			txt_course.setText(rs.getString("courses"));
			txt_head1.setText(rs.getString("head1"));
			txt_head2.setText(rs.getString("head2"));
			txt_head3.setText(rs.getString("head3"));
			txt_amount1.setText(rs.getString("amount1"));
			txt_amount2.setText(rs.getString("amount2"));
			txt_amount3.setText(rs.getString("amount3"));
			txt_total.setText(rs.getString("total_amount"));
			txt_tw.setText(rs.getString("total_in_words"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Print_Receipt frame = new Print_Receipt();
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
	public Print_Receipt() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 930);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 271, 864);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 139, 139));
		contentPane.add(panel);
		
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
		});
		btn_home.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\home.png"));
		btn_home.setForeground(new Color(248, 248, 255));
		btn_home.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_home.setBackground(new Color(0, 139, 139));
		btn_home.setBounds(10, 29, 228, 65);
		panel.add(btn_home);
		
		JButton btn_search_record = new JButton("Search Record");
		btn_search_record.addMouseListener(new MouseAdapter() {
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
		});
		btn_search_record.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\search2.png"));
		btn_search_record.setForeground(new Color(248, 248, 255));
		btn_search_record.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_search_record.setBackground(new Color(0, 139, 139));
		btn_search_record.setBounds(10, 122, 228, 70);
		panel.add(btn_search_record);
		
		JButton btn_course_list = new JButton("Course List");
		btn_course_list.addMouseListener(new MouseAdapter() {
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
		});
		btn_course_list.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\list.png"));
		btn_course_list.setForeground(new Color(248, 248, 255));
		btn_course_list.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_course_list.setBackground(new Color(0, 139, 139));
		btn_course_list.setBounds(10, 219, 228, 70);
		panel.add(btn_course_list);
		
		JButton btn_edit = new JButton("Edit Courses");
		btn_edit.addMouseListener(new MouseAdapter() {
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
		});
		btn_edit.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\edit2.png"));
		btn_edit.setForeground(new Color(248, 248, 255));
		btn_edit.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_edit.setBackground(new Color(0, 139, 139));
		btn_edit.setBounds(10, 315, 228, 70);
		panel.add(btn_edit);
		
		JButton btn_view = new JButton("View All Record");
		btn_view.addMouseListener(new MouseAdapter() {
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
		});
		btn_view.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\view all record.png"));
		btn_view.setForeground(new Color(248, 248, 255));
		btn_view.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_view.setBackground(new Color(0, 139, 139));
		btn_view.setBounds(10, 416, 228, 70);
		panel.add(btn_view);
		
		JButton btn_back = new JButton("Back");
		btn_back.addMouseListener(new MouseAdapter() {
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
		});
		btn_back.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\back1.png"));
		btn_back.setForeground(new Color(248, 248, 255));
		btn_back.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_back.setBackground(new Color(0, 139, 139));
		btn_back.setBounds(10, 514, 228, 70);
		panel.add(btn_back);
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
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
		});
		btn_logout.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\logout.png"));
		btn_logout.setForeground(new Color(248, 248, 255));
		btn_logout.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_logout.setBackground(new Color(0, 139, 139));
		btn_logout.setBounds(10, 616, 228, 70);
		panel.add(btn_logout);
		
		JButton btn_logout_1 = new JButton("Print");
		btn_logout_1.addMouseListener(new MouseAdapter() {
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
				PrinterJob job = PrinterJob.getPrinterJob();
			    job.setJobName("Print Data");
			    
			    job.setPrintable(new Printable() {
			        public int print(Graphics pg, PageFormat pf, int pageNum) {
			            pf.setOrientation(PageFormat.LANDSCAPE);
			            if (pageNum > 0) {
			                return Printable.NO_SUCH_PAGE;
			            }
			            
			            Graphics2D g2 = (Graphics2D)pg;
			            g2.translate(pf.getImageableX(), pf.getImageableY());
			            
			            // Calculate the width and height of each panel
			            int panelWidth = (int)pf.getImageableWidth() / 2;
			            int panelHeight = (int)pf.getImageableHeight();
			            
			            // Print panel_2 on the left half of the page
			            g2.setClip(0, 0, panelWidth, panelHeight);
			            panel_2.print(g2);
			            
			            // Print panel_3 on the right half of the page
			            g2.translate(panelWidth, 0);
			            g2.setClip(panelWidth, 0, panelWidth, panelHeight);
			            panel_3.print(g2);
			            
			            return Printable.PAGE_EXISTS;
			        }
			    });
			    
			    boolean ok = job.printDialog();
			    if (ok) {
			        try {
			            job.print();
			        } catch (PrinterException ex) {
			            ex.printStackTrace();
			        }
			    }
			}});
		btn_logout_1.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\printer-.png"));
		btn_logout_1.setForeground(new Color(248, 248, 255));
		btn_logout_1.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_logout_1.setBackground(new Color(0, 139, 139));
		btn_logout_1.setBounds(10, 715, 228, 70);
		panel.add(btn_logout_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1220, 860, 10, 10);
		contentPane.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(285, 10, 716, 158);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Shrushti\\eclipse-workspace\\Fees_Management_system\\src\\fees_management_system\\my icons\\download.jpeg"));
		lblNewLabel_3.setBounds(6, 10, 214, 136);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Saraswati College ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(288, 0, 461, 61);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("of");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(359, 55, 162, 40);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" Engineering");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(304, 92, 286, 54);
		panel_2.add(lblNewLabel_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(281, 168, 720, 667);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lbl_receipt = new JLabel("Receipt No : ");
		lbl_receipt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_receipt.setBounds(10, 22, 122, 27);
		panel_3.add(lbl_receipt);
		
		JLabel lbl_mode = new JLabel("Mode of Payment :");
		lbl_mode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_mode.setBounds(10, 68, 122, 27);
		panel_3.add(lbl_mode);
		
		lbl_cheque = new JLabel("Cheque No:");
		lbl_cheque.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_cheque.setBounds(10, 116, 122, 27);
		panel_3.add(lbl_cheque);
		
		lbl_dd = new JLabel("DD No.");
		lbl_dd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_dd.setBounds(10, 116, 122, 22);
		panel_3.add(lbl_dd);
		
		lbl_transaction = new JLabel("Transaction No:");
		lbl_transaction.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_transaction.setBounds(10, 116, 122, 22);
		panel_3.add(lbl_transaction);
		
		JLabel lbl_bank = new JLabel("Bank Name:");
		lbl_bank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_bank.setBounds(10, 153, 122, 27);
		panel_3.add(lbl_bank);
		
		JLabel lbl_date = new JLabel("Date :");
		lbl_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_date.setBounds(417, 22, 87, 18);
		panel_3.add(lbl_date);
		
		JLabel lbl_received = new JLabel("Received from:");
		lbl_received.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_received.setBounds(10, 190, 108, 27);
		panel_3.add(lbl_received);
		
		JLabel lbl_year = new JLabel("Year :");
		lbl_year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_year.setBounds(10, 239, 56, 27);
		panel_3.add(lbl_year);
		
		JLabel lbl_course = new JLabel("Course :");
		lbl_course.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course.setBounds(10, 289, 168, 27);
		panel_3.add(lbl_course);
		
		JLabel lbl_adm = new JLabel("Admission No :");
		lbl_adm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_adm.setBounds(417, 243, 108, 18);
		panel_3.add(lbl_adm);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 325, 720, 28);
		panel_3.add(separator);
		
		JLabel lbl_course_1 = new JLabel("Sr No :");
		lbl_course_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_1.setBounds(10, 326, 168, 27);
		panel_3.add(lbl_course_1);
		
		JLabel lbl_course_2 = new JLabel("Heads");
		lbl_course_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_2.setBounds(258, 326, 168, 27);
		panel_3.add(lbl_course_2);
		
		JLabel lbl_course_3 = new JLabel("Amount");
		lbl_course_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_course_3.setBounds(546, 327, 190, 27);
		panel_3.add(lbl_course_3);
		
		JLabel lbl_tw = new JLabel("Total in words");
		lbl_tw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tw.setBounds(10, 533, 109, 20);
		panel_3.add(lbl_tw);
		
		JLabel lblNewLabel_1_1 = new JLabel("Receiver Signature");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(542, 608, 168, 27);
		panel_3.add(lblNewLabel_1_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(495, 551, 168, 2);
		panel_3.add(separator_1);
		
		txt_receipt = new JLabel("New label");
		txt_receipt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_receipt.setBounds(99, 24, 108, 22);
		panel_3.add(txt_receipt);
		
		txt_mode = new JLabel("New label");
		txt_mode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_mode.setBounds(135, 68, 144, 22);
		panel_3.add(txt_mode);
		
		txt_no = new JLabel("New label");
		txt_no.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_no.setBounds(135, 118, 231, 22);
		panel_3.add(txt_no);
		
		 txt_bank = new JLabel("New label");
		txt_bank.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_bank.setBounds(135, 155, 271, 22);
		panel_3.add(txt_bank);
		
		 txt_received = new JLabel("New label");
		txt_received.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_received.setBounds(135, 192, 271, 22);
		panel_3.add(txt_received);
		
		txt_year = new JLabel("New label");
		txt_year.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_year.setBounds(135, 241, 108, 22);
		panel_3.add(txt_year);
		
		 txt_course = new JLabel("New label");
		txt_course.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_course.setBounds(135, 291, 271, 22);
		panel_3.add(txt_course);
		
		 txt_date = new JLabel("New label");
		txt_date.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_date.setBounds(490, 22, 108, 22);
		panel_3.add(txt_date);
		
		 txt_adm = new JLabel("New label");
		txt_adm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_adm.setBounds(535, 241, 108, 22);
		panel_3.add(txt_adm);
		
		 txt_head1 = new JLabel("New label");
		txt_head1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_head1.setBounds(233, 363, 271, 22);
		panel_3.add(txt_head1);
		
		 txt_head2 = new JLabel("New label");
		txt_head2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_head2.setBounds(233, 414, 271, 22);
		panel_3.add(txt_head2);
		
		 txt_head3 = new JLabel("New label");
		txt_head3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_head3.setBounds(233, 469, 271, 22);
		panel_3.add(txt_head3);
		
		 txt_amount1 = new JLabel("New label");
		txt_amount1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_amount1.setBounds(521, 363, 199, 22);
		panel_3.add(txt_amount1);
		
		 txt_amount2 = new JLabel("New label");
		txt_amount2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_amount2.setBounds(521, 414, 199, 22);
		panel_3.add(txt_amount2);
		
		 txt_amount3 = new JLabel("New label");
		txt_amount3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_amount3.setBounds(521, 469, 199, 22);
		panel_3.add(txt_amount3);
		
		 txt_tw = new JLabel("New label");
		txt_tw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_tw.setBounds(123, 531, 350, 22);
		panel_3.add(txt_tw);
		
		 txt_total = new JLabel("New label");
		txt_total.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txt_total.setBounds(521, 513, 199, 22);
		panel_3.add(txt_total);
		getRecords();
		
	}
}
