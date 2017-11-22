package matala_1;

public class Time {
	private String year;
	private String month;
	private String day;
	private int hour;
	private int minute;
	private int second;
	
	public Time(){}
	
	public Time(String year, String month, String day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public Time set_Date(String time){
		Time _time = new Time();
		String[]times =time.split(" ");
		String[]date = times[0].split("-");
		String[]t = times[1].split(":");
		_time.setYear(date[0]);
		_time.setMonth(date[1]);
		_time.setDay(date[2]);
		_time.setHour(Integer.parseInt(t[0]));
		_time.setMinute(Integer.parseInt(t[1]));
		_time.setSecond(Integer.parseInt(t[2]));
		return _time;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	
	public boolean is_Equal(Time t){
		if(this.day.equals(t.day)&&this.month.equals(t.month)&&this.year.equals(t.year)&&this.minute==t.minute&&this.second==t.second&&this.hour==t.hour){
		return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
	}
	
	public static void main(String[] args) {
		String s = "2017-10-18 16:20:38";
		Time t = new Time();
		t=t.set_Date(s);
		System.out.println(t);
	}
	
	
}
