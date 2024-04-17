package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.BoutonRecherche;
import Modele.Connexion;
import Vue.Page;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Controleur {

    public static void main(String[] args) {

        String nomfilm;
        Page Acceuil;
        Connexion conn=null;

        System.out.println("Hello Palkis!");
        String databaseName = "cinema"; // Remplacez par le nom de votre base de données
        String utilisateur = "root"; // Utilisateur par défaut pour MySQL
        String motDePasse = ""; // Remplacez par votre mot de passe

        try {
            Connexion connexion = new Connexion(databaseName, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données réussie !");


            Acceuil=new Page(500,500,"Acceuil");

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
            listener2.ajouterListener2(field, (Connection) conn,Acceuil);

            Acceuil.getFrame().revalidate();
            Acceuil.getFrame().repaint();
            ///Acceuil.getFrame().setLayout(null); // Utilisation d'un layout null pour le JFrame
            //// Acceuil.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Acceuil.getFrame().setVisible(true);

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        }

    }
}
