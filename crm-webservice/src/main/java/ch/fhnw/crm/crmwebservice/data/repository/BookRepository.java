package ch.fhnw.crm.crmwebservice.data.repository;

import ch.fhnw.crm.crmwebservice.data.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByISBN(String ISBN);
    Book findByTitle(String title);
    Book findByYear(int year);
    Book findByBorrowed(boolean borrowed);
    Book findByAuthor(List<Author> authors);
    Book findByGenre(List<Genre> genres);
}
