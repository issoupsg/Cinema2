package Vue;

import Controleur.RecuperationBouton;
import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.BoutonRecherche;
import Modele.Connexion;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class General extends JFrame {
    public JFrame frame;
    public int type;

    public General(){
        this.type = 0;
    }

    public void General() throws SQLException, ClassNotFoundException {
        String databaseName = "cinema"; // Remplacez par le nom de votre base de données
        String utilisateur = "root"; // Utilisateur par défaut pour MySQL
        String motDePasse = ""; // Remplacez par votre mot de passe
        //String motDePasse = "Jack123456"; // mdp pour jack
        Connexion connexionBDD = new Connexion(databaseName, utilisateur, motDePasse);

        // Création de la fenêtre principale
        frame = new JFrame("Interface de Connexion");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        //frame.setLayout(new GridLayout(3, 1));
        frame.setLocationRelativeTo(frame);


        // Création du bouton de connexion
        Bouton connexion = new BoutonAppuie(0,0,50,50,"Connexion");
        JButton connexion1 = connexion.CreaBouton();
        RecuperationBouton listener1 = new RecuperationBouton(connexion1); // Création de l'écouteur avec le bouton
        listener1.ajouterListener();
        listener1.ButtonConnexion(connexion1,frame);


        // Création du bouton d'invité
        Bouton invite = new BoutonAppuie(0,0,50,50,"Invité");
        JButton invite1 = invite.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(invite1); // Création de l'écouteur avec le bouton
        listener2.ajouterListener();
        listener2.ButtonInvite(invite1,frame);


        // Création du bouton de connexion
        Bouton inscription = new BoutonAppuie(0,0,50,50,"Inscription");
        JButton inscription1 = inscription.CreaBouton();
        RecuperationBouton listener3 = new RecuperationBouton(inscription1); // Création de l'écouteur avec le bouton
        listener3.ajouterListener();
        listener3.ButtonInscription(inscription1,frame);

        // Ajout des boutons à la fenêtre principale
        frame.add(connexion1);
        frame.add(invite1);
        frame.add(inscription1);

        // Rendre la fenêtre principale visible
        frame.setVisible(true);
    }
    public void LancementJeux() throws SQLException, ClassNotFoundException {
        String nomfilm;
        Page Acceuil;

        Acceuil = new Page(500, 500, "Acceuil");

        Acceuil.getFrame().setSize(500, 500);
        Bouton appuie=new BoutonAppuie(0,0,50,50,"acceuil");
        JButton bouton = appuie.CreaBouton(); // Création du bouton
        Acceuil.ajouterbouton(bouton,0,0,120,20); // Ajout du bouton à la page
        RecuperationBouton listener=new RecuperationBouton(bouton); // Création de l'écouteur avec le bouton
        listener.ajouterListener(); // Ajout de l'écouteur
        Bouton recherche=new BoutonRecherche(0,0,50,50,"recherche");
        JButton bouton1=recherche.CreaBouton();

        Acceuil.ajouterbouton(bouton1,0,0,120,20);
        //// Acceuil.getPanel().setLayout(new BoxLayout(Acceuil.getPanel(), BoxLayout.Y_AXIS));
        JTextField field=recherche.text();
        Acceuil.ajouterbarre(field,0,0,450,20);
        RecuperationBouton listener2=new RecuperationBouton(bouton1);
        listener2.ajouterListener2(field,Acceuil);

        Acceuil.getFrame().revalidate();
        Acceuil.getFrame().repaint();
        ///Acceuil.getFrame().setLayout(null); // Utilisation d'un layout null pour le JFrame
        //// Acceuil.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Acceuil.getFrame().setVisible(true);
    }
}
