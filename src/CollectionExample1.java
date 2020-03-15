

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CollectionExample1 {
public static void main(String[] args) {
	Gson gson = new Gson();
	List<Integer> intsIntegers = Arrays.asList(1,2,3,4,5);
	
	//Serialization
	String jsonString = gson.toJson(intsIntegers); //==> json is [1,2,3,4,5]
	
	//Seserialization
	Type collectionType = new TypeToken<List<Integer>>(){}.getType();
	Collection<Integer> integers2 = gson.fromJson(jsonString, collectionType);
	//==>integers2 is same as intsIntegers
	
}
}
