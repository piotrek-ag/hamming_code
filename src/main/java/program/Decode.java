package program;

import structures.*;

public class Decode {

	public static int[] decode(int[] singleEncodedCodeWord) {
		Matrices matrices = new Matrices();
		
		// mnożę macierz przez wektor
		// mogę użyć funkcji z klasy Encode ponieważ nie jest ona wrażliwa na rozmiary mnożonych obiektów, 
		// pod warunkiem że ich rozmiary umożliwiają prawidłowe wykonanie mnożenia
		int[][] multipliedMatrix = Encode.multiplyMatrixByVector(matrices.getxxx(), singleEncodedCodeWord);
		
		// sumuję wiersze macierzy
		int[] summedMatrixRows = Encode.sumMatrixRows(multipliedMatrix);
		
		// dzielę modulo przez dwa
		int[] afterModuloDivision = Encode.divideVectorModuloTwo(summedMatrixRows);
		
		if(vectorContainsZerosOnly(afterModuloDivision)) {
			System.out.println("Odkodowane słowo nie zawiera błędów");
			return singleEncodedCodeWord;
		}
		else {
			int[] correctedCodeWord = correctErrors(singleEncodedCodeWord, afterModuloDivision);
			return correctedCodeWord;
		}
	}
	
	private static int[] correctErrors(int[] singleEncodedCodeWord, int[] afterModuloDivision) {

		int[] singleEncodedCodeWordCopy = new int[singleEncodedCodeWord.length];
		singleEncodedCodeWordCopy = singleEncodedCodeWord.clone();
		
		// korekcja dwóch bitów
		int[] correctedCodeWord = new int[singleEncodedCodeWord.length];
		correctedCodeWord = TwoBitCorrection.correctTwoBits(singleEncodedCodeWord, afterModuloDivision);
		
		if(OneBitCorrection.vectorsEqual(correctedCodeWord, singleEncodedCodeWordCopy)) {
			// korekcja pojedynczego bitu
			correctedCodeWord = OneBitCorrection.correctOneBit(singleEncodedCodeWord, afterModuloDivision);			
		}
		return correctedCodeWord;
	}

	private static boolean vectorContainsZerosOnly(int[] inputVector) { // ok
		for(byte i=0;i<inputVector.length;i++) {
			if(inputVector[i]!=0) {
				return false;
			}
		}
		return true;
	}

}
