package Controleur;

import Modele.Bouton;
import Modele.BoutonAppuie;
import Modele.ListPanel;
import Modele.Personne;

import javax.swing.*;
import java.awt.*;

public class EspaceAdmin extends JFrame {
    JPanel panel;
    JPanel buffer2;
    JFrame frame;
    JPanel buffer,bufferText;
    ListPanel pan;
    JList<String>nameList;

    public EspaceAdmin() {
        ///super("ma page");
        frame = new JFrame("Espace Admin");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setSize(450, 400);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
        panel=new JPanel();
        buffer=new JPanel();
    }

    public void lireFacture (JList<String> liste, Personne personne){
        panel.add(liste);
        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.BoutonPage(boutonRetour1,personne, frame);
        buffer.add(boutonRetour1);
        panel.setVisible(true);
        buffer.setVisible(true);
        frame.add(buffer, BorderLayout.CENTER);
        frame.add(panel, BorderLayout.NORTH);
    }
    public void afficherInterfaceAdmin() {
        ListPanel liste=new ListPanel();

        panel.add(liste,BorderLayout.NORTH);
        RecuperationBouton Jliste=new RecuperationBouton(liste.listeJusteNom());
        ///Jliste.ListenerJ(liste.listeJusteNom());
        Bouton boutonajout = new BoutonAppuie(0,0,50,50,"Ajouter");
        JButton boutonajout1 = boutonajout.CreaBouton();
        RecuperationBouton listener2 = new RecuperationBouton(boutonajout1);

        Bouton boutonsupp = new BoutonAppuie(0,0,50,50,"Supprimer");
        JButton boutonsupp1 = boutonsupp.CreaBouton();
        RecuperationBouton listenersupp = new RecuperationBouton(boutonsupp1);
       /// listenersupp.boutetList(liste.listeJusteNom(),boutonsupp1,Jliste);
        listenersupp.setupComponents(liste.listeJusteNom(),boutonsupp1,frame);

        Bouton boutonmodif = new BoutonAppuie(0,0,50,50,"Modifier");
        JButton boutonmod = boutonmodif.CreaBouton();
        RecuperationBouton listenersmod = new RecuperationBouton(boutonmod);

        Bouton boutontop = new BoutonAppuie(0,0,50,50,"Tendence");
        JButton boutontendence = boutontop.CreaBouton();
        RecuperationBouton listenerstop = new RecuperationBouton(boutontendence);


        Bouton boutonRetour = new BoutonAppuie(0,0,50,50,"Retour");
        JButton boutonRetour1 = boutonRetour.CreaBouton();
        RecuperationBouton listener = new RecuperationBouton(boutonRetour1);
        listener.ButtonRetour(boutonRetour1,frame);
        buffer.add(boutonRetour1);
        buffer.add(boutonsupp1);
        buffer.add(boutonajout1);
        buffer.add(boutonmod);
        buffer.add(boutontendence);

        buffer.setVisible(true);
        frame.add(buffer,BorderLayout.CENTER);
        frame.add(panel,BorderLayout.NORTH);



    }


}