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
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else if (action.equals("createuser")){
			request.setAttribute("username", "");
			request.setAttribute("firstName","");
		    request.setAttribute("lastName","");
		    request.setAttribute("message", "");
			request.getRequestDispatcher("/signup.jsp").forward(request,response);
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
		//String loggedIn;
		//HttpSession session = request.getSession();
		String action = request.getParameter("action");
		
		@SuppressWarnings("unused")
		AuthDAO account = new AuthDAO();
		
		if (action == null) {
			out.println("unrecognised action");
			return;
		}
		else if(action.equals("checkuser"))
		{
			
			String username = request.getParameter("username");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			
			request.setAttribute("username", username);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("message", "");
			
			try {
				if(AuthDAO.isUserNameAvailable(username)) {
					// This user already exists in the user database.
					
					request.setAttribute("message", "Username not Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);
				}else{
					request.setAttribute("message", "Username Available");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else if(action.equals("createuser")) {
			String username = request.getParameter("username");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String password = request.getParameter("password");
			String repeatPassword = request.getParameter("repeatpassword");
			
			request.setAttribute("username", username);
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("password", "");
			request.setAttribute("repeatPassword", "");
			request.setAttribute("message", "");
			
			User user = new User(username, firstName, lastName, password);
			
			if(!user.validate_Reg()) {
				// Validate data entered
				request.setAttribute("message", user.getMessage());
				request.getRequestDispatcher("/signup.jsp").forward(request, response);
				
			}
			else {
				if(!password.equals(repeatPassword)) {
					// Passwords don't match.
					request.setAttribute("message", "Passwords do not match.");
					request.getRequestDispatcher("/signup.jsp").forward(request, response);
				}
				else {
					try {
						if(AuthDAO.isUserNameAvailable(username)) {
							// This user already exists in the user database.
							request.setAttribute("message", "Username not Available");
							request.getRequestDispatcher("/signup.jsp").forward(request, response);
						}
						else {
							// We create the account.
							int returnedInt = AuthDAO.enterNewUser(username, password);
							if(returnedInt != -1){
								
							if(AuthDAO.enterUserName(returnedInt, firstName, lastName)){
								request.setAttribute("message", "Account Created Successfully");
							request.getRequestDispatcher("/login.jsp").forward(request, response);
							}
							}
							else{
								request.setAttribute("message", "User Name Insert Failed");
							    request.getRequestDispatcher("/signup.jsp").forward(request, response);
							}
						}
					} catch (SQLException e) {
						e.printStackTrace();
						request.getRequestDispatcher("/signup.jsp").forward(request, response);
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
