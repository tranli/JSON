package Jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

public class JacksonStreamingWriterExample {

	public static void main(String[] args) throws IOException {
		File file = new File("result1.json");
		
		JsonFactory factory = new JsonFactory();
		/*
		 * Write values in Json format to a file*/
		JsonGenerator  generator = factory.createGenerator(file, JsonEncoding.UTF8 );
		generator.writeStartObject();//{
		generator.writeStringField("name", "Tran Li");//"name" : "Tran Li"
		generator.writeStringField("website", "https://github.com/tranli");//"website" : "https://github.com/tranli"
		generator.writeNumberField("year", 2017); //"year" :2017
		
		generator.writeFieldName("posts"); //"colors":
		generator.writeStartArray();//[
		generator.writeString("Java Core"); //Java Core
		generator.writeString("Design Pattern"); //"Design pattern"
		generator.writeString("Spring"); //"Spring"
		
		generator.writeEndArray();
		
		generator.writeEndObject();
		generator.close();
		System.out.println("Done!");
		
	}
}
/*
 * JsonGenerator: Luồng ghi sang chỗi Json
 * JsonParser: Json sử dụng JsonParser 
 * Sử dụng phương thức writeStartObject() và witeEndobject trong lớp JsonGenerator để biểu diễn cho các phần tử kiểu object{}
 * Sử dụng phương thức writeStartArray() và writeEndArray() trong lớp JsonGenerator để biểu diễn cho các phần tử kiểu Array[]
 * Sử dụng phương thức writeStringfield, writeNumberfield(key, value) để gán các giá trị cho key và value của chuỗi json */
