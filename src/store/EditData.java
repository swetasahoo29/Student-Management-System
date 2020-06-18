package store;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditData extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_dob;
	private JTextField txt_regd_no;
	private JTextField txt_course;
	private JTextField txt_id;
	private JTextField txt_totalpayment;
	private JTextField txt_totalpaid;
	private JTextField txt_totaldues;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditData frame = new EditData("");
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
	public EditData(String username_id) {
		System.out.println("Passed data : " + username_id);
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 629);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("ADMIN PLEASE UPDATE THE STUDENT'S DATA...");
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
		lblNewLabel_4.setBounds(72, 280, 85, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("COURSE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(72, 329, 69, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(72, 375, 69, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("TOTAL_PAYMENT");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(72, 426, 156, 20);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("TOTAL_PAID");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(72, 476, 107, 20);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("TOTAL_DUES");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setBounds(72, 512, 120, 20);
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
		txt_regd_no.setBounds(257, 280, 397, 26);
		contentPane.add(txt_regd_no);
		txt_regd_no.setColumns(10);

		txt_course = new JTextField();
		txt_course.setBounds(257, 326, 397, 26);
		contentPane.add(txt_course);
		txt_course.setColumns(10);

		txt_id = new JTextField();
		txt_id.setBounds(257, 372, 397, 26);
		contentPane.add(txt_id);
		txt_id.setColumns(10);

		txt_totalpayment = new JTextField();
		txt_totalpayment.setBounds(257, 423, 397, 26);
		contentPane.add(txt_totalpayment);
		txt_totalpayment.setColumns(10);

		txt_totalpaid = new JTextField();
		txt_totalpaid.setBounds(257, 473, 397, 26);
		contentPane.add(txt_totalpaid);
		txt_totalpaid.setColumns(10);

		txt_totaldues = new JTextField();
		txt_totaldues.setBounds(257, 520, 397, 26);
		contentPane.add(txt_totaldues);
		txt_totaldues.setColumns(10);

		createConnection();
		try {
			String query = "SELECT * FROM STUDENT WHERE NAME='" + username_id + "' OR ID='" + username_id + "'";
			PreparedStatement pat = con.prepareStatement(query);
			ResultSet rs = pat.executeQuery();
			while (rs.next()) {

				txt_username.setText(rs.getString("name"));
				txt_password.setText(rs.getString("password"));
				txt_dob.setText(rs.getString("dob"));
				txt_regd_no.setText(rs.getString("regd_no"));
				txt_course.setText(rs.getString("course"));
				txt_id.setText(rs.getString("id"));
				txt_totalpayment.setText(rs.getString("total_payment"));
				txt_totalpaid.setText(rs.getString("total_paid"));
				txt_totaldues.setText(rs.getString("total_dues"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Button button = new Button("SUBMIT");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
					String dbop = "UPDATE STUDENT SET NAME='" + name + "', PASSWORD='" + pass + "', DOB='" + dob
							+ "', REGD_NO='" + regdno + "', COURSE='" + course + "', ID='" + id + "', TOTAL_PAYMENT="
							+ payment + ", TOTAL_PAID=" + total_paid + ", TOTAL_DUES=" + total_dues + " WHERE (NAME='"
							+ username_id + "')" + " OR (ID='" + username_id + "')";
					stmt.executeUpdate(dbop);
					JOptionPane.showMessageDialog(null, "Databse updated");
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
