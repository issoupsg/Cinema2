package Controleur;

import Modele.Connexion;
import Modele.RechercheSql;
import Vue.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

public class RecuperationBouton {
    private JButton JB;

    public RecuperationBouton(JButton bouton) {
        this.JB = bouton;
    }

    public void ajouterListener() {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeurBouton = JB.getText();
                System.out.println("La valeur du bouton est : " + valeurBouton);
                // Vous pouvez faire d'autres traitements avec la valeur récupérée ici
            }
        });
    }

    public void ajouterListener2(JTextField field, Page Acceuil) {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeur;
                String databaseName = "Cinema"; // Remplacez par le nom de votre base de données
                String utilisateur = "root"; // Utilisateur par défaut pour MySQL
                //String motDePasse = "";
                String motDePasse = "Jack123456";
                String valeurBouton = field.getText();
                System.out.println("La valeur du bouton est : " + valeurBouton);
                Connexion sql = null; // Passer la connexion à la classe RechercheSql
                try {
                    sql = new Connexion(databaseName,utilisateur,motDePasse);
                    valeur=sql.getFilmName(valeurBouton);
                    System.out.println("yey "+valeur);
                    Acceuil.afficherImageURL(valeur,200,200);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                // Vous pouvez faire d'autres traitements avec la valeur récupérée ici
                try {
                    String val = sql.getFilmName(valeurBouton);
                    System.out.println(val);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonConnexion(JButton boutonConnexion, JFrame frame){
        boutonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe
                //afficherInterfaceConnexion();
            }
        });
    }
    public void ButtonInvite(JButton boutonInvite, JFrame frame){
        boutonInvite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /*String databaseName = "cinema"; // Remplacez par le nom de votre base de données
                String utilisateur = "root"; // Utilisateur par défaut pour MySQL
                //String motDePasse = ""; // Remplacez par votre mot de passe
                String motDePasse = "Jack123456"; // mdp pour jack
                Connexion connexionBDD = null; */
                frame.dispose(); // Fermer la fenêtre actuelle
                General g = new General();
                try {
                    g.LancementJeux();
                    g.type=0;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }
    public void ButtonInscription(JButton boutonInscription, JFrame frame){
        boutonInscription.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe

                // CODE D'INSCRIPTION ICI
            }
        });
    }


}
