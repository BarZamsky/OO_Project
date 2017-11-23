package matala_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
/**
 * This class write the LineFile list to a new csv file
 * @author Bar, Noy, Doriya
 *
 */
public class WriteCsv {

	public static void writeFile(List<LineFile> line, String output) {
		try {

			FileWriter fw = new FileWriter(output);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.append("Time");bw.append(',');bw.append("ID");bw.append(','); bw.append("LAT");bw.append(',');
			bw.append("LON"); bw.append(',');bw.append("ALT"); bw.append(',');bw.append("#WIFI NETWORKS");
			bw.append(',');
			for (int i = 1; i <11; i++) {
				bw.append("SSID"+i+','+"MAC"+i+','+"SIGNAL"+i+','+"FREQUENCY"+i);
				bw.append(',');
			}
			bw.write("\n");
			for(LineFile l : line){
				bw.write(l.toString().replace("[", "").replace("]", ""));
				bw.write("\n");
			}
			bw.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
	}
}
