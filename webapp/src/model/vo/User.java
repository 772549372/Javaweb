package model.vo;

public class User {
	String userName;
    String password;
    String chrName;
    String email;
   
      public User(String userName, String password, String chrName, String email) {
    	  this.userName = userName;
    	  this.password = password;
    	  this.chrName = chrName;
    	  this.email = email;
	}
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getChrName() {
		return chrName;
	}
	public void setChrName(String chrName) {
		this.chrName = chrName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
