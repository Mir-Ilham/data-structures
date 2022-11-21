package com.ilham.datastructures.dynamicarray;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class DynamicArrayTest {
	
	Integer a = 1;
	Integer b = 2;
	Integer c = 3;
	
	@Nested
	@DisplayName("Initalization tests")
	class InitializationTests {
		@Test
		public void testIllegalArgumentExceptionForInvalidCapacity() {
			assertThrows(IllegalArgumentException.class, () -> new DynamicArray<Integer>(-1));
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
		public void testZeroCapacityInitializationOfDynamicArray() {
			assertThrows(IllegalArgumentException.class, () -> new DynamicArray<Integer>(0));
		}
		
		@Test
		public void checkForAnEmptyArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			assertTrue(dynamicarray.isEmpty());
		}
	}
	
	@Nested
	@DisplayName("\"Adding elements\" tests")
	class AddTests {
		@Test
		public void testAddingSingleElementAndAccessingIt() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			Integer a = 101;
			dynamicarray.add(a);
			assertEquals(a, dynamicarray.get(0));
		}
		
		@Test
		public void testAddingElementAtASpecificIndexAndAccessingIt() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.addAtIndex(b, 2);
			assertEquals(b, dynamicarray.get(2));
		}
		
		@Test
		public void testCapacityDoubleFeatureOfDynamicArray1() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(2);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertAll(
					() -> assertEquals(4, dynamicarray.getCapacity()),
					() -> assertEquals(a, dynamicarray.get(2))
					);
		}
		
		@Test
		public void testCapacityDoubleFeatureOfDynamicArray2() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.addAtIndex(b, 2);
			assertAll(
					() -> assertEquals(10, dynamicarray.getCapacity()),
					() -> assertEquals(b, dynamicarray.get(2))
					);
		}
	}
	
	@Nested
	@DisplayName("\"Indexing elements\" tests")
	class IndexTests {
		@Test
		public void testIndexingGreaterThanLength() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);		
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.get(10));
		}
		
		@Test
		public void testIndexingLesserThanZero() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.get(-1));
		}
		
		@Test
		public void testValidIndexing() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(c);
			assertEquals(b, dynamicarray.get(1));
		}
		
		@Test
		public void testGetIndexOfElementInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(a);
			assertEquals(3, dynamicarray.getIndex(b));
		}
		
		@Test
		public void testGetIndexOfElementNotInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertEquals(-1, dynamicarray.getIndex(b));
		}
		
		@Test
		public void testElementInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(a);
			assertTrue(dynamicarray.contains(b));
		}
		
		@Test
		public void testElementNotInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertFalse(dynamicarray.contains(b));
		}
	}
	
	@Nested
	@DisplayName("\"Setting elements\" tests")
	class SetTests {
		@Test
		public void testSettingElementOutOfPositiveArrayBounds() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.set(10, b));
		}
		
		@Test
		public void testSettingElementAtNegativeIndex() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.set(-10, b));
		}
		
		@Test
		public void testSettingElementAtValidIndex() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.set(2, b);
			assertEquals(b, dynamicarray.get(2));
		}
	}
	
	@Nested
	@DisplayName("\"Removing elements\" tests")
	class RemoveTests {
		@Test
		public void testRemovingFromEmptyArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			assertThrows(RuntimeException.class, () -> dynamicarray.remove());
		}
		
		@Test
		public void testRemovingFromArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			assertAll(
					() -> assertEquals(b, dynamicarray.remove()),
					() -> assertEquals(2, dynamicarray.size())
					);
		}
		
		@Test
		public void testRemovingAtIndexFromEmptyArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			assertThrows(RuntimeException.class, () -> dynamicarray.removeAtIndex(0));
		}
		
		@Test
		public void testRemovingElementAtNegativeIndex() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.removeAtIndex(-1));
		}
		
		@Test
		public void testRemovingElementOutOfPositiveArrayBounds() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>(5);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertThrows(IndexOutOfBoundsException.class, () -> dynamicarray.removeAtIndex(5));
		}
		
		@Test
		public void testRemovingAtValidIndex() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertAll(
					() -> assertEquals(b, dynamicarray.removeAtIndex(2)),
					() -> assertEquals(4, dynamicarray.size())
					);
		}
		
		@Test
		public void testRemoveElementInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(a);
			assertTrue(dynamicarray.removeItem(b));
		}
		
		@Test
		public void testRemoveElementNotInArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertFalse(dynamicarray.removeItem(b));
		}
		
		@Test
		public void testClearArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(b);
			dynamicarray.clear();
			assertEquals(0, dynamicarray.size());
		}
	}
	
	@Nested
	@DisplayName("Test Array to String")
	class ArrayToString {
		@Test
		public void testStringifyingEmptyArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			assertEquals("[]", dynamicarray.toString());
		}
		
		@Test
		public void testStringifyingNonEmptyArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();

			dynamicarray.add(a);
			dynamicarray.add(b);
			dynamicarray.add(c);
			assertEquals("[1, 2, 3]", dynamicarray.toString());
		}
	}
	
	@Nested
	@DisplayName("Utilities")
	class Utilities {
		@Test
		public void testGetSizeOrLengthOfDynamicArray() {
			DynamicArray<Integer> dynamicarray = new DynamicArray<Integer>();
			dynamicarray.add(a);
			dynamicarray.add(a);
			dynamicarray.add(a);
			assertAll(
					() -> assertEquals(3, dynamicarray.size()),
					() -> assertEquals(3, dynamicarray.length())
					);
		}
	}
}
