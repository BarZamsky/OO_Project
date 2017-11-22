package matala_1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.TimeStamp;

/**
 * This class converts csv file to a KML file with a placemark and a chart for each continent. The chart is generated with the Google Chart API and
 * show the area (surface of the earth) of each continent..
 * We use this example open code for our class :https://github.com/micromata/javaapiforkml/blob/master/src/test/java/de/micromata/jak/examples/Example1.java
 * @author Bar, Noy , Doriya
 *
 */
public class Csv2Kml {
	/**
	 * The createPlacemarkWithChart ()-method generates and set a placemark object, with the given statistical data . The Icon and Style
	 * objects (color and size of the text and icon) are saved to the root element. The placemark is created and set to the given folder.
	 * @param document structure of the KML file
	 * @param folder to add continent
	 * @param time of the continent
	 * @param ID of the mobile phone
	 * @param ssid of the continent
	 * @param MAC of the continent
	 * @param Signal of the continent
	 * @param Frequency of the continent
	 * @param lon of the continent
	 * @param lat of the continent
	 */
	private static void createPlacemarkWithChart(Document document, Folder folder,String time, String ID,String ssid,String MAC, 
			String Signal,String Frequency, double lon, double lat ) {
		
		Style style = document.createAndAddStyle();
		style.createAndSetLabelStyle().withColor("7fffaaff").withScale(1.5);
		style.withId("style_" + ID) // set the stylename to use this style from the placemark
		.createAndSetIconStyle().withScale(1.0).withIcon(new Icon().withHref("http://maps.google.com/mapfiles/kml/paddle/ltblu-stars.png")); // set size and icon
		style.createAndSetLabelStyle().withColor("ff43b3ff").withScale(1.0); // set color and size of the continent name

		Placemark placemark = folder.createAndAddPlacemark();
		TimeStamp stamp = placemark.createAndSetTimeStamp();
		stamp.setWhen(time);
		// use the style for each continent
		placemark.withName(ID)
		.withStyleUrl("#style_" + ID)
		// 3D chart image
		.withDescription(
				"Time: <b>"+ time +"</b><br/>ID: <b>"+ ID +"</b><br/>SSID: <b>"+ ssid +"</b><br/>MAC: <b>"+ MAC +"</b><br/>Signal: <b>"+ Signal +"</b><br/>Frequency: <b>"+ Frequency +"</b>")
		// coordinates and distance (zoom level) of the viewer
		.createAndSetLookAt().withLongitude(lon).withLatitude(lat).withAltitude(0);

		placemark.createAndSetPoint().addToCoordinates(lon, lat); // set coordinates
	}

	public static void main(String[] args) throws IOException {
		final Kml kml = new Kml();
		String name = "C:\\Users\\a\\workspace\\ObjectOriented\\filterlist.csv";
		Document doc = kml.createAndSetDocument().withName("JAK Example1").withOpen(true);
		Folder folder = doc.createAndAddFolder();
		folder.withName("Wifi Networks").withOpen(true);
		
		try(BufferedReader br = new BufferedReader(new FileReader(name))){	
			br.readLine();

			while(br.readLine() != null){
				String [] s =br.readLine().split(",");
				double lat = Double.parseDouble(s[2]);
				double lon = Double.parseDouble(s[3]);
				for (int i = 6; i < s.length; i+=4) {
					if(!s[i].equals("null")){
						createPlacemarkWithChart(doc, folder, s[0] ,s[1], s[i++], s[i++],s[i++], s[i++],  lon	,lat );
					}
				}	
			}
		}
		kml.marshal(new File("C:\\Users\\a\\workspace\\ObjectOriented\\final.kml"));
	}
}



