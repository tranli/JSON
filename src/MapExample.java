import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> inputMap = new HashMap<String, String>();
		inputMap.put("name", "Tran Li");
		inputMap.put("site", "https://github.com/tranli");
		System.out.println("Input Map:" + inputMap);
		
		Gson gson = new Gson();
		 // Serialization
        String json = gson.toJson(inputMap);
        System.out.println("Json: " + json); // {"site":"https://github.com/tranli","name":"Tran Li"}
 
        // Deserialization
        Type mapType = new TypeToken<Map<String, Object>>(){}.getType();
        Map<String, String> outputMap = gson.fromJson(json, mapType);
        System.out.println("Output Map: " + outputMap);
	}
}
