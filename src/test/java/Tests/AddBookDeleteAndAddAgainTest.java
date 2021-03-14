package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
public class AddBookDeleteAndAddAgainTest {

    @Test
    public void AddBookDeleteAndAddAgain() {
        //Adding book using POST and then do a GET by ID call to verify if it is added and assert on book name
        AddBookAPITest addBook = new AddBookAPITest();
        String ID = addBook.addBookAPI("gdhfdjdf");
        GetBookByPassingIDParamTest getBook = new GetBookByPassingIDParamTest();
        String bookName = getBook.getBookByName(ID);
        //Assert.assertEquals(bookName,"gdhfdjdf");

        // Delete the book recently added and verify if it is deleted using GET by ID
        DeleteBookAPITest deleteBook = new DeleteBookAPITest();
        String msgAfterDeletingBook = deleteBook.deleteBookAPI(ID);
        Assert.assertEquals(msgAfterDeletingBook, "book is successfully deleted");
        GetBookByPassingIDAfterDeletingTest getBookAfterDeleting = new GetBookByPassingIDAfterDeletingTest();
        String msgGetBookAfterDeleting = getBookAfterDeleting.getBookAfterDeleting(ID);
        //Assert.assertEquals(msgGetBookAfterDeleting,"The book by requested bookid / author name does not exists!");

        //Adding the same book again
        String newID = addBook.addBookAPI("hgkgkg");
        System.out.println("new ID: "+newID);

    }
}