import com.google.gson.Gson;

public class PrimitiveExample {
	public static void main(String[] args) {
		//Serialization
		Gson gson = new Gson();
		gson.toJson(1); //==>1
		gson.toJson("abcd"); // ==>"abcd"
		gson.toJson(new Long(10)); //==>10
		int[] values = {1};
		gson.toJson(values); //==>[1]
		
		//Deserialization
		int one = gson.fromJson("1", int.class); //==>1
		Integer oneInteger = gson.fromJson("1", Integer.class); //==>1
		Long oneLong = gson.fromJson("1", Long.class);
		Boolean boolean1 = gson.fromJson("false", Boolean.class); //==>false
		String str = gson.fromJson("\"abc\"", String.class);
		String[] anotherStrings = gson.fromJson("[\"abc\"]", String[].class); //==>["abc"]
	}
}
/*
 * toJson() : phương thức dùng để chuyển Java Object sang chuỗi Json (quá trình này được gọi là Serialization). Phương thức này có 1 đối số là đối tượng cần chuyển sang chuỗi Json.*/
/*
 * fromJson() : phương thức dùng để chuyển chuỗi Json sang Java Object (quá trình này được gọi là Deserialization). Phương thức này có 2 đối số, đối số đầu tiên là chuỗi json, đối số thứ hai là kiểu dữ liệu Java Object ứng với chuỗi json.
 */
