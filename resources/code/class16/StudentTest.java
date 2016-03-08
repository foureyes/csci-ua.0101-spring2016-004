public class StudentTest {
	public static void main(String[] args) {
		// keywords before constructor
		// when do you need this vs use on its own (name resolution order)
		//     particularly static vs instance
		String[] firstNames = {"Alice", "Bob", "Carol", "Dan", "Eve", "Faythe"};
		String[] lastNames = {"Go", "Hernandez", "Ibrahim", "Johnson", "Kim", "Lan"};
		Student[] enrolledStudents = new Student[10];
		for(int i = 0; i < enrolledStudents.length; i++) {
			int[] scores = new int[10];
			for(int j = 0; j < 10; j++) {
				scores[j] = randInt(50, 100); 
			}
			Student s = new Student(
					firstNames[randInt(1, 6)],
					lastNames[randInt(1, 6)],
					scores);
			enrolledStudents[i] = s;
		}
		for(Student student: enrolledStudents) {
			System.out.println(student.getFullName() + 
					" - " + student.getAverageHomeworkScore());
		}
	}
	
	public static int randInt(int a, int b) {
		return (int) (Math.random() * (b - a) + a);
	}
}
