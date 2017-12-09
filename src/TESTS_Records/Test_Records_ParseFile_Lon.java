package TESTS_Records;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Records;

public class Test_Records_ParseFile_Lon {


	@Test
	public void test() {
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.parseFile(path);
		assertEquals(34.80912469, r.get_rec().get(5).getLocation().getLon(),0);
	}

}
