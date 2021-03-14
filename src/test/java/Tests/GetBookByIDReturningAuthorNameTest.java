package Tests;

import ResponseServices.GetBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetBookByIDReturningAuthorNameTest {
    public String getBookByIDAndReturnAuthorName(String id) {
        RestAssured.baseURI = "http://216.10.245.166/";
        Response responseGetBook = RestAssured.given().queryParam("ID", id)
                .header("Content-Type", "application/json")
                .when().get("Library/GetBook.php")
                .then().statusCode(200).extract().response();
        System.out.println(responseGetBook.asString());
        GetBookResponse[] book =  responseGetBook.as(GetBookResponse[].class);

        String authorName=  book[0].getAuthor();
        //Assert.assertEquals(responseGetBook.statusCode(),200);
        return authorName;
    }
}
