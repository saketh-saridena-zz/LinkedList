package all;
import java.util.*;
class Node
{
	int data;
	Node next;
}
class Single_Linked_List
{
	static Node head=null,tail=null;
	static Scanner sc=new Scanner(System.in);
	static void create()
	{
		System.out.println("Enter total number of nodes");
		int n=sc.nextInt();
		for(int i=0;i<n;i++)
		{
			Node temp=new Node();
			System.out.println("Enter data");
			temp.data=sc.nextInt();
			temp.next=null;
			if(head==null)
				head=tail=temp;
			else
			{
				tail.next=temp;
				tail=temp;
			}
		}
	}
	static void display()
	{
		if(head==null)
			System.out.println("List is empty");
		else
		{
			Node temp;
			temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
			System.out.println();
		}
	}
	static void Ins_Begin()
	{
		Node temp=new Node();
		System.out.println("Enter data");
		temp.data=sc.nextInt();
		temp.next=null;
		if(head==null)
			System.out.println("List is empty");
		else
		{
			temp.next=head;
			head=temp;
		}
	}
	static void Ins_End()
	{
		Node temp=new Node();
		System.out.println("Enter data");
		temp.data=sc.nextInt();
		temp.next=null;
		if(head==null)
			head=tail=temp;
		else
		{
			tail.next=temp;
			tail=temp;
		}
	}
	static void Ins_Pos(int p)
	{
		Node c=head;
		int count=1;
		while(c!=null)
		{
			if(count==p-1)
				break;
			c=c.next;
			count++;
		}
		if(c!=null)
		{
			Node temp=new Node();
			System.out.println("Enter Data");
			temp.data=sc.nextInt();
			temp.next=c.next;
			c.next=temp;
		}
		else
			System.out.println("Invalid position");
	}
	static void Delete_head()
	{
		Node temp=head;
		if(head!=null)
		{   
			head=head.next;
			temp=null;
		}
		else if(head==tail)
			head=tail=null;
		else
			System.out.println("List is empty");
	}
	static void Delete_Pos(int p)
	{
		Node c=head,prev=null;
		int count=1;
		while(c!=null)
		{
			if(count==p)
				break;
			prev=c;
			c=c.next;
			count++;
		}
		if(c!=null)
		{
			if(head==tail)
			head=tail=null;
		    else
			{
			prev.next=c.next;
				if(c==tail)
					tail=prev;
			c=null;
			}
		}
		else
		{
			System.out.println("Invalid position");
		}
	}
	static void Delete_tail()
	{
		Node temp=head;
		if(head==tail)
			head=tail=null;
		else if(head!=tail)
		{
			while(temp.next!=tail)
			{
				temp=temp.next;
			}
			tail=temp;
			tail.next=null;
		}
			
		else
			System.out.println("List is empty");
	}
	public static void main(String args[])
	{
		create();
		display();
		int ch,p;
		while(true)
		{
			System.out.println("Enter choice \n 1.Insert at Begining \n 2. Insert at Pos\n 3. Insert at End \n 4. Delete Head \n 5. Delete Specified pos Node \n 6. Delete Tail \n 7. Exit");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1: Ins_Begin();
						display();
						break;
				case 2: System.out.println("Enter position of new element");
						p=sc.nextInt();
						Ins_Pos(p);
						display();
						break;
				case 3: Ins_End();
						display();
						break;
				case 4: Delete_head();
						display();
						break;
				case 5: System.out.println("Enter position of element to be deleted");
						p=sc.nextInt();
						Delete_Pos(p);
						display();
						break;
				case 6: Delete_tail();
						display();
						break;
				case 7: System.exit(0);
						break;
				default: System.out.println("Invalid choice");
						break;
			}
		}
	}
}
