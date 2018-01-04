package Project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Filters.filter;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
/**
 * This class represent a LineFile object and all the functions you can apply on it.
 * @author Bar, Noy, Doriya
 *
 */
public class Records implements Functions{
	private ArrayList<LineFile> _rec;
	private List<String[]> _file;

	public Records(){
		_rec=new ArrayList<LineFile>();
	}
	public Records(List<LineFile> rec) {
		_rec=new ArrayList<LineFile>(rec);
	}

	public List<LineFile> get_rec() {
		return _rec;
	}

	/**
	 * This function checks if the condition is true
	 * @param condition Time,ID or Location inserted
	 * @return new Record 
	 */
	public Records filter(filter condition){
		List<LineFile> output = new ArrayList<>();
		for (LineFile lineFile : _rec) {
			if(condition.test(lineFile)){
				output.add(lineFile);
			}
		} 
		return new Records(output);
	}

	/**
	 * This function reads CSV file
	 * @param files the CSV 
	 * @return List of strings[]
	 */
	@Override
	public void readFile(String fileName){
		_file = new ArrayList<String[]>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line="";
			_file.add(br.readLine().split(","));
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				if(str[10].equals("WIFI")){
					_file.add(str);
				}
				
				
			}
			br.close();
		}
		catch(IOException ex) {
			System.out.print("Error reading file\n" + ex);
			System.exit(2);
		}
	}
	/**
	 * This function changes the input CSV file according the new CSV file requires 
	 * @param path folder location
	 */
	
	
	public void parseFile(String path){
		try{
			File f = new File(path);
			File[] files = f.listFiles();

			for (int i = 0; i < files.length; i++) {
				List<LineFile> merge = new ArrayList<LineFile>();
				if(files[i].getName().endsWith("csv")&& (!files[i].isDirectory())){
					readFile(files[i].getName());
					String [] id = _file.get(0);
					String ID = id[2].replace("model=", "");
					int countNet =0;
					Time time =new Time();
					for (int j = 2; j < _file.size(); j+=countNet) {
						String[]s = _file.get(j);
						time = time.set_Date(s[3]);
						List<Network> Wifi = new ArrayList<Network>();
						double lat = Double.parseDouble(s[6]);
						double lon = Double.parseDouble(s[7]);
						double alt = Double.parseDouble(s[8]);
						Point_2D p = new Point_2D(lon, lat);
						countNet =0;
						for (int t = 2; t < _file.size(); t++) {
							String[] lines = _file.get(t);
							Time time2 = new Time();
							time2=time2.set_Date(lines[3]);
							if (time2.is_Equal(time)){
								int signal = Integer.parseInt(lines[5]);
								Network wifi = new Network(lines[1],lines[0],signal,lines[4]);
								Wifi.add(wifi);
								countNet++;	
							}
						}
						Wifi.sort(null);
						List<Network> Wifi2 = new ArrayList<Network>();
						for (int c = 0; c <Wifi.size()&&c<10; c++){
							Wifi2.add(Wifi.get(c));
						}
						merge.add(new LineFile(time,ID,p,alt,countNet,Wifi2));
					}
				}
		
				this._rec.addAll(merge);
			}
		}
		catch(Exception ex) {
			//System.out.print("Error parsing file\n" + ex);
			ex.printStackTrace();
			System.exit(2);
		}
	}
	/**
	 * This function write the new Records to a CSV file
	 * @param fileName output file name
	 */
	@Override
	public void toCsv(String fileName){
		try {

			FileWriter fw = new FileWriter("C:\\Users\\Doriya Spielman\\git\\OO_Project\\Output_Files\\"+fileName+".csv");
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("Time");bw.append(',');bw.append("ID");bw.append(','); bw.append("LAT");bw.append(',');
			bw.append("LON"); bw.append(',');bw.append("ALT"); bw.append(',');bw.append("#WIFI NETWORKS");
			bw.append(',');
			for (int i = 1; i <11; i++) {
				bw.append("SSID"+i+','+"MAC"+i+','+"SIGNAL"+i+','+"FREQUENCY"+i);
				bw.append(',');
			}
			bw.write("\n");
			for(LineFile l : _rec){
				bw.write(l.toString().replace("[", "").replace("]", ""));
				bw.write("\n");
			}
			bw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
	}
	/**
	 * This function create a KML file from the Record
	 * @param output KML file name
	 */
	public void csv2Kml(String output){
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("Locations").withOpen(true);
		Folder folder = doc.createAndAddFolder();
		folder.withName("Wifi Networks").withOpen(true);
		Style style = doc.createAndAddStyle();
		style.createAndSetLabelStyle().withColor("7fffaaff").withScale(1.5);
		for(LineFile f : _rec){
			style.withId("Our_OOP")
			.createAndSetIconStyle().withScale(1.0).withIcon(new Icon().withHref("http://maps.google.com/mapfiles/kml/paddle/ltblu-stars.png"));
			style.createAndSetLabelStyle().withColor("ff43b3ff").withScale(1.0);
			doc.createAndSetTimeStamp().withWhen(f.getTime().toString());
			Placemark placemark=folder.createAndAddPlacemark();
			List<Network> net=f.getNetwork();
			for(Network n : net){
				placemark.createAndSetTimeStamp().withWhen(f.getTime().toString());
				placemark.withName(f.getModel().toString())
				//.withStyleUrl("#style_" + ID)
				.withDescription(
						"Time: <b>"+ f.getTime().toString() +"</b><br/>ID: <b>"+ f.getModel().toString() +"</b><br/>SSID: <b>"+n.getSSID().toString() +"</b><br/>MAC: <b>"+ n.getMac().toString() +"</b><br/>Signal: <b>"+ n.getSignal() +"</b><br/>Frequency: <b>"+ n.getChanel().toString() +"</b>")
				.createAndSetLookAt().withLongitude(f.getLocation().getLon()).withLatitude(f.getLocation().getLat()).withAltitude(f.getAlt());
				doc.addToFeature(placemark);
			}
			placemark.createAndSetPoint().addToCoordinates(f.getLocation().getLon(),f.getLocation().getLat(),f.getAlt());
		}
		kml.setFeature(doc);
		try {
			kml.marshal(new File(output));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getSize(){
		return _rec.size();
	}

	public int getNumMac(){
		ArrayList<String> mac = new ArrayList<>();

		String tempMac="";
		for (LineFile l : _rec) {
			for (int i = 0; i < l.getNetwork().size(); i++) {
				tempMac=l.getNetwork().get(i).Mac;
					if(!mac.contains(tempMac))
						mac.add(tempMac);
							
			}
		}
		return mac.size();
	}
}
