package program;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestConversions {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBinaryNumber2DArrayToString() {
		int[][] exampleArray = {{1,0,0,1},{2,0,0,2},{3,0,0,3}};
		String valueReceived = Conversions.binaryNumber2DArrayToString(exampleArray);
		String valueExpected = "100120023003";
		assertEquals(valueExpected, valueReceived);
	}
	
	@Test
	public void testBytesToText() throws UnsupportedEncodingException {
		byte[] exampleArray = {0,1,0,0,0,0,0,1};
		System.out.println(Conversions.bytesToText(exampleArray));
	}
	
	@Test
	public void intNumericValueToChar() {
		String result = Conversions.intNumericValueToString(1);
		String expectedResult = "1";
		assertEquals(expectedResult, result);
	}
	
	@Test
	public void testIntArrayToString() {
		int[] input = {0,1,0,0,0,0,0,1};
		String result = Conversions.intArrayToString(input);
		String expectedResult = "01000001";
		assertEquals(expectedResult, result);
	}
}
