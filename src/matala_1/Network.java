package matala_1;
/**
 * This class defines for every WIFI network that was scanned by the wigleWifi app it's 4 unique elements 
 * @author Bar, Noy, Doriya
 *
 */
public class Network implements Comparable<Network> {
	public String SSID;
	public String Mac;
	public int Signal;
	public String Chanel;

/**
 * 
 * @param sSID the wifi name
 * @param mac the mac address
 * @param signal 
 * @param chanel
 */
	public Network(String sSID, String mac, int signal, String chanel) {
		SSID = sSID;
		Mac = mac;
		Signal = signal;
		Chanel = chanel;
	}

	public String getSSID() {
		return SSID;
	}
	public void setSSID(String sSID) {
		SSID = sSID;
	}
	public String getMac() {
		return Mac;
	}
	public void setMac(String mac) {
		Mac = mac;
	}
	public int getSignal() {
		return Signal;
	}
	public void setSignal(int signal) {
		Signal = signal;
	}
	public String getChanel() {
		return Chanel;
	}
	public void setChanel(String c) {
		Chanel = c;
	}
	@Override
	public int compareTo(Network o) {
		return Integer.compare(-this.Signal, -o.Signal);
	}

	@Override
	public String toString() {
		return SSID+","+Mac+","+Signal+","+Chanel;
	}



}
