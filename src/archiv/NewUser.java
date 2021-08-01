package archiv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtn;
	private JPasswordField txtp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setResizable(false);
		setTitle("                    Nouveau Utilisateur");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null); 
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNom.setBounds(10, 90, 46, 20);
		contentPane.add(lblNom);
		
		JLabel lblPassword = new JLabel("Mot de Passe:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(10, 129, 77, 20);
		contentPane.add(lblPassword);
		
		JButton btnCreer = new JButton("Creer");
		btnCreer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = txtn.getText();
				String p = txtp.getText();
				String t = "utilisateur";
				
				
				try{ 
					Connection conn =Functions.dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=databasename", "user", "password");
					
						PreparedStatement insert= conn.prepareStatement("INSERT INTO  "+t+"(name, password) VALUES('"+n+"','"+p+"')");
						insert.executeUpdate();
						JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Bien Creer!","Bravo",JOptionPane.INFORMATION_MESSAGE);
					    setVisible(false);
			
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
					;
				}
			}
		});
		btnCreer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCreer.setBounds(186, 196, 89, 27);
		contentPane.add(btnCreer);
		
		txtn = new JTextField();
		txtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtn.setBounds(128, 90, 217, 25);
		contentPane.add(txtn);
		txtn.setColumns(10);
		
		txtp = new JPasswordField();
		txtp.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtp.setColumns(10);
		txtp.setBounds(128, 126, 217, 25);
		contentPane.add(txtp);
	}

}
