package structures;

public class SumOfTwoColumnVectors {
	int columnNumberOne;
	int columnNumberTwo;
	int[] vector;
	
	// gettery i settery
	public int getColumnNumberOne() {
		return columnNumberOne;
	}
	public void setColumnNumberOne(int columnNumberOne) {
		this.columnNumberOne = columnNumberOne;
	}
	public int getColumnNumberTwo() {
		return columnNumberTwo;
	}
	public void setColumnNumberTwo(int columnNumberTwo) {
		this.columnNumberTwo = columnNumberTwo;
	}
	public int[] getVector() {
		return vector;
	}
	public void setSumOfTwoColumnVectors(int[] sumOfTwoColumnVectors) {
		this.vector = sumOfTwoColumnVectors;
	}
	
	// konstruktor
	public SumOfTwoColumnVectors(int c1, int c2, int[] v) {
		columnNumberOne = c1;
		columnNumberTwo = c2;
		vector = v;
	}
}
