package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.AuthDAO;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SignupServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		
		if (action == null) {
			String loggedIn = (String) session.getAttribute("loggedIn");
			session.setAttribute("loggedIn", loggedIn);
			request.setAttribute("message", "");
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			
		}else if (action.equals("createdriver")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repeatpassword", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/DriverRegister.jsp").forward(
					request, response);
			
		}else if (action.equals("createcustomer")) {
			request.setAttribute("name", "");
			request.setAttribute("lname", "");
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("repeatpassword", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/CustomerRegister.jsp").forward(
					request, response);
		}
		else {
			out.println("unrecognised action");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		
		@SuppressWarnings("unused")
		AuthDAO account = new AuthDAO();
		
		if (action == null) {
			out.println("unrecognised action");
			return;
		}
		else if(action.equals("checkdriver"))
		{
			
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			
			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("message", "");
			
			try {
				if(AuthDAO.isDriverNameAvailable(email)) {
					// This user already exists in the user database.
					
					request.setAttribute("message", "Username (Email) not Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "Username (Email) Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else if(action.equals("checkcustomer"))
		{
			
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			
			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("message", "");
			
			try {
				if(AuthDAO.isCustomerNameAvailable(email)) {
					// This user already exists in the user database.
					
					request.setAttribute("message", "Username (Email) not Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "Username (Email) Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("createdriver")) {
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repeatpassword");
			String DOB = request.getParameter("Dob");
			String address1 = request.getParameter("Add1");
			String address2 = request.getParameter("Add2");
			String city = request.getParameter("City");
			String state = request.getParameter("State");
			String zip = request.getParameter("zip");
			String licenseno = request.getParameter("Lnum");
			String dateofissue = request.getParameter("Doi");
			String dateofexpiry = request.getParameter("Doe");
			String carmodel = request.getParameter("Cname");
			String cartype = request.getParameter("Ctype");

			request.setAttribute("FirstName", FirstName);
			request.setAttribute("LastName", LastName);
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", DOB);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("zip", zip);
			request.setAttribute("licenseno", licenseno);
			request.setAttribute("dateofissue", dateofissue);
			request.setAttribute("dateofexpiry", dateofexpiry);
			request.setAttribute("carmodel", carmodel);
			request.setAttribute("cartype", cartype);
			request.setAttribute("message", "");
			
			User user = new User(FirstName, LastName, email, password, DOB, address1, city, state, zip, licenseno, dateofexpiry, carmodel, cartype);
			
			if(!user.validate_create()) {
				// Validate data entered in the form
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				
			}
			else {
				if(!password.equals(repassword)) {
					// Passwords don't match.
					request.setAttribute("message", "Passwords do not match.");
					request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
				}
				else {
					try {
						if(AuthDAO.isDriverNameAvailable(email)) {
							// This user (email) exists in the user database.
							request.setAttribute("message", "Username (Email) not Available");
							request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
						}
						else {
							// We create the Driver account.
							int returnedInt = AuthDAO.enterNewDriver(email, password);
							if(returnedInt != -1){
							// We create the Driver profile table	
							if(AuthDAO.enterDriverProfile(returnedInt, FirstName, LastName, email, password,
									DOB, address1, address2, city, state, zip, 
									licenseno, dateofissue, dateofexpiry,
									carmodel, cartype)){
								request.setAttribute("message", "Account Created Successfully");
							request.getRequestDispatcher("/DriverSuccess.jsp").forward(request, response);
							}
							}
							else{
								request.setAttribute("message", "Sorry Account Creation Failed");
							    request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						request.setAttribute("message", "A SQLException occured");
						request.getRequestDispatcher("/DriverRegister.jsp").forward(request, response);
					}
				}
				
			}
		} else if (action.equals("createcustomer")) {
			String FirstName = request.getParameter("FirstName");
			String LastName = request.getParameter("LastName");
			String email = request.getParameter("Email");
			String password = request.getParameter("password");
			String repassword = request.getParameter("repeatpassword");
			String DOB = request.getParameter("dob");
			String address1 = request.getParameter("add1");
			String address2 = request.getParameter("add2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String zip = request.getParameter("zip");
			String contactnumber = request.getParameter("cnumber");
			

			request.setAttribute("FirstName", FirstName);
			request.setAttribute("lname", LastName);
			request.setAttribute("email", email);
			request.setAttribute("password", "");
			request.setAttribute("repassword", "");
			request.setAttribute("DOB", DOB);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
			request.setAttribute("city", city);
			request.setAttribute("state", state);
			request.setAttribute("zip", zip);
			request.setAttribute("contactnumber", contactnumber);
			request.setAttribute("message", "");
			
			User user = new User(FirstName, LastName, email, password, DOB, address1, city, state, zip, contactnumber);
			
			if(!user.validate_create()) {
				// Validate data entered in the form
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				
			}
			else {
				if(!password.equals(repassword)) {
					// Passwords don't match.
					request.setAttribute("message", "Passwords do not match.");
					request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
				}
				else {
					try {
						if(AuthDAO.isCustomerNameAvailable(email)) {
							// This user (email) exists in the user database.
							request.setAttribute("message", "Username (Email) not Available");
							request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
						}
						else {
							// We create the Customer table.
							int returnedInt = AuthDAO.enterNewCustomer(email, password);
							if(returnedInt != -1){
							// We create the Customer profile table	
							if(AuthDAO.enterCustomerProfile(returnedInt, FirstName, LastName, email, password,
									DOB, address1, address2, city, state, zip, contactnumber)){
								request.setAttribute("message", "Account Created Successfully");
							request.getRequestDispatcher("/CustomerSuccess.jsp").forward(request, response);
							}
							}
							else{
								request.setAttribute("message", "Sorry Account Creation Failed");
							    request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						request.setAttribute("message", "A SQLException occured");
						request.getRequestDispatcher("/CustomerRegister.jsp").forward(request, response);
					}
				}
				
			}
			
		}
		
		try {
			AuthDAO.DB_Close();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

}
