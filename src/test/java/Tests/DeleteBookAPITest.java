package Tests;

import RequestServices.AddBookRequest;
import RequestServices.DeleteBookRequest;
import ResponseServices.AddBookResponse;
import ResponseServices.DeleteBookResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteBookAPITest {
    @Test
    public String deleteBookAPI(String ID) {
        RestAssured.baseURI = "http://216.10.245.166/";
        DeleteBookRequest deleteBook = new DeleteBookRequest();
        deleteBook.setIdToDelete(ID);

        Response responseDeleteBook = RestAssured.given().header("Content-Type", "application/json")
                .body(deleteBook)
                .log().all()
                .when().post("/Library/DeleteBook.php")
                .then().log().all()
                .assertThat().statusCode(200).extract().response();

        System.out.println(responseDeleteBook.asString());
        DeleteBookResponse bookResponses = responseDeleteBook.body().as(DeleteBookResponse.class);
        //Assert.assertEquals(bookResponses.getMsg(), "book is successfully deleted");
        return bookResponses.getMsg();

    }
}
