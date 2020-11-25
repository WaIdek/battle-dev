package com.wsulima.battledev.exercises;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestingUnitTestsTest {

	private final TestingUnitTests testee = new TestingUnitTests();

	@Test
	void dummyMethod() {
		boolean result1 = testee.dummyMethod(true);
		assertThat(result1).isFalse();

		boolean result2 = testee.dummyMethod(false);
		assertThat(result2).isTrue();
	}
}
