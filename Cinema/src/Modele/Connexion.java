package Modele;

import java.sql.*;

public class Connexion {
    private final Connection conn;
    private final Statement stmt;

    public Connexion(String databaseName, String username, String password) throws SQLException, ClassNotFoundException {
        // Chargement du pilote JDBC moderne
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion à la base de données
        //String urlDatabase = "jdbc:mysql://localhost:3306/" + databaseName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String urlDatabase = "jdbc:mysql://localhost:3306/cinema";
        conn = DriverManager.getConnection(urlDatabase, username, password);

        // Préparation de l'instruction SQL pour l'insertion d'un film, sans inclure l'ID
        String sqlInsert = "INSERT INTO film (nom_film, auteur, nbrplace) VALUES (?, ?, ?)";
        PreparedStatement psInsert = conn.prepareStatement(sqlInsert);

        // Exemple d'ajout d'un film
      /*  psInsert.setString(1, "Les Évadés"); // Nom du film
        psInsert.setString(2, "Frank Darabont"); // Auteur
        psInsert.setInt(3, 100); // Nombre de places
        psInsert.executeUpdate(); // Exécution de l'insertion*/

        // Pour ajouter d'autres films, répétez le processus avec différents paramètres

        // Fermeture du PreparedStatement après utilisation
        psInsert.close();

        // Création d'une Statement pour exécuter d'autres requêtes si nécessaire
        stmt = conn.createStatement();
    }
    public String getFilmName(String nom) throws SQLException {
        String filmName = "";
        String sqlSelect = "SELECT image_film FROM film WHERE nom_film = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            System.out.println("cokfd");
            filmName = rs.getString("image_film");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return filmName;
    }


    // Méthode pour fermer les ressources et éviter les fuites de mémoire
    public void close() throws SQLException {
        if (conn != null) {
            conn.close();
        }
        if (stmt != null) {
            stmt.close();
        }
    }
}