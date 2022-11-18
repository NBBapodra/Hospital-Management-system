package com.example.TokenAuthentication.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {

    private long id;
    private String papers;
    private String articles;
    private String video;
    private String blogs;
    private String ebooks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
