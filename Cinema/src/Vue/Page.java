package Vue;

import Modele.Bouton;
import Modele.BoutonAppuie;

import javax.swing.*;
import java.awt.*;

public class Page extends JFrame {
    private static final long serialVersionUID = -4939554401128745304L;
    int x;
    int y;
    JPanel panel;
    JPanel panel2;
    JFrame frame;
    JPanel buffer;
    public Page(){
        super("My first Swing application!");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        panel=(JPanel) this.getContentPane();
        buffer=new JPanel();



        ////  panel2=new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //// frame.getContentPane().setBackground(Color.BLUE);
        ////buffer=new JPanel();
        //// frame.add(buffer);

        //// panel.setLayout(new BorderLayout());
        ///// panel2.setLayout(new BorderLayout());
        ////buffer.setLayout(new BorderLayout());

// Créer un panel sans marge interne
        ////panel.setBorder(BorderFactory.createEmptyBorder());
        ////panel.setLayout(new GridLayout(2, 2));







    }
    public JPanel getPanel(){
        return panel;
    }
    public JFrame getFrame(){
        return frame;
    }
    public void ajouterbouton(JButton bouton,int x,int y,int largeur,int hauteur){
        ////bouton.setBounds(1920 / 2 - largeur / 2, 80, largeur, hauteur);
        bouton.setPreferredSize(new Dimension(250, hauteur));
        bouton.setLocation(x,y);
        panel.add(bouton);
    }
    public void ajouterbarre(JTextField bouton,int x,int y,int largeur,int hauteur){
        bouton.setPreferredSize(new Dimension(largeur, hauteur));
        ////bouton.setBounds(x,y,largeur,hauteur);
        panel.add(bouton);
    }
    public void afficherImageURL(String nomimage,int coordonnex,int coordonney) {
        SwingUtilities.invokeLater(() -> {
            try {
                ImageIcon image = new ImageIcon(getClass().getResource(nomimage));
                Image image1=image.getImage();
                Image newimg = image1.getScaledInstance(300,400,Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(newimg);
                JLabel label = new JLabel(resizedIcon);
                buffer.removeAll();
                // Définir explicitement la position et la taille
               /* label.setBounds(coordonnex, coordonney, 40, 40); // Ajuste selon les besoins
                label.setSize(10,10);
                L*/
                ////buffer.setBounds(0,60,40,40);

                buffer.add(label);
                panel.add(buffer,BorderLayout.EAST);
                buffer.revalidate();
                buffer.repaint();
                buffer.setVisible(true);


                //// frame.setLocationRelativeTo(null);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(panel, "Impossible de charger l'image", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
