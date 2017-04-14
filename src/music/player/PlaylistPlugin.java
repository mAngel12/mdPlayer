package music.player;

import java.io.File;


public class PlaylistPlugin {
    AudioPlugin playlist = new AudioPlugin();
    
    public PlaylistPlugin(String PathToFile){ 
        playlist.open(PathToFile);
    }
    
    public String getAuthor()
    {
        String author = playlist.getAuthor();
        return author;
    }
    
    public String getTitle()
    {
        String title = playlist.getTitle();
        return title;
    }
    
    public String getAuthorAndTitle()
    {
        String elementAuthorAndTitle = playlist.getAuthor() + " - " + playlist.getTitle();
        if(playlist.getAuthor() == "No author")
        {
            return playlist.getTitle();
        }
        else if(elementAuthorAndTitle.length() < 4)
        {
            File file = new File(playlist.getFileName());
            return file.getName();
        }
        else
        {
            return playlist.getAuthor() + " - " + playlist.getTitle();
        }

    }
    
    public String getFileType()
    {
        return playlist.getFileType();
    }
    
    public String getFormatedDuration()
    {
        return playlist.getFormatedDuration();
    }
}

class PlaylistElement {
    
    public PlaylistElement()
    {
        
    }
    public PlaylistElement(String Title, String Author, String Path, String Type)
    {
        elementTitle = Title;
        elementAuthor = Author;
        elementPath = Path;
        elementType = Type;
    }
    public String elementTitle;
    public String elementAuthor;
    public String elementPath;
    public String elementType;
    
    public String getElementAuthorAndTitle()
    {
        String elementAuthorAndTitle = elementAuthor + " - " + elementTitle;
        if(elementAuthor == "No author")
        {
            return elementTitle;
        }
        else if(elementAuthorAndTitle.length() < 4)
        {
            File file = new File(elementPath);
            return file.getName();
        }
        else
        {
            return elementAuthor + " - " + elementTitle;
        }
    }
}