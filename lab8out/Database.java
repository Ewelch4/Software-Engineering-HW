package lab8out;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Database
{
  private Connection conn;
  private Statement stmt;
  //Add any other data fields you like - at least a Connection object is mandatory
  public Database() throws SQLException
  {
	  conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student_space","student","hello");
	    stmt=conn.createStatement();
  }
  public void setConnection(String fn) throws SQLException, FileNotFoundException {
	  Scanner fileScanner = new Scanner (new File(fn));
	 String user = fileScanner.nextLine();
	 String password = fileScanner.nextLine();
	 String url = fileScanner.nextLine();
	 String[] usersplit = user.split("=");
	 String[] passsplit = password.split("=");
	 String[] urlsplit = url.split("=");
	// System.out.println(urlsplit[1]);
	  conn = (Connection) DriverManager.getConnection(urlsplit[1],usersplit[1],passsplit[1]);
    stmt=conn.createStatement();
  }
  public Connection getConnection()
  {
    return conn;
  }
  
  public ResultSet query(String query) throws SQLException
  {
	ResultSet rs =  stmt.executeQuery(query);
	
	rs.next();

	return rs;
  }
  
  public void executeDML(String dml) throws SQLException
  {
	  stmt.executeUpdate(dml);
  }
  public boolean execute(String sql) throws SQLException{
	  return(stmt.execute(sql)) ;
  }
  public void executequery(String sql)throws SQLException {
	stmt.executeQuery(sql);  
  }

public void createNewAccount(String username, String password) throws SQLException {
	stmt.executeUpdate("INSERT INTO USER VALUE('"+username+"','"+password+"');");
	System.out.println("test");
}
  
}
