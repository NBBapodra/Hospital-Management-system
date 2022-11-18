package com.example.TokenAuthentication.controllers;


import com.example.TokenAuthentication.dto.LibraryDto;
import com.example.TokenAuthentication.models.Library;
import com.example.TokenAuthentication.services.LibraryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LibraryController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LibraryService libraryService;

    @PostMapping("/libraryRecords")
    public ResponseEntity<LibraryDto> createLibraryRecords(@Valid @RequestBody LibraryDto libraryDto) {

        // convert DTO to entity
        Library libraryRequest = modelMapper.map(libraryDto, Library.class);
        Library library= libraryService.createLibraryRecord(libraryRequest);
        // convert entity to DTO
        LibraryDto  libraryResponse = modelMapper.map(library, LibraryDto.class);
        return new ResponseEntity<LibraryDto>(libraryResponse, HttpStatus.CREATED);
    }

    @GetMapping("/libraryRecords")
    public List<LibraryDto> getAllLibraryRecord() {
        return libraryService.getAllLibraryRecord().stream().map(post -> modelMapper.map(post, LibraryDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/libraryRecords/{id}")
    public ResponseEntity<LibraryDto> getLibraryRecordById(@PathVariable(value = "id") Long id)
    {

        Library library=libraryService.getLibraryRecordById(id);
        LibraryDto libraryResponse = modelMapper.map(library,LibraryDto.class);
        if(library==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(libraryResponse);
    }

    @PutMapping("/libraryRecords/{id}")
    public ResponseEntity<LibraryDto> updateLibraryRecord(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody LibraryDto libraryDto){
        // convert DTO to entity
        Library libraryRequest = modelMapper.map(libraryDto, Library.class);
        Library library=libraryService.updateLibraryRecord(id,libraryRequest);
        // convert entity to DTO
        LibraryDto  libraryResponse = modelMapper.map(library, LibraryDto.class);
        return ResponseEntity.ok().body(libraryResponse);
    }

    @DeleteMapping("/libraryRecords/{id}")
    public ResponseEntity deleteLibraryRecord(@PathVariable(value = "id") Long id)
    {
        libraryService.deleteLibraryRecord(id);
        return ResponseEntity.ok().body("Library Record deleted successFully");
    }


}
