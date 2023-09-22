package APIAugust.Api_RestAssured;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestSimpleJsonUsingOrgJson {
	
	public static void main(String[] args) {
		
		JSONObject js=new JSONObject();
		js.put( "firstname","Sandhya");
		js.put("lastname","Sandhya");
		js.put("location","Hyderabad");
		js.put("designation","Modulelead");
		js.put("id","1253");
		
		Response rs=
				given()
				.contentType(ContentType.JSON)
				.body(js.toString())
				.when()
				.post("http://localhost:3000/RestDummyAPI1");
		System.out.println("Response Code is "+rs.statusCode());
		System.out.println("Response data is "+rs.asString());
		
	}

}
