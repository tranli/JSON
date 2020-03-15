import com.google.gson.annotations.Expose;

public class Account {

	@Expose (deserialize = false)
	private String accountNumberString;
	
	@Expose
	private String ibanString;
	
	@Expose (serialize = false)
	private String ownerString;
	
	@Expose (serialize = false, deserialize = false)
	private String addressString;
	
	private  String pinString;

	public String getAccountNumberString() {
		return accountNumberString;
	}

	public void setAccountNumberString(String accountNumberString) {
		this.accountNumberString = accountNumberString;
	}

	public String getIbanString() {
		return ibanString;
	}

	public void setIbanString(String ibanString) {
		this.ibanString = ibanString;
	}

	public String getOwnerString() {
		return ownerString;
	}

	public void setOwnerString(String ownerString) {
		this.ownerString = ownerString;
	}

	public String getAddressString() {
		return addressString;
	}

	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}

	public String getPinString() {
		return pinString;
	}

	public void setPinString(String pinString) {
		this.pinString = pinString;
	}
	
	
	
}
/*
 * @Expose có hai thuộc tính tùy chọn: deserialize và serialize. Thông qua hai thuộc tính này chúng ta có thể kiểm soát những gì
 * được Serialized và Deserialisation. Các giá trị mặc định cho hai thuoocjt ính đều là true*/
