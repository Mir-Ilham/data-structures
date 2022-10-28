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
			newNode.next = head;
			head = newNode;
		}
		this.size++;
	}
	
	@Override
	public String toString() {
		if (this.head == null) {
			return "[]";
		}
		String result;
		StringBuilder sb = new StringBuilder("[");
		Node<T> temp = head;
		while (temp != null) {
			sb.append(temp.toString() + ", ");
			temp = temp.next;
		}
		result = sb.toString();
		result = result.substring(0, result.length() - 2) + "]";
		return result;
	}
}
