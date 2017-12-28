package Filters;

import Project.LineFile;

public class And_Filter implements filter {
	private filter _f1, _f2;
	public And_Filter(filter f1, filter f2) {
		_f1 = f1;
		_f2 = f2;
	}
	@Override
	public boolean test(LineFile line) {
		return _f1.test(line) && _f2.test(line);
	}

}