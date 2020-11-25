package com.wsulima.battledev.exercises;

import com.wsulima.battledev.nov2020.problem1.Problem_1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class Exercise_1Test {

	String testInput = String.join("\n"
			, "10"
			, "helene 1010"
			, "marek 21"
			, "karol 31"
			, "henryk 44"
			, "janina 123"
			, "kasia 567"
			, "waldek 12"
			, "zbych 12"
			, "piotr 13"
			, "bozena 999"
	);

	String expected = "waldek";

	@BeforeEach
	public void setupInput() {
		System.setIn(new ByteArrayInputStream(testInput.getBytes()));
	}

	@Test
	void testCalculation() throws Exception {
		String result = Exercise_1.calculate();
		assertThat(result).isNotNull().isEqualTo(expected);
	}

}
