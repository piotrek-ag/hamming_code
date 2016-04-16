package program;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestEncode {

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

	@Test
	public void testMultiplyMatrixByVector() {
		int[] vector = {1,0,1,0,0,0,0,0};
		int[][] matrix = {{0,1,0,0,0,0,0,1},{1,1,1,0,0,0,0,1},{0,1,2,0,0,0,0,1}};
		int[][] expectedResult = {{0,0,0,0,0,0,0,0},{1,0,1,0,0,0,0,0},{0,0,2,0,0,0,0,0}};
		int[][] result = Encode.multiplyMatrixByVector(matrix, vector);
		for(int i=0;i<expectedResult.length;i++) {
			for(int j=0;j<expectedResult[0].length;j++) {
				assertEquals(expectedResult[i][j], result[i][j]);
			}
		}
	}

	@Test
	public void testSumMatrixRows() {
		int[][] matrix = {{0,1,0,0,0,0,0,1},{1,1,1,0,0,0,0,1},{0,1,2,0,0,0,0,1}};
		int[] expectedResult = {2, 4, 4};
		int[] result = Encode.sumMatrixRows(matrix);
		for(int i=0;i<expectedResult.length;i++) {
			assertEquals(expectedResult[i], result[i]);
		}
	}

	@Test
	public void testDivideVectorModuloTwo() {
		int[] vector = {0,2,3,5};
		int[] expectedResult = {0,0,1,1}; 
		int[] result = Encode.divideVectorModuloTwo(vector);
		for(int i=0;i<expectedResult.length;i++) {
			assertEquals(expectedResult[i], result[i]);
		}	
	}
	
	@Test
	public void testAddParityBits() {
		int[] vector = {1,0,1,0,0,0,0,0};
		int[] parityBits = {2,0,2,0};
		int[] expectedResult = {1,0,1,0,0,0,0,0,2,0,2,0};
		int[] result = Encode.addParityBits(vector, parityBits);
		for(int i=0;i<expectedResult.length;i++) {
			assertEquals(expectedResult[i], result[i]);
		}
	}
}
