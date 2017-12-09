package TEST_Point_2D;

import static org.junit.Assert.*;
import org.junit.Test;

import matala_1.Point_2D;

/**
 * Test for getLat in Point_2D
 *
 */
public class Test_Point_2D_Lat {

	@Test
	public void test() {
		Point_2D p1 = new Point_2D(35,32);
		
		assertEquals(32, p1.getLat(),0);
	}

}
