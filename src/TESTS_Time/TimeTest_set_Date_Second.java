package TESTS_Time;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Time;
/**
 * test the function set_Date getSecond
 *
 */
public class TimeTest_set_Date_Second {

	@Test
	public void test() {
		
				String t4 = "2017-12-10 10:11:15";
				Time t5 = new Time();
				t5 = t5.set_Date(t4);
				assertEquals(15, t5.getSecond());
	}

}
