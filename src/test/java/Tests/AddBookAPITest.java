package Tests;


import RequestServices.AddBookRequest;
import ResponseServices.AddBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class AddBookAPITest {
    public String addBookAPI(String bookName){
        RestAssured.baseURI = "http://216.10.245.166/";
        AddBookRequest addBook = new AddBookRequest();
        addBook.setName(bookName);
        addBook.setAuthor("vihhaaann");
        Random r = new Random();
        int randomNo = r.nextInt(1000);
        addBook.setAisle(randomNo);
        addBook.setIsbn("something12");

        Response responseAddBook = RestAssured.given().header("Content-Type", "application/json")
                .body(addBook)
                //.log().all()
                .when().post("/Library/Addbook.php")
                .then().log().all()
                .assertThat().statusCode(200).extract().response();

        //System.out.println(responseAddBook.asString());
       AddBookResponse bookResponses = responseAddBook.body().as(AddBookResponse.class);
      Assert.assertEquals(bookResponses.getMsg(),"successfully added");
       return bookResponses.getId();

    }

}
