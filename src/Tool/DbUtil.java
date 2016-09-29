package Tool;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class DbUtil {
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Bullhorn");
	public static EntityManagerFactory getEmFactory(){
		return emf;
	}
	/**
	 * Gets a Gravatar URL given the email and size
	 * In accordance with Gravatar's requirements the email will be hashed
	 * with the MD5 hash and returned as part of the url
	 * The url will also include the s=xx attribute to request a Gravatar of a
	 * particular size.
	 * References: <a href="http://www.gravatar.com">http://www.gravatar.com</>
	 * @param email - email of the user who's gravatar you want
	 * @param size - indicates pixel height of the image to be returned. Height and Width are same.
	 * @return - the gravatar URL. You can test it in a browser.
	 */
	 public static String getGravatarURL(String email, Integer size){
	 String url = "http://www.gravatar.com/avatar/" +
	 MD5Util.md5Hex(email) + "?s=" + size.toString();
	 return url;
	 }
}
