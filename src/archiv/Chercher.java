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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;

public class Chercher extends JFrame {

	public static JPanel contentPane;
	private JButton btnChercher;
	public static JFormattedTextField txtnum;
	public static JFormattedTextField txtann;
	public static JComboBox chcb;
	public static JComboBox dirccb;
	public static JComboBox sercomcb;
	public static JComboBox wylcb;
	public static JComboBox typch;
	private JLabel lblDateDe;
	public static JFormattedTextField dated;
	private JLabel label_5;
	public static JFormattedTextField datef;
	public static JCheckBox chck;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Chercher frame = new Chercher();
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
	public Chercher() {
		setTitle("Recherche");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 645, 333);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null); 
		JLabel lblChercherPar = new JLabel("Chercher par:");
		lblChercherPar.setFont(new Font("Times New Roman", Font.BOLD, 16));
		chcb = new JComboBox();
		chcb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		chcb.setModel(new DefaultComboBoxModel(new String[] {"", "Expediteur", "Destinataire"}));
		chcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!chcb.getSelectedItem().toString().equals("Date")) {
					dated.setEnabled(false);
					datef.setEnabled(false);	
				}
				
}
		});
		
		JLabel label = new JLabel("N\u00B0:");
		label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtnum = new JFormattedTextField(Functions.createFormatter("#####"));
		txtnum.setToolTipText("00000");
		txtnum.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtnum.setColumns(10);
		
		JLabel label_1 = new JLabel("Direction:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		dirccb = new JComboBox();
		dirccb.setModel(new DefaultComboBoxModel(new String[] {"", "DTN", "MICL", "DRAG"}));
		dirccb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel label_2 = new JLabel("Service/Commune:");
		label_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		sercomcb = new JComboBox();
		sercomcb.setModel(new DefaultComboBoxModel(new String[] {"", "SG", "DGTN", "DGMDADTDS", "CABINET", "SOG", "STARNS"}));
		sercomcb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel label_3 = new JLabel("Wilaya:");
		label_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		wylcb = new JComboBox();
		wylcb.setModel(new DefaultComboBoxModel(new String[] {"", "Adrar", "Chlef", "Laghouat", "Oum El-Bouaghi", "Batna", "B\u00E9ja\u00EFa", "Biskra", "B\u00E9char", "Blida", "Bouira", "Tamanrasset", "T\u00E9bessa", "Tlemcen", "Tiaret", "Tizi Ouzou", "Alger", "Djelfa", "Jijel", "S\u00E9tif", "Saida", "Skikda", "Sidi Bel Abbes", "Annaba", "Guelma", "Constantine", "M\u00E9d\u00E9a", "Mostaganem", "M'Sila", "Mascara", "Ouargla", "Oran", "El-Bayadh", "Illizi", "Bord-Bou-Arr\u00E9ridj", "Boumerd\u00E8s", "El-Taref", "Tindouf", "Tissemsilt", "El Oued", "Khenchela", "Souk Ahras", "Tipaza", "Mila", "A\u00EFn Defla", "Na\u00E2ma", "A\u00EFn T\u00E9mouchent", "Gharda\u00EFa", "Relizane"}));
		wylcb.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		JLabel label_4 = new JLabel("Ann\u00E9e:");
		label_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		txtann = new JFormattedTextField(Functions.createFormatter("####"));
		txtann.setToolTipText("yyyy");
		txtann.setFont(new Font("Times New Roman", Font.BOLD, 16));
		txtann.setColumns(10);
		btnChercher = new JButton("Chercher");
		btnChercher.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnChercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Table.main(null);
				
			}
		});
		
		JLabel lblTypeDeDocument = new JLabel("Type de document a chercher:");
		lblTypeDeDocument.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		typch = new JComboBox();
		typch.setModel(new DefaultComboBoxModel(new String[] {"", "Telegram", "Lettre"}));
		typch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		
		lblDateDe = new JLabel("Date de:");
		lblDateDe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		dated = new JFormattedTextField(Functions.createFormatter("####-##-##"));
		dated.setToolTipText("yyyy-mm-dd");
		dated.setFont(new Font("Times New Roman", Font.BOLD, 16));
		dated.setColumns(10);
		dated.setEnabled(false);
		
		label_5 = new JLabel("\u00E0:");
		label_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		
		datef = new JFormattedTextField(Functions.createFormatter("####-##-##"));
		datef.setToolTipText("yyyy-mm-dd");
		datef.setFont(new Font("Times New Roman", Font.BOLD, 16));
		datef.setColumns(10);
		datef.setEnabled(false);
		
		chck = new JCheckBox("");
		chck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chck.isSelected()) {
					dated.setEnabled(true); 
					datef.setEnabled(true);
					txtann.setEnabled(false);
					txtnum.setEnabled(false);
				}else {
					dated.setEnabled(false); 
					datef.setEnabled(false);
					txtann.setEnabled(true);
					txtnum.setEnabled(true);
				}
			}
		});
		chck.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblTypeDeDocument, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(typch, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblChercherPar)
					.addGap(10)
					.addComponent(chcb, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblDateDe, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
					.addGap(14)
					.addComponent(chck, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(dated, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addGap(4)
					.addComponent(datef, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(71)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
					.addGap(54)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(label_4))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(36)
					.addComponent(txtnum, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addComponent(dirccb, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addComponent(sercomcb, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(wylcb, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(2)
					.addComponent(txtann, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(263)
					.addComponent(btnChercher, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTypeDeDocument, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(typch, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblChercherPar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(chcb, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDateDe, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(2)
							.addComponent(chck, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
						.addComponent(dated, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(datef, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(3)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtnum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dirccb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(sercomcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(wylcb, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtann, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(45)
					.addComponent(btnChercher, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
