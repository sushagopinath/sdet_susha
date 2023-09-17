package APIAugust.Api_RestAssured;

import static io.restassured.RestAssured.given;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestGetAll {
public static void main(String[] args) {
		
		Response rs=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(" http://localhost:3000/RestDummyAPI1");
		System.out.println("status code is:");
		System.out.println(rs.statusCode());
		System.out.println("response data is:");
		System.out.println(rs.asString());
		
	}

}
