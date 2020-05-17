/*Timothy Hoang
2/24/19
CMPT435-111*/
public class LinkedList {
	
	
	// The LinkedList Node class
	private class Node{
		
		int data;
		Node next;
		
		Node(int gdata)
		{
			this.data = gdata;
			this.next = null;
		}
		
	}
	
	// The LinkedList fields
	Node head;
	
	// Constructor
	LinkedList(int gdata)
	{
		this.head = new Node(gdata);
	}
	
	public void Insertend(int gdata)
	{
		Node current = this.head;

		while(current.next!= null)
		{
			current = current.next;
		}
		
		Node newnode = new Node(gdata);
		current.next = newnode;
		
	}
	
	public void Listprint()
	{
		Node current = this.head;

		while(current!= null)
		{
			System.out.print(current.data + " ");
			current = current.next;
		}
		
		System.out.println();
		
	}
	
	public void Removemin() {
	// Complete this method to remove the minimum value in a linkedlist
		int min = 0; //initializes min value, doesnt matter becaue it automatically turns into the first value of the linked list
		boolean minChosen = false;//boolean to acutally initialize min value
		Node current = this.head; //stores current and first item in linked list
		Node beginning = this.head;


		while(current != null) //if there is a current item
		{
			if(minChosen == false) //if its the first item
			{
				min = current.data; //initialize min value
				minChosen = true; 
				current = current.next; //mvoe to next item
			}
			else if(min > current.data) //if the item is less than the current min value
			{
				min = current.data; //replace the min value 
				current = current.next;
			}
			else
			{
				current = current.next;
			}
		}

		current = this.head;
		//System.out.println("min is: "+ min);
		Node previous = this.head; //initializes previous item

		while(current != null) //if there is a current item
		{
			if(current.data == min) //and the value matches the min value
			{

				previous.next = current.next; //link the previous item in the linked list to the next item in the linked list
				current = null; //nulliy the current item

			}
			else
			{
				previous = current; //previous is the current value
				current = current.next; //move to next item in linked list
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		LinkedList exlist = new LinkedList(8);
		
		exlist.Insertend(1);
		exlist.Insertend(5);
		exlist.Insertend(2);
		exlist.Insertend(7);
		exlist.Insertend(10);
		exlist.Insertend(3);
		
		exlist.Listprint();
		//output: 8 1 5 2 7 10 3
		
		exlist.Removemin();
		
		exlist.Listprint();
		//output should be: 8 5 2 7 10 3		
	}
	
	
	

}
