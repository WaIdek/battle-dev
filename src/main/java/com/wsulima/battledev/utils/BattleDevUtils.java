package com.wsulima.battledev.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleDevUtils {

	public static List<String> readInputLines(){
		List<String> result = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			result.add(sc.nextLine().trim());
		}
		return result;
	}

	public static String[] split(String text){
		return text.split(" ");
	}

	public static Integer toNumber(String text){
		return Integer.parseInt(text);
	}

	public static List<Integer> toNumbers(List<String> numbers){
		return numbers.stream().map(Integer::parseInt).collect(java.util.stream.Collectors.toList());
	}

	public static Integer[] toNumbers(String... numbers){
		return Arrays.stream(numbers).map(Integer::parseInt).toArray(Integer[]::new);
	}

}
