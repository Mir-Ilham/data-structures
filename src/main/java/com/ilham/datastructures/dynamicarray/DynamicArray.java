package com.ilham.datastructures.dynamicarray;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {
	private T arr[];
	private int len = 0;
	private int capacity = 0;
	
	DynamicArray() {
		this(16);
	}
	
	DynamicArray(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Illegal Capacity: " + capacity);
		}
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	public int getCapacity() {
		return this.capacity;
	}
	
	public boolean isEmpty() {
		return this.len == 0;
	}
	
	public void add(T item) {
		if (this.len + 1 > this.capacity) {
			expandCapacity();
		}
		this.arr[len++] = item;
	}
	
	public void addAtIndex(T item, int index) {
		if (this.len + 1 > this.capacity) {
			expandCapacity();
		}
		for (int i = this.len - 1; i >= index; i--) {
			this.arr[i + 1] = this.arr[i];
		}
		this.arr[index] = item;
		this.len++;
	}
	
	private void expandCapacity() {
		this.capacity *= 2;

		T temp[] = (T[]) new Object[capacity];
		for (int i = 0; i < len; i++)
			temp[i] = arr[i];
		arr = temp;
	}
	
	public T get(int index) {
		if (index < 0 || index > len - 1)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		return this.arr[index];
	}
	
	public void set(int index, T item) {
		if (index < 0 || index > this.len)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		this.arr[index] = item;
	}
	
	public void remove() {
		// Remove or Pop an element from the last index of array
		if(isEmpty()) {
			throw new RuntimeException("Removing from empty array.");
		} else {
			arr[this.len - 1] = null;
			this.len--;
		}
	}
	
	public int size() {
		return this.len;
	}
	
	public int length() {
		return this.len;
	}
}
