package com.wsulima.battledev.nov2020.problem3;

import java.util.*;

public class Problem_3 {

	public static void main(String[] argv) throws Exception {
		System.out.println(calculate());
	}

	public static String calculate() throws Exception {
		return calculate(readInputLines());
	}

	private static String calculate(List<String> lines) throws Exception {
		List<String> agentsLines = lines.subList(1, lines.size());

		Map<Integer, List<Integer>> superiorsWithAgents = new HashMap<>();
		for (String agentsLine : agentsLines) {
			int agentNo = toNumbers(split(agentsLine))[0];
			int superiorNo = toNumbers(split(agentsLine))[1];
			if (!superiorsWithAgents.containsKey(superiorNo)) {
				superiorsWithAgents.put(superiorNo, new ArrayList<>());
			}
			superiorsWithAgents.get(superiorNo).add(agentNo);
		}

		List<Integer> listOfAgentsCountPerLevel = analyzeMap(superiorsWithAgents);

		String result = "";
		int i = 0;
		for (Integer noOfAgents : listOfAgentsCountPerLevel) {
			if(i++ > 0) {
				result += " ";
			}
			result += noOfAgents;
		}

		return result;
	}

	private static List<Integer> analyzeMap(Map<Integer, List<Integer>> superiorsWithAgents) {
		List<Integer> result = new ArrayList<>();
		result.add(1);

		Map<Integer, Integer> counterPerLevel = new HashMap<>();
		for(int i = 0; i<9; i++){
			counterPerLevel.put(i, 0);
		}
		countForLevel(0, 0, counterPerLevel, superiorsWithAgents);

		for(int i = 0; i<9; i++){
			result.add(counterPerLevel.get(i));
		}
		return result;
	}

	private static void countForLevel(int levelNo, int superiorNo, Map<Integer, Integer> counterPerLevel, Map<Integer, List<Integer>> superiorsWithAgents) {
		if(!superiorsWithAgents.containsKey(superiorNo)) return;
		counterPerLevel.put(levelNo, counterPerLevel.get(levelNo) + superiorsWithAgents.get(superiorNo).size());
		for(Integer agentNo : superiorsWithAgents.get(superiorNo)){
			countForLevel(levelNo + 1, agentNo, counterPerLevel, superiorsWithAgents);
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
