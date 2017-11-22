package matala_1;

import java.util.ArrayList;
import java.util.List;

public class LineFile {
private Time time;
private Model model;
private Location location;
private int numOfNetworks;
private List<Network> network;
//
public LineFile(Time time, Model model, Location location, int numOfNetworks, List<Network> wifi) {
	this.time = time;
	this.model = model;
	this.location = location;
	this.numOfNetworks = numOfNetworks;
	this.network = wifi;
}

public Time getTime() {
	return time;
}
public void setTime(Time time) {
	this.time = time;
}
public Model getModel() {
	return model;
}
public void setModel(Model model) {
	this.model = model;
}
public Location getLocation() {
	return location;
}
public void setLocation(Location location) {
	this.location = location;
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
	return "["+time + ","+ model+ ","+ location+", "+ numOfNetworks+","+ network;
}



}
