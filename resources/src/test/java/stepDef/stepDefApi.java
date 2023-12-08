package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import page.ProductStorePage;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.post;

public class stepDefApi {

    public static WebDriver driver;
    private ProductStorePage loginPage;
    public static String PETID;
    public static String PETNAME;
    public static int STATUSCODE;
    public static String RES_MESSAGE;
    public static String PETINPUTVALUE;
    @Given("^Post Method: Add a pet \"([^\"]*)\" and body id is \"([^\"]*)\"$")
    public  void postAddPet(String petinput, String bodyId){
        PETINPUTVALUE=petinput;
        String postURL = "https://petstore.swagger.io/v2/pet";
        if(bodyId.equals("c")){
            bodyId = "\"c\"";
        }else{
            bodyId=bodyId;
        }

         String requestBody = "{\n  \"id\": "+bodyId+",\n  \"category\": {\n    \"id\": 0,\n    \"name\": \"string\"\n  }," +
                 "\n  \"name\": \""+PETINPUTVALUE+"\",\n  \"photoUrls\": [\n    \"string\"\n  ],\n  \"tags\": [\n    {\n      \"id\": 0,\n      \"name\": \"string\"\n    }\n  ],\n  \"status\": \"available\"\n}";
        Response response = given()
                .header("Content-type", "application/json")
                .accept(ContentType.JSON)
                .and()
                .body(requestBody)
                //.when()
                .post(postURL)
              //  .then()
                .thenReturn();
        //System.out.println(response.body().asString());
        PETID = response.jsonPath().getString("id");
        PETNAME = response.jsonPath().getString("name");
        STATUSCODE = response.statusCode();
        if(STATUSCODE!=200){
        RES_MESSAGE = response.jsonPath().getString("message");
        }
    }
    @And("^Verify the status code as (\\d+) and response body as expected$")
    public void verify_status_code(int getStatusCode){
    Assert.assertEquals("Status code is :",getStatusCode,STATUSCODE);
    String[] errorMessage = {"java.lang.NumberFormatException: For input string: \""+PETID+"\"","Pet not found"};
    if(STATUSCODE==400) {
        Assert.assertEquals("Body have the message is", "bad input", RES_MESSAGE);
    }
    else if (STATUSCODE==500) {
        Assert.assertEquals("Body have the message is", "something bad happened", RES_MESSAGE);
    }
    else if (STATUSCODE==404) {
        for(String e: errorMessage){
            if(RES_MESSAGE.equals(e)){
            Assert.assertEquals("Body have the message is", e, RES_MESSAGE);
            }
        }
    }else {
        Assert.assertEquals("Body contains the Name",PETINPUTVALUE,PETNAME);
    }
    }

    @When("^Verify the GET method for ID \"([^\"]*)\"$")
    public  void signUp(String inputGetID){
        PETID=inputGetID;
        String getURL = "https://petstore.swagger.io/v2/pet/"+PETID;
        Response response = given()
                .header("Content-type", "application/json")
                .accept(ContentType.JSON)
                .and()
                //.when()
                .get(getURL)
                //  .then()
                .thenReturn();

        System.out.println(response.body().asString());
        PETNAME = response.jsonPath().getString("name");
        STATUSCODE = response.statusCode();
        if(STATUSCODE!=200){
            RES_MESSAGE = response.jsonPath().getString("message");
        }
    }

    @Given("^Put method:add a pet \"([^\"]*)\" and body id is \"([^\"]*)\"$")
    public  void putAddPet(String petinput, String bodyId){
        PETINPUTVALUE=petinput;
        String postURL = "https://petstore.swagger.io/v2/pet";
        if(bodyId.equals("c")){
            bodyId = "\"c\"";
        }else{
            bodyId=bodyId;
        }

        String requestBody = "{\n  \"id\": "+bodyId+",\n  \"category\": {\n    \"id\": 0,\n    \"name\": \"string\"\n  }," +
                "\n  \"name\": \""+PETINPUTVALUE+"\",\n  \"photoUrls\": [\n    \"string\"\n  ],\n  \"tags\": [\n    {\n      \"id\": 0,\n      \"name\": \"string\"\n    }\n  ],\n  \"status\": \"available\"\n}";
        Response response = given()
                .header("Content-type", "application/json")
                .accept(ContentType.JSON)
                .and()
                .body(requestBody)
                //.when()
                .put(postURL)
                //  .then()
                .thenReturn();
        //System.out.println(response.body().asString());
        PETID = response.jsonPath().getString("id");
        PETNAME = response.jsonPath().getString("name");
        STATUSCODE = response.statusCode();
        if(STATUSCODE!=200){
            RES_MESSAGE = response.jsonPath().getString("message");
        }
    }
}


