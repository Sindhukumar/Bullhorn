
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pack.User;

/**
 * Servlet implementation class process_form
 */
@WebServlet("/process_form")
public class process_form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public process_form() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextURL = "/Login.html";
		User user = new User();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		user.setName(username);
		user.setPassword(password);

		HttpSession session = request.getSession();
		session.setAttribute("user", user);

		if (user.isValidUser()) {
			nextURL = "/Output.jsp";
		}
		// getServletContext().getRequestDispatcher(nextURL).forward(request,
		// response);
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
