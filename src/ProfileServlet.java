

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tool.DbPost;
import Tool.DbUser;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "/Profile.jsp";
		String useremail = request.getParameter("useremail");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String motto = request.getParameter("motto");
		
		HttpSession session = request.getSession();
		
		Bhuser user = (Bhuser) session.getAttribute("user");
		
		user.setUseremail(useremail);
		user.setUserpassword(password);
		user.setUsername(username);
		user.setMotto(motto);
		
		DbUser.update(user);
		List<Bhpost> posts;
		session.setAttribute("user", user);

		if (DbUser.isValidUser(useremail, password)) {
			user = DbUser.getUserByEmail(useremail);
			session.setAttribute("user", user);
			posts = DbPost.postsofUser(useremail);
			session.setAttribute("posts", posts);
		}
		//getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		 response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
