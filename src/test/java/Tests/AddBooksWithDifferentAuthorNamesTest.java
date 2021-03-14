package Tests;
import org.testng.annotations.Test;


public class AddBooksWithDifferentAuthorNamesTest {
    @Test
    public void AddBooksWithDifferentAuthorNames() {
        //first book with book name sita
        AddBookAPITest addBook = new AddBookAPITest();
        String Id = addBook.addBookAPI("sita");

        //second book with book name gita
        AddBookAPITest addBook1 = new AddBookAPITest();
        String Id1 = addBook1.addBookAPI("gita");


        //third book with book name nita
        AddBookAPITest addBook2 = new AddBookAPITest();
        String Id2 = addBook2.addBookAPI("nita");

        // get all the books that match author name
        GetBooksByAuthorName getBooksByAuthorName = new GetBooksByAuthorName();
        getBooksByAuthorName.getBookByName("vihhaaann");


        }
    }


