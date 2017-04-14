package music.player;


import javazoom.jlgui.basicplayer.BasicPlayer;


public class myBasicPlayer extends BasicPlayer {
    
    public int getStreamPosition()
    {
        return getEncodedStreamPosition();
    }
}
