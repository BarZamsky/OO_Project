package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;

public class TimeTest_getMinute {

	@Test
	public void test() {
		int year = 1993;
		int month = 07;
		int day = 13;
		int hour = 10;
		int minute = 14;
		int second = 15;
		Time t1 = new Time(year, month, day, hour, minute, second);
		assertEquals(14, t1.getMinute());
	}

}
