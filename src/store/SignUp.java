package store;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField txt_password;
	private JTextField txt_regdno;
	private JTextField txt_dob;
	private JTextField txt_courseoffered;
	private JTextField txt_totalpaid;

	/**
	 * Launch the application.
	 */
	Connection con;
	Statement stmt = null;
	private JTextField txt_totaldues;

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

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {// wait
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setBackground(new Color(153, 255, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 634);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(167, 42, 251, 49);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("     NEW USER");
		lblNewLabel.setBounds(0, 0, 251, 49);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 30));

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_1.setBounds(40, 149, 142, 20);
		contentPane.add(lblNewLabel_1);

		txt_username = new JTextField();
		txt_username.setBounds(266, 148, 287, 26);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword.setBounds(41, 344, 142, 20);
		contentPane.add(lblPassword);

		txt_password = new JPasswordField();
		txt_password.setBounds(266, 343, 287, 26);
		contentPane.add(txt_password);

		txt_regdno = new JTextField();
		txt_regdno.setBounds(266, 196, 287, 26);
		contentPane.add(txt_regdno);
		txt_regdno.setColumns(10);

		txt_dob = new JTextField();
		txt_dob.setBounds(266, 246, 287, 26);
		contentPane.add(txt_dob);
		txt_dob.setColumns(10);

		txt_courseoffered = new JTextField();
		txt_courseoffered.setBounds(266, 292, 287, 26);
		contentPane.add(txt_courseoffered);
		txt_courseoffered.setColumns(10);

		txt_totalpaid = new JTextField();
		txt_totalpaid.setBounds(266, 391, 287, 26);
		contentPane.add(txt_totalpaid);
		txt_totalpaid.setColumns(10);

		txt_totaldues = new JTextField();
		txt_totaldues.setBounds(266, 444, 287, 26);
		contentPane.add(txt_totaldues);
		txt_totaldues.setColumns(10);

		Button cmd_createaccount = new Button("Create Account");
		cmd_createaccount.setFont(new Font("Dialog", Font.BOLD, 17));
		cmd_createaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createConnection();
				try {
					String name = txt_username.getText();
					String pass = txt_password.getText();
					String dob = txt_dob.getText();
					String regdno = txt_regdno.getText();
					String course = txt_courseoffered.getText();
					int payment = 2300000;
					String id = regdno + course;
					int total_paid = Integer.parseInt(txt_totalpaid.getText());
					int total_dues = Integer.parseInt(txt_totaldues.getText());
					stmt = con.createStatement();
					String dbop = "INSERT INTO STUDENT(name,password,dob,regd_no,course,id,total_payment,total_paid,total_dues)"
							+ " VALUES('" + name + "','" + pass + "','" + dob + "','" + regdno + "','" + course + "','"
							+ id + "'," + payment + "," + total_paid + "," + total_dues + ")";
					stmt.executeUpdate(dbop);
					String insert_up = "INSERT INTO USERS(username,password) VALUES('" + name + "','" + pass + "')";
					stmt.executeUpdate(insert_up);// fine
					JOptionPane.showMessageDialog(null, "Added to database !!");
					stmt.close();
					LoginJava lg = new LoginJava();
					lg.setVisible(true);
				} catch (SQLException e) {

					System.out.println(e.getMessage());
				}

			}
		});
		cmd_createaccount.setBackground(Color.PINK);
		cmd_createaccount.setBounds(398, 493, 129, 35);
		contentPane.add(cmd_createaccount);

		JLabel lblNewLabel_3 = new JLabel("New label");
		Image img = new ImageIcon(this.getClass().getResource("/signup-icon.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(616, 69, 264, 203);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Regd.No");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_4.setBounds(40, 197, 174, 20);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Total_dues");
		lblNewLabel_5.setBackground(new Color(0, 51, 153));
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_5.setBounds(40, 444, 151, 20);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DOB");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_6.setBounds(40, 247, 69, 20);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Course Offered");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel_7.setBounds(40, 293, 173, 20);
		contentPane.add(lblNewLabel_7);

		JLabel lblGeneratedId = new JLabel("Total_paid");
		lblGeneratedId.setForeground(Color.WHITE);
		lblGeneratedId.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblGeneratedId.setBounds(40, 392, 185, 20);
		contentPane.add(lblGeneratedId);

		JLabel lblNewLabel_2 = new JLabel("Total_dues");
		lblNewLabel_2.setBounds(41, 447, 69, 20);
		contentPane.add(lblNewLabel_2);
	}
}
