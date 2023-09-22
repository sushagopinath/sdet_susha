package APIAugust.Api_RestAssured;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostRequestUsingSimpleJsonFile {
	
	public static void main(String[] args) throws FileNotFoundException {
		File f=new File("../Api_RestAssured/requestbody_simplejson.json");
		FileReader fr=new FileReader(f);
		JSONTokener js= new JSONTokener(fr);
		JSONObject j=new JSONObject(js);
		//System.out.println(j.toString());
		Response rs=
		given()
		.contentType(ContentType.JSON)
		.body(j.toString())
		.when()
		.post("http://localhost:3000/RestDummyAPI1");
		System.out.println("status code is:");
		System.out.println(rs.statusCode());
		System.out.println("response data is:");
		System.out.println(rs.asString());
				
	}

}
