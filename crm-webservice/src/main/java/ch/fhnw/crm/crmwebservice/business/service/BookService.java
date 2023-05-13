package ch.fhnw.crm.crmwebservice.business.service;

import org.aspectj.weaver.ast.And;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

import ch.fhnw.crm.crmwebservice.data.domain.Book;
import ch.fhnw.crm.crmwebservice.data.repository.BookRepository;
//import ch.fhnw.crm.crmwebservice.data.domain.Author;
//import ch.fhnw.crm.crmwebservice.data.repository.AuthorRepository;
//import ch.fhnw.crm.crmwebservice.data.domain.Genre;
//import ch.fhnw.crm.crmwebservice.data.repository.GenreRepository;
import jakarta.validation.Valid;

// TODO: Author and Gerne class are not yet created, therefore the above imports and following parts are commented out

@Service
@Validated
public class BookService {
    
    @Autowired
    private BookRepository bookRepository;
    
//create methode to create a book with the following attribtues book_id, ISBN, title, year, borrowed, author and genre
    /*
    public Book createBook(int book_id, String ISBN, String title, int year, boolean borrowed, List<Author> authors, List<Genre> genres) {
        Book book = new Book();
        book.setBook_id(book_id);
        book.setISBN(ISBN);
        book.setTitle(title);
        book.setYear(year);
        book.setBorrowed(borrowed);
        book.setAuthors(authors);
        book.setGenres(genres);
        return bookRepository.save(book);
    }
    */

//create methode to save a book
    public void saveBook(@Valid Book book) throws Exception {
        if (Integer.toString(book.getBook_id()) == null) {
            if (bookRepository.findByISBN(book.getISBN()) != null) {
                throw new Exception("ISBN" + book.getISBN() + " already exists.");
            }
        } else if (Integer.toString(book.getBook_id()) != null && bookRepository.findByTitle(book.getTitle()) != null) {
            throw new Exception("Book ID " + book.getBook_id() + " with book title " + book.getTitle() + " already exists.");
        }
        bookRepository.save(book);
    }


//create methode to get all books
   public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

//create methode to get a book by id
    public Book getBookById(int book_id) {
        Book book = bookRepository.findById(book_id).get();
        return book;
    }

//create methode to get a book by ISBN
    public Book getBookByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN);
    }

//create methode to get a book by title
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

//create methode to get a book by year
    public Book getBookByYear(int year) {
        return bookRepository.findByYear(year);
    }

//create methode to get a book by borrowed
    public Book getBookByBorrowed(boolean borrowed) {
        return bookRepository.findByBorrowed(borrowed);
    }

//create methode to get a book by author
    /*
    public Book getBookByAuthor(List<Author> authors) {
        return bookRepository.findByAuthor(authors);
    }
    */

//create methode to get a book by genre
    /*
    public Book getBookByGenre(List<Genre> genres) {
        return bookRepository.findByGenre(genres);
    }
    */

//create methode to update a book by id 
    /*
    public Book updateBookById(int book_id, String ISBN, String title, int year, boolean borrowed, List<Author> authors, List<Genre> genres) {
        Book existingBook = bookRepository.findById(book_id).orElse(null);
        existingBook.setBook_id(book_id);
        existingBook.setISBN(ISBN);
        existingBook.setTitle(title);
        existingBook.setYear(year);
        existingBook.setBorrowed(borrowed);
        existingBook.setAuthors(authors);
        existingBook.setGenres(genres);
        return bookRepository.save(existingBook);
    }
    */

//create methode to delete a book by id
    public String deleteBookById(int book_id) {
        bookRepository.deleteById(book_id);
        return "Book removed !! " + book_id;
    }

//create methode to delete all books
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "All books removed !!";
    }

}

