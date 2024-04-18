package Controleur;

import java.sql.SQLException;
import java.util.ArrayList;

public interface FilmDAO {
    void ajouterFilm(Film f) throws SQLException, ClassNotFoundException;
    ArrayList<Film> getListe_films();
    void supprimerFilm(Film f) throws SQLException, ClassNotFoundException;
}
