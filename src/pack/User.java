package pack;


public class User {
	private String username;
	private String password;
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isValidUser(){
		if("sindhu".equals(username)&&"pass".equals(password)){
			return true;
		}
		return false;
	}

}
