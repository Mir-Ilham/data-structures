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
}
