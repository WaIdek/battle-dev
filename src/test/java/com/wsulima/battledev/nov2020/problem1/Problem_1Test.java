package com.wsulima.battledev.nov2020.problem1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;

class Problem_1Test {

	String testInput = String.join("\n"
			, "7"
			, "h25io"
			, "gn0mi12345"
			, "RealDon4321"
			, "yaNNd3v"
			, "cup0ft3444455"
			, "bienvenueCorbier"
			, "BClukschoco"
	);

	String expected = "2";

	@BeforeEach
	public void setupInput() {
		System.setIn(new ByteArrayInputStream(testInput.getBytes()));
	}

	@Test
	void testCalculation() throws Exception {
		String result = Problem_1.calculate();
		assertThat(result).isNotNull().isEqualTo(expected);
	}

}
