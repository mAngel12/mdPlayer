package com.dultzdev.mdplayer.service;

import com.dultzdev.mdplayer.plugin.EditedBasicPlayer;
import java.io.File;
import java.io.PrintStream;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;


public class PlayerService implements BasicPlayerListener {
    
    EditedBasicPlayer player = new EditedBasicPlayer();
    BasicController control = (BasicController) player;

    private boolean endOfSong = false;
    private String title = "No title";
    private String fileType;
    private String author = "No author";
    private int fileBitrate;
    private int fileLengthFrames;
    private long fileSize;
    private float fileDuration;
    private int fileFrameSizeBytes;
    private float fileFrameRatePerSec;
    private float filePosition = (float) player.getStreamPosition();
    private int filePlayFirstBytes;
    private String fileName;
    private String fileLastName;
    private int fileChannels;
    private PrintStream out = null;

    public PlayerService() {
            out = System.out;
    }

    public void play(String filename) {
            player.addBasicPlayerListener(this);
            fileName = filename;
            try
            {	
                if(player.getStatus() == 1 && fileLastName == filename)
                {
                    control.resume();
                }
                else
                {
                    fileLastName = filename;
                    control.stop();
                    control.open(new File(filename));
                    control.play();
                    control.setPan(0.0);
                    filePlayFirstBytes = player.getStreamPosition();
                }
            }
            catch (BasicPlayerException e)
            {
                    e.printStackTrace();
            }
    }

    public void open(String filename) {
        player.addBasicPlayerListener(this);
        fileName = filename;
        try
        {
            control.open(new File(filename));
        }
        catch (BasicPlayerException e)
        {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            control.stop();
        } 
        catch (BasicPlayerException e) 
        {
            e.printStackTrace();
        }
    }

    public void pause() {
        try {
            control.pause();
        }
        catch (BasicPlayerException e)
        {
            e.printStackTrace();
        }
    }
    public void resume() {
        try {
            control.resume();
        }
        catch (BasicPlayerException e)
        {
            e.printStackTrace();
        }
    }
    public void seek(long seekPosition) {
        try {
            control.seek(seekPosition);
        }
        catch (BasicPlayerException e)
        {
            e.printStackTrace();
        }
    }
    public void setVolume(float volume) {
        try
        {
            control.setGain(volume);
        }
        catch (BasicPlayerException e)
        {
            e.printStackTrace();
        }
    }

    public int getStreamPosition() {
        return player.getStreamPosition();
    }

    public float getPosition() {
        filePosition = (float) player.getStreamPosition();
        if(fileType == "MP3")
        {
            if (filePosition == 0 || filePosition == -1 || fileBitrate == 0)
            {
                return 0;
            }
            else
            {
                return (float) (filePosition-filePlayFirstBytes)*8 / (float) fileBitrate;
            }
        }
        if(fileType == "OGG")
        {
            if (filePosition == 0 || filePosition == -1 || fileBitrate == 0)
            {
                return 0;
            }
            else
            {
                return (float) filePosition*8 / (float) fileBitrate;
            }
        }
        if(fileType == "WAVE" || fileType == "AIFF" || fileType == "AU")
        {
            if( fileSize == 0 && fileFrameSizeBytes == 0 && fileFrameRatePerSec ==0)
            {
                return 0;
            }
            else
            {
                return ( (float) filePosition / (float) fileFrameSizeBytes) / (float) fileFrameRatePerSec;
            }
        }
        else
        {
            return 0;
        }
    }

    public int getPositionInSeconds() {
        return (int) getPosition();
    }

    public String getFormatedPosition() {
        if(getPositionInSeconds() >= 60)
        {
            int minutes = (int) getPositionInSeconds()/60;
            int seconds = (int) getPositionInSeconds() - minutes*60;
            if(minutes >= 60)
            {
                int hours = minutes/60;
                minutes = minutes - hours*60;
                if(seconds<10)
                {
                    if(minutes<10)
                    {
                        return Integer.toString(hours) + ":0" + Integer.toString(minutes) + ":0" + Integer.toString(seconds); 
                    }
                    else
                    {
                        return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":0" + Integer.toString(seconds);
                    }
                }
                else
                {
                    if(minutes<10)
                    {
                        return Integer.toString(hours) + ":0" + Integer.toString(minutes) + ":" + Integer.toString(seconds); 
                    }
                    else
                    {
                        return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
                    }
                }
            }
            else
            {
                if(seconds<10)
                {
                    return Integer.toString(minutes) + ":0" + Integer.toString(seconds);
                }
                else
                {
                    return Integer.toString(minutes) + ":" + Integer.toString(seconds);
                }
            }
        }
        else
        {
            if(getPositionInSeconds()<10)
            {
                return "0:0" + getPositionInSeconds();
            }
            else
            {
                return "0:" + getPositionInSeconds();
            }
        }
    }


    public float getDuration() {
        if(fileType == "WAVE" || fileType == "AIFF" || fileType == "AU")
        {
            if(fileSize != 0 && fileFrameSizeBytes !=0 && fileFrameRatePerSec !=0)
            {
                fileDuration = ( (float) fileSize / (float) fileFrameSizeBytes) / (float) fileFrameRatePerSec;
                return fileDuration;
            }
            else
            {
                    return 0;
            }
        }
        if(fileType == "MP3")
        {
            if(fileBitrate != 0)
            {
                fileDuration = ( (float) (fileSize-filePlayFirstBytes)*8 / (float) fileBitrate);
                return fileDuration;
            }
            else 
            {
                    return 0;
            }
        }
        if(fileType == "OGG")
        {
            if(fileBitrate != 0)
            {
                fileDuration = ( (float) fileSize*8 / (float) fileBitrate);
                return fileDuration;
            }
            else 
            {
                    return 0;
            }
        }
        else
        {
            return 0;
        }

    }

    public int getDurationInSeconds() {
        return (int) getDuration();
    }

    public String getFormatedDuration() {
        if(getDurationInSeconds() >= 60)
        {
            int minutes = (int) getDurationInSeconds()/60;
            int seconds = (int) getDurationInSeconds() - minutes*60;
            if(minutes >= 60)
            {
                int hours = minutes/60;
                minutes = minutes - hours*60;
                if(seconds<10)
                {
                    if(minutes<10)
                    {
                        return Integer.toString(hours) + ":0" + Integer.toString(minutes) + ":0" + Integer.toString(seconds); 
                    }
                    else
                    {
                        return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":0" + Integer.toString(seconds);
                    }
                }
                else
                {
                    if(minutes<10)
                    {
                        return Integer.toString(hours) + ":0" + Integer.toString(minutes) + ":" + Integer.toString(seconds); 
                    }
                    else
                    {
                        return Integer.toString(hours) + ":" + Integer.toString(minutes) + ":" + Integer.toString(seconds);
                    }
                }
            }
            else
            {
                if(seconds<10)
                {
                    return Integer.toString(minutes) + ":0" + Integer.toString(seconds);
                }
                else
                {
                    return Integer.toString(minutes) + ":" + Integer.toString(seconds);
                }
            }
        }
        else
        {
            if(getDurationInSeconds()<10)
            {
                return "0:0" + getDurationInSeconds();
            }
            else
            {
                return "0:" + getDurationInSeconds();
            }
        }
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getFileType() {
        return fileType;
    }

    public int getFilePlayFirstBytes() {
        return filePlayFirstBytes;
    }

    public long getFileSize() {
        return (long) fileSize;
    }

    public int getBitrate() {
        if(fileType == "MP3" || fileType == "OGG")
        {
            return fileBitrate;
        }
        else 
        {
            return 0;
        }
    }

    public int getFileFrameSizeBytes() {
        if(fileType == "WAVE")
        {
            return fileFrameSizeBytes;
        }
        else
        {
            return 0;
        }
    }

    public float getFileFrameRatePerSec() {
        if(fileType == "WAVE")
        {
            return fileFrameRatePerSec;
        }
        else
        {
            return 0;
        }
    }

    public String getPlaybackInfo() {
        String playbackInfo = "";
        if(fileChannels == 1)
        {
            playbackInfo = "MONO";
        }
        else if (fileChannels == 2)
        {
            playbackInfo = "STEREO";
        }
        return playbackInfo;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean getEndOfSong() {
        return endOfSong;
    }

    public void setEndOfSong(boolean endOfSong) {
        this.endOfSong = endOfSong;
    }

    public void opened(Object stream, Map properties) {
        File file = new File(fileName);

        author = properties.getOrDefault("author", "No author").toString();
        if (author == null)
        {
            author = "No author";
        }
        title = properties.getOrDefault("title", file.getName()).toString();
        if (title == null)
        {
            title = file.getName();
        }

        fileType = properties.get("audio.type").toString();
        fileSize = Integer.parseInt(properties.get("audio.length.bytes").toString());
        fileChannels = Integer.parseInt(properties.get("audio.channels").toString());

        if(fileType == "WAVE" || fileType == "AIFF" || fileType == "AU")
        {
            fileLengthFrames = Integer.parseInt(properties.get("audio.length.frames").toString());
            fileFrameSizeBytes = Integer.parseInt(properties.get("audio.framesize.bytes").toString());
            fileFrameRatePerSec = Float.parseFloat(properties.get("audio.framerate.fps").toString());
        }
        if(fileType == "OGG" || fileType == "MP3")
        {
            fileBitrate = Integer.parseInt(properties.get("bitrate").toString());
        }		
    }

    public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) { 
    }

    public void stateUpdated(BasicPlayerEvent event) {
            if(event.toString().contains("EOM"))
            {
                setEndOfSong(true);
            }
    }

    public void setController(BasicController controller) { 
    }

    public void display(String msg) {
            if (out != null) out.println(msg);
    }

}
