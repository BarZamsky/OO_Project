package TESTS_Records;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Test_Records_ParseFile_Alt.class, Test_Records_ParseFile_Lat.class, Test_Records_ParseFile_Lon.class,
		Test_Records_ParseFile_Model.class, Test_Records_ReadFile.class, Test_Records_toCsv.class })
public class AllTests_Records {

}
