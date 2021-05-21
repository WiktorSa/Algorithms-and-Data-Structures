import java.util.Iterator;
import java.util.NoSuchElementException;

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

interface Predicate<T>
{
	boolean accept (T arg);
}

class PositiveGradesFilter<T> implements Predicate<T>
{
	public boolean accept(T student) 
	{
		return ((Student) student).getGrade() >= 3.0;
	}
}

class StudentsIterator<T> implements Iterator<T>
{
	private T[] array;
	private int pos = 0;
	
	public StudentsIterator(T[] array)
	{
		this.array = array;
	}
	
	public boolean hasNext()
	{
		return pos < array.length;
	}
	
	public T next() throws NoSuchElementException
	{
		if (hasNext()) {
			return array[pos++];
		}
		
		else {
			throw new NoSuchElementException();
		}
	}

}

class FilterIterator<T>
{
	private StudentsIterator<T> iterator;
	private Predicate<T> predicate;
	
	private T elemNext = null;
	private boolean bHasNext = true;
	
	public FilterIterator(StudentsIterator<T> iterator, Predicate<T> predicate) 
	{
		this.iterator = iterator;
		this.predicate = predicate;
		findNextValid();
	}
	
	private void findNextValid()
	{
		while (iterator.hasNext()) 
		{
			elemNext = iterator.next();
			if (predicate.accept(elemNext)) {
				return;
			}
		}
		bHasNext = false;
		elemNext = null;
	}
	
	public boolean hasNext()
	{
		return bHasNext;
	}
	
	public T next()
	{
		T nextValue = elemNext;
		findNextValid();
		return nextValue;
	}
}
class StudentsAISD
{
	private Student[] students;
	
	public StudentsAISD(Student[] students)
	{
		this.students = students;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayData()
	{
		StudentsIterator<Student> iterator = new StudentsIterator(students);
		
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (iterator.hasNext()) 
		{
			Student student = iterator.next();
			System.out.println(student.toString());
		}
	}
	
	public void changeGrade(String lastName, String firstName, double grade)
	{
		for (int i=0; i<students.length; i++)
		{
			Student student = students[i];
			if (student.getLastName().equals(lastName) && student.getFirstName().equals(firstName)) {
				student.setGrade(grade);
				students[i] = student;
				System.out.println("Pozytywnie zmieniono ocene");
				return;
			}
		}
		System.out.println("Brak osoby o takim imieniu i nazwisku");
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		
		System.out.println("Studenci z pozytywnymi ocenami");
		StudentsIterator<Student> studentsIterator = new StudentsIterator(positiveGradeStudents);
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (studentsIterator.hasNext()) 
		{
			Student student = studentsIterator.next();
			System.out.println(student.toString());
		}
		
		System.out.println("\nStudenci z negatywnymi ocenami");
		studentsIterator = new StudentsIterator(negativeGradeStudents);
		System.out.println(String.format("%10s %15s %15s %10s %10s", "Indeks", "Nazwisko", "Imie", "", "Ocena z AiSD"));
		while (studentsIterator.hasNext()) 
		{
			Student student = studentsIterator.next();
			System.out.println(student.toString());
		}
	}
}


public class Lab1a
{

	public static void main(String[] args) 
	{
		Student[] students = new Student[5];
		students[0] = new Student("123456789", "Sito", "Agata", 5.0);
		students[1] = new Student("453678234", "Strozik", "Filip", 4.5);
		students[2] = new Student("678665647", "Razny", "Patryk", 2.0);
		students[3] = new Student("124352536 ", "Swiat", "Patryk", 3.0);
		students[4] = new Student("352346264", "Skibinski", "Jan", 2.0);
		
		StudentsAISD studentsAIDS = new StudentsAISD(students);
		studentsAIDS.displayData();
		System.out.println("");
		studentsAIDS.changeGrade("Sito", "Agata", 3.5);
		System.out.println("");
		studentsAIDS.displayData();
		System.out.println("");
		studentsAIDS.displayMeanOfGradesPositiveOnly();
		System.out.println("");
		studentsAIDS.displayAllThatFailed();
		System.out.println("");
		studentsAIDS.copyPositiveAndNegativeGrades();
	}

}
