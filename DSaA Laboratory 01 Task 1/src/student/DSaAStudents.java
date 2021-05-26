package student;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DSaAStudents 
{
	private ArrayList<Student> students;
	
	public DSaAStudents()
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
			String row = bufferedReader.readLine(); // First row contains the names of the columns
			while((row = bufferedReader.readLine()) != null)
			{
				String[] data = row.split("\\s+");
				Student student = new Student(data[0], data[1], data[2], Double.parseDouble(data[3]));
				students.add(student);
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Error while reading a file");
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
				System.out.println("Error during while closing a file");
				System.exit(-1);
			}
		}
		
		return students;
	}
	
	public void displayData()
	{
		Iterator<Student> iterator = students.iterator();
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Index", "Last name", "First name", "", "DSaA grade"));
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
				System.out.println("Grade changed successfully");
				return;
			}
		}
		System.out.println("No person with a given first name and last name");
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
		System.out.println("Mean from grades (only positive grades): " + String.format("%.2f", sum/numberOfStudents));
	}
	
	public void displayAllThatFailed()
	{
		Iterator<Student> iterator = students.iterator();
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Index", "Last name", "First name", "", "DSaA grade"));
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
			bufferedWriter = new BufferedWriter(new FileWriter(new File("Students_updated.txt")));
			bufferedWriter.write(String.format("%10s %15s %15s %10s %10s", "Index", "Last Name", "First Name", "", "AaSD grade") + "\n");
			Iterator<Student> iterator = students.iterator();
			while (iterator.hasNext()) 
			{
				Student student = iterator.next();
				bufferedWriter.write(student.toString() + "\n");
			}
		} 
		catch (IOException e) 
		{
			System.out.println("Error while reading a file");
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
				System.out.println("Error during while closing a file");
				System.exit(-1);
			}
		}
	}
}
