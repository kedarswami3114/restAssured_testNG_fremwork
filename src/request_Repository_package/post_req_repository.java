 package request_Repository_package;

import java.io.IOException;
import java.util.ArrayList;

import org.testng.annotations.BeforeTest;

import common_functions_package.Utility_common_function;

public class post_req_repository {
	
	public static String base_URI() {
		   String baseURI = "https://reqres.in/";
		return baseURI;
	}
	
		public static String resource() {
			String resource = "api/users";
		return resource;
	}
		@BeforeTest
		public static String post_req_tc1() throws IOException {
	     //here we call the excel read method
			ArrayList<String> data = Utility_common_function.Read_data_from_excel("post_testcases", "Post_TC1");
			//System.out.println(data);
			
			String req_name =data.get(1);
			String req_job =  data.get(2);
			
			String responsebody ="{\r\n"
					+ "    \"name\": \""+req_name+"\",\r\n"
					+ "    \"job\": \""+req_job+"\"\r\n"
					+ "}\r\n"
					+ "";
			return responsebody;
		}
		
		
		public static String post_req_tc2() throws IOException {
		     //here we call the excel read method
				ArrayList<String> data = Utility_common_function.Read_data_from_excel("post_testcases", "Post_TC2");
				//System.out.println(data);
				
				String req_name = data.get(1);
				String req_job = data.get(2);
				
				String responsebody ="{\r\n"
						+ "    \"name\": \""+req_name+"\",\r\n"
						+ "    \"job\": \""+req_job+"\"\r\n"
						+ "}";
				return responsebody;
			}
		
		public static String post_req_tc3() throws IOException {
		     //here we call the excel read method
				ArrayList<String> data = Utility_common_function.Read_data_from_excel("post_testcases", "Post_TC3");
				//System.out.println(data);
				
				String req_name = data.get(1);
				String req_job = data.get(2);
				
				String responsebody ="{\r\n"
						+ "    \"name\": \""+req_name+"\",\r\n"
						+ "    \"job\": \""+req_job+"\"\r\n"
						+ "}";
				return responsebody;
			}
		
		public static String post_req_tc4() throws IOException {
		     //here we call the excel read method
				ArrayList<String> data = Utility_common_function.Read_data_from_excel("post_testcases", "Post_TC4");
				//System.out.println(data);
				
				String req_name = data.get(1);
				String req_job = data.get(2);
				
				String responsebody ="{\r\n"
						+ "    \"name\": \""+req_name+"\",\r\n"
						+ "    \"job\": \""+req_job+"\"\r\n"
						+ "}";
				return responsebody;
			}
}