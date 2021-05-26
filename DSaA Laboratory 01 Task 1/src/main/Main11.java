package main;
import student.DSaAStudents;

public class Main11 
{
	public static void main(String[] args) 
	{
		DSaAStudents students = new DSaAStudents();
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
