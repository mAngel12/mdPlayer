package com.dultzdev.mdplayer.service;

import com.dultzdev.mdplayer.service.PlayerService;
import java.io.File;


public class PlaylistService {
    
    PlayerService playerService = new PlayerService();
    
    public PlaylistService(String PathToFile) { 
        playerService.open(PathToFile);
    }
    
    public String getAuthor() {
        return playerService.getAuthor();
    }
    
    public String getTitle() {
        return playerService.getTitle();
    }
    
    public String getAuthorAndTitle() {
        String elementAuthorAndTitle = playerService.getAuthor() + " - " + playerService.getTitle();
        if(playerService.getAuthor() == "No author")
        {
            return playerService.getTitle();
        }
        else if(elementAuthorAndTitle.length() < 4)
        {
            File file = new File(playerService.getFileName());
            return file.getName();
        }
        else
        {
            return playerService.getAuthor() + " - " + playerService.getTitle();
        }

    }
    
    public String getFileType() {
        return playerService.getFileType();
    }
    
    public String getFormatedDuration() {
        return playerService.getFormatedDuration();
    }
}