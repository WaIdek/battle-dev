package com.wsulima.battledev.nov2020.problem4;

import java.util.*;

public class Problem_4 {

	public static void main(String[] argv) throws Exception {
		System.out.println(calculate());
	}

	public static String calculate() throws Exception {
		return calculate(readInputLines());
	}

	private static String calculate(List<String> lines) throws Exception {
		Integer[] bytesOfTheKey = toNumbers(split(lines.get(1)));
		List<String> messageLines = lines.subList(2, lines.size());
		List<Integer> xors = new ArrayList<>();
		XorCalculator calculator = new XorCalculator(bytesOfTheKey);
		for (String messageLine : messageLines) {
			Integer[] range = toNumbers(split(messageLine));
			xors.add(calculator.calc(range[0], range[1]));
		}

		String result = "";
		for (int i = 0; i < 256; i++) {
			if (i > 0)
				result += " ";
			if (xors.contains(i)) {
				result += "1";
			} else {
				result += "0";
			}
		}
		return result;
	}

	static class XorCalculator {
		private List<Integer> key;
		private XorCache cache;

		XorCalculator(Integer[] key) {
			this.key = Arrays.asList(key);
			cache = new XorCache();
		}

		public Integer calc(Integer l, Integer r) {
			if(cache.contains(l, r)) return cache.get(l, r);

			Integer result = xor(key.subList(l, r + 1).toArray(new Integer[r - l + 1]));
			cache.put(l, r, result);
			return result;
		}

		private int xor(Integer[] numbers) {
			int result = 0;
			for (int number : numbers) {
				result ^= number;
			}
			return result;
		}
	}

	static class XorCache {
		private Map<XorCacheKey, Integer> cache = new HashMap<>();

		private boolean contains(int l, int r) {
			return cache.containsKey(new XorCacheKey(l, r));
		}

		private Integer get(int l, int r) {
			return cache.get(new XorCacheKey(l, r));
		}

		public void put(int l, int r, Integer result) {
			cache.put(new XorCacheKey(l, r), result);
		}

		class XorCacheKey {
			int l, r;

			public XorCacheKey(int l, int r) {
				this.l = l;
				this.r = r;
			}

			@Override
			public boolean equals(Object o) {
				if (this == o)
					return true;
				if (o == null || getClass() != o.getClass())
					return false;
				XorCacheKey that = (XorCacheKey) o;
				return l == that.l && r == that.r;
			}

			@Override
			public int hashCode() {
				return Objects.hash(l, r);
			}
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
