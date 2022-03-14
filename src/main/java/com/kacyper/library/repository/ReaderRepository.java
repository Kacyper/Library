package com.kacyper.library.repository;

import com.kacyper.library.domain.Reader;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReaderRepository extends CrudRepository<Reader, Long> {

    @Override
    List<Reader> findAll();

    @Override
    Reader save(Reader reader);

    Optional<Reader> findById(Reader readerId);

    @Override
    void deleteById(Long id);

}
