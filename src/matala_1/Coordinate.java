package matala_1;
/**
 * This class represent coordinate of alt,lon and alt
 * @author Bar, Noy, Doriya
 *
 */
public class Coordinate {
	private double lon;
	private double lat;
	private double alt;

	public Coordinate(double lon, double lat, double alt){
		this.alt = alt;
		this.lon = lon;
		this.lat = lat;
	}
	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}
	@Override
	public String toString() {
		return lat +","+lon+","+alt;
	}
}