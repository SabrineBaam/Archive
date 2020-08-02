package archiv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class ReintPass extends JFrame {

	private JPanel contentPane;
	private JTextField usrtxt;
	private JPasswordField psstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReintPass frame = new ReintPass();
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
	public ReintPass() {
		setResizable(false);
		setTitle("           Reinitialisation de mot de pass");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur:");
		lblNomDutilisateur.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNomDutilisateur.setBounds(10, 90, 129, 20);
		contentPane.add(lblNomDutilisateur);
		
		usrtxt = new JTextField();
		usrtxt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		usrtxt.setColumns(10);
		usrtxt.setBounds(190, 88, 213, 25);
		contentPane.add(usrtxt);
		setLocationRelativeTo(null); 
		JLabel lblNouvelleMotDe = new JLabel("Nouvelle mot de passe:");
		lblNouvelleMotDe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNouvelleMotDe.setBounds(10, 129, 170, 20);
		contentPane.add(lblNouvelleMotDe);
		
		psstxt = new JPasswordField();
		psstxt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		psstxt.setColumns(10);
		psstxt.setBounds(190, 124, 213, 25);
		contentPane.add(psstxt);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user= usrtxt.getText();
				String p = psstxt.getText();
				try
			    {
			      Connection con=Functions.dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=Archive", "sa", "SabrineBaam");
			      String query = "update utilisateur set password = '"+p+"' where name = '"+user+"'";
			      PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.executeUpdate();
			      JOptionPane.showMessageDialog(contentPane,"Bien Modifier!","Bravo",JOptionPane.INFORMATION_MESSAGE);
			    }
			    catch (Exception e)
			    {
			      JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
			    }
			
			}
		});
		btnModifier.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnModifier.setBounds(166, 183, 107, 27);
		contentPane.add(btnModifier);
	}
}
