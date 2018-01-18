package Filters;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Project.Point_2D;
import Project.Records;
import Project.Time;
/**
 * This class represent object of filter
 * @author Bar
 *
 */
public class filter_Rec implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<filter> _cond;
	private filter _f1;
	private filter _f2;
	private String _toString;

	public filter_Rec(){
		_cond=new ArrayList<filter>();
		_toString ="";
	}
	/**
	 * This function save the filter to the PC
	 * @param path - location of the new file
	 * @throws IOException
	 */
	public void saveFilterToDisk(String path) throws IOException {
		try {
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error saving Filter\n");
			e.printStackTrace();
		}
	}

	/**
	 * This function loads the filter from the PC
	 * @param path - location of the file
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void deserializeFromFile(String path) {
		filter_Rec fr = null;
		try {
			FileInputStream fileIn = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			fr = (filter_Rec) in.readObject();
			in.close();
			fileIn.close();
			fr.getFilters();
		} catch (IOException i) {
			System.out.println("Error loading Filter\n");
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println("Filter not found\n");
			c.printStackTrace();
			return;
		}
	}

	/**
	 * This function create filter by model
	 * @param model - ID of the phone
	 * @param not - if the filter is !model
	 */
	public void create_Model_Filter(String model,boolean not){
		if(not == true){
			filter f_model = list->!(list.getModel().equals(model.toUpperCase()));
			_cond.add(f_model);
			_toString +="Model not equals to"+model+"; ";
			_f1 = f_model;
		}
		else{
			filter f_model = list->list.getModel().equals(model);
			_cond.add(f_model);
			_toString +="Model equals to:"+model+"; ";
			_f1 = f_model;
		}
	}

	/**
	 * This function creates filter by location and radius
	 * @param alt
	 * @param lat
	 * @param lon
	 * @param radius
	 * @param not - !location 
	 */
	public void create_Location_Filter(double alt, double lat, double lon,double radius,boolean not){
		if(not == true){
			Point_2D p = new Point_2D(lon, lat);
			filter f_location = list->!(list.getLocation().distanceTo(p)<=radius);
			_cond.add(f_location);
			_toString +="Not location distance:" +lat+","+lon+"from radius:"+radius+"; ";
			_f1 = f_location;
		}
		else{
			Point_2D p = new Point_2D(lon, lat);
			filter f_location = list->list.getLocation().distanceTo(p)<=radius;
			_cond.add(f_location);
			_toString +="location distance:" +lat+","+lon+"from radius:"+radius+"; ";;
			_f1 = f_location;
		}
	}
	/**
	 * This function creates filter by time
	 * @param start - starting time
	 * @param end - final time
	 * @param not - not between the times
	 */
	public  void create_Time_Filter(String start, String end,boolean not){
		if(not == true){
			Time t_start = new Time();
			Time t_end = new Time();
			filter f_time = list->!(list.getTime().time_Between(t_start.set_Date(start) , t_end.set_Date(end)));
			_cond.add(f_time);
			_toString +="Not time between:"+start+","+end+"; ";
			_f1 = f_time;
		}
		else{
			Time t_start = new Time();
			Time t_end = new Time();
			filter f_time = list->list.getTime().time_Between(t_start.set_Date(start) , t_end.set_Date(end));
			_cond.add(f_time);
			_toString +="Time between:"+start+","+end+"; ";;
			_f1 = f_time;
		}
	}
	/**
	 * This function add another filter by model to the list
	 * @param model - ID of the phone
	 * @param not - if the filter is !model
	 */
	public void add_Model_Filter(String model,boolean not){
		if(not == true){
			filter f_model = list->!(list.getModel().equals(model.toUpperCase()));
			_cond.add(f_model);
			_toString +="Model not equals to:" +model+"; ";
			_f2 = f_model;
		}
		else{
			filter f_model = list->list.getModel().equals(model);
			_cond.add(f_model);
			_toString +="Model equals to:" +model+"; ";
			_f2 = f_model;
		}
	}
	/**
	 * This function add another filter by location to the list
	 * @param alt
	 * @param lat
	 * @param lon
	 * @param radius
	 * @param not - !location 
	 */
	public void add_Location_Filter(double alt, double lat, double lon,double radius,boolean not){
		if(not == true){
			Point_2D p = new Point_2D(lon, lat);
			filter f_location = list->!(list.getLocation().distanceTo(p)<=radius);
			_cond.add(f_location);
			_toString +="Not location distance:" +lat+","+lon+"from radius:"+radius+"; ";
			_f2 = f_location;
		}
		else{
			Point_2D p = new Point_2D(lon, lat);
			filter f_location = list->list.getLocation().distanceTo(p)<=radius;
			_cond.add(f_location);
			_toString +="location distance:" +lat+","+lon+"from radius:"+radius+"; ";
			_f2 = f_location;
		}
	}
	/**
	 * This function add another filter by time to the list
	 * @param start - starting time
	 * @param end - final time
	 * @param not - not between the times
	 */
	public  void add_Time_Filter(String start, String end,boolean not){
		if(not == true){
			Time t_start = new Time();
			Time t_end = new Time();
			filter f_time = list->!(list.getTime().time_Between(t_start.set_Date(start) , t_end.set_Date(end)));
			_cond.add(f_time);
			_toString +="Not time between:"+start+","+end+"; ";
			_f2 = f_time;
		}
		else{
			Time t_start = new Time();
			Time t_end = new Time();
			filter f_time = list->list.getTime().time_Between(t_start.set_Date(start) , t_end.set_Date(end));
			_cond.add(f_time);	
			_toString +="Time between:"+start+","+end+"; ";
			_f2 = f_time;
		}
	}

	/**
	 * This function filtering the Records of the WIFI scans
	 * @param _rec
	 * @param gate
	 */
	public void create_Filter(Records _rec, String gate){
		if(_cond.size()==1){
			_rec = _rec.filter(_cond.get(0));
			_rec.toCsv("filteredFile.csv");
			_rec.csv2Kml("filteredFile.kml");	
		}
		else{
			if(gate.equals("Or")){
				Or_Filter or = new Or_Filter(_cond.get(0),_cond.get(1));
				_toString+=" (||)";
				_rec = _rec.filter(or);
				_rec.toCsv("filteredFile.csv");
				_rec.csv2Kml("filteredFile.kml");
			}
			if(gate.equals("And")){
				And_Filter and = new And_Filter(_cond.get(0),_cond.get(1));
				_toString+=" (&&)";
				_rec = _rec.filter(and);
				_rec.toCsv("filteredFile.csv");
				_rec.csv2Kml("filteredFile.kml");
			}
		}
	}
	public void getFilters(){
		if(_cond.size()==1){
			_f1 = _cond.get(0);
			_toString=_f1.toString();
		}
		else{
			_f1=_cond.get(0);
			_f2=_cond.get(1);
			_toString=_f1.toString()+_f2.toString();
		}
	}
	@Override
	public String toString() {
		return _toString;
	}
}