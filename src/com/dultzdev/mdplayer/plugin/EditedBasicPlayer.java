package com.dultzdev.mdplayer.plugin;

import javazoom.jlgui.basicplayer.BasicPlayer;


public class EditedBasicPlayer extends BasicPlayer {
    
    public int getStreamPosition()
    {
        return getEncodedStreamPosition();
    }
}
