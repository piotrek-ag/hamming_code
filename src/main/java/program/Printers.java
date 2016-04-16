package program;

public class Printers {
	public static void print2DArray(int[][] arr) {
		for(int[] m : arr) {
			for(int n : m)
				System.out.printf("[%d]", n);
			System.out.println();
		}
	}
	
	public static void print2DArray(char[][] arr) {
		for(char[] m : arr) {
			for(char n : m)
				System.out.printf("[%s]", n);
			System.out.println();
		}
	}
	
	public static void printArray(int[] arr) {
		for(int i : arr) System.out.printf("[%d]", i);
	}
	
	public static void printArray(byte[] b) {
		for(byte i : b) System.out.printf("[%d]", i);
	}

	public static void printCharArray(char[] c) {
		for(char s : c) System.out.printf("[%s]", s);
	}
}
