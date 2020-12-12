package main;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private int counter = 0;
	
	public int Add(String numbers) throws Exception {
		counter ++;
		String delimiter = ",|\n";
		String numbersWithoutDellimiter = numbers;

		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDellimiter = numbers.substring(numbers.indexOf(";") + 2);
		}
		return Add(numbersWithoutDellimiter, delimiter);
	}

	public int Add(String numbers, String delimiter) throws Exception {
		String[] number = numbers.split(delimiter);

		if (isEmpty(numbers)) {
			return 0;
		}
		if (numbers.length() == 1) {
			return stringToInt(numbers);
		} else {
			int sum = 0;
			findDangerousInput(number);
			for (String num : number) {

				sum += stringToInt(num);
			}
			return sum;
		}
	}

	public int GetCalledCount() {
		return counter;
	}
	
	private void findDangerousInput(String[] numbers) throws Exception {
		List<String> negativeNumbers = new ArrayList<String>();
		for (String num : numbers) {
			if (stringToInt(num) < 0) {
				negativeNumbers.add(num);
			}
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers);
		}
	}

	private int stringToInt(String numbers) {
		return Integer.parseInt(numbers);
	}

	private boolean isEmpty(String numbers) {
		return numbers.isEmpty();
	}
}
