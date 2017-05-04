package com.dultzdev.mdplayer.model;

import java.io.File;

public class Song {
    
    private String title;
    private String author;
    private String path;
    private String type;
    
    public Song() {
    }
    
    public Song(String title, String author, String path, String type) {
        this.title = title;
        this.author = author;
        this.path = path;
        this.type = type;
    }
    
    public String getAuthorAndTitle() {
        
        String authorAndTitle = author + " - " + title;
        if(author == "No author")
        {
            return title;
        }
        else if(authorAndTitle.length() < 4)
        {
            File file = new File(path);
            return file.getName();
        }
        else
        {
            return author + " - " + title;
        }
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public String getPath() {
        return path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}