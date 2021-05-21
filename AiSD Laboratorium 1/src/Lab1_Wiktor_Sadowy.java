import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;


// Klasa autorstwa Wiktor Sadowy
class Student
{
	private String index;
	private String lastName;
	private String firstName;
	private double grade;
	
	public Student(String index, String lastName, String firstName, double grade) 
	{
		this.index = index;
		this.lastName = lastName;
		this.firstName = firstName;
		this.grade = grade;
	}

	public String getIndex() 
	{
		return index;
	}
	
	public void setIndex(String index) 
	{
		this.index = index;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public double getGrade() 
	{
		return grade;
	}
	
	public void setGrade(double grade) 
	{
		this.grade = grade;
	}
	
	public String toString()
	{
		// Dodaje puste spacje, zeby byla odleglosc pomiedzy imieniem a ocena
		// Zmieniam tez przecinek na kropke w ocenie
		return String.format("%10s %15s %15s %10s %.1f", index, lastName, firstName, "", grade).replace(",", ".");
	}
	
	public boolean equals(Student student)
	{
		return index.equals(student.getIndex());
	}
}

class StudentsAISD
{
	private ArrayList<Student> students;
	
	public StudentsAISD()
	{
		students = readData();
	}
	
	public ArrayList<Student> readData()
	{
		ArrayList<Student> students = new ArrayList<Student>();
		BufferedReader bufferedReader = null;
		try 
		{
			bufferedReader = new BufferedReader(new FileReader(new File("Students.txt")));
			String row = bufferedReader.readLine(); // Pierwszy rzad zawiera opis kolumn
			while((row = bufferedReader.readLine()) != null)
			{
				String[] data = row.split("\\s+");
				Student student = new Student(data[0], data[1], data[2], Double.parseDouble(data[3]));
				students.add(student);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Blad podczas odczytu");
			System.exit(-1);
		}
		finally 
		{
			try 
			{
				bufferedReader.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Blad podczas zamykania pliku");
				System.exit(-1);
			}
		}
		
		return students;
	}
	
	public void displayData()
	{
		Iterator<Student> iterator = students.iterator();
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}
	
	public void changeGrade(String lastName, String firstName, double grade)
	{
		for (int i=0; i<students.size(); i++)
		{
			Student student = students.get(i);
			if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName)) {
				students.set(i, new Student(student.getIndex(), student.getLastName(), student.getFirstName(), grade));
				System.out.println("Pozytywnie zmieniono ocene");
				return;
			}
		}
		System.out.println("Brak osoby o takim imieniu i nazwisku");
	}
	
	public void displayMeanOfGradesPositiveOnly()
	{
		double sum = 0;
		int numberOfStudents = 0;
		Iterator<Student> iterator = students.iterator();
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			if (student.getGrade() >= 3.0) {
				sum += student.getGrade();
				numberOfStudents ++;
			}
		}
		System.out.println("Srednia ocen z AiSD (tylko pozytywne oceny): " + String.format("%.2f", sum/numberOfStudents));
	}
	
	public void displayAllThatFailed()
	{
		Iterator<Student> iterator = students.iterator();
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			if (student.getGrade() < 3) {
				System.out.println(student.toString());
			}
		}
	}
	
	public void saveData()
	{
		BufferedWriter bufferedWriter = null;
		try 
		{
			bufferedWriter = new BufferedWriter(new FileWriter(new File("Updated_Students.txt")));
			bufferedWriter.write(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD") + "\n");
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) 
			{
				Student student = iterator.next();
				bufferedWriter.write(student.toString() + "\n");
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Blad podczas odczytu");
			System.exit(-1);
		}
		finally 
		{
			try 
			{
				bufferedWriter.close();
			} 
			catch (IOException e) 
			{
				System.out.println("Blad podczas zamykania pliku");
				System.exit(-1);
			}
		}
	}
}


public class Lab1_Wiktor_Sadowy 
{
	public static void main(String[] args) 
	{
		StudentsAISD studentsAIDS = new StudentsAISD();
		studentsAIDS.displayData();
		System.out.println();
		studentsAIDS.changeGrade("Sito", "Agata", 3.5);
		System.out.println("");
		studentsAIDS.displayData();
		System.out.println("");
		studentsAIDS.displayMeanOfGradesPositiveOnly();
		System.out.println();
		studentsAIDS.displayAllThatFailed();
		System.out.println();
		studentsAIDS.saveData();
	}

}
