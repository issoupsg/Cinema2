package Controleur;

import Modele.Connexion;
import Modele.ListPanel;
import Modele.Personne;
import Vue.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class RecuperationBouton {
    private JButton JB;
    private JList liste;
    public RecuperationBouton(JButton bouton) {
        this.JB = bouton;
    }
    public RecuperationBouton(JList<String> liste) {this.liste=liste;}

    public void ajouterListener(Page accueil) {
        JB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Generale General = new Generale();
                try {
                    accueil.dispose();
                    General.Generale();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                // Vous pouvez faire d'autres traitements avec la valeur récupérée ici
            }
        });
    }
public void Jlistener() {
    liste.addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            // S'assurer que l'événement est final (pour éviter les doubles appels)
            if (!e.getValueIsAdjusting()) {
                // Récupérer l'élément sélectionné
                String selectedValue = (String) liste.getSelectedValue();
                // Afficher l'élément sélectionné
                System.out.println("Élément sélectionné : " + selectedValue);
            }
        }
    });
}

    public void ajouterListener2(JTextField field, Page Acceuil) {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String valeur;
                String resume;

                ////String motDePasse = "Jack123456";
                String valeurBouton = field.getText();


                System.out.println("La valeur du bouton est : " + valeurBouton);
                Connexion sql = null; // Passer la connexion à la classe RechercheSql
                try {
                    sql = new Connexion();
                    valeur=sql.getFilmName(valeurBouton);
                    System.out.println("yey "+valeur);
                    if(valeur=="")
                    {
                        valeur="/fermer.jpeg";
                    }
                    Acceuil.afficherImageURL(valeur,200,200);
                    resume= sql.getresume(valeurBouton);
                    Acceuil.ajouterResume(resume);



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
    public void ButtonConnexion(Personne personne,JButton boutonConnexion, JFrame frame){
        boutonConnexion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton de connexion est cliqué
                frame.dispose(); // Fermer la fenêtre actuelle

                // Afficher l'interface de saisie utilisateur et mot de passe
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                System.out.println("Affichage de l'interface de connexion");
                a.afficherInterfaceConnexion(frame);
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
                Personne personne = new Personne(0, "invite", 0);

                Generale g = new Generale();
                try {
                    g.LancementJeux(personne);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonEnregistrer(JButton boutonEnregistrer,JTextField nom, JTextField prenom,JComboBox comboBoxAge,JTextField password, JTextField confirmationPassword,JFrame frame){
        boutonEnregistrer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer selectedOption = (Integer) comboBoxAge.getSelectedItem();
                String nomUtilisateur = nom.getText();
                String prenomUtilisateur = prenom.getText();
                int age = selectedOption;
                String mdp = password.getText();
                String confirmMDP = confirmationPassword.getText();

                try {
                    Connexion v = new Connexion();
                    if(v.verificationInscription(nomUtilisateur,prenomUtilisateur,age,mdp,confirmMDP)){
                        v.InscriptionBDD(nomUtilisateur,prenomUtilisateur,age,mdp,frame);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs de l'inscription,\n Le mot de passe doit être identique à la confirmation.", "Erreur d'inscription", JOptionPane.ERROR_MESSAGE);
                    }
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
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                a.FormulaireInscription(frame);
                // Afficher l'interface de saisie utilisateur et mot de passe

                // CODE D'INSCRIPTION ICI
            }
        });
    }
    public void ButtonValider(JButton boutonValider, JTextField champUtilisateur, JPasswordField champMotDePasse, JFrame frame){
        boutonValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer les valeurs saisies par l'utilisateur
                Personne personne;
                String utilisateur = champUtilisateur.getText();
                String motDePasse = new String(champMotDePasse.getPassword());
                Connexion v = null;
                Generale g = new Generale();
                int type=0;
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                try {
                    v = new Connexion();
                    v.verifierDisponibiliteFilm(utilisateur,motDePasse);
                    if(v.verifierDisponibiliteFilm(utilisateur, motDePasse))
                    {
                        System.out.println("yep");
                        type=v.getType(utilisateur,motDePasse);
                        int id=v.getID(utilisateur,motDePasse);
                        personne=new Personne(type,utilisateur,id);
                        if(type==1)
                        {
                          EspaceAdmin espace= new EspaceAdmin();
                          espace.afficherInterfaceAdmin();
                        }
                        else{
                            g.LancementJeux(personne);
                        }
                        ///code qui associe les id a la personne

                    }
                    else{
                        a.afficherInfosErreur(frame);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                ////Generale g = new Generale();
                // Afficher les informations saisies dans une nouvelle interface
                System.out.println("BOUTON VALDER APPUUYER");
                /*try {
                    if(v.verifierDisponibiliteFilm(utilisateur,motDePasse)){
                        frame.dispose();
                        g.LancementJeux(personne);
                        // CODE DU JEUX
                    }
                    else {
                        a.afficherInfosErreur(frame);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }*/

                // Fermer la fenêtre de connexion
                frame.dispose();
            }
        });
    }
    public void ButtonRetour(JButton boutonRetour,JFrame frame){
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre des informations utilisateur
                frame.dispose();
                Generale g = new Generale();
                try {
                    g.Generale();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    public void ButtonRetour1(JButton boutonRetour, JFrame frame){
        boutonRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AfficherInterfaceConnexion a = new AfficherInterfaceConnexion();
                a.afficherInterfaceConnexion(frame);
                // Fermer la fenêtre des informations utilisateur
                frame.dispose();

                // Afficher à nouveau la fenêtre principale
                //frame.setVisible(true);
            }
        });
    }


    public void ajouterListenernbrfilm(JTextField field, Page Acceuil, JTextField field2,Personne personne) {
        JB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titreFilm = field.getText().trim();
                String inputPlaces = field2.getText().trim();
                try {
                    int nombrePlaces = Integer.parseInt(inputPlaces);
                    if (nombrePlaces < 0) {
                        JOptionPane.showMessageDialog(null, "Le nombre de places ne peut pas être négatif.", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    try {
                        Connexion sql = new Connexion();
                        int placesDisponibles = sql.getnbrplace(titreFilm);
                        if (nombrePlaces > placesDisponibles) {
                            JOptionPane.showMessageDialog(null, "Vous depassez le nombres de place disponible. Veuillez réessayer", "Erreur de validation", JOptionPane.ERROR_MESSAGE);
                            return;
                        }

                        int prix = sql.getnbrfilm(titreFilm, nombrePlaces);
                        String imageUrl = sql.getFilmName(titreFilm);
                        if (imageUrl.equals("")) {
                            imageUrl = "/fermer.jpeg";
                        }

                        Acceuil.afficherImageURL(imageUrl, 0, 0);
                        String resume = sql.getresume(titreFilm);
                        Acceuil.ajouterResume(resume);

                        JOptionPane.showMessageDialog(null, "Réservation pour " + nombrePlaces + " places confirmée. Prix total : " + prix + "euros", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                        int response = JOptionPane.showConfirmDialog(null, "Réserver " + nombrePlaces + " places pour le film '" + titreFilm + "' pour un total de " + prix + " euros?\n" , "Confirmation de la réservation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Votre réservation a été confirmée. La facture vous sera envoyée par email.", "Réservation confirmée", JOptionPane.INFORMATION_MESSAGE);
                            sql.decrementerPlaces(titreFilm, nombrePlaces);
                            Acceuil.dispose();
                            Generale genaral = new Generale();
                            genaral.LancementJeux(personne);

                        } else {
                            JOptionPane.showMessageDialog(null, "Réservation annulée.", "Annulation", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } finally {
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide pour les places.", "Erreur de format", JOptionPane.ERROR_MESSAGE);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL: " + ex.getMessage(), "Erreur SQL", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver JDBC non trouvé: " + ex.getMessage(), "Erreur de Driver", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
