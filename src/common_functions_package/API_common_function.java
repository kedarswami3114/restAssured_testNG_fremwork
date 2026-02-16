package common_functions_package;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
//import request_Repository_package.post_req_repository;

public class API_common_function {

	// these are testing codes of your status code and requestbody only
		public static int statuscode(String baseURI, String resource, String responsebody) {
			
			RestAssured.baseURI = baseURI;
			
			int res_statuscode = given().header("Content-Type","application/json; charset=utf-8").body(responsebody).
					when().post(resource).then().extract().response().statusCode();
			
			return res_statuscode;
			}
		
		public static String responsebody(String baseURI, String resource, String responsebody) {
		
			RestAssured.baseURI = baseURI;
			
			String res_body = given().header("Content-Type","application/json; charset=utf-8").body(responsebody).
					when().post(resource).then().extract().response().asString();
			//System.out.println("responsebody is :"+res_body);
			
			return res_body;
   }
}

