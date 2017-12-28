package Filters;

import Project.LineFile;

public class Not_Filter implements filter{
	private filter _filter;
	public Not_Filter(filter f) {
		_filter = f;
	}
	
	@Override
	public boolean test(LineFile line) {
		return !(_filter.test(line));
	}

}
