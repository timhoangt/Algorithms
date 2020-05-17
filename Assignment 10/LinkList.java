/*Timothy Hoang
4/24/19
CMPT435-111*/

public class LinkList {
	
	
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
	LinkList(int gdata)
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
	
	public Node MergeList(Node a, Node b) { //sorts the linked list
		Node result = null; 
		if (a == null){ //if there is nothing in a
			return b;
		}
		if (b == null){ //if there is nothing in b
			return a;
		}
		if (a.data > b.data) { //if a is bigger than b
			result = b;
			result.next = MergeList(a, b.next);
		}
		else { //if b is bigger than a
			result = a;
			result.next = MergeList(a.next, b);
		}
		return result;
	}

	public int getLength(Node a) { //gets the length of the linkedlist
		int count = 0;
		Node h = a;
		while (h != null) {
			count++;
			h = h.next;
		}
		return count;
	}
	
	public Node Listsort(Node start)
	{
		// Complete this method to sort a Linked list
		// Return the first node in the sorted list
		// Feel free to change the method type, add/remove parameters
		// Full credit (30 points) will be awarded for an algorithm that is O(nlog n). 
		// Algorithms that are O(n^2) slower will be scored out of 10 points.
		Node leftHead = start;
		int mid = getLength(start) / 2; // find the mid of the linked list
		if (start.next == null){ //if there is nothing next
			return start; //return the list
		}

		while (mid - 1 > 0) { //while there is no mid
			leftHead = leftHead.next; 
			mid--;
		}

		Node rightHead = leftHead.next;// make rightHead points to the beginning of the second half of the list
		leftHead.next = null;// cut off the right part of the list
		leftHead = start;// make one pointer points at the beginning of the first half of the list

		Node t1 = Listsort(leftHead);//make recursive calls sorting each half
		Node t2 = Listsort(rightHead);
		return MergeList(t1, t2); // merge the sorted lists
		
	}
	
	public static void main(String[] args) {
		
		LinkList exlist = new LinkList(0);
		
		exlist.Insertend(1);
		exlist.Insertend(5);
		exlist.Insertend(2);
		exlist.Insertend(7);
		exlist.Insertend(10);
		exlist.Insertend(3);
		
		exlist.Listprint();
		//output: 0 1 5 2 7 10 3
		exlist.Listsort(exlist.head);
		exlist.Listprint();
		//output should be: 0 1 2 3 5 7 10
		
		
	}
	
	
	

}
