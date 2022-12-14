package com.ilham.datastructures.linkedlist;

public class LinkedList<T> {
	private int size = 0;
	private Node<T> head = null;
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}
	
	public int length() {
		return this.size;
	}
	
	public void addBegin(T elem) {
		Node<T> newNode = new Node<T>(elem, null);
		if (this.head == null) {
			this.head = newNode;
		} else {
			newNode.next = this.head;
			this.head = newNode;
		}
		this.size++;
	}
	
	public void addAtIndex(T elem, int index) {
		// Add an element to a specific index of the linked list
		// If index is zero add at head
		// If index = list size add at tail
		if (index < 0 || index > this.size) {
			throw new IllegalArgumentException();
		}
		if (index == 0) {
			addBegin(elem);
		} else {
			Node<T> newNode = new Node<T>(elem, null);
			Node<T> temp = getNode(index - 1);
			newNode.next = temp.next;
			temp.next = newNode;
			this.size++;
		}
	}
	
	public void addEnd(T elem) {
		addAtIndex(elem, this.size);
	}
	
	public T get(int index) {
		// Return data in the node of given index
		if (index < 0 || index > this.size - 1)
			throw new IllegalArgumentException();
		return getNode(index).data;
	}
	
	public void set(T elem, int index) {
		// Update data of node at given index
		if (index < 0 || index > this.size - 1)
			throw new IllegalArgumentException();
		getNode(index).data = elem;
	}
	
	public T removeBegin() {
		if (this.size == 0)
			throw new RuntimeException("Empty list");
		T data = this.head.data;
		Node<T> temp = this.head.next;
		this.head.data = null;
		this.head.next = null;
		this.head = temp;
		this.size--;
		return data;
	}
	
	public T removeAtIndex(int index) {
		// Remove an element from a specific index of the linked list
		// If index is zero remove from head
		// If index = list.size - 1 remove from tail
		if (this.size == 0)
			throw new RuntimeException("Empty list");
		if (index < 0 || index > this.size - 1)
			throw new IllegalArgumentException();
		if (index == 0) {
			return removeBegin();
		} else {
			Node<T> temp1 = getNode(index - 1);
			Node<T> temp2 = temp1.next;
			T data = temp2.data;
			temp1.next = temp2.next;
			temp2.next = null;
			temp2.data = null;
			this.size--;
			return data;
		}
	}
	
	public T removeEnd() {
		return removeAtIndex(this.size - 1);
	}
	
	private Node<T> getNode(int index) {
		// Return reference to the node at the given index
		// Index is assumed to be valid
		Node<T> temp = this.head;
		int counter = 0;
		while (true) {
			if (counter == index)
				return temp;
			temp = temp.next;
			counter++;
		}
	}
	
	@Override
	public String toString() {
		if (this.head == null) {
			return "[]";
		}
		String result;
		StringBuilder sb = new StringBuilder("[");
		Node<T> temp = this.head;
		while (temp != null) {
			sb.append(temp.toString() + ", ");
			temp = temp.next;
		}
		result = sb.toString();
		result = result.substring(0, result.length() - 2) + "]";
		return result;
	}
}
