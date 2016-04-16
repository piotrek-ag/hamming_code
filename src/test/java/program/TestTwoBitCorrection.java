package program;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestTwoBitCorrection {

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
	public void testSumTwoVectors() {
		int[] v1 = {1,2,3,4};
		int[] v2 = {1,2,3,4};
		int[] expectedResult = {2,4,6,8};
		int[] result = TwoBitCorrection.sumTwoVectors(v1, v2);
		for(int i=0;i<expectedResult.length;i++) {
			assertEquals(expectedResult[i], result[i]);
		}
	}

}
