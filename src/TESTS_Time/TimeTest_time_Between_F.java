package TESTS_Time;

import static org.junit.Assert.*;

import org.junit.Test;

import matala_1.Time;
/**
 * test the function time_Between (if it's False)
 *
 */
public class TimeTest_time_Between_F {

	@Test
	public void test() {
		
		
				Time time2 = new Time(2017, 10, 13, 11, 15, 20);
				Time start = new Time(2017, 10, 13, 11, 10, 13);
				Time end = new Time(2017, 10, 13, 11, 14, 16);
				boolean b2 =time2.time_Between(start, end);
				assertFalse(b2);
	}

}
