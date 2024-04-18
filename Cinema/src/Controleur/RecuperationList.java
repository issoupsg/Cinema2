package Controleur;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RecuperationList {
    private JList<String> list;

    public RecuperationList(JList<String> list) {
        this.list = list;
    }

    public void ajouterListen(JList<String> liste) {
        System.out.println("ajouterListen");
        liste.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("reissi");
                if (e.getClickCount() == 1) {
                    processSingleClick(e);
                }
            }
        });
    }

    private void processSingleClick(MouseEvent e) {
        int index = list.locationToIndex(e.getPoint());
        if (index >= 0) {
            String selectedName = list.getModel().getElementAt(index);
            System.out.println("Selected Name: " + selectedName);
            // Implement additional actions here based on the selected item
        }
    }
}
