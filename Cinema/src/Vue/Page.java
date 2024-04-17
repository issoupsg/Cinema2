package Vue;

import javax.swing.*;
import java.awt.*;

public class Page extends JFrame {
    int x;
    int y;
    JPanel panel;
    JPanel panel2;
    JFrame frame;
    JPanel buffer;
    public Page(int x , int y,String titre){
        this.x=x;
        this.y=y;
        frame=new JFrame(titre);
        panel=new JPanel();
        panel2=new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //// frame.getContentPane().setBackground(Color.BLUE);

        buffer=new JPanel();
        //// frame.add(buffer);
        frame.setLayout(new GridLayout(2, 2,20,20));
        //// panel.setLayout(new BorderLayout());
        ///// panel2.setLayout(new BorderLayout());
        buffer.setLayout(new BorderLayout());

// Créer un panel sans marge interne
        ////panel.setBorder(BorderFactory.createEmptyBorder());
        panel2.setBorder(BorderFactory.createEmptyBorder());
        buffer.setBorder(BorderFactory.createEmptyBorder());
        panel.setPreferredSize(new Dimension(500, 5));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        buffer.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panel2.setPreferredSize(new Dimension(500, 5));
        buffer.setPreferredSize(new Dimension(500, 200));
        frame.add(panel,BorderLayout.WEST);
        frame.add(panel2,BorderLayout.EAST);
        frame.add(buffer);



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
        panel2.add(bouton);
    }
    public void afficherImageURL(String nomimage,int coordonnex,int coordonney) {
        SwingUtilities.invokeLater(() -> {
            try {
                ImageIcon image = new ImageIcon(getClass().getResource(nomimage));
                JLabel label = new JLabel(image);
                buffer.removeAll();
                // Définir explicitement la position et la taille
                label.setBounds(coordonnex, coordonney, 40, 40); // Ajuste selon les besoins
                label.setSize(10,10);
                buffer.setBounds(0,60,40,40);
                buffer.add(label);
                panel2.setVisible(true);
                frame.pack();
                //// frame.setLocationRelativeTo(null);
                buffer.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Impossible de charger l'image", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
