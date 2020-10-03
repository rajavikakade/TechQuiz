package utilities;
import java.sql.*;
import java.util.ArrayList;

public class JDBC 
{
	public Connection con;
	//Establishing connection to the local MySQL server
	public JDBC()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1monomial///");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//Queries for database operations
	private String SELECT_QUERY = "SELECT * FROM login WHERE Email = ? and Password = ?";
	private String INSERT_QUERY = "INSERT INTO login (Email, Password, Name, College, Year) VALUES (?, ?, ?, ?, ?)";
	private String QUES_FETCH = "SELECT * FROM questionbank WHERE QNO = ?";
	private String INSERT_MARKS = "INSERT INTO marks (Marks, Student_ID) VALUES (?, ?)";
	private String ID_FETCH = "SELECT ID FROM login WHERE Email = ?";
	private String MARKS_FETCH = "SELECT Date_Time, Marks FROM marks WHERE Student_ID = ?";
	private String UPDATE_QUERY = "UPDATE login SET Email = ?, Password = ?, Name = ?, College = ?, Year = ? WHERE ID = ?";
	
	//Validation of user details while Signing Up
	public boolean validate(String email, String pass)
	{
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(SELECT_QUERY);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, pass);
	        
	        System.out.println(preparedStatement);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) 
	        {
	        	User.email = email;
	        	User.pass = pass;
	        	User.name = resultSet.getString(4);
	        	User.college = resultSet.getString(5);
	        	User.year = resultSet.getString(6);
	        	return true;
	        }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	//Flag to determine duplication of Email IDs
	public boolean isUnique = true;
	
	//Insertion of a user after Sign Up
	public void insertRecord(String name, String email, String college, String year, String pass)
	{
		isUnique = true;
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_QUERY);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, pass);
	        preparedStatement.setString(3, name);
	        preparedStatement.setString(4, college);
	        preparedStatement.setString(5, year);
	        
	        System.out.println(preparedStatement);
	        preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			isUnique = false;
			ex.printStackTrace();
		}
	}
	
	//Fetch questions from the database
	public Question fetchQuestion(int ques_id)
	{
		Question ques = new Question();
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(QUES_FETCH);
			preparedStatement.setInt(1, ques_id);
			System.out.println(preparedStatement);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) 
	        {
	        	ques.id = ques_id;
	        	ques.ques = resultSet.getString(2);
	        	ques.op1 = resultSet.getString(3);
	        	ques.op2 = resultSet.getString(4);
	        	ques.op3 = resultSet.getString(5);
	        	ques.op4 = resultSet.getString(6);
	        	ques.ans = resultSet.getString(7);
	        	ques.topic = resultSet.getString(8);
	        }
		}
		catch(Exception ex)
		{
			System.out.println("QUESTION QUERY NOT WORKING");
			ex.printStackTrace();
		}
		
		return ques;
	}
	
	//To obtain the student ID (assigned at the server end) from the Email ID
	public int getID(String email)
	{
		int ID = 0;
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(ID_FETCH);
			preparedStatement.setString(1, email);
			System.out.println(preparedStatement);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next())
	        	ID = resultSet.getInt(1);
		}
		catch(Exception ex)
		{
			System.out.println("QUESTION QUERY NOT WORKING");
			ex.printStackTrace();
		}
		return ID;
	}
		
	//Insert data after a test into the marks table
	public void insertResult(int marks, String email)
	{
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_MARKS);
	        preparedStatement.setInt(1, marks);
	        int student_ID = getID(email);
	        preparedStatement.setInt(2, student_ID);
	       
	        System.out.println(preparedStatement);
	        preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//Storing marks and dates of a user for data visualization
	public ArrayList<String> dateX = new ArrayList<String>();
	public ArrayList<Integer> marksY = new ArrayList<Integer>();
	
	
	//Fetching results of a user to populate the line graph
	public void fetchResults(String email)
	{
		int ID = getID(email);
		
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(MARKS_FETCH);
			preparedStatement.setInt(1, ID);
			System.out.println(preparedStatement);

	        ResultSet resultSet = preparedStatement.executeQuery();
	        while(resultSet.next())
	        {
	        	dateX.add(resultSet.getString("Date_Time"));
	        	marksY.add(resultSet.getInt("Marks"));
	        }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	//To update the data of a user in Manage Account
	public void updateRecord(int ID, String email, String pass, String name, String college, String year)
	{
		isUnique = true;
		try
		{
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_QUERY);
	        preparedStatement.setString(1, email);
	        preparedStatement.setString(2, pass);
	        preparedStatement.setString(3, name);
	        preparedStatement.setString(4, college);
	        preparedStatement.setString(5, year);
	        preparedStatement.setInt(6, ID);
	        
	        System.out.println(preparedStatement);
	        preparedStatement.executeUpdate();
		}
		catch(Exception ex)
		{
			isUnique = false;
			ex.printStackTrace();
		}
		
		
		
		
	}
}
	