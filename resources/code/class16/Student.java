
public class Student {
	public String firstName;
	public String lastName;
	public int[] homeworkScores;
	
	public Student(String first, String last, int[] scores) {
		this.firstName = first;
		this.lastName = last;
		this.homeworkScores = scores;
	}
	
	public String getFullName() {
		return firstName + " " + lastName;
	}
	
	public String toString() {
		return getFullName() + " " + getAverageHomeworkScore();
	}
	
	public float getAverageHomeworkScore() {
		int total = 0;
		for(int score: homeworkScores) {
			total += score;
		}
		return total / homeworkScores.length;
	}
}
