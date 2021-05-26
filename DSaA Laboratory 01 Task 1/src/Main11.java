
public class Main11 
{
	public static void main(String[] args) 
	{
		AaDSStudents students = new AaDSStudents();
		students.displayData();
		System.out.println();
		students.changeGrade("Sito", "Agata", 3.5);
		System.out.println("");
		students.displayData();
		System.out.println("");
		students.displayMeanOfGradesPositiveOnly();
		System.out.println();
		students.displayAllThatFailed();
		System.out.println();
		students.saveData();
	}
}
