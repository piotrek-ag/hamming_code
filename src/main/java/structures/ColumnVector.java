package structures;

public class ColumnVector {
	int columnNumber;
	int[] vector;
	
	// gettery i settery
	public int getColumnNumber() {
		return columnNumber;
	}
	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}
	public int[] getVector() {
		return vector;
	}
	public void setVector(int[] vector) {
		this.vector = vector;
	}
	
	// konstruktor
	public ColumnVector(int cn, int[] v) {
		columnNumber = cn;
		vector = v;
	}
}
