package store;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditPopup extends JFrame {

	private JPanel contentPane;
	private JTextField txt_username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPopup frame = new EditPopup();
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
	public EditPopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 428);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEnterTheUsername = new JLabel("ENTER THE USERNAME OR ID WHOSE DATA  TO BE UPDATED");
		lblEnterTheUsername.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEnterTheUsername.setForeground(Color.WHITE);
		lblEnterTheUsername.setBounds(42, 78, 608, 51);
		contentPane.add(lblEnterTheUsername);

		txt_username = new JTextField();
		txt_username.setBounds(236, 200, 218, 26);
		contentPane.add(txt_username);
		txt_username.setColumns(10);

		Button update = new Button();
		update = new Button("UPDATE");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditData obj = new EditData(txt_username.getText().toString());
				obj.setVisible(true);
			}
		});
		update.setBackground(Color.BLACK);
		update.setBounds(281, 287, 91, 27);
		contentPane.add(update);

	}

}
