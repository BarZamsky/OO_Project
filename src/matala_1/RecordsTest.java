package matala_1;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RecordsTest {

	@Test
	public void test_ReadFile() {
		File path = new File("C:/Users/Doriya Spielman/git/OO_Project");
		File[] files = path.listFiles();
		List<String[]> file = new ArrayList<String[]>();
		for (int i = 0; i < files.length; i++) {
			if(files[i].getName().endsWith("csv")&& (!files[i].isDirectory())){
				file = Records.readFile(files[i]);
			}
		}
		assertEquals(895, file.size());
	}

	@Test
	public void test_ParseFile(){
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.parseFile(path);
		assertEquals("Lenovo PB2-690Y", r.get_rec().get(1).getModel());
		assertEquals(32.16767714, r.get_rec().get(2).getLocation().getLat(),0);
		assertEquals(34.80912469, r.get_rec().get(5).getLocation().getLon(),0);
		assertEquals(30, r.get_rec().get(0).getAlt(),0);


	}
	@Test
	public void test_toCsv(){
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.toCsv(path);
		assertEquals(0, r.get_rec().size());

		
	}
}
