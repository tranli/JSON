package Jackson;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

public class JacksonStreamingReaderExample {

	public static void main(String[] args) throws JsonParseException, IOException {
		File file = new File("result1.json");
		JsonFactory factory = new JsonFactory();
		
		/*
		 * Read values in json format
		 * */
		JsonParser parser  = factory.createParser(file);
		parser.nextToken();//start reading the file
		
		while (parser.nextToken() != JsonToken.END_OBJECT) { // loop until "}"
			
			String nameString = parser.getCurrentName();
			if(nameString.equals("name")) {
				parser.nextToken();
				System.out.println(parser.getText());
			} else if (nameString.equals("website")) {
				parser.nextToken();
				System.out.println(parser.getText());
			} else if (nameString.equals("year")) {
				parser.nextToken();
				System.out.println(parser.getIntValue());
			} else if (nameString.equals("posts")) {
				parser.nextToken();
				//it 's an array
				while (parser.nextToken() !=JsonToken.END_ARRAY) { //loop until "]"
					System.out.println(parser.getText());
				}
			} else {
				//unexpected value, skip it or generate error
			}
		}
		parser.close();
	}
}
/*
 * Trong chế độ streaming, ọi dữ liệu Json được xem như là một token độc lập. khi sử dugj JsonParser để xử lý nó, mỗi token sẽ được xử lý tuần tự
 * Trong lớp JsonReader, chúng ta sử dụng các phương thức:
 * nextToken(): để lấy thông tin token kế tiếp
 * getCurrentName(): lấy tên của thuộc tính (key)
 * getText(), getIntValue(), getBooleanValue(),... trả về giá trị chuỗi của token kế tiếp theo. Tùy thuộc vào kiểu dữ liệu, phương thức sẽ trả về tương ứng.
 * */
