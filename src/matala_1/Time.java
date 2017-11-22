package matala_1;

public class Time {
	private String time;
	
	public Time(String s){
		this.time = s;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return time;
	}

	public boolean equal_Time(Time t) {
		return this.time.equals(t.time);
	}
}
