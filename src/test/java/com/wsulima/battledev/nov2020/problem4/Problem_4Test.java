package com.wsulima.battledev.nov2020.problem4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class Problem_4Test {

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
		String result = Problem_4.calculate();
		assertThat(result).isNotNull().isEqualTo(expected);
	}

}
