package matala_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class filterConTest {

	@Test
	public void test() {
		
		List<String[]> a = writeToKml.readFile("C:/Users/Doriya Spielman/workspace/ObjectOriented/firstFile.csv");
		testFilter f1 = new testFilter("model=ONEPLUS A3003");
		ArrayList<String[]> s = writeToKml.filterCon(a, f1);
		assertEquals("Size of the list should be 138",138, s.size());
	}

}
