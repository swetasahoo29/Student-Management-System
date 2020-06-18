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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class StudentPage extends JFrame {

	private JPanel contentPane;
	private JTextField txt_paytutionfees;
	String name, id, dob, regdno = null, course = null;
	int total_payment = 0, total_dues = 0, total_paid = 0;

	/**
	 * Launch the application.
	 */
	Connection con;
	Statement stmt = null;

	void createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/stms", "root", "qwerty123");
		} catch (ClassNotFoundException ex) {
			System.out.println(ex);

		} catch (SQLException ex) {

			System.out.println(ex);
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentPage frame = new StudentPage();
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
	public StudentPage() {

		name = Username.getLogin_name();

		try {
			createConnection();
			stmt = con.createStatement();
			String query = "SELECT REGD_NO,COURSE,TOTAL_PAYMENT,TOTAL_DUES,TOTAL_PAID FROM STUDENT WHERE NAME=" + "'"
					+ name + "'";
			ResultSet st = stmt.executeQuery(query);

			if (st.next() != false) {
				regdno = st.getString("regd_no");
				course = st.getString("course");
				total_payment = Integer.parseInt(st.getString("total_payment"));
				total_dues = Integer.parseInt(st.getString("total_dues"));
				total_paid = Integer.parseInt(st.getString("total_paid"));
			} else {
				// Need to handle this
			}
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e.toString());
		}
		setBackground(new Color(255, 255, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 926, 687);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel txt_username = new JLabel("Name  :\t" + name);
		txt_username.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_username.setForeground(Color.WHITE);
		txt_username.setBounds(303, 90, 279, 57);
		contentPane.add(txt_username);

		JLabel txt_regdno = new JLabel("Regd No.:" + regdno);
		txt_regdno.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_regdno.setForeground(Color.WHITE);
		txt_regdno.setBounds(300, 163, 300, 55);

		contentPane.add(txt_regdno);

		JLabel txt_courseoffered = new JLabel("Branch :\t" + course);
		txt_courseoffered.setForeground(Color.WHITE);
		txt_courseoffered.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_courseoffered.setBounds(303, 243, 247, 41);
		contentPane.add(txt_courseoffered);

		JLabel lblNewLabel_2 = new JLabel(String.valueOf(total_payment));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(548, 311, 153, 20);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(String.valueOf(total_paid));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(548, 364, 111, 20);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(String.valueOf(total_dues));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(548, 400, 111, 20);
		contentPane.add(lblNewLabel_4);
		JLabel txt_payment = new JLabel("Amount to be Paid : ");
		txt_payment.setBackground(Color.BLACK);
		txt_payment.setFont(new Font("Tahoma", Font.BOLD, 20));
		txt_payment.setForeground(Color.WHITE);
		txt_payment.setBounds(102, 488, 217, 41);
		contentPane.add(txt_payment);

		txt_paytutionfees = new JTextField();
		txt_paytutionfees.setBounds(360, 494, 207, 33);
		contentPane.add(txt_paytutionfees);
		txt_paytutionfees.setColumns(10);

		JLabel lblNewLabel = new JLabel(" HELLO " + name + " !!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.LIGHT_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(314, 16, 288, 33);
		contentPane.add(lblNewLabel);

		Button cmd_pay = new Button("PAY");
		cmd_pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createConnection();

				try {
					stmt = con.createStatement();
					int amount = Integer.parseInt(txt_paytutionfees.getText().toString());
					if (amount > total_payment && amount > total_dues) {
						JOptionPane.showMessageDialog(null, "Sorry!! Invalid Amount");
					} else if (total_paid < total_payment) {
						total_paid += amount;
						total_dues = total_payment - total_paid;
						// JOptionPane.showMessageDialog(null, "total_dues");
						String qu = "UPDATE STUDENT SET TOTAL_PAID = " + total_paid + " , TOTAL_DUES = " + total_dues
								+ " WHERE NAME=" + "'" + name + "'";
						stmt.executeUpdate(qu);
						JOptionPane.showMessageDialog(null, "Database updated!!!");
						stmt.close();
					}
				} catch (SQLException e1) {
					System.out.println("updateError" + e1.toString());
				}
			}
		});

		cmd_pay.setForeground(Color.BLACK);
		cmd_pay.setFont(new Font("Dialog", Font.BOLD, 20));
		cmd_pay.setBounds(649, 500, 91, 27);
		contentPane.add(cmd_pay);

		JLabel lblNewLabel_1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Admin-icon.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(50, 59, 199, 138);
		contentPane.add(lblNewLabel_1);

		JLabel lbltotalpayment = new JLabel("Total_Payment :");
		lbltotalpayment.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbltotalpayment.setForeground(Color.WHITE);
		lbltotalpayment.setBounds(303, 310, 163, 20);
		contentPane.add(lbltotalpayment);

		JLabel lbltotalpaid = new JLabel("Total_Paid :");
		lbltotalpaid.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbltotalpaid.setForeground(Color.WHITE);
		lbltotalpaid.setBounds(313, 359, 143, 20);
		contentPane.add(lbltotalpaid);

		JLabel lbltotaldues = new JLabel(" Total_Dues :");
		lbltotaldues.setFont(new Font("Tahoma", Font.BOLD, 19));
		lbltotaldues.setForeground(Color.WHITE);
		lbltotaldues.setBounds(303, 398, 143, 20);
		contentPane.add(lbltotaldues);

	}
}
