package program;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

public class FileReaders {
	public static int[][] readBinaryStringsFromFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder("/Users/piotragier/java_projects/telekomunikacja/zad-1-hamming/src/main/resources/");
		sb.append(fileName);
		String filePath = sb.toString();
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		
		int numberOfLines = countLines(filePath);
		int[][] retValue = new int[numberOfLines][];
		for(int i=0;i<numberOfLines;i++) {
			String s = br.readLine();
			int[] binaryNumberArray = new int[s.length()];
			for(int j=0;j<s.length();j++) {
				int binaryNumber = Character.getNumericValue(s.charAt(j));
				binaryNumberArray[j] = binaryNumber;
			}
			retValue[i] = binaryNumberArray;
		}
		br.close();
		return retValue;
	}
	
	public static int countLines(String filePath) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filePath));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean empty = true;
	        while ((readChars = is.read(c)) != -1) {
	            empty = false;
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n') {
	                    ++count;
	                }
	            }
	        }
	        return (count == 0 && !empty) ? 1 : count;
	    } finally {
	        is.close();
	    }
	}
}
