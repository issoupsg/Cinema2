import javax.swing.*;
import java.awt.*;

public class ImageDeFondAvecImageIcon {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Image de Fond");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        int largeurFenetre = frame.getWidth();
        int hauteurFenetre = frame.getHeight();

        // Chargement de l'image à partir du fichier
        ImageIcon imageIcon = new ImageIcon(ImageDeFondAvecImageIcon.class.getResource("/attaque.jpg")); // Remplacez "background.jpg" par le chemin de votre image

        // Création d'un JLabel pour afficher l'image de fond
        JLabel backgroundLabel = new JLabel(imageIcon);

        // Définition du layout de la JFrame en BorderLayout pour occuper tout l'espace
        frame.setLayout(new BorderLayout());

        // Ajout du JLabel avec l'image de fond à la JFrame en arrière-plan
        frame.setContentPane(backgroundLabel);

        // Ajout d'autres composants à la JFrame si nécessaire
        JLabel label = new JLabel("Contenu au premier plan");
        label.setForeground(Color.WHITE); // Changer la couleur du texte en blanc pour une meilleure lisibilité
        label.setHorizontalAlignment(JLabel.CENTER);
        frame.add(label, BorderLayout.CENTER);

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}