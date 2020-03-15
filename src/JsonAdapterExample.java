
import java.util.Calendar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonAdapterExample {

	public static void main(String[] args) {
		final GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		
		final Gson gson = gsonBuilder.create();
		
		final ÂmzonBook book = new ÂmzonBook();
		book.setTitleString("Head First Design Patterns");
		book.setIsbn10String("0596007124");
		book.setIsbn13("978-0596007126");
		book.setPriceDouble(52.41);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2004,  Calendar.OCTOBER, 1);
		book.setPublisheDate(calendar.getTime());
		
		String[] authorStrings = new String[] { "Li","Lung", "Linh"};
		book.setAuthorStrings(authorStrings);
		
		System.out.println("Convert Book object to Json string: ");
		final String jsonString = gson.toJson(book);
		System.out.println(jsonString);
		
		System.out.println("Convert Json String to Book object: ");
		final ÂmzonBook parsedBook1 = gson.fromJson(jsonString,  ÂmzonBook.class);
		System.out.println(parsedBook1);
		
		}
}
