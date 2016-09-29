
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.DbPost;
import Tool.DbUser;
import Tool.DbUtil;
import model.Bhpost;
import model.Bhuser;

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
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		Bhuser user = null;
		List<Bhpost> posts;
		List<Bhpost> allPosts = DbPost.bhPost();
		session.setAttribute("allPosts", allPosts);
		session.setAttribute("user", user);
		session.setAttribute("gravatarURL", DbUtil.getGravatarURL(useremail, 50));
		session.setAttribute("gravatarURLsmall", new DbUtil());
		if (DbUser.isValidUser(useremail, password)) {
			user = DbUser.getUserByEmail(useremail);
			session.setAttribute("user", user);
			posts = DbPost.postsofUser(useremail);
			session.setAttribute("posts", posts);
			nextURL = "/Output.jsp";
		}
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		// response.sendRedirect(request.getContextPath() + nextURL);
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
