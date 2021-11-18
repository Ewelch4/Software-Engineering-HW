package lab8out;

import static org.junit.Assert.*;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;


import lab8out.Database;


public class DatabaseFileTest {
	String[] users = {"jsmith@uca.edu","msmith@uca.edu","tjones@yahoo.com","jjones@yahoo.com"};
	String[] passwords = {"hello123","pass123","123456","hello1234"};

	private Database db; 
		
	private int rando;
	
	
	@Before
	public void setUp() throws Exception 
	{
	  db = new Database(); 
	  db.setConnection("db.properties");
	}

	
	@Test
	public void testSetConnection() throws FileNotFoundException, SQLException
	{
	  //1. call setStream() with users.txt
		
		db.setConnection("lab8out/db.properties");
		 java.sql.Connection connection = db.getConnection();
		assertNotNull("Check setStream", connection); //Place object here 
			
			//fail("not yet implemented");
	}


	@Test(expected = FileNotFoundException.class) // giving intentionally bad input to throw an exception
	public void testStream() throws FileNotFoundException, SQLException
	{
	  
	  //1. Set the stream with user.txt (wrong name) – should throw FileNotFoundException
		db.setConnection("lab8in/doesnotexist.properties");
		
	}

		

	@Test // test that query works
	public void testQuery() throws IOException, SQLException 
	{
	  //Use Random # to extract username/ and expected password
			
			
	 String Query = "select aes_decrypt(password,\"key\") from users where username= \"tjones@yahoo.com\";"; 
	 String expected = "123456";
			
	 //get actual result (invoke query with username)
	ResultSet result = db.query(Query);
	String compresult = result.getString("aes_decrypt(password,\"key\")");
			
	//compare expected with actual using assertEquals
			assertEquals(compresult,expected);
			
	}
		
	@Test(expected = SQLException.class)  //Test for bad user name
	public void testQuery2() throws IOException, SQLException
	{
		
		
	 String Query = "select aes_decrypt(password,\"key\") from users where username= \"dontexitspls\";"; 
	 String expected = "123456";
			
	 //get actual result (invoke query with username)
	ResultSet result = db.query(Query);
	String compresult = result.getString("aes_decrypt(password,\"key\")");
	
	 assertNull("Check query", compresult); 
	}
	
	@Test
	public void testExecuteDML() throws SQLException {
		db.executeDML("insert into users values(\"test@test.com\",1000);");
		String Query = "select password from users where username=\"test@test.com\";"; 
		 String expected = "1000";
				
		 //get actual result (invoke query with username)
		ResultSet result = db.query(Query);
	
		String compresult = result.getString("password");
		
		 assertEquals(expected, compresult);
		 //have to go in and delete duplicate as it has issues w/ code below for some reason
		// db.executeDML("\"delete from users where username=\"test@test.com\";");
	}
	
	
	@Test(expected = SQLException.class)
	public void testExecuteDML2() throws SQLException {
		db.executeDML("insert into users values(100,1000);");
		String Query = "select password from users where username=\"test@test.com\";"; 
		 String expected = "1000";
				
		 //get actual result (invoke query with username)
		ResultSet result = db.query(Query);
	
		String compresult = result.getString("password");
		
		 //have to go in and delete duplicate as it has issues w/ code below for some reason
		// db.executeDML("\"delete from users where username=\"test@test.com\";");
	}

}
