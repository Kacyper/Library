package com.kacyper.library.service;

import com.kacyper.library.domain.Rent;
import com.kacyper.library.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbServiceRent {

    private final RentRepository rentRepository;

    public List<Rent> getAllRentals() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRent(final Long rentId) {
        return rentRepository.findById(rentId);
    }

    public Rent saveRent(final Rent rent) {
        return rentRepository.save(rent);
    }

    public void deleteRent(final Long id) {
        rentRepository.deleteById(id);
    }


}
