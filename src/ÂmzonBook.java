import java.util.Arrays;
import java.util.Date;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(value = CustomTypeAdapter.class)
public class ÂmzonBook {

	private String titleString;
	private String[] authorStrings;
	private String isbn10String;
	private String isbn13;
	private Double priceDouble;
	private Date publisheDate;
	public String getTitleString() {
		return titleString;
	}
	public void setTitleString(String titleString) {
		this.titleString = titleString;
	}
	public String[] getAuthorStrings() {
		return authorStrings;
	}
	public void setAuthorStrings(String[] authorStrings) {
		this.authorStrings = authorStrings;
	}
	public String getIsbn10String() {
		return isbn10String;
	}
	public void setIsbn10String(String isbn10String) {
		this.isbn10String = isbn10String;
	}
	public String getIsbn13() {
		return isbn13;
	}
	public void setIsbn13(String isbn13) {
		this.isbn13 = isbn13;
	}
	public Double getPriceDouble() {
		return priceDouble;
	}
	public void setPriceDouble(Double priceDouble) {
		this.priceDouble = priceDouble;
	}
	public Date getPublisheDate() {
		return publisheDate;
	}
	public void setPublisheDate(Date publisheDate) {
		this.publisheDate = publisheDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "Book [title ="+ titleString + ", authors=" + Arrays.toString(authorStrings) + ", isbn10=" + isbn10String + ", isbn13="
        + isbn13 + ", price=" + priceDouble + ", publishedDate=" + publisheDate + "]";

	}
}
