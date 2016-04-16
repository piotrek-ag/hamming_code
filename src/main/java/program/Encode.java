package program;

import structures.Matrices;

public class Encode {

	public static int[] encode(int[] singleWordBeforeEncoding) {
		int[] encodedWord = new int[16]; // retValue
		Matrices matrices = new Matrices();

		// przemnażam macierz przez wektor
		int[][] multipliedMatrix = multiplyMatrixByVector(matrices.getxx(), singleWordBeforeEncoding);
		
		// sumuję wiersze macierzy
		int[] summedMatrixRows = sumMatrixRows(multipliedMatrix);
		
		// dzielę modulo przez dwa
		int[] parityBits = divideVectorModuloTwo(summedMatrixRows);
		
		encodedWord = addParityBits(singleWordBeforeEncoding, parityBits);
		
		return encodedWord;
	}

	public static int[][] multiplyMatrixByVector(int[][] matrix, int[] vector) {
		if(vector.length!=matrix[0].length) System.err.println("Nie mogę przemnożyć :( Słowo o niewłaściwej długości");
		int[][] retValue = new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) { //iteruje 4 razy
			for(int j=0;j<matrix[i].length;j++) { // iteruje 12 razy
				retValue[i][j] = vector[j]*matrix[i][j];
			}
		}
		return retValue;
	}
	
	public static int[] sumMatrixRows(int[][] matrix) { // czyli z macierzy o wymiarach x na y robimy wektor o dł. y, gdzie y to ilosc wierszy macierzy wejściowej
		int[] retVector = new int[matrix.length];
		
		for(int i=0;i<matrix.length;i++) {
			int temp = 0;
			for(int j=0;j<matrix[i].length;j++) {
				temp += matrix[i][j];
			}
			retVector[i] = temp;
		}
		return retVector;
	}
	
	public static int[] divideVectorModuloTwo(int[] vector) {
		for (int i=0;i<vector.length;i++) {
			vector[i] = vector[i]%2;
		}
		return vector;
	}
	
	public static int[] addParityBits(int[] exampleTab, int[] parityBits) {
		int[] retValue = new int[exampleTab.length+parityBits.length];
		
		for(int i=0;i<exampleTab.length;i++) {
			retValue[i] = exampleTab[i];
		}
		for(int i=exampleTab.length;i<retValue.length;i++) {
			retValue[i] = parityBits[i-exampleTab.length];
		}
		return retValue;
	}
}
