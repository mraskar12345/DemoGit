package library;

import java.sql.*;




public class DBOperations  

{
	public static String DBRead() throws Exception
	{
	
		String id = null;
		String connection = "jdbc:sqlserver://XIPLRAC036\\SQLEXPRESS14";
	    String user = "admin";
	    String password1 = "password";
	    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    Connection con = DriverManager.getConnection(connection, user, password1);
	   
	    
	    Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from CarFinance where Id = '1'");
	    
	    	while(rs.next())
	    				{
	    						id = rs.getString(1);
	    						String category = rs.getString(2);
	    						String question = rs.getString(3);
	    						String question1 = rs.getString(3);
	    				}
	    
	    
	    
	    if (!con.isClosed()) {
	      con.close();
	    }
	
	return id;
	
	}
	

}
