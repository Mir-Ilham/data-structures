package com.ilham.datastructures.dynamicarray;

@SuppressWarnings("unchecked")
public class DynamicArray<T> {
	private T arr[];
	private int len = 0;
	private int capacity = 0;
	
	DynamicArray() {
		// Default initialization
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
		// Add item to the end of the array
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
	
	public T remove() {
		// Remove or Pop an element from the last index of array and return it
		if(isEmpty()) {
			throw new RuntimeException("Removing from empty array.");
		}
		T item = this.arr[len - 1];
		this.arr[this.len - 1] = null;
		this.len--;
		return item;
	}
	
	public T removeAtIndex(int index) {
		// Remove an item from given index and return it
		T item = this.arr[index];
		for (int i = index; i < this.len - 1; i++) {
			this.arr[i] = this.arr[i + 1];
		}
		this.arr[this.len - 1] = null;
		this.len--;
		return item;
	}
	
	public boolean removeItem(T item) {
		// Return true if first occurence of item removed else false
		int index = getIndex(item);
		if (index == -1) {
			return false;
		} else {
			removeAtIndex(index);
			return true;
		}
		
	}
	
	public void clear() {
		for (int i = 0; i < this.len; i++) {
			this.arr[i] = null;
		}
		this.len = 0;
	}
	
	public int getIndex(T item) {
		for (int i = 0; i < this.len; i++) {
			if (this.arr[i] == item)
				return i;
		}
		return -1;
	}
	
	public boolean contains(T item) {
		return getIndex(item) != -1;
	}
	
	public int size() {
		return this.len;
	}
	
	public int length() {
		return this.len;
	}
	
	@Override
	public String toString() {
		if (this.len == 0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		int i = 0;
		for (i = 0; i < this.len - 1; i++) {
			sb.append(this.arr[i].toString() + ", ");
		}
		sb.append(this.arr[i] + "]");
		return sb.toString();
	}
}
