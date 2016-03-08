import java.util.Arrays;


public class StudentArray {
	public static void main(String[] args) {
		// keywords before constructor
		// when do you need this vs use on its own (name resolution order)
		//     particularly static vs instance
		String[] firstNames = {"Alice", "Bob", "Carol", "Dan", "Eve", "Faythe"};
		String[] lastNames = {"Go", "Hernandez", "Ibrahim", "Johnson", "Kim", "Lan"};
		/*
		String[][] enrolledStudents = new String[10][2];
		int[][] studentScores = new int[10][10];
		
		for(int i = 0; i < enrolledStudents.length; i++) {
			enrolledStudents[i][0] = firstNames[randInt(1, 6)];
			enrolledStudents[i][1] = lastNames[randInt(1, 6)];
			studentScores[i] = new int[10];
			for(int j = 0; j < 10; j++) {
				studentScores[i][j] = randInt(50, 100); 
			}
		}
		*/
		String[][] enrolledStudents = {
			{"Eve", "Lan"},
			{"Faythe", "Ibrahim"},
			{"Faythe", "Kim"},
			{"Eve", "Kim"},
			{"Dan", "Johnson"},
			{"Dan", "Kim"},
			{"Eve", "Ibrahim"},
			{"Carol", "Johnson"},
			{"Carol", "Johnson"},
			{"Carol", "Hernandez"}
		};
		int[][] studentScores = {
			{91, 56, 51, 62, 75, 91, 97, 66, 51, 67},
			{77, 59, 97, 59, 86, 98, 91, 69, 89, 96},
			{76, 89, 96, 57, 64, 55, 88, 92, 91, 92},
			{94, 64, 51, 51, 73, 98, 71, 96, 66, 67},
			{97, 94, 54, 99, 89, 59, 75, 60, 72, 52},
			{89, 87, 55, 82, 59, 65, 51, 98, 83, 75},
			{63, 91, 93, 57, 54, 64, 87, 59, 87, 66},
			{70, 55, 57, 67, 76, 58, 84, 80, 81, 65},
			{77, 57, 51, 72, 81, 54, 72, 68, 58, 96},
			{72, 81, 71, 69, 90, 61, 60, 51, 57, 93},
		};
		
		for(int i = 0; i < enrolledStudents.length; i++) {
			System.out.print(enrolledStudents[i][0] + " " + 
					enrolledStudents[i][1]  + " - ");
			int total = 0;
			for(int j = 0; j < studentScores[i].length; j++) {
				 total += studentScores[i][j];
			}
			System.out.println((float)total / studentScores[i].length);
		}
		/*
		System.out.println("{");
		for(int i = 0; i < enrolledStudents.length; i++) {
			System.out.println(Arrays.toString(enrolledStudents[i]) + ",");
		}
		System.out.println("}");
		
		
		System.out.println("{");
		for(int j = 0; j < studentScores.length; j++) {
			System.out.println(Arrays.toString(studentScores[j]) + ",");
		}
		System.out.println("}");
		// System.out.println((float)total / studentScores[i].length);
		*/
	}
	public static int randInt(int a, int b) {
		return (int) (Math.random() * (b - a) + a);
	}
	
}
