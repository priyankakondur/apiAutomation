package Tests;

import ResponseServices.GetBookByAuthorResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GetBooksByAuthorName {
    public void getBookByName(String authorName) {
        RestAssured.baseURI = "http://216.10.245.166/";
        Response responseGetBook = RestAssured.given().queryParam("AuthorName",authorName)
                .header("Content-Type", "application/json")
                .when().get("Library/GetBook.php")
                .then().statusCode(200).extract().response();

        //System.out.println(responseGetBook.asString());
        GetBookByAuthorResponse[] book =  responseGetBook.as(GetBookByAuthorResponse[].class);

        System.out.println("Total count of Books authored by "+authorName +" is :" +book.length);
        for(int i=0;i< book.length;i++){
            System.out.println(book[i].getBookName());
        }
    }
}
