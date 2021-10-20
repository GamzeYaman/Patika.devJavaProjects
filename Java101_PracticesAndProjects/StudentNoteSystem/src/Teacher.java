
public class Teacher {

	String name;
	String branch;
	String mpno;
	
	
	public Teacher(String name, String branch, String mpno) {
		this.name = name;
		this.branch = branch;
		this.mpno = mpno;
	}
	
	void print() {
		System.out.println("Teacher Name : " + name);
		System.out.println("Teacher Branch : " + branch);
		System.out.println("Teacher Mpno : " + mpno);
	}
	
	
}
