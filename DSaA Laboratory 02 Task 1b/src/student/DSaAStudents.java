package student;

import iterators.FilterIterator;
import iterators.PositiveGradesFilter;
import iterators.Predicate;
import iterators.StudentsIterator;

public class DSaAStudents 
{
	private Student[] students;
	
	public DSaAStudents(Student[] students)
	{
		this.students = students;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayData()
	{
		StudentsIterator<Student> iterator = new StudentsIterator(students);
		
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Index", "Last name", "First name", "", "DSaA grade"));
		while (!iterator.isDone()) 
		{
			iterator.next();
			Student student = iterator.currentItem();
			System.out.println(student.toString());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void changeGrade(String index, double grade)
	{
		FilterIterator<Student> filterIterator = new FilterIterator(new StudentsIterator(students), (student) -> ((Student) student).getIndex().equals(index));
		while (filterIterator.hasNext()) 
		{
			Student student = filterIterator.next();
			student.setGrade(grade);
			System.out.println("Grade changed successfully");
			return;
		}
		
		System.out.println("Person with a given index was not found");
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayMeanOfGradesPositiveOnly()
	{
		double sum = 0;
		int numberOfStudents = 0;
		FilterIterator<Student> iterator = new FilterIterator(new StudentsIterator(students), new PositiveGradesFilter());
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			sum += student.getGrade();
			numberOfStudents ++ ;
		}
		System.out.println("Srednia ocen z AiSD (tylko pozytywne oceny): " + String.format("%.2f", sum/numberOfStudents));
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayAllThatFailed()
	{
		FilterIterator<Student> iterator = new FilterIterator(new StudentsIterator(students), new Predicate() {

			@Override
			public boolean accept(Object student) 
			{
				return ((Student) student).getGrade() < 3.0;
			}
			
		});
		
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void copyPositiveAndNegativeGrades()
	{
		int sizePositiveGrades = 0;
		int sizeNegativeGrades = 0;
		
		FilterIterator<Student> iterator = new FilterIterator(new StudentsIterator(students), (student) -> ((Student) student).getGrade() >= 3.0);
		while (iterator.hasNext()) 
		{
			sizePositiveGrades++;
			iterator.next();
		}
		sizeNegativeGrades = students.length - sizePositiveGrades;
		
		Student[] positiveGradeStudents = new Student[sizePositiveGrades];
		Student[] negativeGradeStudents = new Student[sizeNegativeGrades];
		
		int pos = 0;
		iterator = new FilterIterator(new StudentsIterator(students), (student) -> ((Student) student).getGrade() >= 3.0);
		while(iterator.hasNext())
		{
			positiveGradeStudents[pos++] = iterator.next();
		}
		
		pos = 0;
		iterator = new FilterIterator(new StudentsIterator(students), (student) -> ((Student) student).getGrade() < 3.0);
		while(iterator.hasNext())
		{
			negativeGradeStudents[pos++] = iterator.next();
		}
		
		System.out.println("Students with positive grades");
		StudentsIterator<Student> studentsIterator = new StudentsIterator(positiveGradeStudents);
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Index", "Last name", "First name", "", "DSaA grade"));
		while (!studentsIterator.isDone()) 
		{
			studentsIterator.next();
			Student student = studentsIterator.currentItem();
			System.out.println(student.toString());
		}
		
		System.out.println("\nStudents with negative grades");
		studentsIterator = new StudentsIterator(negativeGradeStudents);
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Index", "Last name", "First name", "", "DSaA grade"));
		while (!studentsIterator.isDone()) 
		{
			studentsIterator.next();
			Student student = studentsIterator.currentItem();
			System.out.println(student.toString());
		}
	}
}
