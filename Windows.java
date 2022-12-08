package fenetre;
import javax.swing.*;
import java.awt.*;
import elementdeFrame.*;
import video.*;

public class Windows extends JFrame{
  Liste panelListe;
  Lecteur lecture;
    public Windows(){
        initAndShowGUI();
    }

    public void initAndShowGUI() {
    // This method is invoked on Swing thread
    lecture = new Lecteur();
        JPanel panel = new JPanel();
        panel.setBackground(Color.white);
        JPanel panelLecteur = new JPanel();
        panelLecteur.setBackground(Color.white);
        panelListe = new Liste();
         panelListe.setBackground(Color.white);
        panel.setLayout(null);
        panel.add(panelLecteur); panel.add(panelListe);
        panelLecteur.setBounds(0,0,800,800);
        panelLecteur.add(lecture);
        this.add(panel);
        this.setBounds(200, 100, 800, 250);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

  }

}