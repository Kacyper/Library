package com.kacyper.library.repository;

import com.kacyper.library.domain.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    @Override
    Optional<Book> findById(Long id);

    @Override
    List<Book> findAll();

    @Override
    Book save (Book book);

    void deleteById(Long id);

    @Query
    Optional<Book> retrieveRequestedTitle(@Param("Title") String title);
}
