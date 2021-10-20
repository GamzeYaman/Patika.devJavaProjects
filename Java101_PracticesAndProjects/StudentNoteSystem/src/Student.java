
public class Student {

	String studentName;
	String studentNo;
	Course course1;
	Course course2;
	Course course3;
	double average;
	
	public Student(String studentName, String studentNo, Course course1, Course course2, Course course3) {
		this.studentName = studentName;
		this.studentNo = studentNo;
		this.course1 = course1;
		this.course2 = course2;
		this.course3 = course3;
	}

	void addCourseNote(int course1Note, int course2Note, int course3Note, int consideration1Note, int consideration2Note, int consideration3Note) {
		
		if(course1Note >= 0 && course1Note <= 100) {
			if(consideration1Note >= 0 && consideration1Note <= 100) {
				course1.note = course1Note;
				course1.considerationNote = consideration1Note;
			}
		}
		if(course2Note >= 0 && course2Note <= 100) {
			if(consideration2Note >= 0 && consideration2Note <= 100) {
				course2.note = course2Note;
				course2.considerationNote = consideration2Note;
			}
			
		}
	    if(course3Note >= 0 && course3Note <= 100) {
	    	if(consideration3Note >= 0 && consideration3Note <= 100) {
	    		course3.note = course3Note;
	    		course3.considerationNote = consideration3Note;
	    	}
			
		}else {
			System.out.println("Please enter available notes!");
		}
		
	}
	
	double calculateAverage() {
		double course1Average = (course1.note * 0.80) + (course1.considerationNote * 0.20);
		double course2Average = (course2.note * 0.80) + (course2.considerationNote * 0.20);
		double course3Average = (course3.note * 0.80) + (course3.considerationNote * 0.20);
		double totalAverage = course1Average + course2Average + course3Average;
		this.average = totalAverage / 3;
		return average;
	}
	
	void isPass() {
		average = calculateAverage();
		if(average < 0 && average > 100) {
			System.out.println("Unavailable Proccess!");
		}else {
			if(average >= 85 && average <= 100) {
				System.out.println(studentName + " passed the class perfectly. The note is " + average);
			}else if(average >= 70 && average <= 84) {
				System.out.println(studentName + " passed the class goodly. The note is " + average);
			}else if(average >= 55 && average <= 69) {
				System.out.println(studentName + " passed the class averagly. The note is " + average);
			}else {
				System.out.println(studentName + " couldn^t pass the class successfully. The note is " + average);
			}
		}
	}
	
	
	void studentPrint() {
		System.out.println("Student Name : " + studentName);
		System.out.println("Student No : " + studentNo);
		System.out.println("Course 1 Name : " + course1.courseName);
		System.out.println(course1.courseName + " Note : " + course1.note);
		System.out.println("Course 2 Name : " + course2.courseName);
		System.out.println(course2.courseName + " Note : " + course2.note);
		System.out.println("Course 3 Name : " + course3.courseName);
		System.out.println(course3.courseName + " Note : " + course3.note);
		isPass();
		
	}
	
}
