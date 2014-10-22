package com.yahoo.test;

class Link {
	public int data1;
	public Link nextLink;
	
	public Link(int d1) {
		data1 = d1;
	}
	
	public void printOut() {
		System.out.println("Data = " + data1);
	}
	
}


class LinkList {
	private Link first;
	public static int length=0;
	
	public LinkList() {
		first = null;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void insert(int d1) {
		length++;
		Link link = new Link(d1);
		link.nextLink = first;
		first = link;
	}
	
	public Link delete() {
		if(this.isEmpty()) {
			System.out.println("Delete Failed! List is Empty!");
			return null;
		}
		length--;
		Link temp = first;
		first = first.nextLink;
		return temp;
	}
	
	public int length() {
		return length;
	}
	
	public void printList() {
		Link currentLink = first;
		System.out.println("List: ");
		while(currentLink != null) {
			currentLink.printOut();
			currentLink = currentLink.nextLink;
		}
		System.out.println("");
	}
}
public class MyLinkedList {

	/*
	 * Linked List Basics 
	 * http://cslibrary.stanford.edu/103/LinkedListBasics.pdf
	 * 
	 */
	
	public static void main(String[] args) {
		LinkList list = new LinkList();
		
		System.out.println("Is List empty : " + list.isEmpty() + "\n");
		list.insert(1);
		list.insert(3);
		list.insert(5);
		list.insert(7);
		
		System.out.println("Length of List : " + list.length());
		
		list.printList();
		
		Link temp = list.delete();
		System.out.print("Deleted Link : ");
		temp.printOut();
		System.out.println("Length of List : " + list.length());
		
		System.out.println("\nIs List empty : " + list.isEmpty() + "\n");
		
		list.printList();

		Link temp1 = list.delete();
		System.out.println("Length of List : " + list.length());
		Link temp2 = list.delete();
		System.out.println("Length of List : " + list.length());
		Link temp3 = list.delete();
		System.out.println("Length of List : " + list.length());
		Link temp4 = list.delete();
		System.out.println("Length of List : " + list.length());
	}

}
