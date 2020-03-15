import java.util.List;
import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class CollectionExample2  {

	public static void main(String[] args)  {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		List<Person> personsList = new ArrayList<Person>();
		personsList.add(new Person("Tran Li", "Viet Nam"));
		personsList.add(new Person("Lan", "Ha Noi"));
		
		// Serialization
		String jsonString = gson.toJson(personsList);
		System.out.println(jsonString);
		
		// Deserialization
		Type collectionType = new TypeToken<List<Person>>(){}.getType();
        List<Person> persons2 = gson.fromJson(jsonString, collectionType);
	}
}
