package testCases;


import io.restassured.RestAssured;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


import org.testng.Assert;
import org.testng.annotations.Test;

public class GetLatestLunch {	
	
	
	
	@Test
	 public void VerifyGetSpacXLatestLaunchStatusCode()
	 {   
	
	 RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";	 
	
	 RequestSpecification request = RestAssured.given();	 
	
	 Response response = request.get("/latest");	 
	
	 int statusCode = response.getStatusCode();	 
	 
	 Assert.assertEquals(statusCode , 200 , "Correct status code not returned");

}
	
	@Test
	 public void VerifyGetSpacXLatestLaunchDetails()
	 {   
	  String expectedDetails="SpaceX's 22nd ISS resupply mission on behalf of NASA, this mission sends essential supplies to the International Space Station using the cargo variant of SpaceX's Dragon 2 spacecraft. The external payload for this mission is the first pair of ISS Roll Out Solar Arrays. Falcon 9 and Dragon launch from LC-39A, Kennedy Space Center and the booster is expected to land on an ASDS. The mission will be complete with splashdown and recovery of the capsule and down cargo.";
	 RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";	 
	
	 RequestSpecification request = RestAssured.given();	 
	
	 Response response = request.get("/latest");	 
	
	 JsonPath jsonPathEvalutor= response.jsonPath();	
	 
	 String actualDetails=jsonPathEvalutor.get("details");
	 
	 Assert.assertEquals(actualDetails , expectedDetails , "deatils are not correct");

 }
	
	
	@Test
	 public void VerifyGetSpacXLatestLaunchWikipedia()
	 {   
	  String expectedWikipedia="https://en.wikipedia.org/wiki/SpaceX_CRS-22";
	 RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";	 
	
	 RequestSpecification request = RestAssured.given();	 
	
	 Response response = request.get("/latest");	 
	
	 JsonPath jsonPathEvalutor= response.jsonPath();	
	 
	 String actualWikipedia=jsonPathEvalutor.get("links.wikipedia");
	 
	 Assert.assertEquals(actualWikipedia , expectedWikipedia , "deatils are not correct");

}
	
	
	
}
