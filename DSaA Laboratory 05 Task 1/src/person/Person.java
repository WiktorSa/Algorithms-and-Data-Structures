package person;
public class Person implements Comparable<Person>
{
	private String lastName;
	private String firstName;
	private int yearOfBirth;
	
	public Person(String lastName, String firstName, int yearOfBirth) 
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.yearOfBirth = yearOfBirth;
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

	public int getYearOfBirth() 
	{
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) 
	{
		this.yearOfBirth = yearOfBirth;
	}

	public String toString() 
	{
		return String.format("%-20s %-20s %4d", lastName, firstName, yearOfBirth);
	}

	@Override
	public int compareTo(Person person) 
	{
		int result = lastName.compareTo(person.getLastName());
		if (result == 0) {
			result = firstName.compareTo(person.getFirstName());
			if (result == 0) {
				result = yearOfBirth - person.getYearOfBirth();
			}
		}
		// TODO Auto-generated method stub
		return result;
	}
}
