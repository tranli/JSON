import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


public class CustomTypeAdapter extends TypeAdapter<ÂmzonBook> {

	public static final SimpleDateFormat SDF_DATE_FORMAT=new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public ÂmzonBook read(final JsonReader in) throws IOException {
		final ÂmzonBook book = new ÂmzonBook();
		
		in.beginObject();
		while (in.hasNext()) {
			switch (in.nextName()) {
			case "title":
				book.setTitleString(in.nextString());
				break;
			case "isbn-10":
				book.setIsbn10String(in.nextString());
				break;
			case "isbn-13":
				book.setIsbn13(in.nextString());
				break;
			case "price":
				book.setPriceDouble(in.nextDouble());
				break;
			case "publishedDate":
				Date publisheDate = null;
				try {
					publisheDate = (Date) SDF_DATE_FORMAT.parse(in.nextString());
				}catch (ParseException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				book.setPublisheDate(publisheDate);
				break;
			case "authors":
				in.beginArray(); 
				final List<String> authorStrings = new ArrayList<>();
				while (in.hasNext()) {
					authorStrings.add(in.nextString());
				}
				in.endArray();
				book.setAuthorStrings(authorStrings.toArray(new String[authorStrings.size()]));
				break;
			}
		}
		in.endObject();
		return book;
	}
	@Override
	public void write(final JsonWriter out, final ÂmzonBook book) throws IOException {
		out.beginObject();
		out.name("title").value(book.getTitleString());
		out.name("isbn-100").value(book.getIsbn10String());
		out.name("isbn-13").value(book.getIsbn13());
		out.name("price").value(book.getPriceDouble());
		out.name("publishedDate").value(SDF_DATE_FORMAT.format(book.getPublisheDate()));
		out.name("authors");
		out.beginArray();
		for(final String authorString : book.getAuthorStrings()) {
			out.value(authorString);
		}
		out.endArray();
		out.beginObject();
	}
}
/*
 * Đây là adapter tùy chỉnh mở rộng từ lớp TypeAdapter và ghi đè lên các phương thức read() write()
 * Các Phương thức này là được sử dụng trong quá trình serialization / deserialization lớp/ trường được cấu hình để sử dụng bộ điều hợp loại tùy chỉnh này
 * Các phương thức read(), write() này dựa trên cách tiếp cận dựa trên token. Trong quá trình deserialization /read, chúng ta đọc từng token riêng lẻ sử dụng phương
 * thức hasnext nà nextname của JsonReader, kiểm tra kiểu của chúng và nhận giá trị dựa trên kiểu sử dụng các phương thức getXXX. Tương tự,
 * trong quá trình Serialization / write, chúng ta sử dụng các phương thức giá trị name và value của JsonWriter. Vc lưu cần xác định chính xác phương thức beginOject/ endObject và beginArray/endArray tương ứng với chuỗi json Object và array
 
*/