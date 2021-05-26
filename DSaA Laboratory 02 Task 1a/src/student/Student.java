package student;

public class Student
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
		return String.format("%10s %15s %15s %10s %.1f", index, lastName, firstName, "", grade).replace(",", ".");
	}
	
	public boolean equals(Student student)
	{
		return index.equals(student.getIndex());
	}
}
