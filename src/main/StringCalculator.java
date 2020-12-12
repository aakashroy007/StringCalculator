package main;

public class StringCalculator {
	public int Add(String numbers) {
		String[] number = numbers.split(",");
		if (isEmpty(numbers)) {
			return 0;
		} 
		if (numbers.length()==1) {
			return Integer.parseInt(numbers);
		}
		else {
			return Integer.parseInt(number[0])+Integer.parseInt(number[1]);
		}
	}

	private int stringToInt(String numbers) {
		return Integer.parseInt(numbers);
	}

	private boolean isEmpty(String numbers) {
		return numbers.isEmpty();
	}
}
