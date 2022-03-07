package com.kacyper.library.controller;

import com.kacyper.library.domain.Copy;
import com.kacyper.library.dto.CopyDto;
import com.kacyper.library.exception.CopyNotFoundException;
import com.kacyper.library.mapper.CopyMapper;
import com.kacyper.library.service.DbServiceBook;
import com.kacyper.library.service.DbServiceCopy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/getAllCopies")
    public List<CopyDto> getAllCopies() {
        List<Copy> copyList = dbServiceCopy.getAllCopies();
        return copyMapper.mapToCopyDtoList(copyList);
    }

    @GetMapping(value = "/getCopyById/{id}")
    public CopyDto getCopyById(@PathVariable Long id) throws CopyNotFoundException {
        return copyMapper.mapToCopyDto(
                dbServiceCopy.getCopyById(id).orElseThrow(CopyNotFoundException::new)
        );
    }

    @PostMapping(value = "/createCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        copyMapper.mapToCopyDto(dbServiceCopy.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

   @GetMapping(value = "/getCopyQuantity")
   public int getCopyQuantity(@RequestParam String title) {
    return dbServiceCopy.getAllAvailableCopiesByTitle(title);
}

//    @PostMapping(value = "/createCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void createCopy(String title) {
//        CopyDto copyDto = new CopyDto();
//        copyDto.setBook(dbServiceBook.getBookByTitle(title).get());
//        copyDto.setRent(false);
//        copyDto.setInLibrary(true);
//        copyDto.setDestroyed(false);
//
//        Copy copy = copyMapper.mapToCopy(copyDto);
//        dbServiceCopy.saveCopy(copy);
//    }

    @DeleteMapping(value = "/deleteCopy/{id}")
    void deleteCopy(@PathVariable Long id) {
        dbServiceCopy.deleteCopy(id);
    }

    @PutMapping(value = "/updateCopy/{id}")
    public CopyDto updateCopy (@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        Copy saveCopy = dbServiceCopy.saveCopy(copy);
        return copyMapper.mapToCopyDto(saveCopy);
    }
}