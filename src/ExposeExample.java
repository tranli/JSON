import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ExposeExample {

	public static void main(String[] args) {
		final GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		final Gson gson = builder.create();
		
		final Account account = new Account();
        account.setAccountNumberString("A123 4567 8909");
        account.setIbanString("IB 11 22 33 44");
        account.setOwnerString("GP Coder");
        account.setPinString("123456");
        account.setAddressString("Ha Noi, Viet Nam");
 
        final String json = gson.toJson(account);
        System.out.println("Json: " + json);
 
        String json2 = "{\"accountNumber\":\"A123 4567 8909\",\"iban\":\"IBAN 11 22 33 44\",\"owner\":\"Tran Li\",\"pin\":\"123456\",\"address\":\"Ha Noi, Viet Nam\"}";
        final Account account2 = gson.fromJson(json2, Account.class);
        System.out.println("Java Object: ");
        System.out.printf("  + Account Number: %s%n", account2.getAccountNumberString());
        System.out.printf("  + IBAN:           %s%n", account2.getIbanString());
        System.out.printf("  + Owner:          %s%n", account2.getOwnerString());
        System.out.printf("  + Pin:            %s%n", account2.getPinString());
		System.out.printf(" +Address:         %s%n", account2.getAddressString());
	}
}
/* Để làm việc với chú thích expose này , cânf phải sử dụng cấu hình phù hợp. 
 * Khác với @seializedName, cần phải cấu hình Gson chỉ Serialization và Deserialaztion các trường 
 * được chú thích và bỏ qua phần còn lại.*/
 