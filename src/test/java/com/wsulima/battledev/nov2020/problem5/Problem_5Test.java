package com.wsulima.battledev.nov2020.problem5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class Problem_5Test {

	String testInput = String.join("\n"
			, ""
			, ""
			, ""
	);

	String expected = "";

	@BeforeEach
	public void setupInput() {
		System.setIn(new ByteArrayInputStream(testInput.getBytes()));
	}

	@Test
	void testCalculation() throws Exception {
		String result = Problem_5.calculate();
		assertThat(result).isNotNull().isEqualTo(expected);
	}

}
