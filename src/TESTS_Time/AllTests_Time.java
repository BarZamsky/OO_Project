package TESTS_Time;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TimeTest_getDay.class, TimeTest_getHour.class, TimeTest_getMinute.class, TimeTest_getMonth.class,
		TimeTest_getSecond.class, TimeTest_getYear.class, TimeTest_is_Equal_F.class, TimeTest_is_Equal_T.class,
		TimeTest_set_Date_Day.class, TimeTest_set_Date_Hour.class, TimeTest_set_Date_Minute.class,
		TimeTest_set_Date_Month.class, TimeTest_set_Date_Second.class, TimeTest_set_Date_year.class,
		TimeTest_time_Between_F.class, TimeTest_time_Between_T.class })
public class AllTests_Time {

}
