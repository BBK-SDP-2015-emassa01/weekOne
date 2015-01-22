package reflection;

public class Person {
	
	private String name;
	private String userid;
	
	public Person(){
		this("Fred", "xyz123");
	}
	
	public Person(String username, String user){
		name = username;
		userid = user;
		
	}
	
	
	public String getName() {
		return name;
	}
	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString(){
		return this.getClass() + ", Name: " + this.getName() + ", UserID: " + this.getUserid();
	}
	
}
