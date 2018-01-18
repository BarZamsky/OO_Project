package Filters;

/**
 * This class represents the interface filter for filtering the LineFile
 */
import java.io.Serializable;

import Project.LineFile;

public interface filter extends Serializable {
	boolean test(LineFile line);
}

