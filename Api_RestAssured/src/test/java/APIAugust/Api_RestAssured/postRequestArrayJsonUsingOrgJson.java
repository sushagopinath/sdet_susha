package APIAugust.Api_RestAssured;
import static io.restassured.RestAssured.given;

import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postRequestArrayJsonUsingOrgJson {
	public static void main(String[] args) {
	JSONObject inner1=new JSONObject();
	inner1.put("area", "delhi");
	inner1.put("housename", "Crystal");
	inner1.put("streename", "Manikonda");
	inner1.put("type", "primary");
	JSONObject inner2=new JSONObject();
	inner2.put("area", "delhi");
	inner2.put("housename", "Crystal");
	inner2.put("streename", "Manikonda");
	inner2.put("type", "secondary");
	JSONArray js=new JSONArray();
	js.put(0,inner1);
	js.put(1,inner2);
	JSONObject outer=new JSONObject();
	outer.put( "firstname", "Deepa");
	outer.put("lastname", "Babu");
	outer.put("location", "Kochi");
	outer.put("designation", "Manager");
	outer.put("id","1561");
	outer.put("address",js);
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
