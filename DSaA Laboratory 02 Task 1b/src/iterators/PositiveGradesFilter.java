package iterators;

import student.Student;

public class PositiveGradesFilter<T> implements Predicate<T>
{
	public boolean accept(T arg) 
	{
		return ((Student) arg).getGrade() >= 3.0;
	}
}
