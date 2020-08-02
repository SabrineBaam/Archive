package archiv;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;


public class Archiv {

	public static JFrame frmArchivManagement;
	private JFormattedTextField DistinatAnn;
	private JFormattedTextField DistinatNum;
	private JTextField Subject;
	private JTextField ScanImg;
	public String path;
	public static JLabel statulb = new JLabel("");
	private JFormattedTextField Date;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Archiv window = new Archiv();
					window.frmArchivManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Archiv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArchivManagement = new JFrame();
		frmArchivManagement.setResizable(false);
		frmArchivManagement.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmArchivManagement.setForeground(Color.LIGHT_GRAY);
		frmArchivManagement.setFont(new Font("Times New Roman", Font.BOLD, 14));
		frmArchivManagement.setTitle("Archiv Management");
		frmArchivManagement.setBounds(100, 100, 1000, 481);
		frmArchivManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArchivManagement.setLocationRelativeTo(null); 
		JLabel lblTypeDeDocument = new JLabel("Type de Document:");
		lblTypeDeDocument.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblTypeDeDate = new JLabel("Ann\u00E9e:");
		lblTypeDeDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblDistinateur = new JLabel("Expediteur:");
		lblDistinateur.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblDistinataire = new JLabel("Destinataire:");
		lblDistinataire.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblSujet = new JLabel("Objet:");
		lblSujet.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblLimageScanne = new JLabel("L'image Scann\u00E9e:");
		lblLimageScanne.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox typ = new JComboBox();
		typ.setFont(new Font("Times New Roman", Font.BOLD, 16));
		typ.setModel(new DefaultComboBoxModel(new String[] {"", "Telegram", "Lettre"}));
		
		DistinatAnn = new JFormattedTextField(Functions.createFormatter("####"));
		DistinatAnn.setToolTipText("yyyy");
		
		DistinatAnn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		DistinatAnn.setColumns(10);
		
		DistinatNum = new JFormattedTextField(Functions.createFormatter("#####"));
		DistinatNum.setToolTipText("00000");
		DistinatNum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		DistinatNum.setColumns(10);
		
		Subject = new JTextField();
		Subject.setFont(new Font("Times New Roman", Font.BOLD, 16));
		Subject.setColumns(10);
		
		ScanImg = new JTextField();
		ScanImg.setEditable(false);
		ScanImg.setFont(new Font("Times New Roman", Font.BOLD, 16));
		ScanImg.setColumns(10);
		
		JLabel lblDirection = new JLabel("Direction/Wilaya:");
		lblDirection.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistDircb = new JComboBox();
		DistDircb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DistDircb.setModel(new DefaultComboBoxModel(new String[] {"", "DTN", "MICL", "DRAG"}));
		DistDircb.setToolTipText("");
		
		JLabel lblServicecommune = new JLabel("Service/Commune:");
		lblServicecommune.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistSercb = new JComboBox();
		DistSercb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DistSercb.setModel(new DefaultComboBoxModel(new String[] {"", "SG", "DGTN", "DGMDADTDS", "CABINET", "SOG", "STARNS"}));
		
		JLabel lblNumero = new JLabel("N\u00B0:");
		lblNumero.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel label = new JLabel("Direction:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistinatDircb = new JComboBox();
		DistinatDircb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DistinatDircb.setModel(new DefaultComboBoxModel(new String[] {"", "DTN", "MICL", "DRAG"}));
		
		JLabel label_1 = new JLabel("Service/Commune:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistinatSercb = new JComboBox();
		DistinatSercb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DistinatSercb.setModel(new DefaultComboBoxModel(new String[] {"", "SG", "DGTN", "DGMDADTDS", "CABINET", "SOG", "STARNS"}));
		
		JLabel lblWilaya = new JLabel("Wilaya:");
		lblWilaya.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistinatWylcb = new JComboBox();
		DistinatWylcb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		DistinatWylcb.setModel(new DefaultComboBoxModel(new String[] {"", "Adrar", "Chlef", "Laghouat", "Oum El-Bouaghi", "Batna", "B\u00E9ja\u00EFa", "Biskra", "B\u00E9char", "Blida", "Bouira", "Tamanrasset", "T\u00E9bessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "S\u00E9tif", "Saida", "Skikda", "Sidi Bel Abbes", "Annaba", "Guelma", "Constantine", "M\u00E9d\u00E9a", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El-Bayadh", "Illizi", "Bord-Bou-Arr\u00E9ridj", "Boumerd\u00E8s", "El-Taref", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "A\u00EFn Defla", "Na\u00E2ma", "A\u00EFn T\u00E9mouchent", "Gharda\u00EFa", "Relizane"}));
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		Date = new JFormattedTextField(Functions.createFormatter("####-##-##"));
		Date.setToolTipText("yyyy-mm-dd");
		Date.setColumns(10);
		
		JLabel label_2 = new JLabel("Wilaya:");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JComboBox DistWylcb = new JComboBox();
		DistWylcb.setModel(new DefaultComboBoxModel(new String[] {"", "Adrar", "Chlef", "Laghouat", "Oum El-Bouaghi", "Batna", "B\u00E9ja\u00EFa", "Biskra", "B\u00E9char", "Blida", "Bouira", "Tamanrasset", "T\u00E9bessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "S\u00E9tif", "Saida", "Skikda", "Sidi Bel Abbes", "Annaba", "Guelma", "Constantine", "M\u00E9d\u00E9a", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El-Bayadh", "Illizi", "Bord-Bou-Arr\u00E9ridj", "Boumerd\u00E8s", "El-Taref", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "A\u00EFn Defla", "Na\u00E2ma", "A\u00EFn T\u00E9mouchent", "Gharda\u00EFa", "Relizane"}));
		DistWylcb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		JLabel imgshow = new JLabel("");
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser ch = new JFileChooser(); 
				try {
					ch.showOpenDialog( null);
					File f = ch.getSelectedFile();
					path = f.getAbsolutePath();
					String disn = DistinatNum.getText();
					String disAn = DistinatAnn.getText();
					//System.out.println(path);
					String p= Functions.pathrec(path, disn, disAn);
					File f1 = new File(path);
					File f2 = new File(p); 
					f1.renameTo(f2);
					ScanImg.setText(f2.getAbsolutePath());
					
					ImageIcon imic= new ImageIcon(new ImageIcon(f2.getAbsolutePath()).getImage().getScaledInstance(imgshow.getWidth(), imgshow.getHeight(), Image.SCALE_SMOOTH));
					imgshow.setIcon(imic);
					//System.out.println(f2.getAbsolutePath());
				}catch(Exception e){
					JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Veulliez choisir le document SVP! " ,"Attention",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnUpload.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JButton btnScanner = new JButton("Scanner");
		btnScanner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path ="C:\\Program Files\\Adobe\\Acrobat 6.0\\Acrobat\\Acrobat.exe";
				File file = new File(path);
				try {					  
				       Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
				}catch (Exception e) {
					JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Verifier l'emplacement d'Adobe Acrobat SVP! " ,"Attention",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnScanner.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JFormattedTextField DistNum = new JFormattedTextField(Functions.createFormatter("#####"));
		DistNum.setToolTipText("00000");
		DistNum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		DistNum.setColumns(10);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String type = typ.getSelectedItem().toString();
				String disn = DistinatNum.getText();
				String disdir = DistinatDircb.getSelectedItem().toString();
				String disser = DistinatSercb.getSelectedItem().toString();
				String distw = DistinatWylcb.getSelectedItem().toString();
				String disAn = DistinatAnn.getText();
				String dt = Date.getText();
				String expDir = DistDircb.getSelectedItem().toString();
				String expSer = DistSercb.getSelectedItem().toString();
				String expW = DistWylcb.getSelectedItem().toString();
				String Sub = Subject.getText();
				String si = ScanImg.getText();
				String distnum = DistNum.getText();
				try {
					if(type.equals("") || disn.equals("") || disdir.equals("") || disser.equals("") || distw.equals("") || disAn.equals("") || dt.equals("") || expDir.equals("") || expSer.equals("") || expW.equals("") || Sub.equals("") || si.equals("") || DistNum.equals("")) {
						JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Veulliez Saissir les information correct SVP! ","Attention",JOptionPane.ERROR_MESSAGE);
					} 
					else
					Functions.AddItem(type, disn, disdir, disser, distw,disAn,dt,distnum,expDir,expSer,expW, Sub,si);
					//JOptionPane.showMessageDialog(frmArchivManagement,"Bien Ajouter!","Brave",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
				}
				
				}
		});
		btnAjouter.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		
		statulb.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JButton btncher = new JButton("Chercher");
		btncher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Chercher.main(null);
				
			}
		});
		btncher.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		
		
		JLabel label_3 = new JLabel("N\u00B0:");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		JLabel lblImagePreview = new JLabel("Aper\u00E7u de l'image");
		lblImagePreview.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frmArchivManagement.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(769, Short.MAX_VALUE)
					.addComponent(lblImagePreview, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addGap(80))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTypeDeDocument, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblDistinateur, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblDistinataire, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblSujet, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblLimageScanne))
					.addGap(3)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(1)
												.addComponent(typ, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(3)
												.addComponent(Date, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGap(71)
												.addComponent(lblDirection, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
												.addGap(28)
												.addComponent(lblServicecommune, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
												.addGap(79)
												.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(DistNum, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
												.addGap(7)
												.addComponent(DistDircb, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(DistSercb, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
												.addGap(10)
												.addComponent(DistWylcb, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
													.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
													.addGroup(groupLayout.createSequentialGroup()
														.addGap(71)
														.addComponent(label, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
												.addGap(72)
												.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
												.addGap(6)
												.addComponent(lblWilaya, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
												.addGap(2)
												.addComponent(lblTypeDeDate))
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(DistinatNum, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
												.addGap(9)
												.addComponent(DistinatDircb, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
												.addGap(8)
												.addComponent(DistinatSercb, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
												.addGap(6)
												.addComponent(DistinatWylcb, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
												.addGap(2)
												.addComponent(DistinatAnn, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
											.addComponent(Subject, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
											.addGroup(groupLayout.createSequentialGroup()
												.addComponent(ScanImg, GroupLayout.PREFERRED_SIZE, 321, GroupLayout.PREFERRED_SIZE)
												.addGap(18)
												.addComponent(btnUpload)
												.addGap(31)
												.addComponent(btnScanner, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
										.addGap(10))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(btncher)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(208)
									.addComponent(btnAjouter)))
							.addGap(10)
							.addComponent(imgshow, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(lblTypeDeDocument, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(31)
							.addComponent(lblDistinateur, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(lblDistinataire, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(24)
							.addComponent(lblSujet, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblLimageScanne, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addGap(64)
								.addComponent(typ, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addGap(11)
								.addComponent(Date, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addGap(6)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblDirection, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblServicecommune, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(5)
										.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)))
								.addGap(5)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(1)
										.addComponent(DistNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addComponent(DistDircb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistSercb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistWylcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
								.addGap(7)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblWilaya, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblTypeDeDate, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
								.addGap(3)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(DistinatNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistinatDircb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistinatSercb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistinatWylcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(DistinatAnn, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(9)
								.addComponent(Subject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGap(13)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(ScanImg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnScanner)
									.addComponent(btnUpload))
								.addGap(18)
								.addComponent(btnAjouter))
							.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblImagePreview, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(imgshow, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(19, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(414, Short.MAX_VALUE)
					.addComponent(btncher)
					.addContainerGap())
		);
		frmArchivManagement.getContentPane().setLayout(groupLayout);
	}
}
