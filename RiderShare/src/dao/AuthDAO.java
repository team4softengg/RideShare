package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.User;

public class AuthDAO {

	private static Connection conn = null;

	public AuthDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Can't load database driver");
			Logger.getLogger(AuthDAO.class.getName()).log(Level.SEVERE, null, e);
			return;
		}

		try {
			
			/*conn = DriverManager.getConnection(
					"jdbc:mysql://sujasdb.cpxfirco8h4j.us-west-2.rds.amazonaws.com:3306/sujasdb", "sujasghiya", "sujasgs3");*/
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/se_homework4", "root", "root");
		} catch (SQLException e) {
			System.out.println("Can't connect to database.");
			return;
		}

		//System.out.println("Connected to database.");
		
		
	}
	
	
	public static User getUserById(int userId) throws SQLException{
		String sql = "SELECT * FROM user_profile WHERE userId=?";
		User user = new User();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, userId);

		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			user.setUserId(rs.getInt(1)); 
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
		}
		
		return user;
	}
	
	
	/*Check if username already exists in Database*/
	public static int checkUserPass(String userName, String password) throws SQLException {

		String sql = "select userId from user where username=? and password=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, userName);
		stmt.setString(2, password);

		ResultSet checkuseraccount = stmt.executeQuery();

		if (checkuseraccount.next()){
			count=checkuseraccount.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }		
		if(count!=0)
			return count;
		else
			return -1;
	}
	
	/* Enter Username and Password is user table */
	public static int enterNewUser(String userName, String password) throws SQLException {
		String sql = "insert into user (username, password) values (?, ?)";
		int count = 0;
  try{
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, userName);
		stmt.setString(2, password);
		
		@SuppressWarnings("unused")
		int execute = stmt.executeUpdate();
		
		ResultSet rs = stmt.getGeneratedKeys();
		if (rs.next()){
			count=rs.getInt(1);
		}
		
    }catch (Exception e){
	        e.printStackTrace(); 
		   	return -1;
    }
			return count;
	}
	
	
	/*Enter UserId FirstName and Lastname in user_profile table 
	 * from userID returned from enterNewUser(String userName, String password)*/
	
	public static boolean enterUserName(int userId, String firstName, String lastName) throws SQLException {

		String sql = "insert into user_profile (userId, firstName, lastName) values (?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, userId);
		stmt.setString(2, firstName);
		stmt.setString(3, lastName);
		
		int rs = stmt.executeUpdate();
		
		//stmt.close();
		int count = 0;
			
		count = rs;

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	/*Check if username exists in Database*/
	public static boolean isUserNameAvailable(String userName) throws SQLException{

		String sql = "select count(*) as count from user where username=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, userName);

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			count = rs.getInt("count");
		}
		
		rs.close();
		}catch (NullPointerException n){
			return false;
		}

		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public static void DB_Close() throws Throwable
	{
		try {
		if(conn!=null) { 
		conn.close();  // Close the connection
		}
		}
		catch(SQLException e) {
		System.out.println(e);
		}
	}
}

