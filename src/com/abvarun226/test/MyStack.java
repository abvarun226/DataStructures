package com.abvarun226.test;

/**
 * Created by bharghav on 1/11/15.
 */

class Stack {
    int[] stck = new int[10];
    int tos;

    public Stack() {
        tos = -1;
    }

    public void push(int item) {
        if(tos == 9) {
            System.out.println("Stack is full");
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
        Stack myStack1 = new Stack();
        myStack1.push(1);
        myStack1.push(2);
        myStack1.push(3);

        System.out.println("Pop element from Stack : " + myStack1.pop());
        System.out.println("Pop element from Stack : " + myStack1.pop());
        System.out.println("Pop element from Stack : " + myStack1.pop());

        System.out.println("Pop element from Stack : " + myStack1.pop());

    }
}
