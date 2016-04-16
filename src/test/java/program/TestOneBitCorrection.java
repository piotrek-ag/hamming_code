package program;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestOneBitCorrection {

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
	public void testVectorsEqual() {
		int[] v1 = {1,2,3,4};
		int[] v2 = {1,2,3,4};
		boolean expectedResult = true;
		boolean result = OneBitCorrection.vectorsEqual(v1, v2);
		assertEquals(expectedResult, result);
	}

}
