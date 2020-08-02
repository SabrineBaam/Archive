package archiv;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JComboBox;

public class Login extends JFrame {

	public static JPanel contentPane;
	private JTextField txtname;
	private JTextField textServ;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("            Login");
		setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 485, 396);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		setLocationRelativeTo(null); 
		JComboBox<String> Cb_dataBase=new JComboBox<String>();;
		
		JLabel lblUtilisateur = new JLabel("Utilisateur:");
		lblUtilisateur.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblUtilisateur.setBounds(10, 163, 89, 24);
		contentPane.add(lblUtilisateur);
		
		JLabel lblPassword = new JLabel("Mot de passe:");
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPassword.setBounds(10, 214, 81, 24);
		contentPane.add(lblPassword);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtname.setBounds(109, 159, 245, 27);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnConnecetr = new JButton("Login");
		btnConnecetr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n = txtname.getText();
				String p = txtpass.getText();
	
				String nam =null;
				String pass= null;
				try{
					Connection conn =Functions.dbConnect("jdbc:sqlserver://"+textServ.getText()+";databaseName="+Cb_dataBase.getSelectedItem().toString(), "sa", "SabrineBaam");
					PreparedStatement search= conn.prepareStatement("SELECT * FROM utilisateur WHERE name like  '"+n+"'");
					ResultSet rs = search.executeQuery();
	
					
					while(rs.next()){
						nam = rs.getString("name");
						pass = rs.getString("password");
					}
					
					if(n.equals(nam) && p.equals(pass)){
						Archiv.main(null);
					}
					else JOptionPane.showMessageDialog(contentPane,"Mot de passe/nom utilisateur incorrect!","Attention",JOptionPane.ERROR_MESSAGE);
				}catch(Exception e){
				JOptionPane.showMessageDialog(contentPane,"Requet error"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConnecetr.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnConnecetr.setBounds(276, 270, 126, 27);
		contentPane.add(btnConnecetr);
		
		JLabel lblNewLabel = new JLabel("Nouveau Utilisateur");
		lblNewLabel.setForeground(Color.BLACK);
		
		lblNewLabel.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewUser.main(null);
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblNewLabel.setForeground(Color.RED);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				contentPane.setCursor(cursor);

			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblNewLabel.setForeground(Color.BLACK);
				Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
				contentPane.setCursor(cursor);

			}
		});
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 332, 208, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePass = new JLabel("Mot de Passe Oubli\u00E9");
		lblMotDePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMotDePass.setForeground(Color.RED);
				Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
				contentPane.setCursor(cursor);
				
			}
		
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblMotDePass.setForeground(Color.BLACK);
				Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
				contentPane.setCursor(cursor);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ReintPass.main(null);
			}
		});
		lblMotDePass.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMotDePass.setBounds(316, 332, 166, 24);
		contentPane.add(lblMotDePass);
		
		JButton btnCancel = new JButton("Quiter");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCancel.setBounds(56, 270, 126, 27);
		contentPane.add(btnCancel);
		
		JLabel lblDatabase = new JLabel("DataBase:");
		lblDatabase.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDatabase.setBounds(10, 116, 89, 24);
		contentPane.add(lblDatabase);
		
		JLabel lblServer = new JLabel("Server:");
		lblServer.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblServer.setBounds(10, 66, 89, 24);
		contentPane.add(lblServer);
		
		textServ = new JTextField();
		textServ.setText("127.0.0.1");
		textServ.setFont(new Font("Times New Roman", Font.BOLD, 16));
		textServ.setColumns(10);
		textServ.setBounds(109, 66, 245, 27);
		contentPane.add(textServ);
		
	
		Cb_dataBase.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				String db_connect_string="jdbc:sqlserver://"+textServ.getText()+";databaseName=Archive";
				 String db_userid="sa";
		         String db_password="SabrineBaam";
		  Connection conn=null;
		   try {
		      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		      conn = DriverManager.getConnection(db_connect_string,db_userid, db_password);
		     
		      
		      DatabaseMetaData meta = conn.getMetaData();
		      ResultSet res = meta.getCatalogs();
		     
		      while (res.next()) {
		
		         Cb_dataBase.addItem(res.getString("TABLE_CAT"));
		      }
		      res.close();
		   } catch (Exception e) {
			      e.printStackTrace();
			   }
			}
		});
	
	
		Cb_dataBase.setBounds(109, 116, 245, 24);
		contentPane.add(Cb_dataBase);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(109, 211, 245, 27);
		contentPane.add(txtpass);
	}
}
