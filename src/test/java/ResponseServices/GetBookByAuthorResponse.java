package ResponseServices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetBookByAuthorResponse {
    @JsonProperty("book_name")
    private String bookName;
    private String isbn;
    private String aisle;


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

}
