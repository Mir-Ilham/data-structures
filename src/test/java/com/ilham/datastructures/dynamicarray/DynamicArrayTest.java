package com.ilham.datastructures.dynamicarray;

import static org.junit.Assert.*;

import org.junit.Test;

public class DynamicArrayTest {

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalArgumentExceptionForInvalidCapacity() {
		new DynamicArray<Integer>(-1);
	}
	
	@Test
	public void checkDefaultInitializationOfCapacity16() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
		assertEquals(16, dynamicarray.getCapacity());
	}

	@Test
	public void checkInitializationOfCapacity8() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(8);
		assertEquals(8, dynamicarray.getCapacity());
	}
	
	@Test
	public void checkForAnEmptyArray() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
		assertTrue(dynamicarray.isEmpty());
	}
	
	@Test
	public void testAddingSingleElementAndAccessingIt() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
		Integer a = 101;
		dynamicarray.add(a);
		assertEquals(a, dynamicarray.get(0));
	}
	
	@Test
	public void testCapacityDoubleFeatureOfDynamicArray() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(2);
		Integer a = 101;
		dynamicarray.add(a);
		dynamicarray.add(a);
		dynamicarray.add(a);
		assertEquals(4, dynamicarray.getCapacity());
		assertEquals(a, dynamicarray.get(2));
	}
	
	@Test
	public void testCapacityAfterAddingToZeroCapacityDynamicArray() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(0);
		Integer a = 101;
		dynamicarray.add(a);
		assertEquals(16, dynamicarray.getCapacity());
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexingGreaterThanLength() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
		Integer a = 101;
		dynamicarray.add(a);
		dynamicarray.add(a);
		dynamicarray.add(a);
		dynamicarray.get(10);		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexingLesserThanZero() {
		DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
		Integer a = 101;
		dynamicarray.add(a);
		dynamicarray.add(a);
		dynamicarray.add(a);
		dynamicarray.get(-1);		
	}
}
