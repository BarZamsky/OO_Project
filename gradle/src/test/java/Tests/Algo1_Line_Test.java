package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Project.Algo1_line;
import Project.Point_2D;

public class Algo1_Line_Test {
	
	Point_2D p = new Point_2D(35, 31);
	Algo1_line a = new Algo1_line(-90, 11, p);
	
	/**
	 * Test for getSignal in Algo1_line
	 */
	@Test
	public void test_getSignal() {
		assertEquals("-90", a.getSignal());
	}
	/**
	 * Test for getAlt in Algo1_line 
	 */
	@Test
	public void test_getAlt() {
		assertEquals("11", a.getAlt());
	}
	/**
	 * Test for getPoint_2D in Algo1_line
	 */
	@Test
	public void test_getLocation() {
		assertEquals("p", a.getLocation());
	}
}
