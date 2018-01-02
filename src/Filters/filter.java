package Filters;


import java.io.Serializable;

import Project.LineFile;

public interface filter extends Serializable {
	boolean test(LineFile line);
}

