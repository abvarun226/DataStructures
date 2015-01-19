package com.abvarun226.test;

/**
 * Created by bharghav on 1/11/15.
 */

class Link<T> {
    public T data1;
    public Link nextLink;

    public Link(T d1) {
        data1 = d1;
    }

    public void printOut() {
        System.out.println("Data = " + data1);
    }

}


class LinkList<T> {
    private Link<T> first;
    public static int length=0;

    public LinkList() {
        first = null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void insert(T d1) {
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
        LinkList<Integer> list = new LinkList<Integer>();

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

        System.out.println("\n-----------------------------------------\n");

        LinkList<String> list1 = new LinkList<String>();

        System.out.println("Is List empty : " + list1.isEmpty() + "\n");
        list1.insert("one");
        list1.insert("two");
        list1.insert("three");
        list1.insert("four");

        System.out.println("Length of List : " + list1.length());

        list1.printList();

        Link temp5 = list1.delete();
        System.out.print("Deleted Link : ");
        temp5.printOut();
        System.out.println("Length of List : " + list1.length());

        System.out.println("\nIs List empty : " + list1.isEmpty() + "\n");

        list1.printList();

        list1.delete();
        System.out.println("Length of List : " + list1.length());
        list1.delete();
        System.out.println("Length of List : " + list1.length());
        list1.delete();
        System.out.println("Length of List : " + list1.length());
        list1.delete();
        System.out.println("Length of List : " + list1.length());
    }

}