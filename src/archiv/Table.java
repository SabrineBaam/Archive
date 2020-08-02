package archiv;

import java.awt.EventQueue;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Table extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3329145848531653159L;
	private static JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    Table frame = new Table();
					frame.setVisible(true);
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Table() {
		setResizable(false);
		setTitle("Resutat de Recherche");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 507);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		JLabel lbshow = new JLabel("");
		
		boolean b = true;
		Object [][] o=null;
		read_db d=null;
		String[] columns=null;
       	if(Chercher.chcb.getSelectedItem().toString().equals("Expediteur") && !Chercher.typch.getSelectedItem().toString().equals("")) {
        		String der = Chercher.dirccb.getSelectedItem().toString();
        		String ser = Chercher.sercomcb.getSelectedItem().toString();
        		String wyl = Chercher.wylcb.getSelectedItem().toString();
        		String typ= Chercher.typch.getSelectedItem().toString();
        		String an = Chercher.txtann.getText();
        		String n = Chercher.txtnum.getText();
        		String dd= Chercher.dated.getText();
        		String df = Chercher.datef.getText();
        
  
        		
        		if(Chercher.chck.isSelected()) {
        			try {
        			Connection conn= Functions.dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=Archive", "sa", "SabrineBaam") ;
     		   		d=new read_db(b, o);
     		   		columns = new String[] {"Destinataire","","","","","date","Expiditeur","","","","sub","Image" };
     		   		//System.out.println("dist1dd");
     		   		d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE DistDir = '"+der+"' And DistServ = '"+ser+"' And DistWyl = '"+wyl+"' And Date BETWEEN  '"+dd+"' And '"+df+"'", 12);
         			table  = new JTable(d.val, columns);
     		   		
        		} catch (Exception e) {
    				JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
    			}
        		}
        		
        		if(!der.equals("") && !ser.equals("") && !wyl.equals("") && !an.equals("") && !Chercher.chck.isSelected() ) {
        		try {
        	        //System.out.println(tp);
    			    Connection conn= Functions.dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=Archive", "sa", "SabrineBaam") ;
    		   		d=new read_db(b, o);
    		   		columns = new String[] {"Destinataire","","","","","date","Expiditeur","","","","sub","Image" };
    		   		if(n.contains(" ")) {
    		   			//System.out.println("dist1");
    		   			d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE DistDir = '"+der+"' And DistServ = '"+ser+"' And DistWyl = '"+wyl+"' And Date LIKE '%"+an+"%' ", 12);
        				table  = new JTable(d.val, columns);
    		   		}else {
    		   			//System.out.println("dist2");
    		   			d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE DistNum = '"+n+"' And DistDir = '"+der+"' And DistServ = '"+ser+"' And DistWyl = '"+wyl+"' And Date LIKE '%"+an+"%' ", 12);
        				table  = new JTable(d.val, columns);
    		   		}
    				
    			} catch (Exception e) {
    				JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
    			}  
        	}       
       	} else if(Chercher.chcb.getSelectedItem().toString().equals("Destinataire") && !Chercher.typch.getSelectedItem().toString().equals("")) {
       		String n = Chercher.txtnum.getText();
    		String der = Chercher.dirccb.getSelectedItem().toString();
    		String ser = Chercher.sercomcb.getSelectedItem().toString();
    		String wyl = Chercher.wylcb.getSelectedItem().toString();
    		String an = Chercher.txtann.getText();
    		String typ= Chercher.typch.getSelectedItem().toString();
    		String dd= Chercher.dated.getText();
    		String df = Chercher.datef.getText();
    		if(Chercher.chck.isSelected()) {
    			try {
    			Connection conn= Functions.dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=Archive", "sa", "SabrineBaam") ;
 		   		d=new read_db(b, o);
 		   		columns = new String[] {"Destinataire","","","","","date","Expiditeur","","","","sub","Image" };
 		   		System.out.println("dist1dd");
 		   		d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE DistinatDir = '"+der+"' And DistinatSer = '"+ser+"' And DistinatWyl = '"+wyl+"' And Date BETWEEN  '"+dd+"' And '"+df+"'", 12);
     			table  = new JTable(d.val, columns);
 		   		
    		} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
			}
    		}
    		
    		if(!der.equals("") && !ser.equals("") && !wyl.equals("") && !n.equals("") && !an.equals("") && !Chercher.chck.isSelected() ) {
    		try {
    			//System.out.println(tp);
			    Connection conn= Functions.dbConnect("jdbc:sqlserver://10.30.0.50;databaseName=Archive", "sa","02042008-DTN") ;
		   		d=new read_db(b, o);
		   		columns = new String[] {"Destinataire","","","","","date","Expiditeur","","","","sub","Image" };
		   		if(n.contains(" ")) {
		   			d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE  DistinatDir = '"+der+"' And DistinatSer = '"+ser+"' And DistinatWyl = '"+wyl+"'  And DistinatAnn LIKE '%"+an+"%'", 12);
					table  = new JTable(d.val, columns);
		   		}else {
		   			d=Functions.read_from_db(conn, "SELECT * FROM  "+typ+" WHERE DistinatNum = '"+n+"' And DistinatDir = '"+der+"' And DistinatSer = '"+ser+"' And DistinatWyl = '"+wyl+"'  And DistinatAnn LIKE '%"+an+"%'", 12);
					table  = new JTable(d.val, columns);
		   		}
				
			    
			} catch (Exception e) {
				JOptionPane.showMessageDialog(contentPane,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
			}  
    	} 
}else {
        	JOptionPane.showMessageDialog(contentPane,"Veuillez Choisir le type de recherche correct SVP!","Attention",JOptionPane.ERROR_MESSAGE);
            //frame.setVisible(false);
        	return;
        }
   
		scrollPane_1 = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow(); 
				TableModel model = table.getModel();
				String path = (String) model.getValueAt(index, 11);
				//System.out.println(path);
				ImageIcon imic= new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(lbshow.getWidth(), lbshow.getHeight(), Image.SCALE_SMOOTH));
				lbshow.setIcon(imic);			
				
			}
		});
		
		lbshow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String path = (String) model.getValueAt(index, 11);
				File file = new File(path);
				try {
					Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
					  
				}catch (Exception e) {
					JOptionPane.showMessageDialog(contentPane,"Fichier untrouvable "+e.getMessage() ,"Attention",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		
        
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lbshow, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lbshow, GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
					.addContainerGap())
		);
		scrollPane_1.setViewportView(table);
		
		contentPane.setLayout(gl_contentPane);
	}
}
