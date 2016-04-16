package program;

import structures.Matrices;

public class OneBitCorrection {

	public static int[] correctOneBit(int[] singleEncodedCodeWord, int[] afterModuloDivision) {
		int b = checkWhichBitIsWrong(afterModuloDivision);
		System.out.println("Pojedynczy błąd na pozycji: " + b);
		int[] correctedCodeWord = new int[singleEncodedCodeWord.length];
		
		// koryguję błąd
		if(singleEncodedCodeWord[b]==1) {
			correctedCodeWord = singleEncodedCodeWord; 
			correctedCodeWord[b]=0;
		}
		else {
			correctedCodeWord = singleEncodedCodeWord; 
			correctedCodeWord[b]=1;
		}
		return correctedCodeWord;
	}

	private static int checkWhichBitIsWrong(int[] afterModuloDivision) {
		Matrices matrices = new Matrices();
		int[][] bigMatrix = matrices.getxxx();
		int bitNumber = 0;
		int horizontalMatrixDimension = bigMatrix[0].length;
		int vectLength = afterModuloDivision.length;
		int verticalMatrixDimension = bigMatrix.length;
		if(vectLength!=verticalMatrixDimension) System.err.println("Nie można wyznaczyć błędnego bitu. Nie zgadzają się rozmiary wektora niezerowego i pionowy rozmiar macierzy.");
		
		for(int i=0;i<horizontalMatrixDimension;i++) { // dla naszego przypadku iteruje od 0-11
			int[] tempVector = new int[verticalMatrixDimension];
			for(int j=0;j<verticalMatrixDimension;j++) { // 0-3
				tempVector[j] = bigMatrix[j][i];
			}
			if(vectorsEqual(afterModuloDivision, tempVector)) {
				bitNumber=i;
				return bitNumber;
			}
		}
		return bitNumber;
	}

	public static boolean vectorsEqual(int[] v1, int[] v2) {
		if(v1.length==v2.length) { // sprawdzam, czy są tej samej długości
			
			// jesli tak, sprawdzam, czy maja takie same elementy
			for(int i=0;i<v1.length;i++) { // 
				if(v1[i]!=v2[i]) {
					//System.err.println("Wektory są równej długości, ale nie są tożsame");
					return false;
				}
			}
			return true;
		}
		else {
			System.err.println("Wektory są różnej długości.");
			return false;
		}
	}

}
