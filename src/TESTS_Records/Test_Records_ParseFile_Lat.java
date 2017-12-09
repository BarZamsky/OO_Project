package TESTS_Records;

import static org.junit.Assert.*;
import org.junit.Test;

import matala_1.Records;

public class Test_Records_ParseFile_Lat {

	@Test
	public void test() {
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.parseFile(path);
		assertEquals(32.16767714, r.get_rec().get(2).getLocation().getLat(),0);
	}

}
