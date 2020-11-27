package com.wsulima.battledev.nov2020.problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem_2 {

	public static void main(String[] argv) throws Exception {
		System.out.println(calculate());
	}

	public static String calculate() throws Exception {
		return calculate(readInputLines());
	}

	private static String calculate(List<String> lines) throws Exception {
		List<String> messageHours = lines.subList(1, lines.size());

		long total = messageHours.size();
		long suspicious = messageHours.stream().filter(s -> isSuspicious(s)).count();

		return (suspicious  * 100 / total) > 50 ? "SUSPICIOUS" : "OK";
	}

	private static boolean isSuspicious(String s) {
		int hour = Integer.parseInt(s.split(":")[0]);
		return (hour>=20) || (hour < 8 );
	}


	/* ****************************************************************
								UTILS
	**************************************************************** */

	private static List<String> readInputLines() {
		List<String> result = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			result.add(sc.nextLine().trim());
		}
		return result;
	}

	private static String[] split(String text) {
		return text.split(" ");
	}

	private static Integer toNumber(String text) {
		return Integer.parseInt(text);
	}

	private static List<Integer> toNumbers(List<String> numbers) {
		return numbers.stream().map(Integer::parseInt).collect(java.util.stream.Collectors.toList());
	}

	private static Integer[] toNumbers(String... numbers) {
		return Arrays.stream(numbers).map(Integer::parseInt).toArray(Integer[]::new);
	}

}
