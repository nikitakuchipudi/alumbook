
public class User {

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String school;
	
	private int gradYear;
	private int id;
	
	private boolean alum;
	
	public User(String u, String password, String f, String l, String s, int g, boolean a, int id){
		firstName = f;
		lastName = l;
		school = s;
		gradYear = g;
		alum = a;
		this.id = id;
		userName = u;
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getGradYear() {
		return gradYear;
	}

	public void setGradYear(int gradYear) {
		this.gradYear = gradYear;
	}

	public boolean isAlum() {
		return alum;
	}

	public void setAlum(boolean alum) {
		this.alum = alum;
	}
	
	public int getId(){
		return id;
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
	
	@Override
	public String toString(){
		String word = "Username: "+userName+" password: "+password;
		return word;
	}
}
