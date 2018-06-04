
import java.util.Scanner;
import java.util.Random;

public class LList // Linked List that keeps track of the head, tail, and count
{
	private Node head;
	private Node tail;
	private int count;
	
	public void display() // display method that prints the linked list in a wonderful format
	{
		if(getHead() == null)
		{
			return;
		}
		Node current = getHead();
		while(current != null) // as long as current isnt null, it adds the "pointer" 
		{
			System.out.print(current.getData() + "--> \n");
			current=current.getNext();
		}
		System.out.print(current);
	}
	
	public class Node   // node class with various methods such as add and delete
	{
		private InfoType data;
		private Node next;
		
		public Node(InfoType data)   // setter for the node data and next
		{
			this.setData(data);
			this.setNext(null);
		}

		public Node getNext() // getter for next
		{   
			return next;
		}

		public void setNext(Node next) // setter for next
		{
			this.next = next;
		}

		public InfoType getData() // getter for data
		{
			return data;
		}

		public void setData(InfoType data) // setter for data
		{
			this.data = data;
		}
	}
	
	/**public void addAfter(Node previous, InfoType data) 
	{
		if(previous == null)
		{
			System.out.println("The given previous node cannot be null");
			return;
		}
		Node newNode = new Node(data);
		newNode.next = previous.next;
		previous.next = newNode;
	}
	
	
	public void insert(InfoType data)
	{
	
			Node newNode = new Node(data);
			if(head != null)
			{
				head.next = newNode;
			}
			else
			{
				head = newNode;
			}
			tail = newNode;
			count++;
	}*/
	
	public Node addAtBeginning(InfoType data) // add at beginning of the list
	{
		Node newNode = new Node(data);
		count++;							// first thing to do is increase the count
		if(getHead() == null)
		{
			setHead(newNode);    //if its empty initially then the new node is the head and tail
			tail = newNode;
			return newNode;
		}
		newNode.setNext(getHead());    // if not, the new node points to the head
		setHead(newNode);     // now the new node is the head
		return getHead();     // return the new head
	}
	
	public Node addAtEnd(InfoType data) // add at end of the linked list
	{
		Node newNode = new Node(data);
		count ++;						// first thing to do is add to the  count
		if(getHead() == null)
		{
			setHead(newNode);    // if it was initially empty then the new node is the head and tail
			tail = newNode;
			return newNode;
		}
		tail.setNext(newNode);    // if not, now the tail points to the new node
		tail = newNode;  		// now we make the new node equal to the tail of the list
		newNode.setNext(null);     // now have the new tail point to null signifying it's the end
		return tail;			// now return the new tail
		
	}
	public int length()      // just getting the length of the list by getting the count
	{
		return count;
	}
	
	public Node addAtPosition(InfoType data, int position) // adds at a certain position to the list
	{
		int size = count;
		if(position > size + 1 || position < 1)      // if the pos is out of bounds then its invalid
		{
			System.out.println("Invalid position");
			return getHead();
		}
		Node newNode = new Node(data);   // add to the count since we are adding
		count++;
		if(position == 1)
		{
			newNode.setNext(getHead());     // if the position is 1 then the new node points to the head
			return newNode;
		}
		else
		{
			Node previous = getHead();    // make a previous node that is one behind the current
			int count = 1;
			while(count < position -1)      
			{
				previous = previous.getNext();
				count = count +1;
			}
			Node current = previous.getNext();   //current is what previous points to
			newNode.setNext(current);    // the new node points to current
			previous.setNext(newNode);    // previous points to new Node
			return getHead();               // now return the head
			
		}
	}
	
	public Node deleteFirst(Node head) // delete the first node to list 
	{
		if(head == null)			// if its empty then return list, cant delete from empty list
		return head;
		{
			Node temp = head;    // temp node equals the head
			head = head.getNext();    // head is now equal to what head was pointing to
			temp.setNext(null); 	// now temp points to null, breaking it from the list
			return temp;		// return temp value
		}
	}
	
	public Node deleteLast(Node head) // delete last node of linked list
	{
		if(head == null)	// if empty then return the head 
		{
			return head;
		}
		Node last = head;      // set last to the head of the list
		Node previousToLast = null;   // make a node previous to last and set it to null
		while(last.getNext() != null)
		{
			previousToLast = last;    // now set previous to last equal to last
			last = last.getNext();     // last equals what it was pointing to
		}
		previousToLast.setNext(null);     // previous to last now points to null 
		return last;    // return the last element which is what we deleted from the list
	}
	
	public InfoType deleteAtPosition(int position) // delete node from certain position on the list 
	{
		int size = count; 
		if(position > size || position < 1)
		{
			System.out.println("Invalid Position");   // index error if the position ist in the list
			return getHead().getData();   // then just return the list
		}
		if(position ==1)
		{
			Node temp = getHead();    // the temp value is equal to the head value
			setHead(getHead().getNext());   // now head is equal to  what it pointed to
			temp.setNext(null);	// temp's pointer value now equals null
			return temp.getData();	// return the data from temp
		}
		else
		{
			Node previous = getHead();    // Node previous equals the head value
			int current = 1;
			while(current < position -1)
			{
				previous = previous.getNext();
				current++;	
			}
			Node target = previous.getNext();   //node target equals what previous pointed to
			previous.setNext(target.getNext());	// previous's pointer equals the target's pointer now
			target.setNext(null);       // target now points to null
			return target.getData();       //return the data of target
		}
	}
	
	/**public boolean find(Node head, InfoType searchKey)
	{
		if(head == null)
		{
			return false;
		}
		Node current = head;
		while(current != null)
		{
			if(current.data == searchKey)
			{
				return true;
			}
			current = current.next;
		}
		return false;
	}*/
	
	public int searchByID(int id)    // searches by the ID value in InfoType
	{
		int pos = 0;		//position = 0
		if(getHead() == null)		// if head = null then return -1, no bueno
		{
			return -1;
		}
		Node current = getHead();    // now current equals to head
		
		if(current.getData().id == id)    // we are looking for currents data ID to be equal to the ID typed in
		{
			return 1;
		}
		
		while(current.getData().id != id)  // if not equal to id, then make a pos = i, if current is not 
		{
			for (int i=1;i<count+1;i++)      // not equal to ID value then set current to what it was pointing to
			{
				pos=i;
				if(current.getData().id == id)
				{
					return pos;
				}
				current=current.getNext();
			}
			return -1;
		}
		return -1;
	}
	
	public int searchByX(int x)    // searches by the x value in InfoType
	{
		int pos = 0;		//position = 0
		if(getHead() == null)		// if head = null then return -1, no bueno
		{
			return -1;
		}
		Node current = getHead();    // now current equals to head
		
		if(current.getData().x == x)    // we are looking for currents data x to be equal to the x typed in
		{
			return 1;
		}
		
		while(current.getData().x != x)  // if not equal to x, then make a pos = i, if current is not 
		{
			for (int i=1;i<count+1;i++)      // not equal to x value then set current to what it was pointing to
			{
				pos=i;
				if(current.getData().x == x)
				{
					return pos;
				}
				current=current.getNext();
			}
			return -1;
		}
		return -1;
	}
	
	public double searchByY(double y)    // searches by the y value in InfoType
	{
		int pos = 0;		//position = 0
		if(getHead() == null)		// if head = null then return -1, no bueno
		{
			return -1;
		}
		Node current = getHead();    // now current equals to head
		
		if(current.getData().y == y)    // we are looking for currents data y to be equal to the y typed in
		{
			return 1;
		}
		
		while(current.getData().y != y)  // if not equal to y, then make a pos = i, if current is not 
		{
			for (int i=1;i<count+1;i++)      // not equal to y value then set current to what it was pointing to
			{
				pos=i;
				if(current.getData().y == y)
				{
					return pos;
				}
				current=current.getNext();
			}
			return -1;
		}
		return -1;
	}
	
	public Node getHead() //getter for head
	{
		return head;
	}

	public void setHead(Node head) // setter for head
	{
		this.head = head;
	}

	
	public static void main(String[] args) // main method that does testing
	{
		Scanner kb = new Scanner(System.in);   // make a scanner
		
		Random rand = new Random();       // new random number generator
		
		InfoType[] data = new InfoType[5];
		
		for(int i=0; i<5; i++)    // generate 5 values for the LList
		{
			data[i] = new InfoType();
			data[i].id = rand.nextInt(50);
			data[i].x = rand.nextInt(50);
			data[i].y = rand.nextDouble();
		}
		//  Elements that I'm starting with
		System.out.println("Element - ID - X - Y");   // formatting
		System.out.println();
		System.out.println("A="+data[0]+"\nB="+data[1]+"\nC="+data[2]+"\nD="+data[3]+"\nE="+data[4]); // printing values
		
		LList LList = new LList();
		LList.display();  // display list
		System.out.println();
		Node newHead = LList.addAtBeginning((data[0]));   // add at top
		Node newHead2 = LList.addAtBeginning((data[1]));    // add at top
		Node newHead3 = LList.addAtBeginning((data[2]));    // add at top
		// c, b , a
		LList.display();
		System.out.println();
		Node newHead4 = LList.addAtEnd((data[3]));  // add at end
		LList.addAtPosition((data[4]), 3);   // add at position
		System.out.println();
		LList.display();    // show linked list
		// c, b, e, a, d
		System.out.println();
		System.out.println("Length of linked list is " + LList.length());
		System.out.println();
		
		System.out.println("Pick the ID value that you would like to search for and delete:");
		int searchID = kb.nextInt(); // store value as the one to search for, for ID
		int idPos = LList.searchByID(searchID);
		InfoType tempData = new InfoType();
		tempData = LList.deleteAtPosition(idPos);
		System.out.println("List without the element selected:");   // prints list with element removed
		System.out.println();
		LList.display();
		System.out.println();
		LList.addAtBeginning(tempData);  // adds that element back on top now print again
		System.out.println();
		System.out.println("Element added back to beginning of the list:");
		System.out.println();
		LList.display();
		System.out.println();
		
		System.out.println();
		System.out.println("Pick the X value that you would like to search for and delete:"); // search for x and delete
		int searchX = kb.nextInt();
		idPos = LList.searchByX(searchX);
		tempData = new InfoType();
		tempData = LList.deleteAtPosition(idPos);
		System.out.println("List without the element selected:"); // print without selected element
		System.out.println();
		LList.display();
		System.out.println();
		LList.addAtBeginning(tempData);
		System.out.println();
		System.out.println("Element added back to beginning of the list:"); // add back on top now print with it
		System.out.println();
		LList.display();
		System.out.println();
		System.out.println();
		System.out.println("Unsorted linked list with 32 random elements");
		System.out.println();
		
		LList = new LList();    // generates 32 random elements to add to the linked list
		data = new InfoType[32];
		for(int i=0; i<32; i++)
		{
			data[i] = new InfoType();
			data[i].id = rand.nextInt(100);
			data[i].x = rand.nextInt(100);
			data[i].y = rand.nextDouble();
			
			LList.addAtBeginning(data[i]);
		}
		LList.display();
		System.out.println();
		System.out.println();
		System.out.println("List now sorted by their Y values:");
		System.out.println();
		SortedLList sortMe = new SortedLList(LList); // sort me sorts the linked list by their Y and displays the list
		
	}
}
