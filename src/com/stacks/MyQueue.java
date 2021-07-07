package com.stacks;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	private class QueueNode<T> {
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data) {
			this.data = data;
		}
	}
	
	private QueueNode<T> front;
	private QueueNode<T> back;
	
	public void add(T data) {
		QueueNode node = new QueueNode(data);
		if(back!=null) {
			back.next = node;
		}
		back = node;
		//The below statement only gets executed when the queue is empty
		if(front == null) {
			front = back;
		}
	}
	
	public T remove() {
		if(front == null) throw new NoSuchElementException();
		T data = front.data;
		front = front.next;
		if(front == null) {
			back = null;
		}
		return data;
	}
	
	public T peek() {
		if(front == null) throw new NoSuchElementException();
		return front.data;
	}
	
	public boolean isEmpty() {
		return front == null;
	}
	
	
	
	
}
