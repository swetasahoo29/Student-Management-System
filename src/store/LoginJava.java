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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class LoginJava extends JFrame {
	Connection conn = null;
	Statement stmt = null;
	ResultSet RS = null;
	PreparedStatement PST = null;
	boolean isexists = false;
	private JPanel contentPane;
	private JTextField txt_username;
	private JPasswordField passwordField;
	private JPasswordField txt_password;

	/**
	 * Launch the application.
	 */

	void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stms", "root", "qwerty123");
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
					LoginJava frame = new LoginJava();
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
	public LoginJava() {
		setFont(new Font("Dialog", Font.BOLD, 22));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 814, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(122, 159, 93, 20);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBounds(122, 243, 93, 20);
		contentPane.add(lblNewLabel_1);

		txt_username = new JTextField();
		txt_username.setBounds(243, 156, 270, 26);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(444, 240, -154, 26);
		contentPane.add(passwordField);

		txt_password = new JPasswordField();
		txt_password.setBounds(243, 240, 270, 26);
		contentPane.add(txt_password);

		Button Cmd_login = new Button("Login");
		Cmd_login.setFont(new Font("Dialog", Font.BOLD, 17));
		Cmd_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String uname = txt_username.getText();
				String pass = txt_password.getText();
				try {
					createConnection();
					stmt = conn.createStatement();
					ResultSet RS = stmt.executeQuery("SELECT * from USERS");
					while (RS.next()) {
						if (uname.equals(RS.getString("username"))) {
							if (pass.equals(RS.getString("password"))) {
								isexists = true;
								Username.setLogin_name(RS.getString("username"));
								JOptionPane.showMessageDialog(null, " Successfully Logged In!!! ");
								StudentPage obj3 = new StudentPage();
								obj3.setVisible(true);
								break;
							} else {
								isexists = true;
								JOptionPane.showMessageDialog(null, " Incorrect Password  ");
							}
						} else {
							isexists = false;
						}
					}
					if (!isexists) {
						JOptionPane.showMessageDialog(null, " Student not exists! ");
					}
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		Cmd_login.setBackground(Color.PINK);
		Cmd_login.setBounds(422, 309, 91, 27);
		contentPane.add(Cmd_login);

		JLabel txt_loginpage = new JLabel("    LOGIN  PAGE");
		txt_loginpage.setLabelFor(this);
		txt_loginpage.setForeground(new Color(75, 0, 130));
		txt_loginpage.setFont(new Font("Dialog", Font.BOLD, 30));
		txt_loginpage.setBackground(new Color(255, 204, 153));
		txt_loginpage.setBounds(235, 55, 297, 45);
		contentPane.add(txt_loginpage);

		Button cmd_signup = new Button("Signup");
		cmd_signup.setFont(new Font("Dialog", Font.BOLD, 17));
		cmd_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp obj2 = new SignUp();
				obj2.setVisible(true);

			}
		});
		cmd_signup.setBackground(new Color(102, 255, 204));
		cmd_signup.setBounds(422, 365, 91, 27);
		contentPane.add(cmd_signup);

		Button cmd_admin = new Button("Admin");
		cmd_admin.setFont(new Font("Dialog", Font.BOLD, 17));
		cmd_admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String uname = txt_username.getText();
				String pass = txt_password.getText();
				if (uname.equals("admin") && pass.equals("pass")) {
					JOptionPane.showMessageDialog(null, " Successfully Logged In!!! ");
					NewAdminPage obj = new NewAdminPage();
					obj.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, " Incorrect Username or Password ");
				}

			}
		});
		cmd_admin.setBackground(Color.PINK);
		cmd_admin.setBounds(266, 309, 91, 27);
		contentPane.add(cmd_admin);

		JLabel lblDonotHaveAn = new JLabel("Donot have an account?");
		lblDonotHaveAn.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDonotHaveAn.setBounds(132, 372, 274, 20);
		contentPane.add(lblDonotHaveAn);

		JLabel lblNewLabel_2 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/App-login-manager-icon.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img));
		lblNewLabel_2.setBounds(547, 43, 156, 193);
		contentPane.add(lblNewLabel_2);
	}
}
