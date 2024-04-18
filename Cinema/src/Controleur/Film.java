package Controleur;

import Modele.Connexion;

import java.sql.*;

public class Film {
    private int id_auteur;
    private String nom_film;
    private String auteur;
    private int nbrplace;
    private String image_film;

    public Film(String nom_film){
        this.nom_film=nom_film;
        try{
            Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
            String requete = "SELECT id_auteur, auteur, nbrplace, image_film FROM film WHERE nom_film = ?";
            PreparedStatement statement = ((Connection) connexion).prepareStatement(requete);
            statement.setString(1, nom_film);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                this.id_auteur = resultSet.getInt("id_auteur");
                this.auteur = resultSet.getString("auteur");
                this.nbrplace = resultSet.getInt("nbrplace");
                this.image_film = resultSet.getString("image_film");
            }
            resultSet.close();
            statement.close();
            connexion.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

}