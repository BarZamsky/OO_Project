package Filters;
import Project.Point_2D;
import Project.Records;
import Project.Time;
public class filters_for_GUI {

	public static void filter_by_Model(Records _rec, String model){
		filter f_model = list->list.getModel().equals(model);
		_rec = _rec.filter(f_model);
		_rec.toCsv("filter_by_model.csv");
		_rec.csv2Kml("filter_by_model.kml");
	}
	
	public static void filter_by_Location(Records _rec,double alt, double lat, double lon,double radius){
		Point_2D p = new Point_2D(lon, lat);
		filter f_location = list->list.getLocation().distanceTo(p)<=radius;
		_rec = _rec.filter(f_location);
		_rec.toCsv("filter_by_location.csv");
		_rec.csv2Kml("filter_by_location.kml");
	}
	
	public static void filter_by_Time(Records _rec, String start, String end){
		Time t_start = new Time();
		Time t_end = new Time();
		filter f_time = list->list.getTime().time_Between(t_start.set_Date(start) , t_end.set_Date(end));
		_rec = _rec.filter(f_time);
		_rec.toCsv("filter_by_time.csv");
		_rec.csv2Kml("filter_by_time_kml.kml");
	}
	
	public static void filter_Two(Records _rec){
		
	}
}
