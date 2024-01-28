package asdads;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField ProdN;
	private JTextField ProdP;
	private JTextField ProdD;
	private JTable table;
	private JTextField Idd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("Conectar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Class.forName("com.mysql.jdbc.Driver");
				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root","utom");
				JOptionPane.showMessageDialog(null, "Conectado");
					
				
			}catch (Exception r) {
				System.out.println("Error");
				r.printStackTrace();
			}
			}
		});
		btnNewButton_3.setBounds(341, 9, 85, 21);
		contentPane.add(btnNewButton_3);
		
		table = new JTable();
		table.setBounds(66, 166, 261, 43);
		contentPane.add(table);
		
		ProdP = new JTextField();
		ProdP.setBounds(220, 39, 96, 19);
		contentPane.add(ProdP);
		ProdP.setColumns(10);
		
		ProdN = new JTextField();
		ProdN.setBounds(220, 10, 96, 19);
		contentPane.add(ProdN);
		ProdN.setColumns(10);
		
		ProdD = new JTextField();
		ProdD.setBounds(220, 68, 96, 19);
		contentPane.add(ProdD);
		ProdD.setColumns(10);
		
		Idd = new JTextField();
		Idd.setBounds(198, 120, 50, 19);
		contentPane.add(Idd);
		Idd.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(108, 13, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Precio");
		lblNewLabel_1.setBounds(118, 42, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Desc");
		lblNewLabel_2.setBounds(108, 71, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
                 
				
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root","utom");
				
				String nombre = ProdN.getText();
				String desc = ProdD.getText();
				int precio = Integer.parseInt(ProdP.getText());
				String query = "INSERT INTO articulos values ("+null+",'"+nombre+"','"+precio+"','"+desc+"')";
				
				
				java.sql.Statement stmt = con.createStatement();
				stmt.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Prod Agregado correctamente");
			}catch (Exception r) {
				System.out.println("Error");
				r.printStackTrace();
			}
			}
		});
		btnNewButton.setBounds(30, 119, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Consultar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = new DefaultTableModel();
				
				model.addColumn("id");
				model.addColumn("Nombre");
				model.addColumn("Precio");
				model.addColumn("Descripcion");
				
				table.setModel(model);
				
				String[] dato = new String[4];
				String juan = "SELECT * FROM articulos";
				try {
					  Class.forName("com.mysql.jdbc.Driver");
	                    Connection cont = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "utom");
	                    Statement stmt = cont.createStatement();

	                    String query = "SELECT * FROM articulos";

	                    ResultSet rs = stmt.executeQuery(query);

	                    StringBuilder productos = new StringBuilder();
	                    while (rs.next()) {
	                        int id = rs.getInt("id_prod");
	                        String nombre = rs.getString("nombre_prod");
	                        int precio = rs.getInt("precio_prod");
	                        String descripcion = rs.getString("detalles_prod");
	                    
	                        productos.append(id).append("\t").append(nombre).append("\t").append(precio).append("\t")
	                                .append(descripcion).append("\t");
	                    }
	                    JTextArea textArea = new JTextArea(productos.toString());
	                    JOptionPane.showMessageDialog(null, textArea, "Productos", JOptionPane.PLAIN_MESSAGE);
	
			} catch (Exception r) {
				System.out.println("Error");
				r.printStackTrace();
			}
			}
		});
		btnNewButton_1.setBounds(258, 119, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Eliminar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try {
	                    Class.forName("com.mysql.jdbc.Driver");
	                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto", "root", "utom");
	                    int id = Integer.parseInt(Idd.getText());

	                    String query = "DELETE FROM articulos WHERE id_prod = " + id;

	                    Statement stmt = con.createStatement();

	                    int resultado = stmt.executeUpdate(query);
	                    
	                    if (resultado == 1) {
	                        JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "No se encontró un producto con el ID ingresado");
	                    }
				 } catch (Exception r) {
	                    System.out.println("No conectado");
	                    r.printStackTrace();
	                }
				
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(351, 119, 85, 21);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_3 = new JLabel("Id");
		lblNewLabel_3.setBounds(188, 123, 25, 13);
		contentPane.add(lblNewLabel_3);
	}

}
