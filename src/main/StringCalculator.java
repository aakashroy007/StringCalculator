package main;

public class StringCalculator {
	private final String delimiter = ",|\\n";

	public int Add(String numbers) {
		String[] number = numbers.split(delimiter);
		if (isEmpty(numbers)) {
			return 0;
		}
		if (numbers.length() == 1) {
			return Integer.parseInt(numbers);
		} else {
			int sum = 0;
			for (String num : number) {
				sum += Integer.parseInt(num);
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
