package Tests;

import ResponseServices.GetBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class GetBookByPassingIDParamTest {
    @Test
    public String getBookByName(String id) {
        RestAssured.baseURI = "http://216.10.245.166/";
        Response responseGetBook = RestAssured.given().queryParam("ID", id)
                .header("Content-Type", "application/json")
                .when().get("Library/GetBook.php")
                .then().statusCode(200).extract().response();
        System.out.println(responseGetBook.asString());
        GetBookResponse[] book =  responseGetBook.as(GetBookResponse[].class);

          String bookName=  book[0].getBookName();
        //Assert.assertEquals(responseGetBook.statusCode(),200);
        return bookName;
    }
}
