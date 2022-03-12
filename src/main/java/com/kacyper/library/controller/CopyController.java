package com.kacyper.library.controller;

import com.kacyper.library.domain.RentalStatus;
import com.kacyper.library.dto.CopyDto;
import com.kacyper.library.exception.CopyNotFoundException;
import com.kacyper.library.mapper.CopyMapper;
import com.kacyper.library.repository.BookRepository;
import com.kacyper.library.service.DbServiceBook;
import com.kacyper.library.service.DbServiceCopy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/library/copy")
@RequiredArgsConstructor
public class CopyController {

    @Autowired
    private final DbServiceCopy dbServiceCopy;

    @Autowired
    private final CopyMapper copyMapper;

    @Autowired
    private final DbServiceBook dbServiceBook;

    @Autowired
    private final BookRepository bookRepository;

    @GetMapping(value = "/getAllCopies")
    public List<CopyDto> getAllCopies() {
        return copyMapper.mapToCopyDtoList(dbServiceCopy.getAllCopies());
    }

    @GetMapping(value = "/getCopyById/{id}")
    public CopyDto getCopyById(@PathVariable Long id) throws CopyNotFoundException {
        return copyMapper.mapToCopyDto(
                dbServiceCopy.getCopyById(id).orElseThrow(CopyNotFoundException::new)
        );
    }

    @GetMapping(value = "/getCopyQuantity")
    public int getCopyQuantity(@RequestParam String title) {
        return dbServiceCopy.getAllAvailableCopiesByTitle(title);
    }

    @PostMapping(value = "/createCopy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        copyMapper.mapToCopyDto(dbServiceCopy.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @DeleteMapping(value = "/deleteCopy/{id}")
    void deleteCopy(@PathVariable Long id) {
        dbServiceCopy.deleteCopy(id);
    }

    @PutMapping(value = "/updateStatus")
    public void updateStatus(@RequestParam Long copyId, @RequestParam RentalStatus rentalStatus) {
        dbServiceCopy.updateRentalStatus(copyId, rentalStatus);
    }
}
