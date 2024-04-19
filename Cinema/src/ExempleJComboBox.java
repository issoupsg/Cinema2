import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExempleJComboBox {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        JFrame frame = new JFrame("Exemple JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        // Création d'une JComboBox avec quelques options
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.addItem("1");
        comboBox.addItem("2");
        comboBox.addItem("3");

        String selectedOption = (String) comboBox.getSelectedItem();
        // Ajout de la JComboBox à la fenêtre
        frame.getContentPane().add(comboBox, BorderLayout.CENTER);

        // Création d'un bouton pour afficher l'option sélectionnée
        JButton button = new JButton("Afficher Option");
        frame.getContentPane().add(button, BorderLayout.SOUTH);

        // Ajout d'un écouteur d'événements au bouton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Récupérer l'option sélectionnée
                // Afficher l'option sélectionnée dans la console
                System.out.println("Option sélectionnée : " + selectedOption);
            }
        });

        // Rendre la fenêtre visible
        frame.setVisible(true);
    }
}