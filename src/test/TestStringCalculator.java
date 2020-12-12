package test;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import main.StringCalculator;

@Test
public class TestStringCalculator {
	private StringCalculator calculator;

	@BeforeTest
	public void init() {
		calculator = new StringCalculator();
	}

	public void emptyStringReturnZero() {
		assertEquals(calculator.Add(""), 0);
	}

	public void oneNumberReturnValue() {
		assertEquals(calculator.Add("1"), 1);
	}

	public void twoNumbersCommaDelimitedReturnSum() {
		assertEquals(calculator.Add("1,2"), 1+2);
	}
	
	public void unknownAmountNumbersReturnSum() {
		assertEquals(calculator.Add("3,6,15,18,46,33"), 3+6+15+18+46+33);
	}
	
	public void twoNumbersNewLineDelimitedReturnSum( ) {
		assertEquals(calculator.Add("1\n2"), 1+2);
	}
}
