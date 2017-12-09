package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;
/**
 * Test for getSecond in Time
 *
 */
public class TimeTest_getSecond {

	@Test
	public void test() {
		int year = 1993;
		int month = 07;
		int day = 13;
		int hour = 10;
		int minute = 14;
		int second = 15;
		Time t1 = new Time(year, month, day, hour, minute, second);
		assertEquals(15, t1.getSecond());
	}

}
