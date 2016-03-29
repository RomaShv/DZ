package dz4;

public class Employee {
	public String name;
	public int workAge;

	Employee(String name, int workAge) {
		this.name = name;
		this.workAge = workAge;
	}

	@Override
	public String toString() {
		return name + " : " + workAge;
	}

}
