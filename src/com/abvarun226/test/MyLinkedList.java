package com.abvarun226.test;

/**
 * Created by bharghav on 1/11/15.
 */

class Link<T> {
    private T data;
    private Link nextLink;

    public Link(T d1) {
        data = d1;
        nextLink = null;
    }

    public T getData() { return data; }

    public void setNextLink(Link<T> nextLink) {
        this.nextLink = nextLink;
    }

    public Link<T> getNextLink() {
        return nextLink;
    }

}


class LinkList<T> {
    private Link<T> first;
    private int length;

    public LinkList() {
        first = new Link(null);
        length = 0;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void insert(T d1) {
        length++;
        Link<T> link = new Link<T>(d1);
        Link<T> current = first;
        while (current.getNextLink() != null) {
            current = current.getNextLink();
        }
        current.setNextLink(link);
    }

    public void insert(T d1, int index) {
        length++;
        Link<T> link = new Link<T>(d1);
        Link<T> current = first;
        for(int i=1 ; i < index && current.getNextLink() != null ; i++) {
            current = current.getNextLink();
        }

        link.setNextLink(current.getNextLink());
        current.setNextLink(link);

    }

    public T delete(int index) {
        if(index <= 0 || index > length()) {
            return null;
        }

        if(this.isEmpty()) {
            System.out.println("Delete Failed! List is Empty!");
            return null;
        }
        length--;
        Link<T> temp = first;
        for(int i=1 ; i<index ; i++) {
            if(temp.getNextLink() == null) {
                return null;
            }
            temp = temp.getNextLink();
        }

        T output = temp.getNextLink().getData();
        temp.setNextLink(temp.getNextLink().getNextLink());
        return output;
    }

    public int length() {
        return length;
    }

    public T get(int index) {
        if(index < 0) {
            return null;
        }
        index++;
        Link<T> currentLink = first;
        for(int i=1 ; i<=index ; i++) {
            if(currentLink.getNextLink() == null) {
                return null;
            }
            currentLink = currentLink.getNextLink();
        }
        return currentLink.getData();

    }

    public String toString() {
        Link<T> current = first.getNextLink();
        String output = "[";
        while (current != null) {
            output += current.getData().toString();
            current = current.getNextLink();
            if(current != null) {
                output += " , ";
            }
        }
        output += "]";
        return output;
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

        try {
            System.out.println("Is list empty : " + list.isEmpty() + "\n");
            list.insert(1);
            list.insert(3);
            list.insert(5);
            list.insert(7);

            System.out.println("List list = " + list);

            int temp = list.delete(list.length());

            System.out.println("\nDeleted : " + temp);
            System.out.println("List list = " + list);
            System.out.println("Length of list : " + list.length());

            System.out.println("\nIs list empty : " + list.isEmpty() + "\n");


            System.out.println("\nDeleted : " + list.delete(list.length()));
            System.out.println("List list = " + list);

            System.out.println("\nDeleted : " + list.delete(list.length()));
            System.out.println("List list = " + list);

            System.out.println("\nDeleted : " + list.delete(list.length()));
            System.out.println("List list = " + list);

            System.out.println("\nDeleted : " + list.delete(list.length()));
            System.out.println("List list = " + list);
            System.out.println("Length of List : " + list.length());

            System.out.println("\n-----------------------------------------\n");

            LinkList<String> list1 = new LinkList<String>();

            System.out.println("Is List empty : " + list1.isEmpty() + "\n");
            list1.insert("one");
            list1.insert("two");
            list1.insert("three");
            list1.insert("four");

            System.out.println("Length of List : " + list1.length());

            System.out.println("List list1 = " + list1);

            list1.delete(list1.length()-2);
            System.out.println("List list1 = " + list1);
            list1.delete(1);
            System.out.println("List list1 = " + list1 );
            list1.delete(list1.length());
            System.out.println("List list1 = " + list1 );
            System.out.println("\nIs List empty : " + list1.isEmpty() + "\n");

            System.out.println("Value at position 0: " + list1.get(0));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

}