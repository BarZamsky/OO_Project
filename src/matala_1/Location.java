package matala_1;

public class Location {
private Coordinate Points;

	public Location(Coordinate Coor){
		this.Points = Coor;
}

	public Coordinate getPoints() {
		return Points;
	}

	public void setPoints(Coordinate points) {
		Points = points;
	}

	@Override
	public String toString() {
		return Points.toString();
	}
}