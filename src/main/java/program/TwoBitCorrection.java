package program;

import java.util.ArrayList;

import structures.*;

public class TwoBitCorrection {

	public static int[] correctTwoBits(int[] singleEncodedCodeWord, int[] afterModuloDivision) {
		//System.out.println("Starting correctTwoBits() method...");
		int[] b = checkWhichTwoBitsAreWrong(singleEncodedCodeWord, afterModuloDivision);
		int[] correctedCodeWord = new int[singleEncodedCodeWord.length];
		
		for(int i=0;i<b.length;i++) {
			// koryguję błąd
			if(singleEncodedCodeWord[b[i]]==1) {
				correctedCodeWord = singleEncodedCodeWord; 
				correctedCodeWord[b[i]]=0;
			}
			else {
				correctedCodeWord = singleEncodedCodeWord; 
				correctedCodeWord[b[i]]=1;
			}
		}
		return correctedCodeWord;
	}

	public static int[] checkWhichTwoBitsAreWrong(int[] singleEncodedCodeWord, int[] afterModuloDivision) {
		int[] retValue = new int[2];
		Matrices matrices = new Matrices();
		int[][] bigMatrix = matrices.getxxx();
		int bitNumberOne = 0;
		int bitNumberTwo = 0;
		boolean changed = false;
		int horizontalMatrixDimension = bigMatrix[0].length;
		//System.out.println("horizontalMatrixDimension: " + horizontalMatrixDimension);
		int vectLength = afterModuloDivision.length;
		int verticalMatrixDimension = bigMatrix.length;
		//System.out.println("verticalMatrixDimension: " + verticalMatrixDimension);
		if(vectLength!=verticalMatrixDimension) System.err.println("Nie można wyznaczyć błędnych bitów. Nie zgadzają się rozmiary wektora niezerowego i pionowy rozmiar macierzy.");
		int counter = 0;
		
		

		int[][] container = new int[121][]; //
		for(int i=0;i<horizontalMatrixDimension-1;i++) { // dla naszego przypadku iteruje od 0-11
			// pierwszy pionowy wektor
			int[] verticalVector1 = new int[verticalMatrixDimension];
			
			// zapełniam go liczbami
			for(int j=0;j<verticalMatrixDimension;j++) { // 0-3
				verticalVector1[j] = bigMatrix[j][i];
			}
			
			// drugi pionowy wektor
			for(int k=i+1;k<horizontalMatrixDimension;k++) {
				int[] verticalVector2 = new int[verticalMatrixDimension];

				// i zapełniam go liczbami
				for(int l=0;l<verticalMatrixDimension;l++) { // 0-3
					verticalVector2[l] = bigMatrix[l][k]; // tutaj l pełni tą samą rolę co j kilka linijek wyżej
				}
				counter++;
				//System.out.println("\nIlość obrotów pętli: " + counter);
				int[] sumOfTwoVectors = sumTwoVectors(verticalVector1, verticalVector2);
				int[] sumOfTwoVectorsModuloDividedByTwo = Encode.divideVectorModuloTwo(sumOfTwoVectors);
				container[counter] = sumOfTwoVectorsModuloDividedByTwo;
				if(OneBitCorrection.vectorsEqual(sumOfTwoVectorsModuloDividedByTwo, afterModuloDivision)) {
					bitNumberOne=i;
					bitNumberTwo=k;
					changed = true;
				};
			}
			retValue[0] = bitNumberOne;
			retValue[1] = bitNumberTwo;
		}
		if(changed) System.out.println("Podwójny błąd na pozycjach: " + bitNumberOne + " i " + bitNumberTwo);
		return retValue;
	}
	

	public static ArrayList<SumOfTwoColumnVectors> sumEveryTwoColumnsInMatrixForDecodeClass(int[][] passedMatrix) {
		int horizontalMatrixDimension = passedMatrix[0].length;
		int verticalMatrixDimension = passedMatrix.length;
		ArrayList<SumOfTwoColumnVectors> container = new ArrayList<SumOfTwoColumnVectors>();
		for(int i=0;i<horizontalMatrixDimension-1;i++) { // dla naszego przypadku iteruje od 0-11
			// pierwszy pionowy wektor
			int[] verticalVector1 = new int[verticalMatrixDimension];
			
			// zapełniam go liczbami
			for(int j=0;j<verticalMatrixDimension;j++) { // 0-3
				verticalVector1[j] = passedMatrix[j][i];
			}
			
			// i tworzę klasę
			ColumnVector v1 = new ColumnVector(i, verticalVector1);

			// drugi pionowy wektor
			for(int k=i+1;k<horizontalMatrixDimension;k++) {
				int[] verticalVector2 = new int[verticalMatrixDimension];

				// i zapełniam go liczbami
				for(int l=0;l<verticalMatrixDimension;l++) { // 0-3
					verticalVector2[l] = passedMatrix[l][k]; // tutaj l pełni tą samą rolę co j kilka linijek wyżej
				}
				
				// i tworzę klasę
				ColumnVector v2 = new ColumnVector(k, verticalVector2);

				int[] sumOfTwoVectors = sumTwoVectors(v1.getVector(), v2.getVector());
				SumOfTwoColumnVectors sotcv = new SumOfTwoColumnVectors(v1.getColumnNumber(), v2.getColumnNumber(), sumOfTwoVectors);
//				int[] sumOfTwoVectorsModuloDividedByTwo = Encode.divideVectorModuloTwo(sumOfTwoVectors);
				container.add(sotcv);
			}
		}
		return container;
	}

	public static int[] sumTwoVectors(int[] v1, int[] v2) {
		if(v1.length!=v2.length) System.err.println("Wektory różnej długości. Nie można dodać.");
		int[] retValue = new int[v1.length];
		for(int i=0;i<retValue.length;i++) {
			retValue[i] = v1[i]+v2[i];
		}
		return retValue;
	}

	public static ArrayList<ColumnVector> addColumnVectorsToList(int[][] testMatrix1) {
		// dodaję wektory do listy
		ArrayList<ColumnVector> retValue = new ArrayList<ColumnVector>();
		for(int k=0;k<testMatrix1[0].length;k++) { // 0 - 11
			int[] tempVector = new int[testMatrix1.length];

			for(int l=0;l<testMatrix1.length;l++) { // 0 - 3
				tempVector[l] = testMatrix1[l][k];
			}
			ColumnVector cv = new ColumnVector(k, tempVector);
			retValue.add(cv);
		}
		return retValue;
	}
}
