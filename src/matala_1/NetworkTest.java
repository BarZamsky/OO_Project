package matala_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class NetworkTest {

	@Test
	public void test() {
		String ssid = "hello";
		String mac = "1.2.3.4";
		int signal = -87;
		String chanel = "11";
		Network n1 = new Network(ssid, mac, signal, chanel);
		String ssid1 = "samsungs8";
		String mac1 = "12.13.14.15";
		int signal1 = -30;
		String chanel1 = "15";
		Network n2 = new Network(ssid1, mac1, signal1, chanel1);
		assertEquals("samsungs8", n2.getSSID());
		assertEquals("hello", n1.getSSID());
		assertEquals("1.2.3.4", n1.getMac());
		assertEquals("12.13.14.15", n2.getMac());
		assertEquals(-87, n1.getSignal());
		assertEquals(-30, n2.getSignal());
		assertEquals("11", n1.getChanel());
		assertEquals("15", n2.getChanel());
	}
}
