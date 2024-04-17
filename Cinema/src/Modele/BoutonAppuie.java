package Modele;

import javax.swing.*;

public class BoutonAppuie extends Bouton {
    int hauteur;
    int largeur;
    String titre;
    public BoutonAppuie(int x, int y, int hauteur, int largeur,String titre) {
        super(x, y);
        this.hauteur= hauteur;
        this.largeur= largeur;
        this.titre=titre;

    }
    @Override
    public JButton CreaBouton(){
        JButton bouton = new JButton(titre);
        ///bouton.setBounds(x, y, largeur, hauteur); // Position et taille du bouton

        return bouton;

    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return largeur;
    }
    public int getHeight(){
        return hauteur;
    }
}
