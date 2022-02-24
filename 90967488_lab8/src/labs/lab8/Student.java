package labs.lab8;

/**
 * A student with a name and a major.
 */
public class Student extends Person {
	private String major;

	public Student(String aName, String aMajor) {
		super(aName);
		major = aMajor;
	}

	public String toString() {
		return super.toString() + "[major=" + major + "]";
	}
}
