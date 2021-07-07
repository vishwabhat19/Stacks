package com.stacks;

import java.util.EmptyStackException;

public class StackMin {
	
	private class MinStackNode {
		private int data;
		private MinStackNode next;
		
		public MinStackNode(int data) {
			this.data = data;
		}
	}
	
	private MinStackNode top;
	
	public void push(int data) {
		MinStackNode node = new MinStackNode(data);
		if(top == null) {
			top = node;
		}
		else {
			if(top.data>data) {
				node.next = top;
				top = node;
			}
			else {
				//The number that you are going to enter is greater than top
				int temp = top.data;
				top.data = node.data;
				node.data = temp;
				node.next = top;
				top = node;
			}
		}
	}
	
	public int min() {
		return this.pop();
	}
	
	public int pop() {
		if(top == null) throw new EmptyStackException();
		MinStackNode node = top;
		top = top.next;
		return node.data;
	}

	public static void main(String[] args) {
		
		StackMin s = new StackMin();
		s.push(1);
		s.push(10);
		s.push(-1);
		s.push(100);
		s.push(500);
		System.out.println(s.pop());
	}

}
