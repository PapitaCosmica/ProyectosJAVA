package Bibidi;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Bu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bu frame = new Bu();
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
	public Bu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(170, 10, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(170, 39, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
			
		
		
		JButton btnNewButton = new JButton("Suma");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				
			}
		});
		btnNewButton.setBounds(181, 187, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("P. Numero ");
		lblNewLabel.setBounds(92, 13, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2. Numero");
		lblNewLabel_1.setBounds(92, 42, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(170, 68, 96, 19);
		contentPane.add(textPane);
		
	
	}
}
