package matala_1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;
import de.micromata.opengis.kml.v_2_2_0.Feature;

/**
 * This class converts CSV file to a KML file with a placemark and a chart for each continent. The chart is generated with the Google Chart API and
 * show the area (surface of the earth) of each continent..
 *
 * @author Bar, Noy , Doriya
 *
 */
public class Csv2Kml {
/**
 * This function creates a KML file with TimeStamp
 * @param lines the LineFile List
 * @param output the name of the new KML file
 */
	private static void create_Kml(List<LineFile> lines, String output) {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("Locations").withOpen(true);
		Folder folder = doc.createAndAddFolder();
		folder.withName("Wifi Networks").withOpen(true);
		Style style = doc.createAndAddStyle();
		style.createAndSetLabelStyle().withColor("7fffaaff").withScale(1.5);
		style.withId("Our_OOP")
		.createAndSetIconStyle().withScale(1.0).withIcon(new Icon().withHref("http://maps.google.com/mapfiles/kml/paddle/ltblu-stars.png"));
		style.createAndSetLabelStyle().withColor("ff43b3ff").withScale(1.0);
		for(LineFile f : lines){
			doc.createAndSetTimeStamp().withWhen(f.getTime().toString());
			Placemark placemark=folder.createAndAddPlacemark();
			List<Network> net=f.getNetwork();
			for(Network n : net){
				placemark.createAndSetTimeStamp().withWhen(f.getTime().toString());
				placemark.withName(f.getModel().toString())
				//.withStyleUrl("#style_" + ID)
				.withDescription(
						"Time: <b>"+ f.getTime().toString() +"</b><br/>ID: <b>"+ f.getModel().toString() +"</b><br/>SSID: <b>"+n.getSSID().toString() +"</b><br/>MAC: <b>"+ n.getMac().toString() +"</b><br/>Signal: <b>"+ n.getSignal().toString() +"</b><br/>Frequency: <b>"+ n.getChanel().toString() +"</b>")
				.createAndSetLookAt().withLongitude(f.getLocation().getPoints().getLon()).withLatitude(f.getLocation().getPoints().getLat()).withAltitude(f.getLocation().getPoints().getAlt());
				doc.addToFeature(placemark);
			}
			placemark.createAndSetPoint().addToCoordinates(f.getLocation().getPoints().getLon(),f.getLocation().getPoints().getLat(),f.getLocation().getPoints().getAlt());
		}
		kml.setFeature(doc);
		try {
			kml.marshal(new File(output));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
		String []s = matala_1.Folder.csv_Files("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		List<LineFile> fin = new ArrayList<LineFile>();
		fin = matala_1.ParsingFiles.merge_File(s);
		filter c1 = list->list.getLocation().getPoints().getAlt()>=400;
		List<LineFile> filteredStrings = FileFilter.filter(fin,c1);
		create_Kml(filteredStrings, "filterKML.kml");
	}
}



