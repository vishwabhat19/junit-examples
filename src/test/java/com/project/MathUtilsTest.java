package com.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class MathUtilsTest
{
	MathUtils mathUtils;

	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up...");
	}

	@Nested
	class AddTest {
		@Test
		@DisplayName("Testing add method for +")
		void testAddPositive()
		{
			assertEquals(2, mathUtils.add(1,1), "This method should add two numbers!");
		}

		@Test
		@DisplayName("Testing add method for -")
		void testAddNegative()
		{
			assertEquals(-2, mathUtils.add(-1,-1), "This method should add two numbers!");
		}
	}

	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area!");
	}

	@Test
	void testDivide() {

		assertThrows(ArithmeticException.class, () -> {mathUtils.divide(10, 0);});
	}

	@Test
	@DisplayName("Multiply Method")
	void testMultiply()
	{
		//assertEquals(6, mathUtils.multiply(2,3));
		assertAll(
				() -> assertEquals(6, mathUtils.multiply(2,3)),
				() -> assertEquals(4, mathUtils.multiply(2,2)),
				() -> assertEquals(4, mathUtils.multiply(-2,-2))
		);
	}
}