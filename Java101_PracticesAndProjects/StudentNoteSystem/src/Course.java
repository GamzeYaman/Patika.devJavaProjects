
public class Course {

	String courseName;
	String courseCode;
	Teacher teacher;
	int note;
	String prefix;
	int considerationNote;
	
	public Course(String courseName, String prefix, String courseCode){
		this.courseName = courseName;
		this.prefix = prefix;
		this.courseCode = courseCode;
		int note = 0;
		int considerationNote = 0;
	}
	
	void addTeacher(Teacher teacher) {
		if(teacher.branch.equals(this.prefix)) {
		     this.teacher = teacher;
		}else {
			System.out.println("Teacher and course didn't match.");
		}
	}
	
	void printCourse() {
		System.out.println("Course Name : " + courseName);
		System.out.println("CourseCode : " + prefix + courseCode);
		System.out.println("Course Note : " + note);
		this.teacher.print();
	}
}
