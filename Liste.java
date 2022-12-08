package elementdeFrame;
import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.*;
import java.util.*;
import ecouteur.*;

import javax.swing.*;
public class Liste extends JPanel{
  File dir = new File("D:\\music");
  ArrayList<String> all;
  ArrayList<String> audio;
  ArrayList<String> video;
  ArrayList<ArrayList<String>> tous; 
  int choix=2; 
  ListenBoutton listener;
  JButton audios;
  JButton videos;
  JButton alls;
  JScrollPane jsp;
  JPanel paneli;
  JButton[] but;


    public Liste(){
      audios = new JButton("Audio");
      videos = new JButton("Video");
      alls = new JButton("All");
      listener = new ListenBoutton();
      listener.setTousBoutton(audios,videos,alls,this);
      audios.addActionListener(listener); videos.addActionListener(listener); alls.addActionListener(listener);
      all = new ArrayList<>();
      audio = new ArrayList<>();
      video = new ArrayList<>();
      tous = new ArrayList<>();
        setBounds(950,0,400,800);
        setLayout(null);
        addAudio();
        addVideo();
        addAll();
        addTous();
        jsp = manamboatra();
        add(choix()); add(jsp);
    }

    public void changerListe(int e){
      choix = e;
      paneli.setVisible(false);
      jsp.removeAll();
      jsp.validate();
      prepare();
      paneli.setVisible(true);
      jsp.add(paneli);
    }

    public void addTous(){
      tous.add(audio);
      tous.add(video);
      tous.add(all);
    }

    public void addAudio(){
        if (!dir.exists() || !dir.isDirectory()) {
        System.out.println("Cannot find video source directory: " + dir);
        all = null; audio=null; video = null;
      }
      
      for (String file : dir.list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          if(name.endsWith(".mp3")){
            System.out.println("mety");
            return true;
          }
          System.out.println("null ee");
          return false;
        }
      })) audio.add((file).replace("\\", "/").replaceAll(" ", "%20"));  
     
    }

    public void addVideo(){
      if (!dir.exists() || !dir.isDirectory()) {
      System.out.println("Cannot find video source directory: " + dir);
      all = null; audio=null; video = null;
      }

      for (String file : dir.list(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          if(name.endsWith(".mp4")) return true;
          return false;
        }
      })) video.add((file).replace("\\", "/").replaceAll(" ", "%20"));
  }

  public void addAll(){
    if (!dir.exists() || !dir.isDirectory()) {
    System.out.println("Cannot find video source directory: " + dir);
    all = null; audio=null; video = null;
    }

    for (String file : dir.list(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        if(name.endsWith(".mp4")) return true;
        return false;
      }
    })) all.add((file).replace("\\", "/").replaceAll(" ", "%20"));
}

    
      public JPanel choix(){
          JPanel panel = new JPanel();
          panel.setBounds(10,30,380,20);
          panel.setLayout(new GridLayout(1,3));
          panel.setBackground(Color.white);
          
          audios.setBackground(Color.white);
          videos.setBackground(Color.white);
          alls.setBackground(Color.white);
          panel.add(audios); panel.add(videos); panel.add(alls);
    
          return panel;
      }
    
      public void prepare(){
        paneli = new JPanel();
          paneli.setBounds(10,50,380,700);
          paneli.setBackground(Color.white);
          ArrayList<String> ito =(ArrayList<String>) tous.get(choix);
          but = new JButton[ito.size()];
          for(int i=0 ; i<ito.size();i++){
            but[i] = new JButton(ito.get(i));
            but[i].setFocusPainted(false);
            but[i].setBackground(Color.white);
            //   but.setBorder(BorderFactory.createEmptyBorder());
            but[i].setVerticalTextPosition(SwingConstants.TOP);
            but[i].setHorizontalAlignment(SwingConstants.LEFT);
            paneli.add(but[i]);
            System.out.println("aize ee");
          }
          paneli.setLayout(new GridLayout(ito.size(),1));
      }

        public JScrollPane manamboatra(){
          prepare();
          int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
          int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
            JScrollPane jspe = new JScrollPane(paneli,v,h);
            jspe.setBounds(10,50,380,500);
          return jspe;
      }
}