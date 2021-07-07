package com.stacks;

import java.util.EmptyStackException;

public class TwoStacks {
	
	int size;
	int top1,top2;
	int arr[];
	
	public TwoStacks(int size) {
		arr = new int[size];
		top1 = -1;
		top2 = size;
	}
	
	public void push1(int data) {
		top1++;
		if(top1 == top2) {
			System.out.println("Stack Overflow"); 
			return;
		}
		else {
			arr[top1] = data;
		}
	}
	
	public void push2(int data) {
		top2--;
		if(top1 == top2) {
			System.out.println("Stack Overflow");
			return;
		}
		else {
			arr[top2] = data;
		}
	}
	
	public int pop1() {
		if(top1 == -1) {
			System.out.println("Stack 1 is empty");
			throw new EmptyStackException();
		}
		else {
			int data = arr[top1];
			top1--;
			return data;
		}
	}
	
	public int pop2() {
		if(top2 == size) {
			System.out.println("Stack 2 is empty");
			throw new EmptyStackException();
		}
		else {
			int data = arr[top2];
			top2++;
			return data;
		}
	}
	
	public static void main(String args[]) {
		
		TwoStacks ts = new TwoStacks(5);
		ts.pop1();
		ts.push1(5);
        ts.push2(10);
        ts.push2(15);
        ts.push1(11);
        ts.push2(7);
        ts.pop1();
        
	}

}
