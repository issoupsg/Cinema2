package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.BoutonRecherche;
import Modele.Connexion;
import Vue.*;
import Vue.Page;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Controleur {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println("Hello Cinema!");
        Generale Generale = new Generale();
        Generale.Generale();
    }
}
