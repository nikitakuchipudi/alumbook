
public class AccountNode {

	private User user;
	private AccountNode next;
	
	AccountNode(User user){
		this.user = user;
		next = null;
	}
	
	AccountNode(User user, AccountNode next){
		this.user = user;
		this.next = next;
	}
	
	public void setNode(AccountNode node){
		next = node;
	}
	
	public AccountNode getNext(){
		return next;
	}

	public void setData(User data){
		this.user = data;
	}

	public User getData(){
		return user;
	}

	@Override
	public String toString(){
		return "AccountNOde[ data: "+user.toString()+", next: "+next + "]";
	}
}
