package APIAugust.Api_RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class postRequestUsingPojoSimpleJson {
	
	public static void main(String[] args) {
		
		basicInformationSimpleJson b=new basicInformationSimpleJson();
		b.setFirstname("Adarsh");
		b.setLastname("kumar");
		b.setDesignation("Developer");
		b.setLocation("Kerala");
		b.setId("adarsh");
		
		Response rs=
				given()
				.contentType(ContentType.JSON)
				.body(b)
				.when()
				.post("http://localhost:3000/RestDummyAPI1");
		System.out.println("status code is:");
		System.out.println(rs.statusCode());
		System.out.println("response data is:");
		System.out.println(rs.asString());	
	}

}
