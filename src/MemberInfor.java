import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;

public class MemberInfor {

	private int id;
	
	private String nameString;
	 
	 @Until(1.7)
	 private String yahooAccountString;
	 
	 @Since(2.3)
	 private String facebookAccountString;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameString() {
		return nameString;
	}

	public void setNameString(String nameString) {
		this.nameString = nameString;
	}

	public String getYahooAccountString() {
		return yahooAccountString;
	}

	public void setYahooAccountString(String yahooAccountString) {
		this.yahooAccountString = yahooAccountString;
	}

	public String getFacebookAccountString() {
		return facebookAccountString;
	}

	public void setFacebookAccountString(String facebookAccountString) {
		this.facebookAccountString = facebookAccountString;
	}

	
	
	
	 
	 
}
