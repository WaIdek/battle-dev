package com.wsulima.battledev.nov2020.problem6;

import com.wsulima.battledev.nov2020.problem5.Problem_5;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class Problem_6Test {

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
		String result = Problem_6.calculate();
		assertThat(result).isNotNull().isEqualTo(expected);
	}

}
