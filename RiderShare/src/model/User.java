package model;

public class User {
	private int userId;
	private String username = "";
	private String password = "";
	private String firstName = "";

	private String lastName = "";
	private boolean loggedIn = false;
	private String message = "";
	
	public String getMessage() {
		return message;
	}

	public User() {
		
	}
	
	public User(String username){
		this.username = username;
	}
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String firstName, String lastName, String password) {
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String LastName) {
		lastName = LastName;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean validate() {
		
		if(username == "") {
			message = "Username not filled in";
			return false;
		}

		if(password == "") {
			message = "Invalid password";
			return false;
		}
		
		if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		
		return true;
	}
	
	public boolean validate_Reg(){
		
		if(username == "") {
			message = "Username not filled in";
			return false;
		}
		
		if(firstName == "") {
			message = "Please enter First Name";
			return false;
		}
		
		if(lastName == "") {
			message = "Please enter Last Name";
			return false;
		}
		if(password == "") {
			message = "Invalid password";
			return false;
		}
		if(password.length() < 8) {
			message = "Password must be at least 8 characters.";
			return false;
		}
		else if(password.matches("\\w*\\s+\\w*")) {
			message = "Password cannot contain space.";
			return false;
		}
		return true;
		
	}
	
	

}

