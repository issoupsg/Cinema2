package Controleur;

import Modele.ListPanel;

import javax.swing.*;
import java.awt.*;

public class EspaceAdmin extends JFrame {
    JPanel panel;
    JPanel buffer2;
    JFrame frame;
    JPanel buffer,bufferText;
    ListPanel pan;
    JList<String>nameList;

    public EspaceAdmin() {
        super("ma page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

      /*  panel=(JPanel) this.getContentPane();
        buffer=new JPanel();

        nameList = new JList<>();
        pan = new ListPanel();
        bufferText=new JPanel();

        bufferText.setPreferredSize(new Dimension(350, 100));
        pan.setPreferredSize(new Dimension(350, 400));

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///buffer2.setLayout(new GridLayout(2, 2));
*/

    }

    public void afficherInterfaceAdmin() {
    }
       /*JFrame frameConnexion = new JFrame("Admin");
        frameConnexion.setSize(450, 300);
        frameConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConnexion.setLayout(new GridLayout(4, 1));

        // Positionner la nouvelle fenêtre par rapport à la fenêtre principale
        frameConnexion.setLocationRelativeTo(frame);
        ListPanel liste=new ListPanel();
        liste.getList();
        frameConnexion.add(liste);*/

       /* JTextField champUtilisateur = new JTextField();
        frameConnexion.add(new JLabel("Nom Film"));
        frameConnexion.add(champUtilisateur);
        JTextField Auteur = new JTextField();
        frameConnexion.add(Auteur);
        JTextField Nbrplace = new JTextField();
        frameConnexion.add(Nbrplace);
        ///frameConnexion.add(champMotDePasse);
        ///frameConnexion.add(boutonValider1);

        /*Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(boutonRetour1); // Création de l'écouteur avec le bouton
        listener2.ButtonRetour(boutonRetour1,frameConnexion);*/

        // Ajouter le bouton de retour à la fenêtre des informations utilisateur
        ///frameConnexion.add(boutonRetour1);


        // Rendre la fenêtre de connexion visible
      ////  frameConnexion.setVisible(true);
}

