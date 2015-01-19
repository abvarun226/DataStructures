package com.abvarun226.test;

/**
 * Created by bharghav on 1/11/15.
 */

class Stack {
    private int[] stck;
    private int tos;

    Stack() {
        tos = -1;
        stck = new int[10];
        System.out.println("By default, Initializing Stack size to 10");
    }

    Stack(int stackSize) {
        tos = -1;
        stck = new int[stackSize];
        System.out.println("Initializing Stack size to " + stackSize);
    }

    public void push(int item) {
        if(tos == stck.length-1) {
            System.out.println("Stack overflow");
        } else {
            stck[++tos] = item;
        }
    }

    public int pop() {
        if(tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        return stck[tos--];
    }

}

public class MyStack {
    public static void main(String... args) {
        Stack myStack1 = new Stack(20);
        for(int i=0 ; i<21 ; i++) {
            myStack1.push(i);
        }

        System.out.println("Pop element from Stack : " + myStack1.pop());
        System.out.println("Pop element from Stack : " + myStack1.pop());
        System.out.println("Pop element from Stack : " + myStack1.pop());

        System.out.println("Pop element from Stack : " + myStack1.pop());

    }
}
