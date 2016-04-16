package program;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.lang3.StringUtils;

public class Conversions {
	// convert string to int
	public static int stringToInt(String s) {
		int i = Integer.parseInt(s);
		return i;
	}
	
	// convert byte array to int array
	public static int[] byteArrayToIntArray(byte[] barr) {
		int[] retValue = new int[barr.length];
		for(int i=0;i<retValue.length;i++) {
			int tempInt = barr[i];
			retValue[i] = tempInt;
		}
		return retValue;
	}
	
	// convert int array to byte array
	public static byte[] intArrayToByteArray(int[] input) {
		byte[] tempByteArr = new byte[input.length];
		for(int i=0;i<input.length;i++) {
			tempByteArr[i] = (byte) input[i];
		}
		return tempByteArr;
	}
	
	// convert int number to binary array of ints
	public static int[] intNumberToBinaryArray(int inputInt) {
		int[] retValue = new int[8];
		if(inputInt>127) System.err.println("Liczba musi mieścić się w przedziale 0-127");
		String s = StringUtils.leftPad(Integer.toBinaryString(inputInt), 8, '0');
		
		for(int i=0;i<8;i++) {
			int t = Character.getNumericValue(s.charAt(i));
			retValue[i] = t;
		}
		return retValue;
	}

	public static String binaryNumber2DArrayToString(int[][] encodedArray) {
		StringBuilder sb = new StringBuilder();
		for(int[] row : encodedArray)
			for (int number : row)
				sb.append(String.valueOf(number));
		return sb.toString();
	}


	public static int binaryStringToDecimalInteger(String s) { // ok
		return Integer.parseInt(s, 2);
	}
	
	// nie używana
	public static String charArrayToString(char[] input) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length;i++) {
			 sb.append(String.valueOf(input[i]));
		}
		String retValue = sb.toString();
		return retValue;
	}

	// nie używana
	public static char[] intArrayToCharArray(int[] inputArr) {
		char[] retValue = new char[inputArr.length];
		for(int i=0;i<inputArr.length;i++) {
			retValue[i] = (char) inputArr[i];
		}
		return retValue;
	}
	
	// nie używana - testowana
	public static String bytesToText (byte[] bytes) throws UnsupportedEncodingException {
		String text = new String(bytes, StandardCharsets.US_ASCII);
		return text;
	}
	
	// np. {0,1,0,0,0,0,0,1} -> "01000001"
	public static String intArrayToString(int[] input) { // ok
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length;i++) {
			sb.append(intNumericValueToString(input[i]));
		}
		return sb.toString();
	}
	
	// wartość numeryczna na znak np. 1 -> '1'
	public static String intNumericValueToString(int i) { // ok
		String c = String.valueOf(i);
		return c;
	}
	
	// byteToChar w pętli
	public static char[] byteArrayToCharArray(byte[] inputArr) { // ok
		char[] retValue = new char[inputArr.length];
		for(int i=0;i<inputArr.length;i++) {
			retValue[i] = byteToChar(inputArr[i]);
		}
		return retValue;
	}
	
	 // zwraca znak ASCII, eg. jeśli byte równa się 65, funkcja zwraca 'A'
	public static char byteToChar(byte b) { // ok
		char c = (char) b;
		return c;
	}
}
