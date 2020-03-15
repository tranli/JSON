import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import com.google.gson.stream.JsonWriter;

public class GsonStreamingWriterExample {

	public static void main(String[] args) throws IOException {
		OutputStream outputStream = new FileOutputStream("result.json");
		JsonWriter writter = new JsonWriter(new OutputStreamWriter(outputStream, "UTF-8"));
		
		writter.beginObject();
		writter.name("name").value("Tran Li"); //"name" :"Tran Li"
		writter.name("website").value("https://github.com/tranli");
		writter.name("year").value(2020); //"year" :2017
		
		writter.name("pots"); //"color" :
		writter.beginArray(); //[
		writter.value("Java Core"); //"Java Core"
		writter.value("Design Pattern"); //"Design Pattern
		writter.value("Spring"); //Spring
		writter.endArray();
		
		writter.endObject(); //}
		writter.close();
		System.out.println("Done!");
	}
}
/*Sử dụng phương thức beginObject() và endObject() trong lớp JsonWriter để biểu diễn cho các phần tử kiểu object {}.
Sử dụng phương thức beginArray() và endArray() trong lớp JsonWriter để biểu diễn cho các phần tử kiểu array [].
Sử dụng phương thức name(key) và value(value) để gán các giá trị cho key và value của chuỗi json.
*/
