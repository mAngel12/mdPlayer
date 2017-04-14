package music.player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class PlsFormatPlugin {
    
    public PlsFormatPlugin()
    {
        
    }
    
    public int numberOfEntries(File file) throws IOException
    {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String textLine = bufferedReader.readLine();
        String numberString = null;
        int number = 0;
        do {
            if(textLine.contains("NumberOfEntries="))
            {
                for(int i = 0; i<textLine.length(); i++)
                {
                    char c = textLine.charAt(i);
                    if (c == '=')
                    {
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
    public String openPlaylist_returnLM(File file, int index) throws IOException
    {
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
                PlaylistPlugin playlist = new PlaylistPlugin(filePath); 
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
    
    public PlaylistElement openPlaylist_returnPE(File file, int index) throws IOException
    {
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PlaylistElement playlistElement = new PlaylistElement();
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
                PlaylistPlugin playlist = new PlaylistPlugin(filePath); 
                if(playlist.getFileType() != "WAVE" && playlist.getFileType() != "AIFF" && playlist.getFileType() != "AU")
                {
                    playlistElement.elementTitle = playlist.getTitle();
                    playlistElement.elementAuthor = playlist.getAuthor();
                    playlistElement.elementType = playlist.getFileType();
                    playlistElement.elementPath = filePath.toString();
                }
                else
                {
                    playlistElement.elementTitle = mfile.getName();
                    playlistElement.elementType = playlist.getFileType();
                    playlistElement.elementPath = filePath.toString();
                }
            }
            textLine = bufferedReader.readLine();
        } while(textLine != null);
        
        bufferedReader.close();

        return playlistElement;
    }      
    public void savePlaylist(File file, List pathList, int amount) throws FileNotFoundException
    {
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
    

