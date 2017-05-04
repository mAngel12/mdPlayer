package com.dultzdev.mdplayer.service;

import com.dultzdev.mdplayer.model.Song;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class PlaylistOpenService {
    
    public int numberOfEntries(File file) throws IOException {
        
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();
        String numberString = null;
        int number = 0;
        do {
            if(textLine.contains("NumberOfEntries=")) {
                for(int i = 0; i<textLine.length(); i++) {
                    char c = textLine.charAt(i);
                    if (c == '=') {
                        numberString = textLine.substring( i+1, textLine.length() );
                        i = textLine.length();
                    }
                }            
            }
        textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();
        number = Integer.parseInt(numberString);
        return number;
    }
    public String openPlaylistAndReturnOneElementToString(File file, int index) throws IOException {
        
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();
        String filePath = null;
        String finalTitle = null;
        do {
            String fileText = "File" + index;
            if(textLine.contains(fileText))
            {
                for(int i = 0; i<textLine.length(); i++)
                {
                    char c = textLine.charAt(i);
                    if (c == '=')
                    {
                        filePath = textLine.substring( i+1, textLine.length() );
                        i = textLine.length();
                    }
                        
                }
                File mfile = new File(filePath);
                PlaylistService playlist = new PlaylistService(filePath); 
                if(playlist.getFileType() != "WAVE" && playlist.getFileType() != "AIFF" && playlist.getFileType() != "AU")
                {
                    finalTitle = index + ". " + playlist.getAuthorAndTitle(); 
                }
                else
                {
                    finalTitle = index + ". " + mfile.getName();
                }
            }    
        textLine = bufferedReader.readLine();
        } while(textLine != null);

        bufferedReader.close();

        return finalTitle;
    }
    
    public Song openPlaylistAndReturnOneElementToSong(File file, int index) throws IOException {
        
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Song song = new Song();
        String textLine = bufferedReader.readLine();
        String filePath = null;
        do {
            if(textLine.contains("File" + index))
            {
                for(int i = 5; i<textLine.length(); i++)
                {
                    char c = textLine.charAt(i);
                    if (c == '=')
                    {
                        filePath = textLine.substring( i+1, textLine.length() );
                    }
                        
                }
                File mfile = new File(filePath);
                PlaylistService playlist = new PlaylistService(filePath); 
                if(playlist.getFileType() != "WAVE" && playlist.getFileType() != "AIFF" && playlist.getFileType() != "AU")
                {
                    song.setTitle(playlist.getTitle());
                    song.setAuthor(playlist.getAuthor());
                    song.setType(playlist.getFileType());
                    song.setPath(filePath.toString());
                }
                else
                {
                    song.setTitle(mfile.getName());
                    song.setType(playlist.getFileType());
                    song.setPath(filePath.toString());
                }
            }
            textLine = bufferedReader.readLine();
        } while(textLine != null);
        
        bufferedReader.close();

        return song;
    }      
}
