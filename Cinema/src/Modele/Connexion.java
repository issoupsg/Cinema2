package Modele;

import Controleur.Generale;

import java.sql.*;import javax.swing.*;

public class Connexion {
    private final Connection conn;
    private final Statement stmt;
    String databaseName="Cinema";
    String username="root";
    //String password="";
    String password="Jack123456";

    public Connexion() throws SQLException, ClassNotFoundException {
        // Chargement du pilote JDBC moderne
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connexion à la base de données
        String urlDatabase = "jdbc:mysql://localhost:3306/" + databaseName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
    public String getresume(String nom) throws SQLException {
        String filmName="";
        String sqlSelect = "SELECT resume FROM film WHERE nom_film = ?";
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            ////System.out.println("cokfd");
            filmName = rs.getString("resume");
        }

        // Fermeture des ressources
        rs.close();
        psSelect.close();

        return filmName;

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

    public JList<String> getlistFilms(JList<String> ok) throws SQLException {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String sqlSelect = "SELECT nom_film, nbrplace, prix_place FROM film";
        PreparedStatement psSelect = null;
        ResultSet rs = null;

        try {
            // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
            psSelect = conn.prepareStatement(sqlSelect);

            // Exécution de la requête et récupération du résultat
            rs = psSelect.executeQuery();
            while (rs.next()) {  // Utiliser while au lieu de if pour traiter tous les enregistrements
                String filmName = rs.getString("nom_film");
                int nbPlace = rs.getInt("nbrplace");
                float prix = rs.getFloat("prix_place");
                // Format de chaque entrée : "Nom du film - Nombre de places - Prix"
                String entry = filmName + " - " + nbPlace + " places - " + prix + " €";
                listModel.addElement(entry);  // Ajout de l'entrée au modèle de liste
            }

            ok.setModel(listModel);  // Mettre à jour le modèle de la JList
        } finally {
            // Assurer la fermeture des ressources dans un bloc finally
            if (rs != null) rs.close();
            if (psSelect != null) psSelect.close();
        }

        return ok;
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

    public int getnbrfilm(String nom, int nombreplce) throws SQLException {
        int prix = 0;
        int nbrplace;
        String sqlSelect = "SELECT nbrplace,prix_place FROM film WHERE nom_film = ?";

        // Utilisation d'un PreparedStatement pour éviter les problèmes de sécurité liés aux injections SQL
        PreparedStatement psSelect = conn.prepareStatement(sqlSelect);
        psSelect.setString(1, nom); // Lier le paramètre à la valeur 57

        // Exécution de la requête et récupération du résultat
        ResultSet rs = psSelect.executeQuery();
        if (rs.next()) {
            System.out.println("cokfd");
            nbrplace = rs.getInt("nbrplace");
            prix = rs.getInt("prix_place");
        }
        return (prix * nombreplce);


    }

    public boolean Verification(String utilisateur, String motDePasse) throws SQLException {
        // Connexion à la base de données (à adapter selon votre configuration)
        String URL_BDD = "jdbc:mysql://localhost:3306/cinema";
        String UTILISATEUR_BDD = "root";
        String MOT_DE_PASSE_BDD = "Jack123456";
        Connection connexion = null;
        Generale g = new Generale();

        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Etablissement de la connexion
            connexion = DriverManager.getConnection(URL_BDD, UTILISATEUR_BDD, MOT_DE_PASSE_BDD);

            // Si la connexion est établie avec succès
            if (connexion != null) {

                System.out.println("Connexion établie avec la base de données !");
                PreparedStatement ps1 = connexion.prepareStatement("SELECT * FROM user");
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("Utilisateur") + "\t" + rs.getString("mdp") + "\t" + rs.getInt("type"));
                    if (rs.getString("Utilisateur").equals(utilisateur) && rs.getString("mdp").equals(motDePasse)) {
                        g.type = rs.getInt("type");
                        return true;
                    }
                }
                System.out.println("Type de membre: " + g.type);
                // Vous pouvez maintenant effectuer des opérations sur la base de données
            } else {
                System.out.println("Echec de la connexion à la base de données !");
            }

            // TOUT LES EXCEPTIONS
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e.getMessage());
        } finally {
            // Fermeture de la connexion
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
        return false;
    }

    public int getType(String utilisateur, String motDePasse) throws SQLException {
        String URL_BDD = "jdbc:mysql://localhost:3306/cinema";
        String UTILISATEUR_BDD = "root";
        String MOT_DE_PASSE_BDD = "Jack123456";
        Connection connexion = null;
        Generale g = new Generale();

        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Etablissement de la connexion
            connexion = DriverManager.getConnection(URL_BDD, UTILISATEUR_BDD, MOT_DE_PASSE_BDD);

            // Si la connexion est établie avec succès
            if (connexion != null) {

                System.out.println("Connexion établie avec la base de données !");
                PreparedStatement ps1 = connexion.prepareStatement("SELECT * FROM user");
                ResultSet rs = ps1.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getString("Utilisateur") + "\t" + rs.getString("mdp") + "\t" + rs.getInt("type"));
                    if (rs.getString("Utilisateur").equals(utilisateur) && rs.getString("mdp").equals(motDePasse)) {
                        g.type = rs.getInt("type");
                        return g.type;
                    }
                }
                System.out.println("Type de membre: " + g.type);
                // Vous pouvez maintenant effectuer des opérations sur la base de données
            } else {
                System.out.println("Echec de la connexion à la base de données !");
            }
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC non trouvé : " + e.getMessage());
        } finally {
            // Fermeture de la connexion
            try {
                if (connexion != null) {
                    connexion.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
        return 0;
    }

    public void InscriptionBDD(String nom, String prenom, int age, String password)throws SQLException{

    }
    public boolean verificationInscription(String nom, String prenom, int age, String password, String confirmationPassword){
        /*System.out.println("nom: "+nom);
        System.out.println("prenom: "+prenom);
        System.out.println("age: "+age);
        System.out.println("password: "+password);
        System.out.println("confirmerPassword: "+confirmationPassword);*/
        if(nom.isEmpty() || prenom.isEmpty() || password.isEmpty() || confirmationPassword.isEmpty() || !password.equals(confirmationPassword)){
            return false;
        }
        else {
            return true;
        }
    }
}