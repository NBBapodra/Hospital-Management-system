package com.example.TokenAuthentication.services;


import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.models.Library;

import java.util.List;

public interface LibraryService {

    List<Library> getAllLibraryRecord();

    Library createLibraryRecord(Library library);

    Library getLibraryRecordById(Long id);

    Library updateLibraryRecord(Long id, Library library);

    void deleteLibraryRecord(Long id);
}
