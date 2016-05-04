package newPackage1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Badr
 */
public class testauth {
     public static void main(String[] args) throws Exception
{

	//load the jdbc driver class
	Class.forName("com.mysql.jdbc.Driver");
	/*make connection with the database*/
	Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");/* red colored part has to be as per your database*/
	/*select instances from the table*/
	PreparedStatement statement = con.prepareStatement("Select * from users");
	/*execution of the database query*/
	ResultSet result = statement.executeQuery();
	 
	/*print the result with three attributes from the table 'products in my case' */
	while(result.next()){
		System.out.println(result.getString(1) +"\t"+ result.getString(2)+ "\t" + result.getString(3)+ "\t" + result.getString(4));
		
		}
	}
}

