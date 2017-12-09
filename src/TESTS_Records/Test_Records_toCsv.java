package TESTS_Records;

import static org.junit.Assert.*;
import org.junit.Test;
import matala_1.Records;

public class Test_Records_toCsv {

	@Test
	public void test() {
		Records r = new Records();
		String path = "C:/Users/Doriya Spielman/git/OO_Project";
		r.toCsv(path);
		assertEquals(0, r.get_rec().size());
	}

}
