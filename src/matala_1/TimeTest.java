package matala_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {
		Time time = new Time("1993", "07", "13", 19, 35, 10);
		Time t = new Time("1993", "07", "13", 19, 35, 10);
		boolean output = time.is_Equal(t);
		assertTrue(output);
		
	}

}
