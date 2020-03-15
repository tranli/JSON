import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SerializedNameExample {

	public static void main(String[] args) {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		final Student student = new Student("1", "Tran Li", "Java Dev");
		
		final String jsonString  = gson.toJson(student);
		System.out.println("Json: "+ jsonString);
		
		final Student student2 = gson.fromJson(jsonString, Student.class);
		System.out.println("Java object:" +student2);
		
	}
}
