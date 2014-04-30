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
			
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/se_homework4", "root", "root");
		} catch (SQLException e) {
			System.out.println("Can't connect to database.");
			return;
		}

		//System.out.println("Connected to database.");
		
		
	}
	
	/*Check if driver (driverid) already exists in Database*/
	public static int checkDriverPass(String email, String password) throws SQLException {

		String sql = "select driverId from driver where email=? and password=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);
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
	
	/*Get the Driver Details during Login and return User object*/
	public static User getDriverById(int driverId) throws SQLException{
		String sql = "select * from driver_profile where driverId=?";
		User user = new User();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);

		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			user.setEmail(rs.getString(1)); 
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
		}
		
		return user;
	}
	
	
	/*Check if customer (customerid) already exists in Database*/
	public static int checkCustomerPass(String email, String password) throws SQLException {

		String sql = "select customerId from customer where email=? and password=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setString(1, email);
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
	
	/*Get the Customer Details during Login and return User object*/
	public static User getCustomerById(int customerId) throws SQLException{
		String sql = "select * from customer_profile where customerId=?";
		User user = new User();
		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, customerId);

		ResultSet rs = stmt.executeQuery();
		if(rs.next()){
			user.setEmail(rs.getString(1)); 
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
		}
		
		return user;
	}
	
	
	/* Enter email and Password is driver table */
	public static int enterNewDriver(String email, String password) throws SQLException {
		String sql = "insert into driver (email, password) values (?, ?)";
		int count = 0;
  try{
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, email);
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
	
	
	/*Enter UserId and all user information in driver_profile table 
	 * from userID returned from enterNewDriver(String email, String password)*/
	
	public static boolean enterDriverProfile(int driverId, String FirstName, String LastName, String email, String password,
			String DOB, String address1, String address2, String city, String state, String zip, String licenseno, String dataofissue, 
			String dataofexpiry, String carmodel, String cartype) throws SQLException {
		
		String sql = "insert into driver_profile (driverId, firstName, lastName, email, password, dob, address1, address2,"
				+ "city, state, zip, licenseno, dataofissue, dataofexpiry, carmodel, cartype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, driverId);
		stmt.setString(2, FirstName);
		stmt.setString(3, LastName);
		stmt.setString(4, email);
		stmt.setString(5, password);
		stmt.setString(6, DOB);
		stmt.setString(7, address1);
		stmt.setString(8, address2);
		stmt.setString(9, city);
		stmt.setString(10, state);
		stmt.setString(11, zip);
		stmt.setString(12, licenseno);
		stmt.setString(13, dataofissue);
		stmt.setString(14, dataofexpiry);
		stmt.setString(15, carmodel);
		stmt.setString(16, cartype);
		
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
	
	/* Enter email and Password is customer table */
	public static int enterNewCustomer(String email, String password) throws SQLException {
		String sql = "insert into customer (email, password) values (?, ?)";
		int count = 0;
  try{
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		stmt.setString(1, email);
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
	
	
	/*Enter UserId and all user information in user_profile table 
	 * from userID returned from enterNewCustomer(String email, String password)*/
	
	public static boolean enterCustomerProfile(int customerId, String FirstName, String LastName, String email, String password,
			String DOB, String address1, String address2, String city, String state, String zip, String contactnumber) throws SQLException {
		
		String sql = "insert into customer_profile (customerId, firstName, lastName, email, password, dob, address1, address2,"
				+ "city, state, zip, licenseno, dataofissue, dataofexpiry, carmodel, cartype) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = conn.prepareStatement(sql);

		stmt.setInt(1, customerId);
		stmt.setString(2, FirstName);
		stmt.setString(3, LastName);
		stmt.setString(4, email);
		stmt.setString(5, password);
		stmt.setString(6, DOB);
		stmt.setString(7, address1);
		stmt.setString(8, address2);
		stmt.setString(9, city);
		stmt.setString(10, state);
		stmt.setString(11, zip);
		stmt.setString(12, contactnumber);
		
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
	
	
	/*Check if email (Driver) exists in Database*/
	public static boolean isDriverNameAvailable(String email) throws SQLException{

		String sql = "select count(*) as count from driver where email=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);

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
	
	/*Check if email (Customer) exists in Database*/
	public static boolean isCustomerNameAvailable(String email) throws SQLException{

		String sql = "select count(*) as count from customer where email=?";
		int count = 0;
		try{
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, email);

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

