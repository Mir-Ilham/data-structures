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
}
