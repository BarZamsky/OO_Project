package TEST_Point_2D;

import static org.junit.Assert.*;
import org.junit.Test;

import matala_1.Point_2D;

/**
 * Test for the function Distance in Point_2D
 *
 */
public class Test_Point_2D_distance {

	@Test
	public void test() {
		
		Point_2D p1 = new Point_2D(35,32);
		Point_2D p2 = new Point_2D(31,29);
		double d1 = p1.distanceTo(p2);
		assertEquals(5, d1,0);
	}

}
