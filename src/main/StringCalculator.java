package main;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	private int counter = 0;

	public int Add(String numbers) throws Exception {
		counter++;
		String delimiter = ",|\n";
		String numbersWithoutDellimiter = numbers;
		int startIndex = 0;
		int endIndex = 0;

		if (numbers.startsWith("//")) {
			startIndex = numbers.indexOf("//") + 2;
			endIndex = startIndex + 1;
			delimiter = numbers.substring(startIndex, endIndex);
			numbersWithoutDellimiter = numbers.substring(numbers.indexOf(";") + 2);
		}
		
		if (numbers.indexOf("[") != -1) {
			startIndex = numbers.indexOf("[");
			endIndex = numbers.lastIndexOf("]") + 1;
			delimiter = numbers.substring(startIndex, endIndex);
			numbersWithoutDellimiter = numbers.substring(numbers.lastIndexOf("]") + 2);
		}
		
		return Add(numbersWithoutDellimiter, parseMultipleDelimiter(delimiter));
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
				if(num.isEmpty()) {
					continue;
				}
				if (stringToInt(num)>1000) {
					continue;
				}					
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
			if (num.isEmpty()) {
				continue;
			}
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
	
	private String parseMultipleDelimiter(String delimiter) {
		if (delimiter.indexOf("[")==-1) {
			return delimiter;
		}
		String[] delimiterArray = delimiter.split("[|]");
		String parsedDelimiter="[";
		for(String current: delimiterArray) {
			parsedDelimiter +=current;
			parsedDelimiter += "|";
		}
		parsedDelimiter = parsedDelimiter.substring(0,parsedDelimiter.lastIndexOf("|"));
		parsedDelimiter += "]";
		return parsedDelimiter;
		
	}
}
