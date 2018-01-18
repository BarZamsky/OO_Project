
import static org.junit.Assert.*;
import org.junit.Test;

import Project.Time;
////
public class Time_Test {
	int year = 1993;
	int month = 07;
	int day = 13;
	int hour = 10;
	int minute = 14;
	int second = 15;
	Time t1 = new Time(year, month, day, hour, minute, second);
	Time t2 = new Time(1993, 07, 13, 10, 14, 15);
	Time t3 = new Time(2017, 11, 13 , 10, 10, 15);
	Time time2 = new Time(2017, 10, 13, 11, 15, 20);
	Time start = new Time(2017, 10, 13, 11, 10, 13);
	Time end = new Time(2017, 10, 13, 11, 14, 16);
	Time time1 = new Time(2017, 10, 13, 11, 13, 15);
	boolean b1 = time1.time_Between(start, end);
	boolean b2 =time2.time_Between(start, end);
	/**
	 * Test for getDay in Time
	 */
	@Test
	public void test_getDay() {
		assertEquals(13, t1.getDay());
	}
	/**
	* Test for getHour in Time
	*/
	@Test
	public void test_getHour() {
		assertEquals(10, t1.getHour());
	}
	/**
	 * Test for getMinute in Time
	 */
	@Test
	public void test_getMinute() {
		assertEquals(14, t1.getMinute());
	}
	/**
	 * Test for getMonth in Time
	 */
	@Test
	public void test_getMonth() {
		assertEquals(07, t1.getMonth());
	}
	/**
	 * Test for getSecond in Time
	 */
	@Test
	public void test_getSecond() {
		assertEquals(15, t1.getSecond());
	}
	/**
	 * Test for getYear in Time
	 */
	@Test
	public void test_getYear() {
		assertEquals(1993, t1.getYear());
	}
	/**
	 * test the function is_Equal (if it's False)
	 */
	@Test
	public void test_is_Equal_F() {
		assertFalse(t1.is_Equal(t3));
	}
	/**
	 * test the function is_Equal (if it's True)
	 */
	@Test
	public void test_is_Equal_T() {
		assertTrue(t1.is_Equal(t2));
	}
	/**
	 * test the function set_Date (getDay)
	 */
	@Test
	public void test_set_Data_Dat() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(10, t5.getDay());
	}
	/**
	 * test the function set_Date getHour
	 */
	@Test
	public void test_set_Dta_Hour() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(10, t5.getHour());
	}
	/**
	 * test the function set_Date getMinute
	 */
	@Test
	public void test_set_Data_Minute() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(11, t5.getMinute());
	}
	/**
	 * test the function set_Date getMonth
	 */
	@Test
	public void test_set_Data_Month() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(12, t5.getMonth());
	}
	/**
	 * test the function set_Date getSecond
	 */
	@Test
	public void test_set_Data_Second() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(15, t5.getSecond());
	}
	/**
	 * test the function set_Date getYear
	 */
	@Test
	public void test_set_Data_Year() {
		String t4 = "2017-12-10 10:11:15";
		Time t5 = new Time();
		t5 = t5.set_Date(t4);
		assertEquals(2017, t5.getYear());
	}
	/**
	 * test the function time_Between (if it's False)
	 */
	@Test
	public void test_timeBetween_F() {
		assertFalse(b2);
	}
	/**
	 * test the function time_Between (if it's True)
	 */
	@Test
	public void test_timeBetween_T() {
		assertTrue(b1);
	}
}
