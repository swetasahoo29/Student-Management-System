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
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class NewAdminPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtDob;
	private JTextField txtCourse;
	private JTextField txtRegdno;
	private JScrollPane scrollPane;
	private JTable table;

	String[] columnNames = { "USERNAME", "PASSWORD", "DOB", "REGD_NO", "COURESE", "ID", "total_payment", "total_paid",
			"total_dues" };

	private ArrayList<Username> arraylist = new ArrayList<>();
	Username username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewAdminPage frame = new NewAdminPage();
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
	public NewAdminPage() {
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1140, 696);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtId = new JTextField();
		txtId.setBackground(new Color(102, 255, 255));
		txtId.setText("ID");
		txtId.setBounds(15, 137, 146, 26);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(102, 255, 255));
		txtUsername.setText("Username");
		txtUsername.setBounds(15, 179, 146, 26);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBackground(new Color(102, 255, 255));
		txtPassword.setText("Password");
		txtPassword.setBounds(15, 221, 146, 26);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);

		txtDob = new JTextField();
		txtDob.setBackground(new Color(102, 255, 255));
		txtDob.setText("DOB");
		txtDob.setBounds(15, 269, 146, 26);
		contentPane.add(txtDob);
		txtDob.setColumns(10);

		txtCourse = new JTextField();
		txtCourse.setBackground(new Color(102, 255, 255));
		txtCourse.setText("Course");
		txtCourse.setBounds(15, 311, 146, 26);
		contentPane.add(txtCourse);
		txtCourse.setColumns(10);

		txtRegdno = new JTextField();
		txtRegdno.setBackground(new Color(102, 255, 255));
		txtRegdno.setText("Regd_no");
		txtRegdno.setBounds(15, 353, 146, 26);
		contentPane.add(txtRegdno);
		txtRegdno.setColumns(10);

		Button button = new Button("INSERT");
		button.setBackground(new Color(175, 238, 238));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PopupForm obj = new PopupForm();
				obj.setVisible(true);
			}
		});

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, "", null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "USERNAME", "PASSWORD", "DOB", "REGD_NO", "COURSE", "ID", "total_payment", "total_paid",
						"total_dues" }) {

			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { Float.class, Float.class, Float.class, Integer.class, String.class,
					String.class, String.class, String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		createConnection();

		try {
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columnNames);
			String query = "SELECT * FROM STUDENT";
			PreparedStatement pat = con.prepareStatement(query);
			ResultSet rs = pat.executeQuery();

			while (rs.next()) {
				username = new Username(rs.getString("name"), rs.getString("password"), rs.getString("dob"),
						rs.getString("regd_no"), rs.getString("course"), rs.getString("id"), rs.getInt("total_payment"),
						rs.getInt("total_paid"), rs.getInt("total_dues"));
				System.out.println();
				arraylist.add(username);
			}

			// DbUtils.resultSetToTableModel(rs)
			Object[] rowData = new Object[9];

			System.out.println("ArrayList size : " + arraylist.size());
			for (int i = 0; i < arraylist.size(); i++) {
				rowData[0] = arraylist.get(i).getName();
				rowData[1] = arraylist.get(i).getPassword();
				rowData[2] = arraylist.get(i).getDob();
				rowData[3] = arraylist.get(i).getRegd_no();
				rowData[4] = arraylist.get(i).getCourse();
				rowData[5] = arraylist.get(i).getId();
				rowData[6] = arraylist.get(i).getTotal_payment();
				rowData[7] = arraylist.get(i).getTotal_paid();
				rowData[8] = arraylist.get(i).getTotal_dues();

				model.addRow(rowData);
			}
			table.setModel(model);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		button.setBounds(15, 468, 146, 27);
		contentPane.add(button);

		Button button_1 = new Button("DELETE");
		button_1.setBackground(new Color(175, 238, 238));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete obj = new Delete();
				obj.setVisible(true);
			}
		});
		button_1.setBounds(15, 515, 146, 27);
		contentPane.add(button_1);

		Button button_2 = new Button("UPDATE");
		button_2.setBackground(new Color(175, 238, 238));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPopup edit = new EditPopup();
				edit.setVisible(true);
			}
		});
		button_2.setBounds(15, 557, 146, 27);
		contentPane.add(button_2);

		JLabel lblNewLabel = new JLabel("Hello Admin!!!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 206, 209));
		lblNewLabel.setBounds(488, 27, 183, 20);
		contentPane.add(lblNewLabel);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(231, 83, 857, 525);
		contentPane.add(scrollPane);

		scrollPane.setViewportView(table);
	}
}
//
// @SuppressWarnings("rawtypes")
/*
 * public Class getColumnClass(int columnIndex) { return
 * columnTypes[columnIndex]; }
 */

//
