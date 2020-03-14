import com.google.gson.Gson;

class Person {

	private String nameString;
	private String locationString;
	
	public Person(String nameString, String locationString) {
		super();
		this.nameString = nameString;
		this.locationString = locationString;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Person [name="+nameString + ", location =" +locationString+ "]";
	}
	
	//Getters and setters are not required for this example.
	//Gson sets the fields directly using reflection.
}

public class  ObjectExample {
	public static void main(String[] args) {
		Person person = new Person("Tran Li", "Viet Nam");
		Gson gson = new Gson();
		//Serialization
		String jsonString = gson.toJson(person);
		System.out.println(jsonString); //{"name":"Tran Li", "location": "Viet Nam"}
		
		//Deserialization
		Person person2 = gson.fromJson(jsonString, Person.class);
		System.out.println(person2);
	}

}
