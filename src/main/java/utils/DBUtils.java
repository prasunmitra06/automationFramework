package utils;

import java.sql.*;


class DBConnection{
	static Connection conn;
	
	public DBConnection() throws Exception {
		 String url = "jdbc:sqlserver://LAPTOP-01TN7J6A\\SQLEXPRESS;databaseName=AutomationDB;integratedSecurity=true";
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
	     conn = DriverManager.getConnection(url); 
	     
	}
	
}


class DBInsert extends DBConnection { 
	
public DBInsert() throws Exception {
		super();
	}

public void DBInsertMethod() 
{
	try { 
    	
        String sql = "INSERT INTO [AutoTbl1] ([col1], [col2], [col3], [col4],[col5],[col6]) VALUES (?, ?, ?, ?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
               
        statement.setInt(1, 5);	
        statement.setString(2, "Aman");
        statement.setString(3, "Kulkarni");
        statement.setString(4, "61");
        statement.setString(5, "2018-06-09");
        statement.setString(6, "Paaji is in Panjib");
         
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
         conn.close(); 
    } catch (Exception e) { 
        //System.err.println("Got an exception! "); 
        System.err.println(e.getMessage()); 
    } 

}
}

class DBUpdate extends DBConnection{


public DBUpdate() throws Exception {
		super();
	}

public void DBUpdateMethod()
{
	try { 
    	
        String sql = "UPDATE [AutoTbl1] SET [col4] = ? WHERE [col2] = ?;";
        PreparedStatement statement = conn.prepareStatement(sql);
               
        statement.setInt(1, 89);	
        statement.setString(2, "Paaji");
         
        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was Update successfully!");
        }
         conn.close(); 
    } catch (Exception e) { 
        //System.err.println("Got an exception! "); 
        System.err.println(e.getMessage()); 
    } 


}

}


 class DBSelect extends DBConnection{
	
	
	public DBSelect() throws Exception {
		super();
	}

	public void DBSelectMethod() throws Exception
	{
		
		String sql = "SELECT [col1], [col2], [col3], [col4],[col5],[col6] FROM [AutoTbl1] WHERE [COL1] = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, 5);
        
        ResultSet rs = statement.executeQuery();
        
        while (rs.next()) {
			String fname = rs.getString("col2");
			String lname = rs.getString("col3");
			String age = rs.getString("col4");
			
			System.out.println("Full Name: "+fname+ " "+ lname);
			System.out.println("Age: "+age);
			System.out.println(" ");
			
		}
		
	}
}



 public class DBUtils{
  public static void main (String[] args) throws Exception{ 
	  
	  /*DBInsert DBinObj = new DBInsert();
	  DBinObj.DBInsertMethod();
	  
	  DBUpdate dbUpObj = new DBUpdate();
	  dbUpObj.DBUpdateMethod();*/
	  
	  DBSelect DBseObj = new DBSelect();
	  DBseObj.DBSelectMethod();
	  
	  
  }       
}
