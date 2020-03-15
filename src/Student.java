import com.google.gson.annotations.SerializedName;

public class Student {

	@SerializedName("id")
	private String studentIdString;
	
	@SerializedName("name")
	private String studentNameString;
	
	@SerializedName("clazz")
	private String clazzIdString;
	
	public Student() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Student(String studentIdString, String studentNameString, String clazzIdString) {
		super();
		this.studentIdString = studentIdString;
		this.studentNameString = studentNameString;
		this.clazzIdString = clazzIdString;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Student [studentId =" +studentIdString+ ", studentName=" +studentNameString+ ", clazzId="+ clazzIdString + "]";
	}
}
