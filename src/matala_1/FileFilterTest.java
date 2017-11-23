package matala_1;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class FileFilterTest {

	@Test
	public void filterTest() {
		
		String[] files = Folder.csv_Files("C:/Users/Doriya Spielman/git/OO_Project");
		List<LineFile> l=ParsingFiles.merge_File(files);
		filter f = list->list.getLocation().getPoints().getAlt()>=650;
		List<LineFile> filterList = FileFilter.filter(l,f);
		assertEquals("is the size after filtering ok?", 43, filterList.size());
	}

}
