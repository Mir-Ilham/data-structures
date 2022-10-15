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

}
