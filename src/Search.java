

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
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL = "/newsfeed.jsp";
		String searchtext = request.getParameter("searchtext");

		HttpSession session = request.getSession();

		Bhuser user = null;
		List<Bhpost> searchPosts = DbPost.searchPosts(searchtext);
		session.setAttribute("searchPosts", searchPosts);
		nextURL = "/newsfeed.jsp?searchtext="+searchtext;
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		// response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
