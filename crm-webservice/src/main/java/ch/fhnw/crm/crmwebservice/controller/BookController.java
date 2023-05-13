@RestController
@RequestMapping("/api/book")

public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public ResponseEntity<Void> postCreate(@RequestBody Book book) {
        try {
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/allbooks")
    public List<Book> all() {
       return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public @ResponseBody Book getBook(@PathVariable(value = "bookId") String bookId) {
        return bookService.getCurrentBook(Long.parseLong(bookId));
    }

    @PutMapping("/book/{bookId}")
    public ResponseEntity<Void> putBook(@RequestBody Book book, @PathVariable(value = "bookId") String bookId) {
        try {
            book.setId(Long.parseLong(bookId));
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/book/{titel}")
    publich @ResponseBody Book getBook(@PathVariable(value = "titel") String titel) {
        return bookService.getCurrentBook(titel);
    }

    @PutMapping("/book/{titel}")
    public ResponseEntity<Void> putBook(@RequestBody Book book, @PathVariable(value = "titel") String titel) {
        try {
            book.setTitel(titel);
            bookService.saveBook(book);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/book/{author}")
    publich @ResponseBody Book getBook(@PathVariable(value = "author") String author) {
        return bookService.getCurrentBook(author);
    }

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
    

    //to do: what is this for?
    @Hidden
    @RequestMapping(value = "/validate", method = {RequestMethod.GET, RequestMethod.HEAD})
    public ResponseEntity<Void> init() {
        return ResponseEntity.ok().build();
    }

}