package APIAugust.Api_RestAssured;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class postRequestUsingRandomGerneratedId {
	
	public static void main(String[] args) throws FileNotFoundException {
		File f=new File("../Api_RestAssured/requestbody_random_id_simplejson.json");
		FileReader fr=new FileReader(f);
		JSONTokener js= new JSONTokener(fr);
		JSONObject j=new JSONObject(js);
		
		String requestBody=j.toString();
		Random r=new Random();
		Integer randomIntvalue=r.nextInt();
		requestBody=requestBody.replaceAll(Pattern.quote("{{id}}"),randomIntvalue.toString());
		Response rs=
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.post("http://localhost:3000/RestDummyAPI2");
		System.out.println("status code is:");
		System.out.println(rs.statusCode());
		System.out.println("response data is:");
		System.out.println(rs.asString());
				
	}


}
