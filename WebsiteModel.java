import java.util.ArrayList;

public class WebsiteModel {

	private User accounts[];
	
	private LinkedAccounts account;
	
	private int numbOfUsers = 0;
	
	public WebsiteModel(){
		
		account = new LinkedAccounts();
		
		//User(String u, String password, String f, String l, String s, int g, boolean a, int id)
		account.enqueue(new User("Student1","pass1","Alex","Maxwell","Local High School",2016,false, 0));
		account.enqueue(new User("Alumni1","pass1","Mat","Wagner","RIT",2010,true,1));
		account.enqueue(new User("Student2","pass2","Nicki","Kuchipudi","RIT",2012,false, 2));
		account.enqueue(new User("Alumni2","pass1","Mat","1","RIT",2010,true,3));
		account.enqueue(new User("Alumni3","pass1","Mat","2","RIT",2010,true,4));
		account.enqueue(new User("Alumni4","pass1","Mat","3","RIT",2010,true,5));



		
		
		numbOfUsers = 6;
		
        System.out.println("Print out all Accounts:"+account.toString());

	}
	
	
	/**
	 * Returns Id of user
	 * @param user - username requested
	 * @param pass - password for username
	 * @return - id of user
	 */
	public int userExist(String user, String pass){
		
		int count = 0;
		
		AccountNode current = account.getFront();
		while(current != null){
			System.out.println(current.getData().getUserName()+" "+current.getData().getPassword());
			System.out.println(current.getData().getUserName()+" "+user);
			if(current.getData().getUserName().equals(user)){
				if(current.getData().getPassword().equals(pass)){
					System.out.println("Count of the found: "+count);
					return count;
				}
				else{
					return -1;
				}
			}
			count ++;
			current = current.getNext();
		}
		System.out.println(current);
		return -1;
	}

	private AccountNode searchAccount(int count){
		if(count == 0)
				return account.getFront();
		System.out.println("Count: "+count);
		AccountNode current = account.getFront();
		for(int i = 0; i < count; i ++){
			System.out.println(current.getData().getUserName()+" "+current.getData().getPassword());
			current = current.getNext();
		}
		return current;
	}
	
	public ArrayList<Integer> nameExist(String name){
		String[] names = name.split("\\s+");
		
		ArrayList<Integer> found = new ArrayList<Integer>();
		for(int i = 0; i < names.length; i++){
			System.out.println("NameExists: "+names[i]);
			AccountNode current = account.getFront();
			int count = 0;
			while(current != null){
				
				if(current.getData().getFirstName().equalsIgnoreCase(names[i]) || current.getData().getLastName().equalsIgnoreCase(names[i])){
					System.out.println("Added: "+names[i]);
					found.add(count);
				}
				count ++;
				current = current.getNext();
			}
		}
		return found;
	}
	
	public boolean getAlumni(int count){
		
		return searchAccount(count).getData().isAlum();
	}
	
	public String getFirst(int count){

		return searchAccount(count).getData().getFirstName();
	}
	
	public String getLast(int count){
		
		return searchAccount(count).getData().getLastName();
	}
	
	public void addUser(String u, String password, String f, String l, String s, int g, boolean a){
		account.enqueue(new User(u,password,f,l,s,g,a,numbOfUsers));
		numbOfUsers++;
	}
}
