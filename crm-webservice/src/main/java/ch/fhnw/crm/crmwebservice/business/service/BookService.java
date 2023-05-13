package ch.fhnw.crm.crmwebservice.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ch.fhnw.crm.crmwebservice.data.domain.Customer;
import ch.fhnw.crm.crmwebservice.data.repository.CustomerRepository;
//import java.util.List;
import ch.fhnw.crm.crmwebservice.data.domain.Book;
import ch.fhnw.crm.crmwebservice.data.repository.BookRepository;
//import ch.fhnw.crm.crmwebservice.data.domain.Author;
//import ch.fhnw.crm.crmwebservice.data.repository.AuthorRepository;
//import ch.fhnw.crm.crmwebservice.data.domain.Genre;
//import ch.fhnw.crm.crmwebservice.data.repository.GenreRepository;


@Service
public class BookService {
    
    @Autowired
    private BookRepository BookRepository;
    
//create methode to create a book with the following attribtues book_id, ISBN, title, year, borrowed, author and genre
    public Book createBook(int book_id, String ISBN, String title, int year, boolean borrowed, List<Author> authors, List<Genre> genres) {
        Book book = new Book();
        book.setBook_id(book_id);
        book.setISBN(ISBN);
        book.setTitle(title);
        book.setYear(year);
        book.setBorrowed(borrowed);
        book.setAuthors(authors);
        book.setGenres(genres);
        return BookRepository.save(book);
    }

//create methode to get all books
/*
   public List<Book> getAllBooks() {
        return BookRepository.findAll();
    }
*/

//create methode to get a book by id
    public Book getBookById(int book_id) {
        return BookRepository.findById(book_id).orElse(null);
    }

//create methode to get a book by ISBN
    public Book getBookByISBN(String ISBN) {
        return BookRepository.findByISBN(ISBN);
    }

//create methode to get a book by title
    public Book getBookByTitle(String title) {
        return BookRepository.findByTitle(title);
    }

//create methode to get a book by year
    public Book getBookByYear(int year) {
        return BookRepository.findByYear(year);
    }

//create methode to get a book by borrowed
    public Book getBookByBorrowed(boolean borrowed) {
        return BookRepository.findByBorrowed(borrowed);
    }

//create methode to get a book by author
    public Book getBookByAuthor(List<Author> authors) {
        return BookRepository.findByAuthor(authors);
    }

//create methode to get a book by genre
    public Book getBookByGenre(List<Genre> genres) {
        return BookRepository.findByGenre(genres);
    }

//create methode to update a book by id 
    public Book updateBookById(int book_id, String ISBN, String title, int year, boolean borrowed, List<Author> authors, List<Genre> genres) {
        Book existingBook = BookRepository.findById(book_id).orElse(null);
        existingBook.setBook_id(book_id);
        existingBook.setISBN(ISBN);
        existingBook.setTitle(title);
        existingBook.setYear(year);
        existingBook.setBorrowed(borrowed);
        existingBook.setAuthors(authors);
        existingBook.setGenres(genres);
        return BookRepository.save(existingBook);
    }

//create methode to delete a book by id
    public String deleteBookById(int book_id) {
        BookRepository.deleteById(book_id);
        return "Book removed !! " + book_id;
    }

//create methode to delete all books
    public String deleteAllBooks() {
        BookRepository.deleteAll();
        return "All books removed !!";
    }

}

