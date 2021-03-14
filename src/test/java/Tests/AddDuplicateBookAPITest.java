package Tests;


import RequestServices.AddBookRequest;
import ResponseServices.AddDuplicateBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddDuplicateBookAPITest {
    @Test
    public String addBookAPI(){
        RestAssured.baseURI = "http://216.10.245.166/";
        AddBookRequest addBook = new AddBookRequest();
        addBook.setName("my name is kondur");
        addBook.setAuthor("abcd");
        addBook.setAisle(57521387);
        addBook.setIsbn("oiu");

        Response responseAddDuplicateBook = RestAssured.given().header("Content-Type", "application/json")
                .body(addBook)
                .log().all()
                .when().post("/Library/Addbook.php")
                .then().log().all()
                .assertThat().statusCode(404).extract().response();
        System.out.println(responseAddDuplicateBook.asString());
        AddDuplicateBookResponse duplicateBookResponse = responseAddDuplicateBook.getBody().as(AddDuplicateBookResponse.class);
       // Assert.assertEquals(duplicateBookResponse.getMsg(),"Add Book operation failed, looks like the book already exists");
        return duplicateBookResponse.getMsg();
    }}
