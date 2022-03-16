package com.kacyper.library.controller;

import com.kacyper.library.domain.Rent;
import com.kacyper.library.dto.RentDto;
import com.kacyper.library.exception.RentNotFoundException;
import com.kacyper.library.mapper.RentMapper;
import com.kacyper.library.service.DbServiceRent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/library")
@RequiredArgsConstructor
public class RentController {

    private final DbServiceRent dbServiceRent;
    private final RentMapper rentMapper;

    @GetMapping(value = "/getRents")
    public List<RentDto> getAllRents() {
        List<Rent> rentList = dbServiceRent.getAllRentals();
        return rentMapper.mapToRentDtoList(rentList);
    }

    @GetMapping(value = "/getRent/{id}")
    public RentDto getRent(@PathVariable Long id) throws RentNotFoundException {
        return rentMapper.mapToRentDto(
                dbServiceRent.getRent(id).orElseThrow(RentNotFoundException::new)
        );
    }

    @DeleteMapping(value = "/deleteRent/{id}")
    void deleteRent(@PathVariable Long id) {
        dbServiceRent.deleteRent(id);
    }

    @PostMapping(value = "/rentBook", consumes = APPLICATION_JSON_VALUE)
    public void rentBook(@RequestBody RentDto rentDto) {
        rentMapper.mapToRentDto(dbServiceRent.saveRent(rentMapper.mapToRent(rentDto)));
    }

    @PutMapping(value = "/returnBook")
    public void returnBook(@RequestParam Long rentId) {
        dbServiceRent.returnRent(rentId);
    }

}
