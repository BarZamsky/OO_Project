package matala_1;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FileFilterTest.class, FolderTest.class, ParsingFileTest.class, readFileTest.class, readFolderTest.class,
		TimeTest.class, WriteCsvTest.class })
public class AllTests {

}
