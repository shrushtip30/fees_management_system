package fees_management_system;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home_page frame = new Home_page();
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
	public Home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 206, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
	    setVisible(true);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(-29, 0, 1020, 182);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Saraswati College ");
		lblNewLabel.setFont(new Font("Georgia", lblNewLabel.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel.setBounds(315, 10, 461, 61);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("of");
		lblNewLabel_1.setFont(new Font("Georgia", lblNewLabel_1.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel_1.setBounds(464, 65, 162, 40);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Engineering");
		lblNewLabel_2.setFont(new Font("Georgia", lblNewLabel_2.getFont().getStyle() | Font.BOLD, 45));
		lblNewLabel_2.setBounds(365, 115, 286, 54);
		panel.add(lblNewLabel_2);
		
		JButton btn_addfees = new JButton("Add Fees  ");
		btn_addfees.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Add_Page add=new Add_Page();
				add.setVisible(true);;
				Home_page.this.dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_addfees.setBackground(c);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_addfees.setBackground(c);
			}
		});
		
		btn_addfees.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_addfees.setForeground(new Color(248, 248, 255));
		btn_addfees.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\plus.png"));
		btn_addfees.setBackground(new Color(0, 139, 139));
		btn_addfees.setBounds(48, 213, 248, 156);
		contentPane.add(btn_addfees);
		
		JButton btn_search = new JButton("Search Record");
		btn_search.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_search.setBackground(c);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_search.setBackground(c);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Search_Page search=new Search_Page();
				search.setVisible(true);
				Home_page.this.dispose();
				
			}
		});
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_search.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\search-document.png"));
		btn_search.setBackground(new Color(0, 139, 139));
		btn_search.setForeground(new Color(248, 248, 255));
		btn_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_search.setBounds(366, 213, 280, 156);
		contentPane.add(btn_search);
		
		JButton btn_view = new JButton("View All Records");
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
				Home_page.this.dispose();
			}
		});
		
		btn_view.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_view.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\view all record.png"));
		btn_view.setBackground(new Color(0, 139, 139));
		btn_view.setForeground(new Color(248, 248, 255));
		btn_view.setBounds(706, 213, 275, 156);
		contentPane.add(btn_view);
	
		
		JButton btn_logout = new JButton("Logout");
		btn_logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Color c=new Color(0,103,103);
				btn_logout.setBackground(c);
			}
			public void mouseExited(MouseEvent e) {
				Color c=new Color(0,153,153);
				btn_logout.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_page l=new Login_page();
				l.setVisible(true);
				Home_page.this.dispose();
			}
		});
		
		btn_logout.setIcon(new ImageIcon("C:\\Users\\Shrushti\\Downloads\\my icons\\my icons\\logout.png"));
		btn_logout.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btn_logout.setForeground(new Color(248, 248, 255));
		btn_logout.setBackground(new Color(0, 139, 139));
		btn_logout.setBounds(10, 482, 195, 65);
		contentPane.add(btn_logout);
	}
}
