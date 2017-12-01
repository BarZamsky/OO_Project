package matala_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LineFileTest {
	
	@Test
	public void test() {
		Time t = new Time(1994, 02, 19, 10, 30, 30);
		String model = "BAR";
		Point_2D p1 = new Point_2D(40,23.5);
		int alt = 11;
		int numOfNetworks = 7;
		Network n1 = new Network("oop", "1.3.4", -60, "10");
		Network n2 = new Network("project", "1.3.5.7", -50, "12");
		Network n3 = new Network("testing", "1.66.75.37", -90, "6");
		List<Network> wifi = new ArrayList<Network>();
		wifi.add(n1);wifi.add(n2);wifi.add(n3);
		LineFile l1 = new LineFile(t, model, p1, alt, numOfNetworks, wifi);
		assertEquals("BAR", l1.getModel());
		assertEquals(23.5 , l1.getLocation().getLat(), 0);
		assertEquals(19	, l1.getTime().getDay());
		assertEquals(1994, l1.getTime().getYear());
		assertEquals(11, l1.getAlt(),0);
		assertEquals(7, l1.getNumOfNetworks());
		assertEquals(7, l1.getNumOfNetworks());
		assertEquals(-90, l1.getNetwork().get(2).getSignal());
		
	}

}
