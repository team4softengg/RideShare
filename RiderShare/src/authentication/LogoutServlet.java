package authentication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LogoutServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logout = "You have Logged Out successfully";
		HttpSession session = request.getSession();
		request.setAttribute("username", "");
		request.setAttribute("password", "");
		request.setAttribute("message", "");
		String loggedIn = null;
		session.setAttribute("loggedIn", loggedIn);
		request.setAttribute("logout", logout);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String logout = "You have Logged Out successfully";
		HttpSession session = request.getSession();
		request.setAttribute("username", "");
		request.setAttribute("password", "");
		request.setAttribute("message", "");
		String loggedIn = null;
		session.setAttribute("loggedIn", loggedIn);
		session.setAttribute("logout", logout);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

}
