package matala_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Point_2DTest {

	@Test
	public void test() {
		Point_2D p1 = new Point_2D(35,32);
		Point_2D p2 = new Point_2D(31,29);
		Point_2D p3 = new Point_2D(32.5,34.25);
		Point_2D p4 = new Point_2D(29.5,30.25);
		double d1 = p1.distanceTo(p2);
		double d2 = p3.distanceTo(p4);
		assertEquals(5, d1,0);
		assertEquals(5, d2,0);
		assertEquals(32, p1.getLat(),0);
		assertEquals(35, p1.getLon(),0);
		assertEquals(31, p2.getLon(),0);
		assertEquals(29, p2.getLat(),0);
	}

}
