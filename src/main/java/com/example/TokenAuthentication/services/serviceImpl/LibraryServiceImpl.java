package com.example.TokenAuthentication.services.serviceImpl;

import com.example.TokenAuthentication.exception.ResourceNotFoundException;
import com.example.TokenAuthentication.models.Doctor;
import com.example.TokenAuthentication.models.Library;
import com.example.TokenAuthentication.repository.LibraryRepository;
import com.example.TokenAuthentication.services.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Override
    public List<Library> getAllLibraryRecord() {
        return libraryRepository.findAll();
    }

    @Override
    public Library createLibraryRecord(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library getLibraryRecordById(Long id) {

        Optional<Library> library=libraryRepository.findById(id);

        if(library.isPresent()) {
            return library.get();
        }else {
            try {
                throw new ResourceNotFoundException("Library Record not Found", "id", id);
            } catch (ResourceNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Library updateLibraryRecord(Long id, Library library) {

        Library library1;

        try {
            library1 = libraryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Library Record not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        library1.setId(library.getId());
        library1.setPapers(library.getPapers());
        library1.setArticles(library.getArticles());
        library1.setEbooks(library.getEbooks());
        library1.setBlogs(library.getBlogs());
        library1.setVideo(library.getVideo());
        library1.setCreatedAt(library.getCreatedAt());
        library1.setUpdatedAt(library.getUpdatedAt());

        return  libraryRepository.save(library1);
    }

    @Override
    public void deleteLibraryRecord(Long id) {

        try {
           Library library1 = libraryRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Library Record not found for this id :: " + id, "id", id));
        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        }

        libraryRepository.deleteById(id);
    }
}
