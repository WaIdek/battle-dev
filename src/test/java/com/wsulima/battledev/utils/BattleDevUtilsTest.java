package com.wsulima.battledev.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BattleDevUtilsTest {

	@Test
	void readInputLines() {
		System.setIn(new ByteArrayInputStream("aaa \n bbb \n   ccc\na b c".getBytes()));
		assertThat(BattleDevUtils.readInputLines()).hasSize(4).containsExactly("aaa", "bbb", "ccc", "a b c");
	}

	@Test
	void split() {
		assertThat(BattleDevUtils.split("aaa")).hasSize(1).containsExactly("aaa");
		assertThat(BattleDevUtils.split("aaa bbb")).hasSize(2).containsExactly("aaa", "bbb");
	}

	@Test
	void toNumber() {
		assertThat(BattleDevUtils.toNumber("123")).isNotNull().isEqualTo(123);
	}

	@Test
	void toNumbersList() {
		List<Integer> result = BattleDevUtils.toNumbers(Arrays.asList("1", "4", "8"));
		assertThat(result).hasSize(3).contains(1, 4, 8);
	}

	@Test
	void testToNumbersArray() {
		Integer[] result = BattleDevUtils.toNumbers("1", "4", "8");
		assertThat(result).hasSize(3).contains(1, 4, 8);
	}
}
