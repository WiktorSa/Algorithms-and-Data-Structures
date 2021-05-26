package main;
import student.DSaAStudents;
import student.Student;

public class Main21a
{
	public static void main(String[] args) 
	{
		Student[] students = new Student[5];
		students[0] = new Student("123456789", "Sito", "Agata", 5.0);
		students[1] = new Student("453678234", "Strozik", "Filip", 4.5);
		students[2] = new Student("678665647", "Razny", "Patryk", 2.0);
		students[3] = new Student("124352536 ", "Swiat", "Patryk", 3.0);
		students[4] = new Student("352346264", "Skibinski", "Jan", 2.0);
		
		DSaAStudents aaDSStudents = new DSaAStudents(students);
		aaDSStudents.displayData();
		System.out.println("");
		aaDSStudents.changeGrade("123456789", 3.5);
		System.out.println("");
		aaDSStudents.displayData();
		System.out.println("");
		aaDSStudents.displayMeanOfGradesPositiveOnly();
		System.out.println("");
		aaDSStudents.displayAllThatFailed();
		System.out.println("");
		aaDSStudents.copyPositiveAndNegativeGrades();
	}

}
