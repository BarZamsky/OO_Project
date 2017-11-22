package matala_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import matala0.Exe_0;

public class ParsingFileTest {

	@Test
	public void parse_fileTest() {

		String[] files = Folder.csv_Files("C:/Users/Doriya Spielman/workspace/ObjectOriented");
		ArrayList<String[]> output = ReadFiles.readFile(files[0]);
		List<LineFile> l=ParsingFiles.parse_File(output);
		assertEquals("Size of the list should be 0",149, l.size());	
	}
	
	//
//	@Test
//	public void failtest() {
//
//		String[] files = Folder.csv_Files("C:/Users/Doriya Spielman/workspace/ObjectOriented");
//		ArrayList<String[]> output = ReadFiles.readFile(files[0]);
//		List<LineFile> l=ParsingFiles.parse_File(output);
//		//assertNotEquals("exaption!!!!!!!!!",0, l.size());
//		if(l.size() != 149)
//		fail("not goodddddd");
//	}
	
	
	@Test
	public void marge_fileTest() {

		String[] files = Folder.csv_Files("C:/Users/Doriya Spielman/workspace/ObjectOriented");
		List<LineFile> l=ParsingFiles.merge_Files(files);
		assertEquals("Size of the list should be 465",465, l.size());	
	}
	

}
