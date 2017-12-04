package matala_1;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class RecordsTest {

	@Test
	public void test_ReadFile() {
		File path = new File("C:\\Users\\a\\git\\OO_Project\\ObjectOriented");
		File[] files = path.listFiles();
		List<String[]> file = new ArrayList<String[]>();
		for (int i = 0; i < files.length; i++) {
			if(files[i].getName().endsWith("csv")&& (!files[i].isDirectory())){
				file = Records.readFile(files[i]);
			}
		}
		assertEquals(295, file.size());
	}

	@Test
	public void test_ParseFile(){
		Records r = new Records();
		String path = "C:\\Users\\a\\git\\OO_Project\\ObjectOriented";
		r.parseFile(path);
		assertEquals("ONEPLUS A3003", r.get_rec().get(1).getModel());
		assertEquals(32.16874461, r.get_rec().get(4).getLocation().getLat(),0);
	}
}
