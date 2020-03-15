import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VersioningExample {

	public static void main(String[] args) {
		final GsonBuilder builder = new GsonBuilder();
		builder.setVersion(2.0);
		
		final Gson gson = builder.create();
		final MemberInfor member = new MemberInfor();
		member.setId(1);
		member.setNameString("Tran Li");
		member.setYahooAccountString("tranli@yahoo.com");//until version 1.7
		member.setFacebookAccountString("facebook.com/TranLi/");// Since version 2.0
		
		final String jsonString = gson.toJson(member);
		System.out.println("Json: "+ jsonString);
		
		//parse Json to Java
		String json2 = "{\"id\":1,\"name\":\"Tran Li\",\"yahooAccount\":\"tranli@yahoo.com\",\"facebookAccount\":\"facebook.com/TranLi/\"}";
		
		 final MemberInfor otherMemberInfor = gson.fromJson(json2, MemberInfor.class);
		 System.out.println("Deeserialised (version 1.0)");
		 System.out.printf(" +id: %s%n", otherMemberInfor.getId());
		 System.out.printf(" +Name: %s%n", otherMemberInfor.getNameString());
		 System.out.printf(" +YahooAccount: %s Untils(1.7)%n", otherMemberInfor.getYahooAccountString());
		 System.out.printf(" +Facebook: %s since(2.3)%n", otherMemberInfor.getFacebookAccountString());
		 
	}
}

/*
 * @Since và @Until được sử dụng để kiểm soát các field khi chuyển đổi giữa các đối tượng java và các đối tượng Json
 * Hai chú thích này hữu ích khi muốn quản lý phiên bản của các lớp Json. 
 * Có thể kiểm soát nếu một field cụ thể được xem xét để serialization / deserialization dựa trên phiên bản nhất định
 * Chú thích @Since: cho biết số phiên bản mà một field được được thêm vào. Nghĩa là field này sẽ chỉ được xem xét cho Serialization/ Deeserialization bắt đầu từ phiên bản nhất định
 * Chú thích @until: cho biết số phiên bản mà một field đã bị loại bỏ. Nghĩa là field này sẽ chỉ được xem xét cho serialization / deserialization cho đến khi phiên bản nhất đinh. Sau phiên bản đó nó sẽ bị bỏ qua
 * 
 * 
 * Những chú thích này được áp dụng trên cấp field và chỉ có hiệu lực khi Gson được tạo bằng GsonBuilder và gọi phương thức Gsonbuilder.setVerson()*/

