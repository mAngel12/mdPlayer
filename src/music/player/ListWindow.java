package music.player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ListWindow extends javax.swing.JFrame {

    /**
     * Creates new form ListWindow
     */
    public ListWindow(MainWindow mainWindow) {
        initComponents();
        
        File selectedFile = new File(System.getProperty("user.dir")+ "/default.pls");
        PlsFormatPlugin openPlaylist = new PlsFormatPlugin();
        listModel.removeAllElements();
        int numberOfEntries = 0;
        try {
            numberOfEntries = openPlaylist.numberOfEntries(selectedFile);
        } catch (IOException ex) {
        }
        for(int i=playlistFileAmount; i<numberOfEntries; i++)
        {
            playlistElements[i] = new PlaylistElement();
        }
        playlistFileAmount = 0;
        for(int i=1; i<=numberOfEntries; i++)
        {
            try {
                listModel.addElement(openPlaylist.openPlaylist_returnLM(selectedFile, i));
                playlistElements[i-1] = openPlaylist.openPlaylist_returnPE(selectedFile, i);
            } catch (IOException ex) {
            }
            playlistFileAmount = playlistFileAmount + 1;
        }
        
    }
    
    public int playlistFileAmount = 0;
    String selectedFileName;
    public String lastParentPath = System.getProperty("user.dir");
    public boolean doubleClickChoose = false;
    public int doubleClickChooseIndex;
    public PlaylistElement playlistElements[] = new PlaylistElement[1000];
    DefaultListModel listModel = new DefaultListModel();

    // public MainWindow mainWindow = new MainWindow(this);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlaylistScrollPane = new javax.swing.JScrollPane();
        PlaylistList = new javax.swing.JList<>();
        AddButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        SaveButton = new javax.swing.JButton();
        OpenButton = new javax.swing.JButton();
        PlaylistMenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        OpenPlaylistMenuItem = new javax.swing.JMenuItem();
        SavePlaylistMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        AddFilesMenuItem = new javax.swing.JMenuItem();
        PlaylistMenu = new javax.swing.JMenu();
        RemoveMenuItem = new javax.swing.JMenuItem();
        ClearMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        MoveUpMenuItem = new javax.swing.JMenuItem();
        MoveDownMenuItem = new javax.swing.JMenuItem();
        HelpMenu = new javax.swing.JMenu();
        AboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PlayList");
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(459, 333));
        setType(java.awt.Window.Type.UTILITY);

        PlaylistList.setModel(listModel);
        PlaylistList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        PlaylistList.setToolTipText("");
        PlaylistList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlaylistListMouseClicked(evt);
            }
        });
        PlaylistScrollPane.setViewportView(PlaylistList);

        AddButton.setText("Add Files");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete File");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        SaveButton.setText("Save PlayList");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        OpenButton.setText("Open PlayList");
        OpenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenButtonActionPerformed(evt);
            }
        });

        FileMenu.setText("File");

        OpenPlaylistMenuItem.setText("Open playlist");
        OpenPlaylistMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenPlaylistMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenPlaylistMenuItem);

        SavePlaylistMenuItem.setText("Save playlist");
        SavePlaylistMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SavePlaylistMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(SavePlaylistMenuItem);
        FileMenu.add(jSeparator1);

        AddFilesMenuItem.setText("Add files");
        AddFilesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddFilesMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(AddFilesMenuItem);

        PlaylistMenuBar.add(FileMenu);

        PlaylistMenu.setText("Playlist");

        RemoveMenuItem.setText("Remove selected");
        RemoveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveMenuItemActionPerformed(evt);
            }
        });
        PlaylistMenu.add(RemoveMenuItem);

        ClearMenuItem.setText("Clear playlist");
        ClearMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearMenuItemActionPerformed(evt);
            }
        });
        PlaylistMenu.add(ClearMenuItem);
        PlaylistMenu.add(jSeparator2);

        MoveUpMenuItem.setText("Move Up");
        MoveUpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveUpMenuItemActionPerformed(evt);
            }
        });
        PlaylistMenu.add(MoveUpMenuItem);

        MoveDownMenuItem.setText("Move Down");
        MoveDownMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveDownMenuItemActionPerformed(evt);
            }
        });
        PlaylistMenu.add(MoveDownMenuItem);

        PlaylistMenuBar.add(PlaylistMenu);

        HelpMenu.setText("Help");

        AboutMenuItem.setText("About Player");
        AboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuItemActionPerformed(evt);
            }
        });
        HelpMenu.add(AboutMenuItem);

        PlaylistMenuBar.add(HelpMenu);

        setJMenuBar(PlaylistMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlaylistScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AddButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OpenButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SaveButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PlaylistScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(DeleteButton)
                    .addComponent(SaveButton)
                    .addComponent(OpenButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed

        JFileChooser addFileChooser = new JFileChooser(lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        addFileChooser.setMultiSelectionEnabled(true);
        addFileChooser.setDragEnabled(true);
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
            File[] files = addFileChooser.getSelectedFiles();
            for(int i=0; i<files.length; i++)
            {
                System.out.println("das");
                File selectedFile = files[i];
                String selectedFilePath = selectedFile.getPath();
                lastParentPath = selectedFile.getParent();
                PlaylistPlugin playlistPlugin = new PlaylistPlugin(selectedFilePath);
                if(playlistPlugin.getFileType() != "WAVE" && playlistPlugin.getFileType() != "AIFF" && playlistPlugin.getFileType() != "AU")
                {
                    String elementTitle = playlistPlugin.getTitle();
                    String elementAuthor = playlistPlugin.getAuthor();
                    String elementAuthorAndTitle = playlistPlugin.getAuthorAndTitle();
                    String elementType = playlistPlugin.getFileType();
                    playlistFileAmount = playlistFileAmount + 1;
                    playlistElements[playlistFileAmount-1] = new PlaylistElement(elementTitle, elementAuthor, selectedFilePath, elementType);
                    listModel.addElement(playlistFileAmount + ". " + elementAuthorAndTitle);
                }
                else
                {
                    selectedFileName = selectedFile.getName();
                    String elementType = playlistPlugin.getFileType();
                    playlistFileAmount = playlistFileAmount + 1;
                    playlistElements[playlistFileAmount-1] = new PlaylistElement(selectedFileName, "", selectedFilePath, elementType);
                    listModel.addElement(playlistFileAmount + ". " + selectedFileName);
                }
            }
            
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_AddButtonActionPerformed

    private void OpenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenButtonActionPerformed
        
        JFileChooser addFileChooser = new JFileChooser(lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterPlaylist = new FileNameExtensionFilter("PLS Playlist File Format (.pls)", "pls");
        addFileChooser.addChoosableFileFilter(filterPlaylist);
 
        int fileResult = addFileChooser.showOpenDialog(this);
        if (fileResult == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = addFileChooser.getSelectedFile();
            lastParentPath = selectedFile.getParent();
            PlsFormatPlugin openPlaylist = new PlsFormatPlugin();
            listModel.removeAllElements();
            int numberOfEntries;
            try {
                numberOfEntries = openPlaylist.numberOfEntries(selectedFile);
                for(int i=playlistFileAmount; i<numberOfEntries; i++)
                {
                    playlistElements[i] = new PlaylistElement();
                }
                playlistFileAmount = 0;
                for(int i=1; i<=numberOfEntries; i++)
                {
                   listModel.addElement(openPlaylist.openPlaylist_returnLM(selectedFile, i));
                   playlistElements[i-1] = openPlaylist.openPlaylist_returnPE(selectedFile, i);
                   playlistFileAmount = playlistFileAmount + 1;
                }
            } catch (IOException ex) {
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_OpenButtonActionPerformed

    private void PlaylistListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaylistListMouseClicked
        JList list = (JList)evt.getSource();
        if (evt.getClickCount() == 2) 
        {
            int index = list.locationToIndex(evt.getPoint());
            doubleClickChoose = true;
            doubleClickChooseIndex = index;
        }
    }//GEN-LAST:event_PlaylistListMouseClicked

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int selectedIndex = PlaylistList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            playlistFileAmount = playlistFileAmount-1;
            if (selectedIndex < playlistFileAmount)
            {
                for(int i = selectedIndex; i<playlistFileAmount; i++)
                {
                    playlistElements[i].elementTitle = playlistElements[i+1].elementTitle;
                    playlistElements[i].elementAuthor = playlistElements[i+1].elementAuthor;
                    playlistElements[i].elementPath = playlistElements[i+1].elementPath;
                    playlistElements[i].elementType = playlistElements[i+1].elementType;
                    //playlistElements[i].elementDuration = playlistElements[i+1].elementDuration;
                    if(playlistElements[i].elementType != "WAVE" && playlistElements[i].elementType != "AIFF" && playlistElements[i].elementType != "AU")
                    {
                        listModel.setElementAt(i+1 + ". " + playlistElements[i].getElementAuthorAndTitle(), i);
                    }
                    else
                    {
                        listModel.setElementAt(i+1 + ". " + playlistElements[i].elementTitle, i);
                    }
                }
            }
            AutoSaveDefaultPlaylist();
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        
        List<String> pathList = new ArrayList<String>();
        for(int i=0; i<playlistFileAmount; i++)
        {
            pathList.add(playlistElements[i].elementPath);
        }
        JFileChooser saveFileChooser = new JFileChooser(lastParentPath);
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
            lastParentPath = file.getParent();
            PlsFormatPlugin savePlaylist = new PlsFormatPlugin();
            try {
                savePlaylist.savePlaylist(file, pathList, playlistFileAmount);
            } catch (FileNotFoundException ex) {
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void AboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null, "mdPlayer is a simple music player written in Java using BasicPlayer API.\n"
            + "Copyright © 2017 DultzDev.\n"
            + "mdPlayer v0.1\n"
            + "Visit www.dultzdev.com for updates and more informations.\n", "About mdPlayer",
            JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutMenuItemActionPerformed

    private void OpenPlaylistMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenPlaylistMenuItemActionPerformed
        JFileChooser addFileChooser = new JFileChooser(lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterPlaylist = new FileNameExtensionFilter("PLS Playlist File Format (.pls)", "pls");
        addFileChooser.addChoosableFileFilter(filterPlaylist);
 
        int fileResult = addFileChooser.showOpenDialog(this);
        if (fileResult == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = addFileChooser.getSelectedFile();
            lastParentPath = selectedFile.getParent();
            PlsFormatPlugin openPlaylist = new PlsFormatPlugin();
            listModel.removeAllElements();
            int numberOfEntries;
            try {
                numberOfEntries = openPlaylist.numberOfEntries(selectedFile);
                for(int i=playlistFileAmount; i<numberOfEntries; i++)
                {
                    playlistElements[i] = new PlaylistElement();
                }
                playlistFileAmount = 0;
                for(int i=1; i<=numberOfEntries; i++)
                {
                   listModel.addElement(openPlaylist.openPlaylist_returnLM(selectedFile, i));
                   playlistElements[i-1] = openPlaylist.openPlaylist_returnPE(selectedFile, i);
                   playlistFileAmount = playlistFileAmount + 1;
                }
            } catch (IOException ex) {
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_OpenPlaylistMenuItemActionPerformed

    private void SavePlaylistMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SavePlaylistMenuItemActionPerformed
        List<String> pathList = new ArrayList<String>();
        for(int i=0; i<playlistFileAmount; i++)
        {
            pathList.add(playlistElements[i].elementPath);
        }
        JFileChooser saveFileChooser = new JFileChooser(lastParentPath);
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
            lastParentPath = file.getParent();
            PlsFormatPlugin savePlaylist = new PlsFormatPlugin();
            try {
                savePlaylist.savePlaylist(file, pathList, playlistFileAmount);
            } catch (FileNotFoundException ex) {
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_SavePlaylistMenuItemActionPerformed

    private void AddFilesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddFilesMenuItemActionPerformed
        
        JFileChooser addFileChooser = new JFileChooser(lastParentPath);
        addFileChooser.setAcceptAllFileFilterUsed(false);
        addFileChooser.setMultiSelectionEnabled(true);
        addFileChooser.setDragEnabled(true);
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
            File[] files = addFileChooser.getSelectedFiles();
            for(int i=0; i<files.length; i++)
            {
                System.out.println("das");
                File selectedFile = files[i];
                String selectedFilePath = selectedFile.getPath();
                lastParentPath = selectedFile.getParent();
                PlaylistPlugin playlistPlugin = new PlaylistPlugin(selectedFilePath);
                if(playlistPlugin.getFileType() != "WAVE" && playlistPlugin.getFileType() != "AIFF" && playlistPlugin.getFileType() != "AU")
                {
                    String elementTitle = playlistPlugin.getTitle();
                    String elementAuthor = playlistPlugin.getAuthor();
                    String elementAuthorAndTitle = playlistPlugin.getAuthorAndTitle();
                    String elementType = playlistPlugin.getFileType();
                    playlistFileAmount = playlistFileAmount + 1;
                    playlistElements[playlistFileAmount-1] = new PlaylistElement(elementTitle, elementAuthor, selectedFilePath, elementType);
                    listModel.addElement(playlistFileAmount + ". " + elementAuthorAndTitle);
                }
                else
                {
                    selectedFileName = selectedFile.getName();
                    String elementType = playlistPlugin.getFileType();
                    playlistFileAmount = playlistFileAmount + 1;
                    playlistElements[playlistFileAmount-1] = new PlaylistElement(selectedFileName, "", selectedFilePath, elementType);
                    listModel.addElement(playlistFileAmount + ". " + selectedFileName);
                }
            }
            
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_AddFilesMenuItemActionPerformed

    private void RemoveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveMenuItemActionPerformed
        int selectedIndex = PlaylistList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
            playlistFileAmount = playlistFileAmount-1;
            if (selectedIndex < playlistFileAmount)
            {
                for(int i = selectedIndex; i<playlistFileAmount; i++)
                {
                    playlistElements[i] = playlistElements[i+1];
                    if(playlistElements[i].elementType != "WAVE" && playlistElements[i].elementType != "AIFF" && playlistElements[i].elementType != "AU")
                    {
                        listModel.setElementAt(i+1 + ". " + playlistElements[i].getElementAuthorAndTitle(), i);
                    }
                    else
                    {
                        listModel.setElementAt(i+1 + ". " + playlistElements[i].elementTitle, i);
                    }
                }
            }
            AutoSaveDefaultPlaylist();
        }
    }//GEN-LAST:event_RemoveMenuItemActionPerformed

    private void ClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearMenuItemActionPerformed
        listModel.removeAllElements();
        playlistFileAmount = 0;
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_ClearMenuItemActionPerformed

    private void MoveUpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveUpMenuItemActionPerformed
        int index = PlaylistList.getSelectedIndex();
        if(index != 0 && playlistFileAmount >= 2)
        {
            PlaylistElement temp = new PlaylistElement();
            temp = playlistElements[index];
            playlistElements[index] = playlistElements[index - 1];
            playlistElements[index - 1] = temp;

            if(playlistElements[index].elementType != "WAVE" && playlistElements[index].elementType != "AIFF" && playlistElements[index].elementType != "AU")
            {
                listModel.setElementAt(index+1 + ". " + playlistElements[index].getElementAuthorAndTitle(), index);
            }
            else
            {
                listModel.setElementAt(index+1 + ". " + playlistElements[index].elementTitle, index);
            }

            if(playlistElements[index-1].elementType != "WAVE" && playlistElements[index-1].elementType != "AIFF" && playlistElements[index-1].elementType != "AU")
            {
                listModel.setElementAt(index + ". " + playlistElements[index-1].getElementAuthorAndTitle(), index-1);
            }
            else
            {
                listModel.setElementAt(index + ". " + playlistElements[index-1].elementTitle, index-1);
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_MoveUpMenuItemActionPerformed

    private void MoveDownMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveDownMenuItemActionPerformed
        int index = PlaylistList.getSelectedIndex();
        if(index != playlistFileAmount-1 && playlistFileAmount >= 2)
        {
            PlaylistElement temp = new PlaylistElement();
            temp = playlistElements[index];
            playlistElements[index] = playlistElements[index + 1];
            playlistElements[index + 1] = temp;

            if(playlistElements[index].elementType != "WAVE" && playlistElements[index].elementType != "AIFF" && playlistElements[index].elementType != "AU")
            {
                listModel.setElementAt(index+1 + ". " + playlistElements[index].getElementAuthorAndTitle(), index);
            }
            else
            {
                listModel.setElementAt(index+1 + ". " + playlistElements[index].elementTitle, index);
            }

            if(playlistElements[index+1].elementType != "WAVE" && playlistElements[index+1].elementType != "AIFF" && playlistElements[index+1].elementType != "AU")
            {
                listModel.setElementAt(index+2 + ". " + playlistElements[index+1].getElementAuthorAndTitle(), index+1);
            }
            else
            {
                listModel.setElementAt(index+2 + ". " + playlistElements[index+1].elementTitle, index+1);
            }
        }
        AutoSaveDefaultPlaylist();
    }//GEN-LAST:event_MoveDownMenuItemActionPerformed

    
    public void AutoSaveDefaultPlaylist()
    {
        List<String> pathList = new ArrayList<String>();
        for(int i=0; i<playlistFileAmount; i++)
        {
            pathList.add(playlistElements[i].elementPath);
        }
        File file = new File(System.getProperty("user.dir")+ "/default.pls");
        PlsFormatPlugin savePlaylist = new PlsFormatPlugin();
        try {
            savePlaylist.savePlaylist(file, pathList, playlistFileAmount);
        } catch (FileNotFoundException ex) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenuItem;
    private javax.swing.JButton AddButton;
    private javax.swing.JMenuItem AddFilesMenuItem;
    private javax.swing.JMenuItem ClearMenuItem;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenu HelpMenu;
    private javax.swing.JMenuItem MoveDownMenuItem;
    private javax.swing.JMenuItem MoveUpMenuItem;
    private javax.swing.JButton OpenButton;
    private javax.swing.JMenuItem OpenPlaylistMenuItem;
    public javax.swing.JList<String> PlaylistList;
    private javax.swing.JMenu PlaylistMenu;
    private javax.swing.JMenuBar PlaylistMenuBar;
    private javax.swing.JScrollPane PlaylistScrollPane;
    private javax.swing.JMenuItem RemoveMenuItem;
    private javax.swing.JButton SaveButton;
    private javax.swing.JMenuItem SavePlaylistMenuItem;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
