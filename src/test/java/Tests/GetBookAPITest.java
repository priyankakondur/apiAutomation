package Tests;

import ResponseServices.GetBookResponse;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetBookAPITest {
    @Test
    public void getBookAPI() {
        RestAssured.baseURI = "http://216.10.245.166/";
        Response responseGetBook = get("http://216.10.245.166/Library/GetBook.php?ID=oiru57387").then().statusCode(200)
                .extract().response();
        System.out.println(responseGetBook.asString());
                /*RestAssured.given().queryParam("ID", "priyanka227")
                .header("Content-Type", "application/json")
                .when().get("Library/GetBook.php")
                .then().statusCode(200).extract().response();*/
       GetBookResponse[] book =  responseGetBook.as(GetBookResponse[].class);
       Assert.assertEquals(book[0].getBookName(),"my name is kondur");
    }
}