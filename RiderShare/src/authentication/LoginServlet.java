package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AuthDAO;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
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
			request.setAttribute("message", "");
			request.setAttribute("email", "");
			String loggedIn = (String) session.getAttribute("loggedIn");
			session.setAttribute("loggedIn", loggedIn);
			request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
			
		} else if (action.equals("driverlogin")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/DriverLogin.jsp").forward(request,
					response);
		}
		else if (action.equals("customerlogin")) {
			request.setAttribute("email", "");
			request.setAttribute("password", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/CustomerLogin.jsp").forward(request,
					response);
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
		// use connection
				PrintWriter out = response.getWriter();
				String loggedIn;
				HttpSession session = request.getSession();
				String action = request.getParameter("action");

				if (action == null) {
					/*request.setAttribute("email", "");
					request.setAttribute("message", "");*/
					request.getRequestDispatcher("/HomePage.jsp").forward(request, response);
				}

				@SuppressWarnings("unused")
				AuthDAO account = new AuthDAO();
				
				if(action.equals("driverlogin")) {
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					
					request.setAttribute("email", email);
					request.setAttribute("password", "");
					request.setAttribute("message", "");
					
					User user = new User(email, password);
					
					if(!user.validate_login()) {
						// Validate data entered in driver login form
						request.setAttribute("message", user.getMessage());
						request.getRequestDispatcher("/DriverLogin.jsp").forward(request, response);
						return;
					}
					try {
						int returnUserID = AuthDAO.checkDriverPass(email, password);
						if(returnUserID != -1){
						User fetch_username = AuthDAO.getDriverById(returnUserID);
						
						if(fetch_username != null) {
							loggedIn = "true";
							session.setAttribute("loggedIn", loggedIn);
							//session.setAttribute("fetch_username",fetch_username);
							request.getRequestDispatcher("/PostJourney.jsp").forward(request, response);
						}
					}
						else {
							request.setAttribute("message", "Username or Password Not Valid");
							request.getRequestDispatcher("/DriverLogin.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						request.setAttribute("message", "Database error: Please try again later.");
						request.getRequestDispatcher("/DriverLogin.jsp").forward(request, response);
					}
					
				} if(action.equals("customerlogin")) {
					String email = request.getParameter("email");
					String password = request.getParameter("password");
					
					request.setAttribute("email", email);
					request.setAttribute("password", "");
					request.setAttribute("message", "");
					
					User user = new User(email, password);
					
					if(!user.validate_login()) {
						// Validate data entered in customer login form
						request.setAttribute("message", user.getMessage());
						request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
						return;
					}
					try {
						int returnUserID = AuthDAO.checkCustomerPass(email, password);
						if(returnUserID != -1){
						User fetch_username = AuthDAO.getCustomerById(returnUserID);
						
						if(fetch_username != null) {
							loggedIn = "true";
							session.setAttribute("loggedIn", loggedIn);
							//session.setAttribute("fetch_username",fetch_username);
							request.getRequestDispatcher("/PostJourney.jsp").forward(request, response);
						}
					}
						else {
							request.setAttribute("message", "Username or Password Not Valid");
							request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
						}
					} catch (SQLException e) {
						request.setAttribute("message", "Database error: Please try again later.");
						request.getRequestDispatcher("/CustomerLogin.jsp").forward(request, response);
					}
					
				}
				else {
					out.println("unrecognised action");
				}
				
				try {
					AuthDAO.DB_Close();
				} catch (Throwable e) {
					
					e.printStackTrace();
				}
	}

}
