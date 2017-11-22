package matala_1;

import static org.junit.Assert.*;



import org.junit.Test;


public class readFolderTest {
		//ClassLoader classLoader = getClass().getClassLoader();

	@Test
	public void test() throws Exception{

		    String files = "C:/Users/Doriya Spielman/workspace/ObjectOriented";	
		    String[] result = Folder.csv_Files(files);
		    assertEquals("Size of the list should be 12",12, result.length);
		  }
		}


