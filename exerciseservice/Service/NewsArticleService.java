package com.example.exerciseservice.Service;

import com.example.exerciseservice.Model.NewsArticle;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle>newsArticles=new ArrayList<>();

    public ArrayList<NewsArticle> getNewsArticles(){
        return newsArticles;
    }

    public void addNewsArticles(NewsArticle newsArticle){
        newsArticles.add(newsArticle);
    }

    public boolean update(String id, NewsArticle newsArticle){
        for (int i = 0; i < newsArticles.size(); i++) {
            if(newsArticles.get(i).getID().equals(id)){
                newsArticles.set(i,newsArticle);
                        return true;
            }
        }

        return false;
    }


    public boolean delete(String id){
        for (int i = 0; i <newsArticles.size() ; i++) {
            if(newsArticles.get(i).getID().equals(id)){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean Publish(String id){
        for (int i = 0; i <newsArticles.size() ; i++) {
            if(newsArticles.get(i).getID().equals(id)){
                newsArticles.get(i).setPublished(true);
                return true;
            }
        }
        return false;
    }


    public ArrayList<NewsArticle> getAllPublished(){
        ArrayList<NewsArticle> Published=new ArrayList<>();
        for (int i = 0; i <newsArticles.size() ; i++) {
            if(newsArticles.get(i).isPublished()){
                Published.add(newsArticles.get(i));
            }
        }
        if(Published.size()==0)return null;
        return Published;
    }


    public ArrayList<NewsArticle> getNewsArticlesByCategory(String category ){
        ArrayList<NewsArticle>byCategory=new ArrayList<>();
        for (int i = 0; i <newsArticles.size() ; i++) {
            if(newsArticles.get(i).getCategory().equalsIgnoreCase(category)){
                byCategory.add(newsArticles.get(i));
            }
        }
        if(byCategory.size()==0)return null;
        return byCategory;
    }










}
