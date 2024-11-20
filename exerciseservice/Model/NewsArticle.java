package com.example.exerciseservice.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class NewsArticle {

    @NotEmpty(message = "id can't be null")
    private String ID;

    @NotEmpty(message = "title can't be null")
    @Size(max=100,message = "title maximum 100 characters")
    private String title;

    @NotEmpty(message = "author can't be null")
    @Size(min=5,max = 20, message ="author should has 4-20 f 20 characters")
    private String author;

    @NotEmpty(message = "category can't be null")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "enter valid category politics|sports|technology")
    private String category;

    @NotEmpty(message = "category can't be null")
    @URL(message = "enter valued url")
    private String imageUrl;

    @AssertFalse(message = "isPublished Must be by default false")
    private boolean isPublished;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate publishDate;



}
