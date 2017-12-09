package TESTS_Network;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Network_getChanel.class, Test_Network_getMac.class, Test_Network_getSignal.class,
		Test_Network_getSSID.class })
public class AllTests_Network {

}
