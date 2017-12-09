package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;

public class TimeTest_is_Equal_T {

	@Test
	public void test() {
		//test the function is_Equal (if True)
		
		int year = 1993;
		int month = 07;
		int day = 13;
		int hour = 10;
		int minute = 14;
		int second = 15;
		Time t1 = new Time(year, month, day, hour, minute, second);
		Time t2 = new Time(1993, 07, 13, 10, 14, 15);
		assertTrue(t1.is_Equal(t2));
	}

}
