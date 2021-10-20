
public class Main {

	public static void main(String[] args) {
		
		Teacher teacher1 = new Teacher("Namjoon Kim" , "Math" , "111" );
		Teacher teacher2 = new Teacher("Jisoo Kim" , "Ch" , "222");
		Teacher teacher3 = new Teacher("Jungkook Jeon" , "Sp" , "333");
		
		Course math = new Course("Mathematic" , "Math" , "101");
		Course chemistry = new Course("Chemistry" , "Ch" , "201");
		Course spanish = new Course("Spanish" , "Sp" , "101");
		math.addTeacher(teacher1);
		chemistry.addTeacher(teacher2);
		spanish.addTeacher(teacher3);
		//math.printCourse();
		//chemistry.printCourse();
		//spanish.printCourse();
		
		Student student1 = new Student("Lia Brown", "123654" , math , chemistry , spanish);
		student1.addCourseNote(100, 70, 65, 80 , 80 , 80);
		student1.studentPrint();
	}
}
