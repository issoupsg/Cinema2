package Modele;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoutonRecherche extends Bouton {
    // Attribut pour la barre de recherche
    private JTextField barreRecherche;
    int hauteur;
    int largeur;
    String titre;
    public BoutonRecherche(int x, int y, int hauteur, int largeur, String titre) {
        super(x, y);
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.titre = titre;

        // Initialisation de la barre de recherche
        barreRecherche = new JTextField();
        ////  barreRecherche.setBounds(50,50,200,900);

    }

    public JTextField text(){
        JTextField field=new JTextField();
        //// field.setBounds(50,50,900,900);
        return field;
    }
    @Override
    public JButton CreaBouton() {
        JButton bouton = new JButton(titre);
        //// bouton.setBounds(x, y, largeur, hauteur); // Position et taille du bouton
        return bouton;
    }

    // Méthode pour récupérer le texte entré dans la barre de recherche
    public String getTexteRecherche() {

        return barreRecherche.getText();
    }

    // Méthode pour obtenir la barre de recherche
    public JTextField getBarreRecherche() {
        return barreRecherche;
    }
}