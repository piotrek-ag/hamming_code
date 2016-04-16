package program;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {
	
	public static void writeStringToFile(String s, String fileName) throws IOException {
		int bufferSize = 8 * 1024;
		StringBuilder sb = new StringBuilder("/Users/piotragier/java_projects/telekomunikacja/zad-1/src/main/resources/");
		sb.append(fileName);
		FileWriter f0 = new FileWriter(sb.toString());
		BufferedWriter bw = new BufferedWriter(f0, bufferSize);
		bw.write(s);
		bw.close();
	}
}
