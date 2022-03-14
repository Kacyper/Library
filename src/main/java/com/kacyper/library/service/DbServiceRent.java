package com.kacyper.library.service;

import com.kacyper.library.domain.Rent;
import com.kacyper.library.domain.RentalStatus;
import com.kacyper.library.repository.CopyRepository;
import com.kacyper.library.repository.RentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DbServiceRent {

    private final RentRepository rentRepository;

    private final CopyRepository copyRepository;

    public List<Rent> getAllRentals() {
        return rentRepository.findAll();
    }

    public Optional<Rent> getRent(final Long rentId) {
        return rentRepository.findById(rentId);
    }

    public Rent saveRent(final Rent rent) {
        rent.getCopy().setRentalStatus(RentalStatus.RENTED);
        rent.setRentDate(LocalDate.now());
        copyRepository.save(rent.getCopy());
        return rentRepository.save(rent);
    }

    public void returnRent(Long rentId) {
        Optional<Rent> rentOptional = rentRepository.findById(rentId);
        Rent rent1 = rentOptional.get();
        rent1.getCopy().setRentalStatus(RentalStatus.AVAILABLE);
        copyRepository.save(rent1.getCopy());
        rent1.setReturnDate(LocalDate.now());
        rentRepository.save(rent1);
    }

    public void deleteRent(final Long id) {
        rentRepository.deleteById(id);
    }


}
