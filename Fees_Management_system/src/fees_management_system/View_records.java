package fees_management_system;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class View_records extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable tbl_fees;
	String rcpt,name,adm,course,payment;
	Float amount;
	DefaultTableModel m;

	/**
	 * Launch the application.
	 */
	public void search() {
		m=(DefaultTableModel)tbl_fees.getModel();
		TableRowSorter<DefaultTableModel> trs=new TableRowSorter<>(m);
		tbl_fees.setRowSorter(trs);
		
	}
	public void setrecords() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/management";
            String username = "root";
            String pass = "password";
			Connection con1=DriverManager.getConnection(url,username,pass);
			PreparedStatement p=con1.prepareStatement("Select * from fees_details");
			ResultSet rs=p.executeQuery();
			while(rs.next()) {
				String rcpt=rs.getString("reciept_no");
				String name=rs.getString("student_name");
				String adm=rs.getString("adm_no");
				String course=rs.getString("courses");
				String payment=rs.getString("payment_mode");
				float amount=rs.getFloat("total_amount");
				
				Object[] obj = {rcpt,name,adm,course,payment,amount};
				m=(DefaultTableModel) tbl_fees.getModel();
				m.addRow(obj);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_records frame = new View_records();
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
	public View_records() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1288, 835);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 267, 833);
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
			public void mouseClicked(MouseEvent e) {
				Home_page l=new Home_page();
				l.setVisible(true);
				View_records.this.dispose();
			}
		});
		btn_home.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\home.png"));
		btn_home.setForeground(new Color(248, 248, 255));
		btn_home.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_home.setBackground(new Color(0, 139, 139));
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
				View_records l=new View_records();
				l.setVisible(true);
				View_records.this.dispose();
			}
			
		});
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
			
		});
		btn_view.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\view all record.png"));
		btn_view.setForeground(new Color(248, 248, 255));
		btn_view.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_view.setBackground(new Color(0, 139, 139));
		btn_view.setBounds(21, 277, 228, 70);
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
			public void mouseClicked(MouseEvent e) {
				Home_page l=new Home_page();
				l.setVisible(true);
				View_records.this.dispose();
			}
			
		});
		btn_back.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\back1.png"));
		btn_back.setForeground(new Color(248, 248, 255));
		btn_back.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_back.setBackground(new Color(0, 139, 139));
		btn_back.setBounds(21, 396, 228, 70);
		panel.add(btn_back);
		
		JButton btn_logout = new JButton("Logout");
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
				View_records.this.dispose();
			}
			
		});
		btn_logout.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\logout.png"));
		btn_logout.setForeground(new Color(248, 248, 255));
		btn_logout.setFont(new Font("Georgia", Font.PLAIN, 17));
		btn_logout.setBackground(new Color(0, 139, 139));
		btn_logout.setBounds(21, 517, 228, 70);
		panel.add(btn_logout);
		
		tbl_fees = new JTable();
		tbl_fees.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Receipt_No.", "Name", "Adm_No", "Course", "Payment", "Amount"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		// Create a JScrollPane and add the table to it
		JScrollPane scrollPane = new JScrollPane(tbl_fees);
		scrollPane.setBounds(291, 36, 932, 558);

		// Add the JScrollPane (which contains the table) to the contentPane
		contentPane.add(scrollPane);
		setrecords();
		
		

		
	}
	}

