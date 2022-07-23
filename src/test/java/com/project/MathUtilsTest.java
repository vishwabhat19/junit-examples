package com.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest
{
	MathUtils mathUtils;

	@BeforeAll
	void init() {
		mathUtils = new MathUtils();
	}

	@Test
	void testAdd()
	{
		int expected = 2;
		int actual = mathUtils.add(1,1);
		assertEquals(expected, actual, "This method should add two numbers!");
	}

	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area!");
	}

	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> {mathUtils.divide(10, 0);});
	}

}