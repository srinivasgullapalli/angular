package com.srinivas.design.patterns.examples.linkedLists;

public class LinkedListOperations {

	Node head;

	static class Node {
		Integer data;
		Node next;

		Node(Integer d) {
			this.data = d;
			this.next = null;
		}
	}
	
	
	public void add(Integer data)
	{
		Node newNode = new Node(data);
		newNode.next=head;
		head = newNode;
		
	}
	
	public  Integer printMiddleElement()
	{
	Node slowPointer=head;
	Node fastPointer=head;
	if(head !=null)
	{
		while(fastPointer !=null && fastPointer.next !=null)
		{
			fastPointer =fastPointer.next.next;
			slowPointer =slowPointer.next;
		}
		return slowPointer.data;
	}
	return null;
	}
	
	public void printLinkedList()
	{
		Node currentNode=head;
		while(currentNode !=null)
		{
			System.out.print(currentNode.data+" -> ");
			currentNode=currentNode.next;
		}
		System.out.println("NULL");
	}
	
	public LinkedListOperations.Node reverseLinkedList(Node data)
	{
		Node currentNode=data;
		Node previousNode=null;
		Node nextNode=null;
		while(currentNode !=null)
		{
			nextNode =currentNode.next;
			currentNode.next=previousNode;
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

	public static void main(String[] args) {
        LinkedListOperations list = new LinkedListOperations();
       
        for(Integer i=5;i>0;i--)
        {
        list.add(i);
        list.printLinkedList();
        }
        System.out.println("Middle Element is : "+list.printMiddleElement());
	}
	
	

}
