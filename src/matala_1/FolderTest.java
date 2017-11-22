package matala_1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class FolderTest {

	@Test
	public void isExistTest() {
		String Path = "C:/Users/Doriya Spielman/workspace/ObjectOriented";
		boolean exist=Folder.is_Exist(Path);
		assertTrue("is the file exist?", exist);
	} 

	    
	@Test   
	public void csv_FilesTest() {
		String path = "C:/Users/Doriya Spielman/workspace/ObjectOriented";
		String[] ifCsv=Folder.csv_Files(path);
		assertEquals("how many csv files",2, ifCsv.length);
	}
	   
	@Test
	public void fail_csv_FilesTest() {
		String path = "C:/Users/Doriya Spielman/workspace/ObjectOriented";
		String[] ifCsv=Folder.csv_Files(path);
	
		assertNotEquals("how many csv files",7, ifCsv.length);
	System.out.println("ERROR: wrong capacity of csv files ");	
	}
}
