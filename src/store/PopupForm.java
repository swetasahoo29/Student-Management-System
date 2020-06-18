package store;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class PopupForm extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_dob;
	private JTextField txt_regd_no;
	private JTextField txt_course;
	private JTextField txt_totalpaid;
	private JTextField txt_totaldues;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupForm frame = new PopupForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	Statement stmt = null;

	void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stms", "root", "qwerty123");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);
			// Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
			// null,ex);
		} catch (SQLException ex) {
			// Logger.getLogger(Main.class.getName()).log(Level.SEVERE,
			// null,ex);
			System.out.println(ex);
		}

	}

	/**
	 * Create the frame.
	 */
	public PopupForm() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 629);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMIN PLEASE INSERT THE STUDENT'S DATA...");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(302, 26, 591, 39);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(72, 146, 107, 20);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(72, 194, 107, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("DOB");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(72, 244, 69, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("REGD_NO");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(72, 290, 85, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("COURSE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(72, 339, 69, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_8 = new JLabel("TOTAL_PAID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(72, 392, 107, 20);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("TOTAL_DUES");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(72, 452, 120, 20);
		contentPane.add(lblNewLabel_9);

		txt_username = new JTextField();
		txt_username.setBounds(257, 143, 397, 26);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		txt_password = new JTextField();
		txt_password.setBounds(257, 191, 397, 26);
		contentPane.add(txt_password);
		txt_password.setColumns(10);

		txt_dob = new JTextField();
		txt_dob.setBounds(257, 241, 397, 26);
		contentPane.add(txt_dob);
		txt_dob.setColumns(10);

		txt_regd_no = new JTextField();
		txt_regd_no.setBounds(257, 287, 397, 26);
		contentPane.add(txt_regd_no);
		txt_regd_no.setColumns(10);

		txt_course = new JTextField();
		txt_course.setBounds(257, 336, 397, 26);
		contentPane.add(txt_course);
		txt_course.setColumns(10);

		txt_totalpaid = new JTextField();
		txt_totalpaid.setBounds(257, 389, 397, 26);
		contentPane.add(txt_totalpaid);
		txt_totalpaid.setColumns(10);

		txt_totaldues = new JTextField();
		txt_totaldues.setBounds(257, 449, 397, 26);
		contentPane.add(txt_totaldues);
		txt_totaldues.setColumns(10);

		Button button = new Button("SUBMIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// DataBase store
				createConnection();
				try {
					String name = txt_username.getText();
					String pass = txt_password.getText();
					String dob = txt_dob.getText();
					String regdno = txt_regd_no.getText();
					String course = txt_course.getText();
					String id = regdno + course;
					int payment = 2300000;
					int total_paid = Integer.parseInt(txt_totalpaid.getText());
					int total_dues = Integer.parseInt(txt_totaldues.getText());
					stmt = con.createStatement();
					String dbop = "INSERT INTO STUDENT(name,password,dob,regd_no,course,id,total_payment,total_paid,total_dues)"
							+ " VALUES('" + name + "','" + pass + "','" + dob + "','" + regdno + "','" + course + "','"
							+ id + "'," + payment + "," + total_paid + "," + total_dues + ")";
					stmt.executeUpdate(dbop);
					String insert_up = "INSERT INTO USERS(username,password) VALUES('" + name + "','" + pass + "')";
					stmt.executeUpdate(insert_up);
					JOptionPane.showMessageDialog(null, "Added to database !!");
					stmt.close();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			}
		});
		button.setBackground(Color.BLACK);
		button.setFont(new Font("Dialog", Font.BOLD, 17));
		button.setBounds(745, 512, 180, 34);
		contentPane.add(button);
	}
}
