package com.kacyper.library.book;

import com.kacyper.library.domain.Book;
import com.kacyper.library.repository.BookRepository;
import com.kacyper.library.service.DbServiceBook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookTestSuite {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private DbServiceBook dbServiceBook;

    @Test
    void testSaveBook() {
        //Given
        Book book = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book);

        //When
        List<Book> bookList = bookRepository.findAll();
        Long idBook1 = book.getId();

        //Then
        assertEquals(1, bookList.size());

        //CleanUp
        bookRepository.deleteById(idBook1);
    }

    @Test
    void testSaveBooks() {
        //Given
        Book book1 = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book1);

        Book book2 = Book.builder()
                .author("Miguel de Cervantes")
                .title("Don Quixote")
                .releaseDate(1605)
                .build();
        bookRepository.save(book2);

        //When
        List<Book> bookList = bookRepository.findAll();
        Long idBook1 = book1.getId();
        Long idBook2 = book2.getId();

        //Then
        assertEquals(2, bookList.size());

        //CleanUp
        bookRepository.deleteById(idBook1);
        bookRepository.deleteById(idBook2);
    }

    @Test
    void testFindBookByTitle() {
        //Given
        Book book1 = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book1);

        Book book2 = Book.builder()
                .author("Miguel de Cervantes")
                .title("Don Quixote")
                .releaseDate(1605)
                .build();
        bookRepository.save(book2);

        //When
        Long idBook1 = book1.getId();
        Long idBook2 = book2.getId();

        //Then
        assert(book1.getTitle().equals("Pan Tadeusz"));

        //CleanUp
        bookRepository.deleteById(idBook1);
        bookRepository.deleteById(idBook2);
    }

    @Test
    void testFindBookByAuthor() {
        //Given
        Book book1 = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book1);

        Book book2 = Book.builder()
                .author("Miguel de Cervantes")
                .title("Don Quixote")
                .releaseDate(1605)
                .build();
        bookRepository.save(book2);

        //When
        Long idBook1 = book1.getId();
        Long idBook2 = book2.getId();

        //Then
        assert(book1.getAuthor().equals("Adam Mickiewicz"));

        //CleanUp
        bookRepository.deleteById(idBook1);
        bookRepository.deleteById(idBook2);
    }

    @Test
    void testDeleteBookById() {
        //Given
        Book book1 = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book1);

        Book book2 = Book.builder()
                .author("Miguel de Cervantes")
                .title("Don Quixote")
                .releaseDate(1605)
                .build();
        bookRepository.save(book2);

        //When
        Long idBook1 = book1.getId();
        Long idBook2 = book2.getId();

        bookRepository.deleteById(idBook1);
        bookRepository.deleteById(idBook2);

        List<Book> bookList = bookRepository.findAll();
        //Then
        assertEquals(0, bookList.size());
    }

    @Test
    void testUpdateBook() {
        //Given
        Book book1 = Book.builder()
                .author("Adam Mickiewicz")
                .title("Pan Tadeusz")
                .releaseDate(1834)
                .build();
        bookRepository.save(book1);

        //When
        book1.setAuthor("A.Mickiewicz");
        bookRepository.save(book1);

        Long idBook1 = book1.getId();

        //Then
        assert(book1.getAuthor().equals("A.Mickiewicz"));

        //CleanUp
        bookRepository.deleteById(idBook1);
    }
}
