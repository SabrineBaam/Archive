package archiv;




import java.sql.*;

import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;






public class Functions {
	public static String pathrec(String p,String n,String an) {
		String [] l= p.split("\\\\");
		String path=null;
		path = l[0]+"\\"+l[1]+"\\"+l[2]+"\\"+l[3]+"\\"+n+an+".png";	
		return path;
	}
	
	
	public static MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.err.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}

	
	public static Connection dbConnect(String db_connect_string,
            String db_userid,
            String db_password)
   {  Connection conn=null;
      try {
         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         conn = DriverManager.getConnection(db_connect_string,
                  db_userid, db_password);
         Archiv.statulb.setText("Connecté");
      } catch (Exception e) {
         e.printStackTrace();
      }
	return conn;
   }
      public void dbDisConnect(String db_connect_string,
              String db_userid,
              String db_password)
     {
        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(db_connect_string,
                     db_userid, db_password);
              conn.close();
              System.out.println("disconnected");
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
	public static void AddItem(String v1,String v2,String v3,String v4,String v5,String v6,String v7,String v8,String v9,String v10,String v11,String v12, String v13) throws Exception{
		
		  
		try{ 
			Connection conn =dbConnect("jdbc:sqlserver://127.0.0.1;databaseName=databaseNAme", "user", "password");
			
				PreparedStatement insert= conn.prepareStatement("INSERT INTO "+v1+"(DistinatNum,DistinatDir,DistinatSer,DistinatWyl,DistinatAnn, Date,DistNum,DistDir,DistServ,DistWyl, Subject, ScanImg) VALUES('"+v2+"','"+v3+"','"+v4+"','"+v5+"','"+v6+"','"+v7+"','"+v8+"','"+v9+"','"+v10+"','"+v11+"','"+v12+"','"+v13+"')");
				insert.executeUpdate();
				JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Bien Ajouter!","Bravo",JOptionPane.INFORMATION_MESSAGE);
			
	
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(Archiv.frmArchivManagement,"Erreur"+e.getMessage(),"Attention",JOptionPane.ERROR_MESSAGE);
			;
		}
		
	}


	public static read_db read_from_db(Connection cont ,String query,  int columns){
		try{
			
			if(query == null || cont == null || query.equals("")){
				read_db d = new read_db(false, null);
				return d ;
			}
			read_db d = new read_db(false, null);
			Statement st = null ;
		
			st = cont.createStatement();			
			ResultSet rs = null ;
			ResultSet rs2 = null ;
			rs2 = st.executeQuery(query);	
			
			int i =0 ;
			while(rs2.next()){				
				i = i+1;							
			}	
			Object[][] val = new Object[i][columns] ;
			rs = st.executeQuery(query);
			int j = 0;
			while(rs.next()){
				for(int i1 =0 ; i1<columns ; i1++){
					
					val[j][i1] = new Object();
					if(rs.getObject(i1+1) != null){
					val[j][i1] = rs.getObject(i1+1);}else {
						val[j][i1] = "";
					}
					
				}
				j = j+1;
			}
				
		
			d.result = true ;
			d.val = val;
			
			st.close();
			rs.close();
			return d ;
		}catch(Exception e){
			read_db d = new read_db(false, null);
		
			return d ;
		}
			
	}
	public static void getDatabases() {
		
	}
	
	
	}


