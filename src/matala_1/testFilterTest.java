package matala_1;
import static org.junit.Assert.*;

import java.rmi.server.ExportException;

import org.junit.Test;

import matala0.testFilter;

public class testFilterTest {

	@Test
	public void test() throws ExportException {
	
		testFilter a = new testFilter("int bar=1");
		boolean output = a.test("int bar=1");
		assertTrue("int bar=1", output);
	//	assertFalse("int bar=1", output);
		
	}

}
