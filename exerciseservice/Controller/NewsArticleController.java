package com.example.exerciseservice.Controller;

import com.example.exerciseservice.ApiResponse.ApiResponse;
import com.example.exerciseservice.Model.NewsArticle;
import com.example.exerciseservice.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/news-article")
public class NewsArticleController {

    private final NewsArticleService newsArticleService;

@GetMapping("/get-all")
    public ResponseEntity getNewsArticles(){
        return ResponseEntity.status(200).body( newsArticleService.getNewsArticles());
    }


    @PostMapping("/add")
    public ResponseEntity addNewsArticles(@RequestBody @Valid NewsArticle newsArticle, Errors errors){
    if(errors.hasErrors())return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

    newsArticleService.addNewsArticles(newsArticle);
        return ResponseEntity.status(200).body(new ApiResponse("news Article added successfully"));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        boolean isUpdated=newsArticleService.update(id,newsArticle);
        if(isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("news Article updated successfully"));
        }
        return ResponseEntity.status(200).body(new ApiResponse("news Article Not found"));

    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id){
        boolean isDelete=newsArticleService.delete(id);
        if(isDelete){
            return ResponseEntity.status(200).body(new ApiResponse("new article delete successfully"));
        }return ResponseEntity.status(400).body(new ApiResponse("id Not found"));

    }


    @PutMapping("/publish/{id}")
    public ResponseEntity Publish(@PathVariable String id){
    if(newsArticleService.Publish(id))
        return ResponseEntity.status(200).body(new ApiResponse("Published successfully"));
        return ResponseEntity.status(400).body(new ApiResponse("news article by this id not found"));
    }


    @GetMapping("/get-Published")
    public ResponseEntity getAllPublished(){
   if( newsArticleService.getAllPublished()==null)
       return ResponseEntity.status(200).body(new ApiResponse("there is no published news"));
        return ResponseEntity.status(200).body(newsArticleService.getAllPublished());
    }

    @GetMapping("/get-by-category/{category}")
    public ResponseEntity getNewsArticlesByCategory(@PathVariable String category){
        if( newsArticleService.getNewsArticlesByCategory(category)==null){
            return ResponseEntity.status(200).body(new ApiResponse("there is no news in this category"));}
        return ResponseEntity.status(200).body(newsArticleService.getNewsArticlesByCategory(category));
    }





}
