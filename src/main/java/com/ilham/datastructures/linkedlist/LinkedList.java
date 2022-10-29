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
