package TESTS_Network;

import static org.junit.Assert.*;
import org.junit.Test;

import matala_1.Network;
/**
 * Test for getSignal in Network
 *
 */
public class Test_Network_getSignal {

	@Test
	public void test() {
		String ssid = "samsungs8";
		String mac = "12.13.14.15";
		int signal = -30;
		String chanel = "15";
		Network n = new Network(ssid, mac, signal, chanel);
		assertEquals(-30, n.getSignal());
	}

}
