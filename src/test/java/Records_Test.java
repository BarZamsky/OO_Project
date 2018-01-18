

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import Project.Records;
/**
 * This class test the Records class
 * @author Bar,Noy,Doriya
 *
 */
public class Records_Test extends Records{
	Records r = new Records();
	private List<String[]> _file;
	String path = "C:/Users/Doriya Spielman/git/OO_Project";

	@Test
	public void test_ParseFile_Alt() {
		r.parseFile(path);
		assertEquals(30, r.get_rec().get(0).getAlt(),0);
	}
	@Test
	public void test_ParseFile_Lat() {
		r.parseFile(path);
		assertEquals(32.16767714, r.get_rec().get(2).getLocation().getLat(),0);
	}
	@Test
	public void test_ParseFile_Lon() {
		r.parseFile(path);
		assertEquals(34.80912469, r.get_rec().get(5).getLocation().getLon(),0);
	}
	@Test
	public void test_ParseFile_Model() {
		r.parseFile(path);
		assertEquals("Lenovo PB2-690Y", r.get_rec().get(1).getModel());
	}
	@Test
	public void test_ReadFile() {
		try{
			File f = new File(path);
			File[] files = f.listFiles();

			for (int i = 0; i < files.length; i++) {
				if(files[i].getName().endsWith("csv")&& (!files[i].isDirectory())){
					readFile(files[i].getName());
				}	
			}
		}
		catch(Exception ex) {
			System.out.print("Error parsing file\n" + ex);
			System.exit(2);
		}
		assertEquals(895, _file.size());
	}
	@Test
	public void test_toCsv() {
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.toCsv(path);
		assertEquals(0, r.get_rec().size());
	}
}
