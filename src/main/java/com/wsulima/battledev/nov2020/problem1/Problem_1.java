package com.wsulima.battledev.nov2020.problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem_1 {

	public static void main(String[] argv) throws Exception {
		System.out.println(calculate());
	}

	public static String calculate() throws Exception {
		return calculate(readInputLines());
	}

	private static String calculate(List<String> lines) throws Exception {
		List<String> accountNames = lines.subList(1, lines.size());

		int counter = 0;
		for (String accountName : accountNames) {
			if(endsWith5Digits(accountName)){
				counter++;
			}
		}

		return "" + counter;
	}

	private static boolean endsWith5Digits(String accountName) {
		try {
			String last5chars = accountName.substring(accountName.length() - 5);
			Long.parseLong(last5chars);
			return true;
		} catch (Exception e) {
			return false;
		}
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
