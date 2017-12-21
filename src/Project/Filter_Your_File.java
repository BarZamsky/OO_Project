package Project;
import java.util.Scanner;
/**
 * This class is the main class of our project. 
 * You can create CSV file, filter it by Time,Location or ID and create a kml file
 * @author Bar, Noy, Doriya
 *
 */
public class Filter_Your_File {

	public static void choose_Condition(Records _rec){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose how would you like to filter the file : ");
		System.out.println("1- Time, 2-Model, 3-Location");
		int choise = sc.nextInt();
		switch(choise){
		case 1:
			sc.nextLine();
			System.out.println("Please enter date to start filtering with.\n");
			System.out.println("format: YY-MM-DD HH:MM:SS (include space)");
			String t1 = sc.nextLine();
			System.out.println("Please enter date to end filtering with.\n");
			System.out.println("format: YY-MM-DD HH:MM:SS (include space)");
			String t2 = sc.nextLine();
			Time t_start = new Time();
			Time t_end = new Time();
			filter f_time = list->list.getTime().time_Between(t_start.set_Date(t1) , t_end.set_Date(t2));
			_rec = _rec.filter(f_time);
			_rec.toCsv("filter_by_time.csv");
			System.out.println("your file is ready : 'filter_by_time.csv'");
			_rec.csv2Kml("filter_by_time_kml.kml");
			System.out.println("Created KML_FILE : 'filter_by_time.kml'");
			break;

		case 2: 
			sc.nextLine();
			System.out.println("Please enter the model you are searching :");
			System.out.println("(just the name of the device)");
			String model = sc.nextLine();
			filter f_model = list->list.getModel().equals(model);
			_rec = _rec.filter(f_model);
			_rec.toCsv("filter_by_model.csv");
			System.out.println("your file is ready : 'filter_by_model.csv'");
			_rec.csv2Kml("filter_by_model.kml");
			System.out.println("Created KML_FILE : 'filter_by_model.kml'");
			break;

		case 3:
			System.out.println("Please enter the lat:\n");
			double lat = sc.nextDouble();
			System.out.println("Please enter the lon:\n");
			double lon = sc.nextDouble();
			System.out.println("please enter Radius:\n");
			double radius = sc.nextDouble();
			Point_2D p = new Point_2D(lon, lat);
			filter f_location = list->list.getLocation().distanceTo(p)<=radius;
			_rec = _rec.filter(f_location);
			_rec.toCsv("filter_by_location.csv");
			System.out.println("your file is ready : 'filter_by_location.csv'");
			_rec.csv2Kml("filter_by_location.kml");
			System.out.println("Created KML_FILE : 'filter_by_location.kml'");
			break;

		default:
			break;

		}
		sc.close();
	}
	public static void main(String[] args) {
		Records r = new Records();
		r.parseFile("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		r.toCsv("Merge_File.csv");
		r.csv2Kml("Merge_File_kml.kml");
		Scanner s = new Scanner(System.in);
		System.out.println("Would you like to filter your merge_file? press 1");
		int c = s.nextInt();
		if(c==1){
			choose_Condition(r);
		}
		else{
			System.out.println("Good-Bye");
		}
		s.close();
	}
}
