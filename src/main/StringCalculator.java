package main;

public class StringCalculator {

	public int Add(String numbers) {
		String delimiter = ",|\n";
		String numbersWithoutDellimiter = numbers;

		if (numbers.startsWith("//")) {
			int delimiterIndex = numbers.indexOf("//") + 2;
			delimiter = numbers.substring(delimiterIndex, delimiterIndex + 1);
			numbersWithoutDellimiter = numbers.substring(numbers.indexOf(";") + 2);
		}		
		return Add(numbersWithoutDellimiter, delimiter);
	}

	public int Add(String numbers, String delimiter) {
		String[] number = numbers.split(delimiter);
		if (isEmpty(numbers)) {
			return 0;
		}
		if (numbers.length() == 1) {
			return stringToInt(numbers);
		} else {
			int sum = 0;
			for (String num : number) {

				sum += stringToInt(num);
			}
			return sum;
		}
	}

	private int stringToInt(String numbers) {
		return Integer.parseInt(numbers);
	}

	private boolean isEmpty(String numbers) {
		return numbers.isEmpty();
	}
}
