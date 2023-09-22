package APIAugust.Api_RestAssured;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postRequestComplexJsonUsingOrgJson {
	
public static void main(String[] args) {
		
		JSONObject inner=new JSONObject();
		inner.put("area", "hyderabad");
		inner.put("housename", "Crystal");
		inner.put("streename","Manikonda");
		
		JSONObject outer=new JSONObject();
		outer.put( "firstname","Deepa");
		outer.put("lastname","Kumari");
		outer.put("location","Kochi");
		outer.put("designation","Manager");
		outer.put("id","1231");
		outer.put("address",inner);
		
		Response rs=
				given()
				.contentType(ContentType.JSON)
				.body(outer.toString())
				.when()
				.post("http://localhost:3000/RestDummyAPI1");
		System.out.println("Response Code is "+rs.statusCode());
		System.out.println("Response data is "+rs.asString());
		
	}

}
