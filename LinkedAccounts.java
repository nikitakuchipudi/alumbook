
public class LinkedAccounts {
	private AccountNode head;		//First QueueNode;
	private int count;		//Counts
	
	public LinkedAccounts(){
		head = new AccountNode(null);
		count = 0;
	}
	
	public User dequeue(){
		try{
			if( head.getNext() == null)
				throw new UnderflowException("There is nothing to remove.");
			AccountNode temp = head.getNext().getNext();	//Holds next node
			User tempData = head.getNext().getData();		//Holds head's data
			head.setNode(temp);			//sets next node after head
			count --;
			return tempData;
		}catch(UnderflowException e){
			System.out.println(e);
			return null;
		}
	}

	public void enqueue(User newElement) {
		System.out.println("Enqueue: "+newElement.getUserName());
		AccountNode current = head;		//Sets current head;
		while(current.getNext() != null){	//Cycles through to find end node
			current = current.getNext();		
		}
		
		//Sets that last node to a new node with newElement
		current.setNode(new AccountNode(newElement));
		System.out.println(newElement.getUserName());
		count++;
		
	}

	public boolean remove(User itemToRemove) {
		AccountNode current = head;
		AccountNode previous = head;


		while(current.getNext() != null){
			if(current.getNext().getData() == itemToRemove){
				previous.setNode(current.getNext());
				return true;
			}
			current = current.getNext();
		}

		return false;
	}

	
	public boolean equals(LinkedAccounts other){
		LinkedAccounts otherQueue = other;
		AccountNode current = head;
		AccountNode current2 = otherQueue.head;
		
		if(otherQueue.getSize() == this.getSize()){
			while(current.getNext() != null){
				if(current.getNext().getData() != current2.getNext().getData())
					return false;
				current = current.getNext();
				current2 = current2.getNext();
			}
			return true;
		}
		else{
			return false;
		}

	}
	

	public AccountNode getFront() {
		try {
			if(count == 0)
				throw new UnderflowException("There is nothing. So there is no front to get :(");
			else
				return head.getNext();
		} catch (UnderflowException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return null;
		}
		
	}

	public int getSize(){
		return count;
	}

	public boolean isEmpty(){
		return head.getNext() == null;
	}

	public void makeEmpty(){
		count = 0;
		head.setNode(null);
	}
	
	@Override
	public String toString(){
		String word ="";
		AccountNode current = head;
		int count = 0;
		while(current.getNext() != null){
			word += current.getNext().getData() + " "+ count+"\n";
			current = current.getNext();
			count++;
		}  
		
		return word;
	}
}
