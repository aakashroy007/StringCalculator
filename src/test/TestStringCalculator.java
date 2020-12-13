package test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
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

	public void emptyStringReturnZero() throws Exception {
		assertEquals(calculator.Add(""), 0);
	}

	public void oneNumberReturnValue() throws Exception {
		assertEquals(calculator.Add("1"), 1);
	}

	public void twoNumbersCommaDelimitedReturnSum() throws Exception {
		assertEquals(calculator.Add("1,2"), 1 + 2);
	}

	public void unknownAmountNumbersReturnSum() throws Exception {
		assertEquals(calculator.Add("3,6,15,18,46,33"), 3 + 6 + 15 + 18 + 46 + 33);
	}

	public void twoNumbersNewLineDelimitedReturnSum() throws Exception {
		assertEquals(calculator.Add("1\n2"), 1 + 2);
	}

	public void whenDelimiterIsSpecifiedThenItIsUsedToSeparateNumbers() throws Exception {
		assertEquals(calculator.Add("//;\n1;2"), 1 + 2);
	}

	@Test(expectedExceptions = Exception.class)
	public void negativeInputReturnsException() throws Exception {
		calculator.Add("-1");
	}

	public void multipleNegativeInputReturnsException() throws Exception {
		RuntimeException exception = null;

		try {
			calculator.Add("3,-6,15,-18,46,33");
		} catch (RuntimeException e) {
			exception = e;
		}

		assertNotNull(exception);
		assertEquals(exception.getMessage(), "Negatives not allowed: [-6, -18]");
	}

	public void countAddMethodInvoked() throws Exception {
		calculator.Add("1,\n");
		assertEquals(calculator.GetCalledCount(), 1);

		calculator.Add("1,2,3");
		assertEquals(calculator.GetCalledCount(), 2);
	}

	public void ignoreNumberGreaterThan1000() throws Exception {
		assertEquals(calculator.Add("2,1001"), 2);
	}

	public void whenAnyLengthDelimiterIsSpecified() throws Exception {
		assertEquals(calculator.Add("//[***]\n1***2***3"), 6);
	}
	
	public void whenMultipleDelimitersAreSpecified() throws Exception {
		assertEquals(calculator.Add("//[*][%]\n1*2%3"), 6);
	}
	
	public void whenVariableLengthMultipleDelimitersAreSpecified() throws Exception {
		assertEquals(calculator.Add("//[**][%%]\n1**2%%3"), 6);
	}
}
