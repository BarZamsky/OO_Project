package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;
/**
 * test the function is_Equal (if it's False)
 *
 */
public class TimeTest_is_Equal_F {

	@Test
	public void test() {
		
		int year = 1993;
		int month = 07;
		int day = 13;
		int hour = 10;
		int minute = 14;
		int second = 15;
		Time t1 = new Time(year, month, day, hour, minute, second);
		Time t3 = new Time(2017, 11, 13 , 10, 10, 15);
		assertFalse(t1.is_Equal(t3));
	}

}
