package matala_1;
/**
 * This class represent a Time object of the wifi scan
 * @author Bar,Noy,Doriya
 *
 */
public class Time {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;

	public Time(){}

	public Time(int year, int month, int day, int hour, int minute, int second) {
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	/**
	 * This function take a String from the csv file and adapt it to the Time object
	 * @param time String time
	 * @return new Time object
	 */
	public Time set_Date(String time){
		Time _time = new Time();
		String[]times =time.split(" ");
		String[]date = times[0].split("-");
		String[]t = times[1].split(":");
		_time.setYear(Integer.parseInt(date[0]));
		_time.setMonth(Integer.parseInt(date[1]));
		_time.setDay(Integer.parseInt(date[2]));
		_time.setHour(Integer.parseInt(t[0]));
		_time.setMinute(Integer.parseInt(t[1]));
		_time.setSecond(Integer.parseInt(t[2]));
		return _time;
	}
	/**
	 * This function checks if two given times are equals
	 * @param t Time object
	 * @return true if equals
	 */
	public boolean is_Equal(Time t){
		if(this.day==t.day&&this.month==t.month&&this.year==t.year&&this.minute==t.minute&&
				this.second==t.second&&this.hour==t.hour){
			return true;
		}
		return false;
	}

	public boolean time_Between(Time start , Time end){
		return(this.day>=start.getDay() && this.day<=end.getDay()) && (this.month>=start.getMonth() &&this.month<=end.getMonth())
				&& (this.year>=start.getYear() && this.year<=end.getYear()) && (this.hour>=start.getHour() && this.hour<=end.getHour())
				&&(this.second>=start.getSecond() && this.second<=end.getSecond())&&(this.minute>=start.getMinute()&&this.minute<=end.getMinute());
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
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

	@Override
	public String toString() {
		return year+"-"+month+"-"+day+"T"+hour+":"+minute+":"+second+"Z";
	}		
}
