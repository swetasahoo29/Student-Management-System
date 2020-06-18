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

public class Delete extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Delete frame = new Delete();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection con;
	Statement stmt = null;
	private Button button;

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
	public Delete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 428);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheUsername = new JLabel("ENTER THE USERNAME OR ID WHOSE DATA IS TO BE DELETED");
		lblEnterTheUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEnterTheUsername.setForeground(Color.WHITE);
		lblEnterTheUsername.setBounds(42, 78, 608, 51);
		contentPane.add(lblEnterTheUsername);

		txt_username = new JTextField();
		txt_username.setBounds(236, 200, 218, 26);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		button = new Button("DELETE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					createConnection();
					String name = txt_username.getText();

					stmt = con.createStatement();// wait
					String dbop = "DELETE FROM STUDENT WHERE NAME=" + "'" + name + "'" + "OR ID='" + name + "'";
					stmt.executeUpdate(dbop);
					JOptionPane.showMessageDialog(null, "Student's data removed successfully!");
					stmt.close();
				} catch (SQLException e1) {
					System.out.println(e1.getMessage());
				}

			}
		});
		button.setBackground(Color.BLACK);
		button.setBounds(281, 287, 91, 27);
		contentPane.add(button);

	}

}
