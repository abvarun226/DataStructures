package com.abvarun226.test;

/**
 * Created by bharghav on 1/11/15.
 */

class Stack {
    int stck[] = new int[10];
    int tos;

    Stack() {
        tos = -1;
    }

    void push(int item) {
        if(tos == 9) {
            System.out.println("Stack is full");
        } else {
            stck[++tos] = item;
        }
    }

    int pop() {
        if(tos < 0) {
            System.out.println("Stack underflow");
            return 0;
        }
        return stck[tos--];
    }

}

public class MyStack {

}
