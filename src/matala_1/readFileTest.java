  package matala_1;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class readFileTest {

	@Test
	public void test() {

	String[] files = Folder.csv_Files("C:/Users/Doriya Spielman/workspace/ObjectOriented");
	for (int i = 0; i < files.length; i++) {
	
	List<String[]> output= ReadFiles.readFile(files[i]);
	
	assertEquals("Size of the list should be 0",0, output.size());
	}
	}

}
