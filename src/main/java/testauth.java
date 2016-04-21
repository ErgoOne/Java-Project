
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
	//main class
	
	Class.forName("com.mysql.jdbc.Driver");
	//load the jdbc driver class
	Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","");/* red colored part has to be as per your database*/
	/*make connection with the database(db name ecommerce, user is root and password is not set in my case put yours in those places with password if you have set password for the database*/
	PreparedStatement statement = con.prepareStatement("Select * from users");
	/*sql structure to select instances from the table*/
	ResultSet result = statement.executeQuery();
	/*execution of the database query*/ 
	
	while(result.next()){
		System.out.println(result.getString(1) +"\t"+ result.getString(2)+ "\t" + result.getString(3)+ "\t" + result.getString(4));
		/*print the result with three attributes from the table 'products in my case' */
		}
	}
}
}
