package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import program.*;


public class Main {

	public static void main(String[] args) throws IOException {
		System.out.print(
				"Uruchom moduł:\n"
				+ "[1] Zakoduj tekst z pliku inputTextString.txt do pliku binaryString.txt\n"
				+ "[2] Odkoduj plik binaryEncodedInputString.txt i zapisz text do pliku outputTextString.txt\n"
				//+ "[3] Dekodowanie pliku\n"
				+ "[*] Wcisniecie innego dowolnego klawisza konczy dzialanie programu\n");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		sc.close();
		char in = input.charAt(0);
		int choice = 0;
		if(in=='1') choice=1;
		else if(in=='2') choice=2;
		else choice=3;
		
		///// beginning of switch
		switch(choice) {
			case(1):
				// tekst z pliku zamieniam na dwuwymiarową tablicę intów - zer i jedynek
				// wszystkie operacje w tej funkcji przeprowadzam na 8-bitowych słowach
				int[][] binaryArray = textFromFileToBinaryArray();
			
				// jeśli chcę sprawdzić, co jest w tej tablicy, wywołuję:
				System.out.println("Wyjściowy zestaw słów: ");
				Printers.print2DArray(binaryArray);

				// zakodowana tablica ma tyle samo słów, co niezakodowana, ale długość każdego słowa wzrasta z 8 do 12 bitów
				int[][] encodedArray = new int[binaryArray.length][16]; // rozwiązanie hardkodowane :(
				int lineLength = encodedArray[0].length;
				
				// tutaj przemnażam przez macierz[8][8] - długość tablicy urasta do 16 bitów
				for(int i=0;i<binaryArray.length;i++) {
					encodedArray[i] = Encode.encode(binaryArray[i]);
				}
				
				System.out.println("\nZestaw słów kodowych: ");
				Printers.print2DArray(encodedArray);
				
				// zamieniam dwuwymiarową tablicę na string zer i jedynek przed zapisaniem do pliku
				String stringEncodedArray = Conversions.binaryNumber2DArrayToString(encodedArray);
				
				// zapisuję zakodowaną tablicę słów do pliku, gdzie będzie można ręcznie zmienić pojedynczy bit dla zasymulowania błędu
				FileWriters.writeStringToFile(stringEncodedArray, "binaryEncodedInputString.txt", lineLength); // niby ok.
				break;
			case(2):
				int[][] binaryEncodedArray = FileReaders.readBinaryStringsFromFile("binaryEncodedInputString.txt");
				System.out.println("Słowa kodowe otrzymane: ");
				Printers.print2DArray(binaryEncodedArray);
				
				int[][] correctedBinaryArray = new int[binaryEncodedArray.length][binaryEncodedArray[0].length];
				for(int i=0;i<binaryEncodedArray.length;i++) {
					System.out.println("Słowo " + i);
					correctedBinaryArray[i] = Decode.decode(binaryEncodedArray[i]);	// dostawić korekcję 2 bitów			
				}
								
				// konwertuję dwuwymiarową tablicę intów na tekst
				String decodedText = intBinaryArrayToText(correctedBinaryArray);
				System.out.println("\nOdkodowany tekst: " + decodedText);
				break;
			case(3):
				System.out.println("<KONIEC>");
				System.exit(0);
				break;
			default:
				System.out.println("<KONIEC>");
				System.exit(0);
		}
		///// end of switch
	}

	private static int[][] textFromFileToBinaryArray() throws IOException {
		// 1) Odczytuję tekst z pliku
		FileRead fr1 = new FileRead("inputTextString.txt");
		System.out.println("Wyjściowy tekst:"); 
		System.out.println(fr1.fileReadout);
		System.out.println();
		
		// 2) Zamieniam tekst na tablicę bajtów
		byte[] byteArray = fr1.returnByteArray();
		
		// 3) A następnie na tablicę intów
		int[] intArray = Conversions.byteArrayToIntArray(byteArray);
		int[][] passedIntArray = new int[intArray.length][8];
		
		// 4) A tablicę intów na dwuwymiarową tablicę intów - zer i jedynek
		for(int i=0;i<intArray.length;i++) {
			for(int j=0;j<8;j++){
				passedIntArray[i] = Conversions.intNumberToBinaryArray(intArray[i]);
			}
		}
		return passedIntArray;
	}
	

	public static String intBinaryArrayToText(int[][] correctedBinaryArray) throws UnsupportedEncodingException {
		byte[] wordsAsBytes = new byte[correctedBinaryArray.length];
		
		// przycinam po osiem ostatnich bitów w każdym ze słów
		int[][] shortenedArr = new int[correctedBinaryArray.length][correctedBinaryArray[0].length-8];
		for(int i=0;i<shortenedArr.length;i++) {
			for(int j=0;j<shortenedArr[i].length;j++) {
				shortenedArr[i][j] = correctedBinaryArray[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<shortenedArr.length;i++) {
			String s = Conversions.intArrayToString(shortenedArr[i]);
			int number = Conversions.binaryStringToDecimalInteger(s);
			wordsAsBytes[i] = (byte) number;
			sb.append(Conversions.byteToChar(wordsAsBytes[i]));
		}
		
		String retValue = sb.toString(); 
		return retValue;
	}
}
