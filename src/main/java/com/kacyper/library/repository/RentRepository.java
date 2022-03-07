package com.kacyper.library.repository;

import com.kacyper.library.domain.Rent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentRepository extends CrudRepository<Rent, Long> {

    List<Rent> findAll();

    @Override
    Rent save(Rent rent);

    @Override
    Optional<Rent> findById(Long id);

    void deleteById(Long id);

}
