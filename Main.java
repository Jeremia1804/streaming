package main;
import fenetre.*;
import javafx.scene.media.*;

import javax.swing.*;
public class Main{
    public static void main(String[] args){
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override public void run() {
                // System.out.println("oi");
                new Windows();
            }
          });
    }
}