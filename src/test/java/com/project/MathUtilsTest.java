package com.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("When running MathUtils")
class MathUtilsTest
{
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		mathUtils = new MathUtils();
	}

	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up...");
	}

	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest {
		@Test
		@DisplayName("when adding two positive numbers")
		void testAddPositive()
		{
			assertEquals(2, mathUtils.add(1,1), "returns the right sum");
		}

		@Test
		@DisplayName("when adding two negative numbers")
		void testAddNegative()
		{
			assertEquals(-2, mathUtils.add(-1,-1), "returns the right sum");
		}
	}

	@Test
	@Tag("Circle")
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area!");
	}

	@Test
	@Tag("Math")
	void testDivide() {

		assertThrows(ArithmeticException.class, () -> {mathUtils.divide(10, 0);});
	}

	@Test
	@DisplayName("Multiply Method")
	@Tag("Math")
	void testMultiply()
	{
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
		//Only returns true if all the assertEquals pass
		assertAll(
				() -> assertEquals(6, mathUtils.multiply(2,3)),
				() -> assertEquals(4, mathUtils.multiply(2,2)),
				() -> assertEquals(4, mathUtils.multiply(-2,-2))
		);
	}
}