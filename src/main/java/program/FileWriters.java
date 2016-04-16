package program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriters {
	public static void writeStringToFile(String binaryString, String fileName, int lineLength) throws IOException {
		StringBuilder sb = new StringBuilder("/Users/piotragier/java_projects/telekomunikacja/zad-1-hamming/src/main/resources/");
		sb.append(fileName);
		String filePath = sb.toString();
		int bufferSize = 8 * 1024;
		FileWriter fw = new FileWriter(filePath);
		BufferedWriter bw = new BufferedWriter(fw, bufferSize);
		for(int i=0;i<binaryString.length();i+=lineLength) {
			bw.write(binaryString.substring(i, i+lineLength));
			bw.newLine();
		}
		bw.close();
	}
}