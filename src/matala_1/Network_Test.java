package matala_1;
import static org.junit.Assert.*;
import org.junit.Test;

public class Network_Test {
	String ssid = "samsungs8";
	String mac = "12.13.14.15";
	int signal = -30;
	String chanel = "15";
	Network n = new Network(ssid, mac, signal, chanel);
	
	/**
	 * Test for getChanel in Network
	 */
	@Test
	public void test_getChanel() {
		assertEquals("15", n.getChanel());
	}
	/**
	 * Test for getMac in Network
	 */
	@Test
	public void test_getMac() {
		assertEquals("12.13.14.15", n.getMac());
	}
	/**
	 * Test for getSignal in Network
	 */
	@Test
	public void test_getSignal() {
		assertEquals(-30, n.getSignal());
	}
	/**
	 * Test for getSSID in Network
	 */
	@Test
	public void test_getSSID() {
		assertEquals("samsungs8", n.getSSID());
	}
}
