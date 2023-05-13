import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;


@Entity
public class Book {
    @Id
    private int book_id;
    private String ISBN;
    private String title;
    private int year;
    private boolean borrowed;
    private List<Author> authors;
    private List<Genre> genres;


public void setBook_id(int book_id) {
    this.book_id = book_id;
}

public int getBook_id() {
    return book_id;
}

public void setISBN(String ISBN) {
    this.ISBN = ISBN;
}

public String getISBN() {
    return ISBN;
}

public void setTitle(String title) {
    this.title = title;
}

public String getTitle() {
    return title;
}

public void setYear(int year) {
    this.year = year;
}

public int getYear() {
    return year;
}

public void setBorrowed(boolean borrowed) {
    this.borrowed = borrowed;
}

public boolean getBorrowed() {
    return borrowed;
}

public void setAuthors(List<Author> authors) {
    this.authors = authors;
}

public List<Author> getAuthors() {
    return authors;
}

public void setGenres(List<Genre> genres) {
    this.genres = genres;
}

public List<Genre> getGenres() {
    return genres;
}

}



