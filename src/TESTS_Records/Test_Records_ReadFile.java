package TESTS_Records;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import matala_1.Records;

public class Test_Records_ReadFile {

	@Test
	public void test() {
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

}
