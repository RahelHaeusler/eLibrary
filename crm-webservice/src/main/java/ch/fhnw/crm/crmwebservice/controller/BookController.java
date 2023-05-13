package ch.fhnw.crm.crmwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;

import ch.fhnw.crm.crmwebservice.business.service.BookService;
import ch.fhnw.crm.crmwebservice.data.domain.Book;
import io.swagger.v3.oas.annotations.Hidden;


@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

// TODO: Test - remove later (not sure if it works)
    @GetMapping("/test")
    public String testString() {
        return "This is a test generated in BookController class /test";
    }

    @GetMapping("/testing")
    public String testingString() {
        return "This is a test generated in BookController class /testing";
    }

// TODO: saveBook method is not implemented in BookService.java; why cant we use createBook method?
    /*
    @PostMapping("/create")
    public ResponseEntity<Void> postCreate(@RequestBody Book book) {
        try {
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    */

    @GetMapping("/allbooks")
    public List<Book> all() {
       return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public @ResponseBody Book getBook(@PathVariable(value = "bookId") Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> putBook(@RequestBody Book book, @PathVariable(value = "bookId") int bookId) {
        try {
            book.setBook_id(bookId);
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/book/{titel}")
    public @ResponseBody Book getBook(@PathVariable(value = "titel") String titel) {
        return bookService.getBookByTitle(titel);
    }

    @PutMapping("/book/{titel}")
    public ResponseEntity<Void> putBook(@RequestBody Book book, @PathVariable(value = "titel") String titel) {
        try {
            book.setTitle(titel);
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    /*
    @GetMapping("/book/{author}")
    public @ResponseBody Book getBook(@PathVariable(value = "author") String author) {
        return bookService.getCurrentBook(author);
    }
    */

    /*
    @PutMapping("/book/{author}")
    public ResponseEntity<Void> putBook(@RequestBody Book book, @PathVariable(value = "author") String author) {
        try {
            book.setAuthor(author);
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }
    */


    // TODO: what is this for?
    @Hidden
    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }

}