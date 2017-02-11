package nebulous.collegeApp;

public class FamilyMember{

	private String firstName;
	private String middleName;
	private String lastName;
	
	private Gender gender;
	
	private int age;
	private int grade;
	
	public FamilyMember(String first, String middle, String last, Gender gender, int age, int grade){
		this.firstName = first;
		this.middleName = middle;
		this.lastName = last;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public int getGrade() {
		return grade;
	}

	public Gender getGender() {
		return gender;
	}
	
}
