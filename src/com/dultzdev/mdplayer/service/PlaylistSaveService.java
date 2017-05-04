package com.dultzdev.mdplayer.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;


public class PlaylistSaveService {
    
    public void savePlaylist(File file, List pathList, int amount) throws FileNotFoundException {
        PrintWriter cleaner = new PrintWriter(file);
        cleaner.print("");
        cleaner.close();
        PrintWriter saver = new PrintWriter(file);
        saver.println("[playlist]");
        for(int i = 1; i <= amount; i++)
        {
            String fileN = "File" + i + "=" + pathList.get(i-1).toString();
            saver.println(fileN);
        }
        saver.println("NumberOfEntries=" + amount);
        saver.println("Version=2");
        saver.close();
    }
}
