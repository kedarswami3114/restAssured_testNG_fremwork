package test_class_package;

import java.io.IOException;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import common_functions_package.API_common_function;
import common_functions_package.Utility_common_function;
import io.restassured.path.json.JsonPath;
import request_Repository_package.post_req_repository;

public class post_TC3 {
	
	@Test
	public static void create() throws IOException {
		
		for(int i=0; i<5; i++) 
		{
		int res_statuscode = API_common_function.statuscode(post_req_repository.base_URI(), 
				post_req_repository.resource(), post_req_repository.post_req_tc3());
		    System.out.println(res_statuscode);
		if(res_statuscode == 201)
		{
		 String res_body = API_common_function.responsebody(post_req_repository.base_URI(), 
				post_req_repository.resource(), post_req_repository.post_req_tc3());
	        System.out.println(res_body);
	      post_TC3.validator(res_body, res_statuscode);
	      //here we declare code for evidence file creation
	      Utility_common_function.evidence_file_creator("post_3", post_req_repository.post_req_tc3(), res_body);
	    break;
		}
		else
		{
			System.out.println("statuscode is not found, retrying the API");
		}
	  }
	}
	  public static void validator(String res_body, int res_statuscode) throws IOException {
	    
		  //parse request body
		  JsonPath reqjsp = new JsonPath(post_req_repository.post_req_tc3());
		  String req_name = reqjsp.getString("name");
		  String req_job = reqjsp.getString("job");
		  
		  JsonPath jsp = new JsonPath(res_body);
	    //extract or parse responsebody parameters
		  String res_name=jsp.getString("name");
		  //System.out.println(res_name);
		  String res_job=jsp.getString("job");
		  //System.out.println(res_job);
		  String res_id=jsp.getString("id");
		  //System.out.println(res_id);
		  String res_createdAt=jsp.getString("createdAt");
		  //System.out.println(res_createdAt);
		  
		  //validate responsebody parameters
		  Assert.assertEquals(res_name, req_name);
		  Assert.assertEquals(res_job, req_job);
		  Assert.assertNotNull(res_id);
		  //Assert.assertEquals(res_statuscode, 201);
		  
		  //extract and validate createdAt parameter
		  String actual_date = res_createdAt.substring(0,10);
		  String current_date = LocalDate.now().toString(); //create date object
		  //System.out.println(current_date);
		  Assert.assertEquals(actual_date, actual_date);
		   
	  }
	
}

