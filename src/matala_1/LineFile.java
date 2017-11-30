package matala_1;

import java.util.List;
/**
 * This class represent the form of the lines in the new arranged CSV file  
 * @author Bar,Noy,Doriya
 *
 */
public class LineFile {
	private Time time;
	private String model;
	private Point_2D location;
	private double alt;
	private int numOfNetworks;
	private List<Network> network;

	public LineFile(Time time, String model, Point_2D location,double alt, int numOfNetworks, List<Network> wifi) {
		this.time = time;
		this.model = model;
		this.location = location;
		this.alt = alt;
		this.numOfNetworks = numOfNetworks;
		this.network = wifi;
	}

	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Point_2D getLocation() {
		return location;
	}
	public void setLocation(Point_2D location) {
		this.location = location;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	public int getNumOfNetworks() {
		return numOfNetworks;
	}
	public void setNumOfNetworks(int numOfNetworks) {
		this.numOfNetworks = numOfNetworks;
	}
	public List<Network> getNetwork() {
		return network;
	}
	public void setNetwork(List<Network> network) {
		this.network = network;
	}

	@Override
	public String toString() {
		return time + ","+ model+ ","+ location+","+alt+","+ numOfNetworks+","+ network;
	}


}
