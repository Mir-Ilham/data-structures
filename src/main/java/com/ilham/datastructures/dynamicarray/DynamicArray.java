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
		if (capacity < 0) {
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
			if (this.capacity == 0) {
				this.capacity = 1;
			} else {
				this.capacity *= 2;				
			}

			T temp[] = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++)
				temp[i] = arr[i];
			arr = temp;
		}
		arr[len++] = item;
	}
	
	public T get(int index) {
		if (index < 0 || index > len - 1)
			throw new IndexOutOfBoundsException("Index " + index + " is out of bounds!");
		return this.arr[index];
	}
}
