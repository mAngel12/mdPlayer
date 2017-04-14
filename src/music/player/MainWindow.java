package music.player;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        setIcon();
        class RefreshGUITimer extends TimerTask {
            @Override
            public void run() {
                if(usedPlayFunction == true)
                {
                    if(newListWindow.playlistFileAmount == 0)
                    {
                        TitleTextField.setText("No Author - No Title");
                    }
                    else if(player.getFileType() != "WAVE" && player.getFileType() != "AIFF" && player.getFileType() != "AU")
                    {
                        TitleTextField.setText(newListWindow.playlistElements[actualPlaylistIndex].getElementAuthorAndTitle());
                    }
                    else
                    {
                        TitleTextField.setText(newListWindow.playlistElements[actualPlaylistIndex].elementTitle);
                    }
                    usedPlayFunction = false;
                }
                TimeTextField.setText(player.getFormatedPosition() + " / " + player.getFormatedDuration());
                PlaybackTextField.setText(player.getPlaybackInfo());
                TypeTextField.setText(player.getFileType());
                
                
                if (!userUseSlider && FileSlider.getValueIsAdjusting()) {
                    timerUpdateSlider = true;
                    try {
                        FileSlider.setValue(player.getSecPosition());  
                    }
                    finally {
                        timerUpdateSlider = false;
                    }
                }
                if (newListWindow.doubleClickChoose)
                {
                    player.play(newListWindow.playlistElements[newListWindow.doubleClickChooseIndex].elementPath);
                    actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                    FileSlider.setValueIsAdjusting(true);
                    FileSlider.setMaximum(player.getSecDuration());
                    newListWindow.doubleClickChoose = false;
                    usedPlayFunction = true;
                }
                if (player.endOfMusic)
                {
                    if(repeatMode)
                    {
                        newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
                        player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                        actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                        FileSlider.setValueIsAdjusting(true);
                        FileSlider.setMaximum(player.getSecDuration());
                        player.endOfMusic = false;
                        usedPlayFunction = true;
                    }
                    else if(randomMode)
                    {
                        Random randomGenerator = new Random();
                        newListWindow.PlaylistList.setSelectedIndex(randomGenerator.nextInt(newListWindow.playlistFileAmount-1));
                        player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                        actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                        FileSlider.setValueIsAdjusting(true);
                        FileSlider.setMaximum(player.getSecDuration());
                        player.endOfMusic = false;
                        usedPlayFunction = true;
                    }
                    else
                    {
                        if(actualPlaylistIndex+1 < newListWindow.playlistFileAmount)
                        {
                            actualPlaylistIndex = actualPlaylistIndex+1;
                            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
                            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                            FileSlider.setValueIsAdjusting(true);
                            FileSlider.setMaximum(player.getSecDuration());
                            player.endOfMusic = false;
                            usedPlayFunction = true;
                        }
                        else
                        { 
                            actualPlaylistIndex = 0;
                            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
                            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                            FileSlider.setValueIsAdjusting(true);
                            FileSlider.setMaximum(player.getSecDuration());
                            player.endOfMusic = false;
                            usedPlayFunction = true;
                        }
                    }
                }
            }
        }  
        Timer RefreshTimer = new Timer();
        RefreshGUITimer RefreshTimerTask = new RefreshGUITimer();
        RefreshTimer.schedule(RefreshTimerTask, 0, 250);
   
    }
    int VolumeMemory = 100;
    int actualPlaylistIndex;
    boolean userUseSlider = false;
    boolean timerUpdateSlider = true;
    boolean repeatMode = false;
    boolean randomMode = false;
    boolean usedPlayFunction = false;
    AudioPlugin player = new AudioPlugin();
    public ListWindow newListWindow = new ListWindow(this);
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileSlider = new javax.swing.JSlider();
        VolumeSlider = new javax.swing.JSlider();
        BackButton = new javax.swing.JButton();
        PlayButton = new javax.swing.JButton();
        PauseButton = new javax.swing.JButton();
        StopButton = new javax.swing.JButton();
        NextButton = new javax.swing.JButton();
        PlayListButton = new javax.swing.JButton();
        RepeatCheckBox = new javax.swing.JCheckBox();
        RandomCheckBox = new javax.swing.JCheckBox();
        MuteCheckBox = new javax.swing.JCheckBox();
        VolumeLabel = new javax.swing.JLabel();
        TimeTextField = new javax.swing.JTextField();
        TitleTextField = new javax.swing.JTextField();
        PlaybackLabel = new javax.swing.JLabel();
        TypeLabel = new javax.swing.JLabel();
        PlaybackTextField = new javax.swing.JTextField();
        TypeTextField = new javax.swing.JTextField();
        MainMenuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu FileMenu = new javax.swing.JMenu();
        PlayFileMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        OpenPlaylistMenuItem = new javax.swing.JMenuItem();
        SavePlaylistMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        ExitMenuItem = new javax.swing.JMenuItem();
        PlayMenu = new javax.swing.JMenu();
        PreviousMenuItem = new javax.swing.JMenuItem();
        PlayMenuItem = new javax.swing.JMenuItem();
        PauseMenuItem = new javax.swing.JMenuItem();
        StopMenuItem = new javax.swing.JMenuItem();
        NextMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        VolumeUpMenuItem = new javax.swing.JMenuItem();
        VolumeDownMenuItem = new javax.swing.JMenuItem();
        OptionsMenu = new javax.swing.JMenu();
        PlaylistPanelMenuItem = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        RepeatCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        RandomCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MuteCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("mdPlayer");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.black);
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(459, 178));

        FileSlider.setValue(0);
        FileSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                FileSliderStateChanged(evt);
            }
        });

        VolumeSlider.setValue(100);
        VolumeSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                VolumeSliderStateChanged(evt);
            }
        });

        BackButton.setText("<<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        PlayButton.setText("Play");
        PlayButton.setToolTipText("");
        PlayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtonActionPerformed(evt);
            }
        });

        PauseButton.setText("Pause");
        PauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseButtonActionPerformed(evt);
            }
        });

        StopButton.setText("Stop");
        StopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopButtonActionPerformed(evt);
            }
        });

        NextButton.setText(">>");
        NextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextButtonActionPerformed(evt);
            }
        });

        PlayListButton.setText("PlayList");
        PlayListButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayListButtonActionPerformed(evt);
            }
        });

        RepeatCheckBox.setText("Repeat");
        RepeatCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepeatCheckBoxActionPerformed(evt);
            }
        });

        RandomCheckBox.setText("Random");
        RandomCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        RandomCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomCheckBoxActionPerformed(evt);
            }
        });

        MuteCheckBox.setText("Mute");
        MuteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuteCheckBoxActionPerformed(evt);
            }
        });

        VolumeLabel.setText("Volume");

        TimeTextField.setEditable(false);
        TimeTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TimeTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TimeTextField.setText(Integer.toString(player.getSecPosition()));
        TimeTextField.setFocusTraversalPolicyProvider(true);

        TitleTextField.setEditable(false);
        TitleTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TitleTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TitleTextField.setText("No Author - No Title");
        TitleTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PlaybackLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        PlaybackLabel.setText("Playback:");

        TypeLabel.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        TypeLabel.setText("Type:");

        PlaybackTextField.setEditable(false);

        TypeTextField.setEditable(false);

        FileMenu.setText("File");
        FileMenu.setToolTipText("");

        PlayFileMenuItem.setText("Play file ...");
        PlayFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayFileMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(PlayFileMenuItem);
        FileMenu.add(jSeparator1);

        OpenPlaylistMenuItem.setText("Open Playlist");
        OpenPlaylistMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenPlaylistMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenPlaylistMenuItem);

        SavePlaylistMenuItem.setText("Save Playlist");
        SavePlaylistMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePlaylistMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(SavePlaylistMenuItem);
        FileMenu.add(jSeparator2);

        ExitMenuItem.setText("Exit");
        ExitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(ExitMenuItem);

        MainMenuBar.add(FileMenu);

        PlayMenu.setText("Play");

        PreviousMenuItem.setText("Previous");
        PreviousMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PreviousMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(PreviousMenuItem);

        PlayMenuItem.setText("Play");
        PlayMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(PlayMenuItem);

        PauseMenuItem.setText("Pause");
        PauseMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(PauseMenuItem);

        StopMenuItem.setText("Stop");
        StopMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(StopMenuItem);

        NextMenuItem.setText("Next");
        NextMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(NextMenuItem);
        PlayMenu.add(jSeparator3);

        VolumeUpMenuItem.setText("Volume Up");
        VolumeUpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolumeUpMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(VolumeUpMenuItem);

        VolumeDownMenuItem.setText("Volume Down");
        VolumeDownMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolumeDownMenuItemActionPerformed(evt);
            }
        });
        PlayMenu.add(VolumeDownMenuItem);

        MainMenuBar.add(PlayMenu);

        OptionsMenu.setText("Options");

        PlaylistPanelMenuItem.setText("Playlist Panel");
        PlaylistPanelMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaylistPanelMenuItemActionPerformed(evt);
            }
        });
        OptionsMenu.add(PlaylistPanelMenuItem);
        OptionsMenu.add(jSeparator5);

        RepeatCheckBoxMenuItem.setText("Repeat mode");
        RepeatCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RepeatCheckBoxMenuItemActionPerformed(evt);
            }
        });
        OptionsMenu.add(RepeatCheckBoxMenuItem);

        RandomCheckBoxMenuItem.setText("Random mode");
        RandomCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RandomCheckBoxMenuItemActionPerformed(evt);
            }
        });
        OptionsMenu.add(RandomCheckBoxMenuItem);
        OptionsMenu.add(jSeparator4);

        MuteCheckBoxMenuItem.setText("Mute");
        MuteCheckBoxMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MuteCheckBoxMenuItemActionPerformed(evt);
            }
        });
        OptionsMenu.add(MuteCheckBoxMenuItem);

        MainMenuBar.add(OptionsMenu);

        HelpMenu.setText("Help");

        AboutMenuItem.setText("About Player");
        AboutMenuItem.setToolTipText("");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenuItem);

        MainMenuBar.add(HelpMenu);

        setJMenuBar(MainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(BackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(StopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NextButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(TitleTextField)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(TimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PlaybackLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PlaybackTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TypeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PlayListButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VolumeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(2, 2, 2)))
                        .addComponent(MuteCheckBox))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(FileSlider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RepeatCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(RandomCheckBox)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlayListButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PlaybackLabel)
                            .addComponent(TypeLabel)
                            .addComponent(PlaybackTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addComponent(TitleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(RepeatCheckBox)
                        .addComponent(RandomCheckBox))
                    .addComponent(FileSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BackButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PlayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PauseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(StopButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(VolumeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(VolumeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(MuteCheckBox))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void RepeatCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepeatCheckBoxActionPerformed
        if(RepeatCheckBox.isSelected())
        {
            repeatMode = true;
            randomMode = false;
            RepeatCheckBox.setSelected(true);
            RandomCheckBox.setSelected(false);
            RandomCheckBoxMenuItem.setSelected(false);
        }
        else if(!RepeatCheckBox.isSelected())
        {
            repeatMode = false;
            RepeatCheckBoxMenuItem.setSelected(false);
        }
    }//GEN-LAST:event_RepeatCheckBoxActionPerformed

    private void MuteCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuteCheckBoxActionPerformed
        if(MuteCheckBox.isSelected())
        {
            VolumeMemory = VolumeSlider.getValue();
            VolumeSlider.setValue(0);
            MuteCheckBoxMenuItem.setSelected(true);
        }
        else if(!MuteCheckBox.isSelected())
        {
            VolumeSlider.setValue(VolumeMemory);
            MuteCheckBoxMenuItem.setSelected(false);
        }
    }//GEN-LAST:event_MuteCheckBoxActionPerformed

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if(actualPlaylistIndex > 0)
        {
            actualPlaylistIndex = actualPlaylistIndex-1;
            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
    }//GEN-LAST:event_BackButtonActionPerformed

    private void PauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseButtonActionPerformed
        player.pause();    
    }//GEN-LAST:event_PauseButtonActionPerformed

    private void NextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextButtonActionPerformed
        if(actualPlaylistIndex+1 < newListWindow.playlistFileAmount)
        {
            actualPlaylistIndex = actualPlaylistIndex+1;
            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
    }//GEN-LAST:event_NextButtonActionPerformed

    private void PlayListButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayListButtonActionPerformed
        if(!newListWindow.isVisible()) {
            newListWindow.setVisible(true);
        }
        else if(newListWindow.isVisible()) {
            newListWindow.dispose();
        }
    }//GEN-LAST:event_PlayListButtonActionPerformed

    private void PlayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtonActionPerformed
        if(newListWindow.PlaylistList.getSelectedIndex() >= 0)
        {
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
        else
        {   
            if(newListWindow.playlistFileAmount == 0)
            { 
                usedPlayFunction = true;
            }
            else
            {
                newListWindow.PlaylistList.setSelectedIndex(0);
                player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                FileSlider.setValueIsAdjusting(true);
                FileSlider.setMaximum(player.getSecDuration());
                usedPlayFunction = true;
            }
        }  
    }//GEN-LAST:event_PlayButtonActionPerformed

    private void StopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopButtonActionPerformed
        player.stop();
    }//GEN-LAST:event_StopButtonActionPerformed

    private void FileSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_FileSliderStateChanged
        
        if(player.getFileType() == "MP3" || player.getFileType() == "WAVE")
        {
            long filePositionBytes = 0;
            if(!userUseSlider && !FileSlider.getValueIsAdjusting())
            {
                userUseSlider = true;
                try {
                    if(player.getFileType() == "MP3")
                    {
                        filePositionBytes = (FileSlider.getValue()*player.getBitrate())/8+player.getFilePlayFirstBytes();
                    }
                    else if(player.getFileType() == "WAVE")
                    {
                        filePositionBytes = (long) (FileSlider.getValue()*player.getFileFrameSizeBytes()*player.getFileFrameRatePerSec());
                    }
                    else
                    {
                        filePositionBytes = 0;
                    }
                }
                finally {
                    player.seek(filePositionBytes);
                    userUseSlider = false;
                    FileSlider.setValueIsAdjusting(true);
                }
            }
        }
        else
        {
            userUseSlider = false;
            FileSlider.setValueIsAdjusting(true);
        }
    }//GEN-LAST:event_FileSliderStateChanged

    private void VolumeSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_VolumeSliderStateChanged
        player.setVolume((float) VolumeSlider.getValue()/200);
    }//GEN-LAST:event_VolumeSliderStateChanged

    private void RandomCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomCheckBoxActionPerformed
        if(RandomCheckBox.isSelected())
        {
            randomMode = true;
            repeatMode = false;
            RandomCheckBoxMenuItem.setSelected(true);
            RepeatCheckBox.setSelected(false);
            RepeatCheckBoxMenuItem.setSelected(false);
        }
        else if(!RandomCheckBox.isSelected())
        {
            randomMode = false;
            RandomCheckBoxMenuItem.setSelected(false);
        }
    }//GEN-LAST:event_RandomCheckBoxActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "mdPlayer is a simple music player written in Java using BasicPlayer API.\n"
            + "Copyright © 2017 DultzDev.\n"
            + "mdPlayer v0.1\n"
            + "Visit www.dultzdev.com for updates and more informations.\n", "About mdPlayer",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void PlayFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayFileMenuItemActionPerformed
                
        JFileChooser addFileChooser = new JFileChooser(newListWindow.lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterAllMusic = new FileNameExtensionFilter("Music Files (.mp3, .ogg, .oga, .wav, .aiff, .au)", "mp3", "ogg", "oga", "wav", "aiff", "au");
        FileNameExtensionFilter filterMP3 = new FileNameExtensionFilter("MPEG-1/MPEG-2 Audio Layer 3 Files (.mp3) ", "mp3");
        FileNameExtensionFilter filterOGG = new FileNameExtensionFilter("Audio Ogg Files (.ogg, .oga)", "ogg", "oga");
        FileNameExtensionFilter filterWAVE = new FileNameExtensionFilter("WAVE form audio format Files (.wav)", "wav");
        FileNameExtensionFilter filterAIFF = new FileNameExtensionFilter("Audio Interchange File Format Files (.aiff)", "aiff");
        FileNameExtensionFilter filterAU = new FileNameExtensionFilter("AU Files (.au)", "au");
        addFileChooser.addChoosableFileFilter(filterAllMusic);
        addFileChooser.addChoosableFileFilter(filterMP3);
        addFileChooser.addChoosableFileFilter(filterWAVE);
        addFileChooser.addChoosableFileFilter(filterOGG);
        addFileChooser.addChoosableFileFilter(filterAIFF);
        addFileChooser.addChoosableFileFilter(filterAU);
 
        int fileResult = addFileChooser.showOpenDialog(this);
        if (fileResult == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = addFileChooser.getSelectedFile();
            String selectedFilePath = selectedFile.getPath();
            newListWindow.lastParentPath = selectedFile.getParent();
            PlaylistPlugin playlistPlugin = new PlaylistPlugin(selectedFilePath);
            if(playlistPlugin.getFileType() != "WAVE" && playlistPlugin.getFileType() != "AIFF" && playlistPlugin.getFileType() != "AU")
            {
                String elementTitle = playlistPlugin.getTitle();
                String elementAuthor = playlistPlugin.getAuthor();
                String elementAuthorAndTitle = playlistPlugin.getAuthorAndTitle();
                String elementType = playlistPlugin.getFileType();
                newListWindow.playlistFileAmount = newListWindow.playlistFileAmount + 1;
                newListWindow.playlistElements[newListWindow.playlistFileAmount-1] = new PlaylistElement(elementTitle, elementAuthor, selectedFilePath, elementType);
                newListWindow.listModel.addElement(newListWindow.playlistFileAmount + ". " + elementAuthorAndTitle);
            }
            else
            {
                newListWindow.selectedFileName = selectedFile.getName();
                String elementType = playlistPlugin.getFileType();
                newListWindow.playlistFileAmount = newListWindow.playlistFileAmount + 1;
                newListWindow.playlistElements[newListWindow.playlistFileAmount-1] = new PlaylistElement(newListWindow.selectedFileName, "", selectedFilePath, elementType);
                newListWindow.listModel.addElement(newListWindow.playlistFileAmount + ". " + newListWindow.selectedFileName);
            }         
        newListWindow.PlaylistList.setSelectedIndex(newListWindow.playlistFileAmount-1);
        player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
        actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
        FileSlider.setValueIsAdjusting(true);
        FileSlider.setMaximum(player.getSecDuration());
        usedPlayFunction = true;
        }
        
        newListWindow.AutoSaveDefaultPlaylist();

    }//GEN-LAST:event_PlayFileMenuItemActionPerformed

    private void OpenPlaylistMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenPlaylistMenuItemActionPerformed
        JFileChooser addFileChooser = new JFileChooser(newListWindow.lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterPlaylist = new FileNameExtensionFilter("PLS Playlist File Format (.pls)", "pls");
        addFileChooser.addChoosableFileFilter(filterPlaylist);
 
        int fileResult = addFileChooser.showOpenDialog(this);
        if (fileResult == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = addFileChooser.getSelectedFile();
            newListWindow.lastParentPath = selectedFile.getParent();
            PlsFormatPlugin openPlaylist = new PlsFormatPlugin();
            newListWindow.listModel.removeAllElements();
            int numberOfEntries;
            try {
                numberOfEntries = openPlaylist.numberOfEntries(selectedFile);
                for(int i=newListWindow.playlistFileAmount; i<numberOfEntries; i++)
                {
                    newListWindow.playlistElements[i] = new PlaylistElement();
                }
                newListWindow.playlistFileAmount = 0;
                for(int i=1; i<=numberOfEntries; i++)
                {
                   newListWindow.listModel.addElement(openPlaylist.openPlaylist_returnLM(selectedFile, i));
                   newListWindow.playlistElements[i-1] = openPlaylist.openPlaylist_returnPE(selectedFile, i);
                   newListWindow.playlistFileAmount = newListWindow.playlistFileAmount + 1;
                }
            } catch (IOException ex) {
            }
        }
    }//GEN-LAST:event_OpenPlaylistMenuItemActionPerformed

    private void SavePlaylistMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePlaylistMenuItemActionPerformed
        List<String> pathList = new ArrayList<String>();
        for(int i=0; i<newListWindow.playlistFileAmount; i++)
        {
            pathList.add(newListWindow.playlistElements[i].elementPath);
        }
        JFileChooser saveFileChooser = new JFileChooser(newListWindow.lastParentPath);
        saveFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterPLS = new FileNameExtensionFilter("Playlist File Format (.pls)", "pls");
        saveFileChooser.addChoosableFileFilter(filterPLS);
        int fileResult = saveFileChooser.showSaveDialog(this);
        if (fileResult == JFileChooser.APPROVE_OPTION) 
        {
            String filename = saveFileChooser.getSelectedFile().toString();
            if (!filename .endsWith(".pls"))
            {
                filename += ".pls";
            }
            File file = new File(filename);
            newListWindow.lastParentPath = file.getParent();
            PlsFormatPlugin savePlaylist = new PlsFormatPlugin();
            try {
                savePlaylist.savePlaylist(file, pathList, newListWindow.playlistFileAmount);
            } catch (FileNotFoundException ex) {
            }
        }
    }//GEN-LAST:event_SavePlaylistMenuItemActionPerformed

    private void ExitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_ExitMenuItemActionPerformed

    private void PreviousMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PreviousMenuItemActionPerformed
        if(actualPlaylistIndex > 0)
        {
            actualPlaylistIndex = actualPlaylistIndex-1;
            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
    }//GEN-LAST:event_PreviousMenuItemActionPerformed

    private void PlayMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayMenuItemActionPerformed
        if(newListWindow.PlaylistList.getSelectedIndex() >= 0)
        {
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
        else
        {   
            if(newListWindow.playlistFileAmount == 0)
            { 
                usedPlayFunction = true;
            }
            else
            {
                newListWindow.PlaylistList.setSelectedIndex(0);
                player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
                actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
                FileSlider.setValueIsAdjusting(true);
                FileSlider.setMaximum(player.getSecDuration());
                usedPlayFunction = true;
            }
        }
    }//GEN-LAST:event_PlayMenuItemActionPerformed

    private void PauseMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseMenuItemActionPerformed
        player.pause();
        
        for(int i=0; i<newListWindow.playlistFileAmount; i++)
        {
            System.out.println(newListWindow.playlistElements[i].elementAuthor);
            System.out.println(newListWindow.playlistElements[i].elementPath);
            System.out.println(newListWindow.playlistElements[i].elementTitle);
            System.out.println(newListWindow.playlistElements[i].elementType);
            
        }
        
    }//GEN-LAST:event_PauseMenuItemActionPerformed

    private void StopMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopMenuItemActionPerformed
        player.stop();
    }//GEN-LAST:event_StopMenuItemActionPerformed

    private void NextMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NextMenuItemActionPerformed
        if(actualPlaylistIndex+1 < newListWindow.playlistFileAmount)
        {
            actualPlaylistIndex = actualPlaylistIndex+1;
            newListWindow.PlaylistList.setSelectedIndex(actualPlaylistIndex);
            player.play(newListWindow.playlistElements[newListWindow.PlaylistList.getSelectedIndex()].elementPath);
            actualPlaylistIndex = newListWindow.PlaylistList.getSelectedIndex();
            FileSlider.setValueIsAdjusting(true);
            FileSlider.setMaximum(player.getSecDuration());
            usedPlayFunction = true;
        }
    }//GEN-LAST:event_NextMenuItemActionPerformed

    private void VolumeUpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolumeUpMenuItemActionPerformed
        if((float) VolumeSlider.getValue()/200 <= 0.45)
        {
            player.setVolume((float) ((float) VolumeSlider.getValue()/200 + 0.05));
            VolumeSlider.setValue(VolumeSlider.getValue()+10);
        }
        else
        {
            player.setVolume((float) 0.5);
            VolumeSlider.setValue(100);
        }
    }//GEN-LAST:event_VolumeUpMenuItemActionPerformed

    private void VolumeDownMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolumeDownMenuItemActionPerformed
        if((float) VolumeSlider.getValue()/200 >= 0.05)
        {
            player.setVolume((float) ((float) VolumeSlider.getValue()/200 - 0.05));
            VolumeSlider.setValue(VolumeSlider.getValue()-10);
        }
        else
        {
            player.setVolume((float) 0.0);
            VolumeSlider.setValue(0);
        }
    }//GEN-LAST:event_VolumeDownMenuItemActionPerformed

    private void PlaylistPanelMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaylistPanelMenuItemActionPerformed
        if(!newListWindow.isVisible()) {
            newListWindow.setVisible(true);
        }
        else if(newListWindow.isVisible()) {
            newListWindow.dispose();
        }
    }//GEN-LAST:event_PlaylistPanelMenuItemActionPerformed

    private void RepeatCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RepeatCheckBoxMenuItemActionPerformed
        if(RepeatCheckBoxMenuItem.isSelected())
        {
            repeatMode = true;
            randomMode = false;
            RepeatCheckBox.setSelected(true);
            RandomCheckBox.setSelected(false);
            RandomCheckBoxMenuItem.setSelected(false);
        }
        else if(!RepeatCheckBoxMenuItem.isSelected())
        {
            repeatMode = false;
            RepeatCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_RepeatCheckBoxMenuItemActionPerformed

    private void RandomCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RandomCheckBoxMenuItemActionPerformed
        if(RandomCheckBoxMenuItem.isSelected())
        {
            randomMode = true;
            repeatMode = false;
            RandomCheckBox.setSelected(true);
            RepeatCheckBox.setSelected(false);
            RepeatCheckBoxMenuItem.setSelected(false);
        }
        else if(!RandomCheckBoxMenuItem.isSelected())
        {
            randomMode = false;
            RandomCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_RandomCheckBoxMenuItemActionPerformed

    private void MuteCheckBoxMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MuteCheckBoxMenuItemActionPerformed
         if(MuteCheckBoxMenuItem.isSelected())
        {
            VolumeMemory = VolumeSlider.getValue();
            VolumeSlider.setValue(0);
            MuteCheckBox.setSelected(true);
        }
        else if(!MuteCheckBoxMenuItem.isSelected())
        {
            VolumeSlider.setValue(VolumeMemory);
            MuteCheckBox.setSelected(false);
        }
    }//GEN-LAST:event_MuteCheckBoxMenuItemActionPerformed
    
    private void setIcon()
    {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon_mdplayer.png")));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            }
        }); 
        }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JButton BackButton;
    private javax.swing.JMenuItem ExitMenuItem;
    private javax.swing.JSlider FileSlider;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuBar MainMenuBar;
    private javax.swing.JCheckBox MuteCheckBox;
    private javax.swing.JCheckBoxMenuItem MuteCheckBoxMenuItem;
    private javax.swing.JButton NextButton;
    private javax.swing.JMenuItem NextMenuItem;
    private javax.swing.JMenuItem OpenPlaylistMenuItem;
    private javax.swing.JMenu OptionsMenu;
    private javax.swing.JButton PauseButton;
    private javax.swing.JMenuItem PauseMenuItem;
    private javax.swing.JButton PlayButton;
    private javax.swing.JMenuItem PlayFileMenuItem;
    private javax.swing.JButton PlayListButton;
    private javax.swing.JMenu PlayMenu;
    private javax.swing.JMenuItem PlayMenuItem;
    private javax.swing.JLabel PlaybackLabel;
    private javax.swing.JTextField PlaybackTextField;
    private javax.swing.JMenuItem PlaylistPanelMenuItem;
    private javax.swing.JMenuItem PreviousMenuItem;
    private javax.swing.JCheckBox RandomCheckBox;
    private javax.swing.JCheckBoxMenuItem RandomCheckBoxMenuItem;
    private javax.swing.JCheckBox RepeatCheckBox;
    private javax.swing.JCheckBoxMenuItem RepeatCheckBoxMenuItem;
    private javax.swing.JMenuItem SavePlaylistMenuItem;
    private javax.swing.JButton StopButton;
    private javax.swing.JMenuItem StopMenuItem;
    private javax.swing.JTextField TimeTextField;
    private javax.swing.JTextField TitleTextField;
    private javax.swing.JLabel TypeLabel;
    private javax.swing.JTextField TypeTextField;
    private javax.swing.JMenuItem VolumeDownMenuItem;
    private javax.swing.JLabel VolumeLabel;
    private javax.swing.JSlider VolumeSlider;
    private javax.swing.JMenuItem VolumeUpMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    // End of variables declaration//GEN-END:variables
}
