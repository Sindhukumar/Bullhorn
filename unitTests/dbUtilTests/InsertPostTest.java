package dbUtilTests;

import static org.junit.Assert.*;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;

import org.junit.Test;

import Tool.DbPost;
import Tool.DbUtil;
import model.Bhpost;
import model.Bhuser;

public class InsertPostTest {

	@Test
	public void test() {
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
	}

}
