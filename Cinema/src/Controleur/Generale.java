package Controleur;

import Controleur.RecuperationBouton;
import Controleur.RecuperationList;
import Vue.AfficherInterfaceConnexion;
import Modele.*;
import Vue.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
public class Generale extends JFrame {
    public JFrame frame;
    public int type;

    public Generale(){
    }

    public void Generale() throws SQLException, ClassNotFoundException {
        String databaseName = "cinema"; // Remplacez par le nom de votre base de données
        String utilisateur = "root"; // Utilisateur par défaut pour MySQL
        //String motDePasse = ""; // Remplacez par votre mot de passe
        String motDePasse = "Jack123456"; // mdp pour jack
        Connexion connexionBDD = new Connexion(databaseName, utilisateur, motDePasse);

        // Création de la fenêtre principale
        frame = new JFrame("Interface de Connexion");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        //frame.setLayout(new GridLayout(3, 1));
        frame.setLocationRelativeTo(frame);


        // Création du bouton de connexion
        Bouton connexion = new BoutonAppuie(0,0,50,50,"Connexion");
        JButton connexion1 = connexion.CreaBouton();
        RecuperationBouton listener1 = new RecuperationBouton(connexion1); // Création de l'écouteur avec le bouton
        listener1.ButtonConnexion(connexion1,frame);


        // Création du bouton d'invité
        Bouton invite = new BoutonAppuie(0,0,50,50,"Invité");
        JButton invite1 = invite.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(invite1); // Création de l'écouteur avec le bouton
        listener2.ButtonInvite(invite1,frame);


        // Création du bouton de connexion
        Bouton inscription = new BoutonAppuie(0,0,50,50,"Inscription");
        JButton inscription1 = inscription.CreaBouton();
        RecuperationBouton listener3 = new RecuperationBouton(inscription1); // Création de l'écouteur avec le bouton
        listener3.ButtonInscription(inscription1,frame);

        // Ajout des boutons à la fenêtre principale
        frame.add(connexion1);
        frame.add(invite1);
        frame.add(inscription1);

        // Rendre la fenêtre principale visible
        frame.setVisible(true);
    }
    public void LancementJeux(int type) throws SQLException, ClassNotFoundException {
        String nomfilm;
        Page Acceuil;
        Connexion conn=null;

        System.out.println("Hello Palkis!");
        System.out.println("LE TYPE DE LA PERSONNE ENREGISTER: "+type);
        String databaseName = "Cinema"; // Remplacez par le nom de votre base de données
        String utilisateur = "root"; // Utilisateur par défaut pour MySQL
        //String motDePasse = ""; // Remplacez par votre mot de passe
        String motDePasse = "Jack123456"; // mdp Jack
        try {
            Connexion connexion = new Connexion(databaseName, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données réussie !");



            UIManager.setLookAndFeel(new NimbusLookAndFeel());

            // Start my window
            ///Acceuil.getListPanel().
            //// Acceuil.getFrame().setSize(500, 500);
            ListPanel PAN=new ListPanel();
            JList<String> Liste= PAN.listecrea();
            RecuperationList listen =new RecuperationList(Liste);
            listen.ajouterListen(Liste);
            Acceuil=new Page(Liste);
            Bouton appuie=new BoutonAppuie(0,0,50,50,"accueil");
            JButton bouton = appuie.CreaBouton(); // Création du bouton
            Acceuil.ajouterbouton(bouton,0,0,120,50); // Ajout du bouton à la page
            RecuperationBouton listener=new RecuperationBouton(bouton); // Création de l'écouteur avec le bouton
            listener.ajouterListener(Acceuil);
            Acceuil.getPanel().add(bouton, BorderLayout.NORTH);


            Bouton recherche=new BoutonRecherche(0,0,50,50,"recherche");
            JButton bouton1=recherche.CreaBouton();
            Acceuil.ajouterbouton(bouton1,0,0,120,20);
            Acceuil.getPanel().add(bouton1, BorderLayout.WEST);
            Acceuil.getListPanel().setVisible(true);
            Acceuil.getPanel().add(Acceuil.getListPanel(), BorderLayout.WEST);
            Bouton recherche2=new BoutonRecherche(0,0,50,50,"CalculerPrix");
            JButton bouton2=recherche2.CreaBouton();
            Acceuil.ajouterbouton(bouton2,0,0,120,20);




            JTextField field=recherche.text();
            Acceuil.ajouterbarre(field,0,0,450,200);
            RecuperationBouton listener2=new RecuperationBouton(bouton1);
            listener2.ajouterListener2(field,Acceuil);



            Acceuil.getPanel().add(Acceuil.getbuffer());

            JTextField field2=recherche.text();
            Acceuil.ajouterbarre(field,0,0,450,200);
            RecuperationBouton listener3=new RecuperationBouton(bouton2);
            listener3.ajouterListenernbrfilm(field,Acceuil,field2);
            Acceuil.getbuffer().add(field2,BorderLayout.CENTER);
            Acceuil.getbuffer().add(bouton2, BorderLayout.CENTER);
            Acceuil.getbuffer().add(field,BorderLayout.CENTER);
            Acceuil.getPanel().add(Acceuil.getbuffer());
            Acceuil.getbuffer().add(bouton1, BorderLayout.CENTER);

            Acceuil.afficherImageURL("/fermer.jpeg",Acceuil.getHeight(),0);



            Acceuil.setVisible(true);
            Acceuil.revalidate();
            Acceuil.getPanel().setPreferredSize(new Dimension(850,400));
            Acceuil.getPanel().repaint();
            Acceuil.pack();
            Acceuil.repaint();
            ///Acceuil.getFrame().setLayout(null); // Utilisation d'un layout null pour le JFrame
            //// Acceuil.getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ////Acceuil.getFrame().setVisible(true);

        } catch (ClassNotFoundException e) {
            System.out.println("Erreur : Driver non trouvé.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données.");
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

    }
    public  boolean verifierUtilisateur(String utilisateur, String motDePasse) throws SQLException {
        // Connexion à la base de données (à adapter selon votre configuration)
        String URL_BDD = "jdbc:mysql://localhost:3306/cinema";
        String UTILISATEUR_BDD = "root";
        String MOT_DE_PASSE_BDD = "Jack123456";
        Connection connexion = null;
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
                        this.type=rs.getInt("type");
                        return true;
                    }
                }
                System.out.println("Type de membre: "+type);
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
