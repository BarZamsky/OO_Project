package Tests;
import static org.junit.Assert.*;
import org.junit.Test;

import Project.Point_2D;

public class Point_2D_Test {

	/**
	 * Test for the function Distance in Point_2D
	 */
	@Test
	public void testDistance() {
		Point_2D p1 = new Point_2D(35,32);
		Point_2D p2 = new Point_2D(31,29);
		double d1 = p1.distanceTo(p2);
		assertEquals(5, d1,0);
	}
	/**
	 * Test for getLat in Point_2D
	 */
	@Test
	public void testLat() {
	Point_2D p1 = new Point_2D(35,32);
		assertEquals(32, p1.getLat(),0);
	}
	/**
	 * Test for getLon in Point_2D
	 */
	@Test
	public void testLon() {
		Point_2D p1 = new Point_2D(35,32);
		assertEquals(35, p1.getLon(),0);
	}
}
