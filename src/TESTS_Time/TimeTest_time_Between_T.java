package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;
/**
 * test the function time_Between (if it's True)
 *
 */
public class TimeTest_time_Between_T {

	@Test
	public void test() {
		
				Time time1 = new Time(2017, 10, 13, 11, 13, 15);
				Time start = new Time(2017, 10, 13, 11, 10, 13);
				Time end = new Time(2017, 10, 13, 11, 14, 16);
				boolean b1 = time1.time_Between(start, end);
				assertTrue(b1);
	}

}
