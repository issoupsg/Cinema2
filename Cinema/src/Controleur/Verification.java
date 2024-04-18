package Controleur;
import java.sql.*;

public class Verification {
    public  boolean Verification(String utilisateur, String motDePasse) throws SQLException {
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
                ResultSet rs=ps1.executeQuery();
                while(rs.next()){
                    System.out.println(rs.getString("Utilisateur")+"\t"+rs.getString("mdp")+"\t"+rs.getInt("type"));
                    if(rs.getString("Utilisateur").equals(utilisateur) && rs.getString("mdp").equals(motDePasse)){
                        g.type=rs.getInt("type");
                        return true;
                    }
                }
                System.out.println("Type de membre: "+g.type);
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
}
