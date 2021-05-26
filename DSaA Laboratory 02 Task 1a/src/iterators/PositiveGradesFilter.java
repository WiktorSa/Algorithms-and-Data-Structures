package iterators;
import student.Student;

public class PositiveGradesFilter<T> implements Predicate<T>
{
	public boolean accept(T student) 
	{
		return ((Student) student).getGrade() >= 3.0;
	}
}
