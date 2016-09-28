

import java.io.IOException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Tool.DbPost;
import Tool.DbUtil;
import model.Bhpost;
import model.Bhuser;

/**
 * Servlet implementation class PostServ
 */
@WebServlet("/PostServ")
public class PostServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextURL="/error.jsp";
		Date postdate = new Date();
		//get a popuated bhuser object since we'll add that to the post
		EntityManager em = DbUtil.getEmFactory().createEntityManager();
		String query = "select u from Bhuser u where u.useremail=:email";
		TypedQuery<Bhuser> q = em.createQuery(query,Bhuser.class);
		//q.setParameter("email",user.getEmail());
		q.setParameter("email","larry12345@gmail.com");
		
		Bhuser bhuser = null;
		try{
			bhuser = q.getSingleResult();
			System.out.println("The user id is: "+bhuser.getBhuserid());
			nextURL = "/newsfeed.jsp";
		}catch(NoResultException e){
			System.out.println(e);
		}catch(NonUniqueResultException e){
			System.out.println(e);
		}finally{
			em.close();
		}
		System.out.println("inserting into post table");
		Bhpost bhpost = new Bhpost();
		bhpost.setBhuser(bhuser);
		bhpost.setPostdate(postdate);
		bhpost.setPosttext("This is a unit test post");
		System.out.println("Calling DbPost.insert");
		DbPost.insert(bhpost);
		
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
