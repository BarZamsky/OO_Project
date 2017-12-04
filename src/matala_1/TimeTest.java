package matala_1;

import static org.junit.Assert.*;
import org.junit.Test;

public class TimeTest {

	@Test
	public void test() {
		int year = 1993;
		int month = 07;
		int day = 13;
		int hour = 10;
		int minute = 14;
		int second = 15;
		Time t1 = new Time(year, month, day, hour, minute, second);
		assertEquals(1993, t1.getYear());
		assertEquals(07, t1.getMonth());
		assertEquals(13, t1.getDay());
		assertEquals(10, t1.getHour());
		assertEquals(14, t1.getMinute());
		assertEquals(15, t1.getSecond());
		
		//test the function is_Equal
		Time t2 = new Time(1993, 07, 13, 10, 14, 15);
		Time t3 = new Time(2017, 11, 13 , 10, 10, 15);
		assertTrue(t1.is_Equal(t2));
		assertFalse(t1.is_Equal(t3));
		
		//test the function set_Date
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(2017, t5.getYear());
		assertEquals(12, t5.getMonth());
		assertEquals(10, t5.getDay());
		assertEquals(10, t5.getHour());
		assertEquals(11, t5.getMinute());
		assertEquals(15, t5.getSecond());
		
		//test the function time_Between
		Time time1 = new Time(2017, 10, 13, 11, 13, 15);
		Time time2 = new Time(2017, 10, 13, 11, 15, 20);
		Time start = new Time(2017, 10, 13, 11, 10, 13);
		Time end = new Time(2017, 10, 13, 11, 14, 16);
		boolean b1 = time1.time_Between(start, end);
		boolean b2 =time2.time_Between(start, end);
		assertTrue(b1);
		assertFalse(b2);
	}
}
