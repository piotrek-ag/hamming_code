package program;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import structures.*;

public class TestMatrices {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	//11001
	//10101
	//10010
	@SuppressWarnings("unused")
	@Test
	public void testIfMatrixSatisfiesRequirementsForTwoBitCorrection() {
		Matrices matrices = new Matrices();
		int[][] bigMatrix = matrices.getBigMatrix();
		int[][] smallMatrix = matrices.getSmallMatrix();
		int[][] testMatrix1 = {{1,1,0,0},{1,0,1,0},{1,0,0,1}};
		int[][] x = matrices.getxx();
		ArrayList<SumOfTwoColumnVectors> container = TwoBitCorrection.sumEveryTwoColumnsInMatrixForDecodeClass(x);
		ArrayList<ColumnVector> testAgainst = TwoBitCorrection.addColumnVectorsToList(x);
		
		// porównuję
		for(int i=0;i<container.size();i++) {
			SumOfTwoColumnVectors p = container.get(i);
			for(int j=0;j<testAgainst.size();j++) {
				ColumnVector q = testAgainst.get(j);
				// żadna z kolumn macierzy nie może być sumą dwóch innych kolumn tej macierzy
				if(OneBitCorrection.vectorsEqual(p.getVector(), q.getVector())) {
//					// a czy może być sumą siebie samej i innej kolumny
//					boolean columnsAreSame = (p.getColumnNumberOne()==q.getColumnNumber() || p.getColumnNumberTwo()==q.getColumnNumber());
//					if(columnsAreSame) assertEquals(true, true);
//					else assertEquals(true, false);
					assertEquals(true, false);
				}
				else assertEquals(true, true);
				
			}
		}
	}

	public static ArrayList<int[]> sumEveryTwoColumnsInMatrix(int[][] passedMatrix) {
		int horizontalMatrixDimension = passedMatrix[0].length;
		int verticalMatrixDimension = passedMatrix.length;
		ArrayList<int[]> container = new ArrayList<int[]>();
		for(int i=0;i<horizontalMatrixDimension-1;i++) { // dla naszego przypadku iteruje od 0-11
			// pierwszy pionowy wektor
			int[] verticalVector1 = new int[verticalMatrixDimension];
			
			// zapełniam go liczbami
			for(int j=0;j<verticalMatrixDimension;j++) { // 0-3
				verticalVector1[j] = passedMatrix[j][i];
			}
			
			// drugi pionowy wektor
			for(int k=i+1;k<horizontalMatrixDimension;k++) {
				int[] verticalVector2 = new int[verticalMatrixDimension];

				// i zapełniam go liczbami
				for(int l=0;l<verticalMatrixDimension;l++) { // 0-3
					verticalVector2[l] = passedMatrix[l][k]; // tutaj l pełni tą samą rolę co j kilka linijek wyżej
				}
				int[] sumOfTwoVectors = TwoBitCorrection.sumTwoVectors(verticalVector1, verticalVector2);
//				int[] sumOfTwoVectorsModuloDividedByTwo = Encode.divideVectorModuloTwo(sumOfTwoVectors);
				container.add(sumOfTwoVectors);
				
			}
		}
		return container;
	}

	@Test
	public void testSumEveryTwoColumnsInMatrix() {
		int[][] matrixForTesting = {{1,1,5},{2,2,2},{3,3,3}};
		//111 -> 222
		//222 -> 444
		//333 -> 666
		int[] x = {2,4,6};
		int[] y = {6,4,6};
		int[] z = {6,4,6};
		ArrayList<int[]> expectedResult = new ArrayList<int[]>();
		expectedResult.add(x);
		expectedResult.add(y);
		expectedResult.add(z);
		ArrayList<int[]> result = sumEveryTwoColumnsInMatrix(matrixForTesting);
		for(int i=0;i<expectedResult.size();i++) {
			for(int j=0;j<expectedResult.get(0).length;j++) {
				assertEquals(expectedResult.get(i)[j], result.get(i)[j]);
			}
		}
	}
}
