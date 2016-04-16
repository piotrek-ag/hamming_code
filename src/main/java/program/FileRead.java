package program;

import java.nio.charset.*;
import java.io.*;

public class FileRead {
	public String fileReadout;

	public byte[] returnByteArray() {
		byte[] b = fileReadout.getBytes(StandardCharsets.US_ASCII);
		return b;
	}
	
	private void readTextStringFromFile(String fileName) throws IOException {
		StringBuilder sb = new StringBuilder("/Users/piotragier/java_projects/telekomunikacja/zad-1-hamming/src/main/resources/");
		sb.append(fileName);
		try (FileReader fr = new FileReader(sb.toString())) {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(fr);
			String s;
			while( (s = br.readLine())!=null ) {
				fileReadout = s;
			}
		}
	}
	
	// constructor
	public FileRead(String fileName) throws IOException {
		readTextStringFromFile(fileName);
	}
}

