package matala_1;
/**
 * This class represent coordinate of alt,lon and alt
 * @author Bar, Noy, Doriya
 *
 */

public class Point_2D {
	private double lon;
	private double lat;

	public Point_2D(double lon, double lat){
		this.lat = lat;
		this.lon = lon;
	}
	
	public double distanceTo(Point_2D l1){
		return Math.hypot( this.getLon() - l1.getLon() , this.getLat() - l1.getLat());
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
	@Override
	public String toString() {
		return lat +","+lon;
	}
	public static void main(String[] args) {
		Point_2D p1= new Point_2D(32, 40);
		Point_2D p2 = new Point_2D(13,10);
		double a = p1.distanceTo(p2);
		System.out.println(a);
	}
}