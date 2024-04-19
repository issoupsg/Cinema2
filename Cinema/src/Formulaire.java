import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Formulaire  extends JFrame{
    JLabel labtitre,labnom,labprenom,labage,labsexe,labpays,labdiscipline;
    JTextField jtfnom,jtfprenom,jtfage;
    JRadioButton jrbfeminin,jrbmasculin;
    JComboBox combopays;
    JButton btajout;
    JCheckBox jchmarathon,jchnatation,jchsprint,jchsaut;
    public Formulaire(){
        this.setTitle("Inscription");
        this.setSize(400,480);
        this.setLocationRelativeTo(null);
        JPanel pan=new JPanel();
        pan.setLayout(null);
        pan.setBackground(new Color(173, 216, 230));
        add(pan);

        labtitre=new JLabel("Formulaire d'inscription");
        labtitre.setBounds(60,10,300,30);
        labtitre.setFont(new Font("Arial",Font.BOLD,22));
        labtitre.setForeground(Color.white);
        pan.add(labtitre);

        labnom=new JLabel("Nom :");
        labnom.setBounds(20,60,300,30);
        labnom.setFont(new Font("Arial",Font.BOLD,18));
        labnom.setForeground(Color.white);
        pan.add(labnom);

        jtfnom=new JTextField();
        jtfnom.setBounds(130,60,200,25);
        pan.add(jtfnom);

        labprenom=new JLabel("Pr�nom :");
        labprenom.setBounds(20,100,300,30);
        labprenom.setFont(new Font("Arial",Font.BOLD,18));
        labprenom.setForeground(Color.white);
        pan.add(labprenom);

        jtfprenom=new JTextField();
        jtfprenom.setBounds(130,100,200,25);
        pan.add(jtfprenom);

        labage=new JLabel("Age :");
        labage.setBounds(20,140,300,30);
        labage.setFont(new Font("Arial",Font.BOLD,18));
        labage.setForeground(Color.white);
        pan.add(labage);

        jtfage=new JTextField();
        jtfage.setBounds(130,140,200,25);
        pan.add(jtfage);

        labsexe=new JLabel("Sexe :");
        labsexe.setBounds(20,180,300,30);
        labsexe.setFont(new Font("Arial",Font.BOLD,18));
        labsexe.setForeground(Color.white);
        pan.add(labsexe);

        jrbfeminin=new JRadioButton("F�minin");
        jrbfeminin.setBounds(130,180,90,25);
        pan.add(jrbfeminin);

        jrbmasculin=new JRadioButton("Masculin");
        jrbmasculin.setBounds(240,180,90,25);
        pan.add(jrbmasculin);

        ButtonGroup bg=new ButtonGroup();
        bg.add(jrbfeminin);
        bg.add(jrbmasculin);


        labpays=new JLabel("Pays :");
        labpays.setBounds(20,220,300,30);
        labpays.setFont(new Font("Arial",Font.BOLD,18));
        labpays.setForeground(Color.white);
        pan.add(labpays);

        combopays=new JComboBox();
        combopays.setBounds(130,220,200,25);
        for (int i = 1; i <= 100; i++) {
            combopays.addItem(i);
        }
        combopays.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox<?> comboBox = (JComboBox<?>) e.getSource();
                Integer age = (Integer) comboBox.getSelectedItem();
                System.out.println("L'utilisateur a sélectionné l'âge : " + age);
            }
        });

        pan.add(combopays);

        labdiscipline=new JLabel("Discipline :");
        labdiscipline.setBounds(20,260,300,30);
        labdiscipline.setFont(new Font("Arial",Font.BOLD,18));
        labdiscipline.setForeground(Color.white);
        pan.add(labdiscipline);

        jchmarathon=new JCheckBox("Marathon");
        jchmarathon.setBounds(130,260,90,25);
        pan.add(jchmarathon);

        jchnatation=new JCheckBox("Natation");
        jchnatation.setBounds(240,260,90,25);
        pan.add(jchnatation);

        jchsprint=new JCheckBox("Sprint");
        jchsprint.setBounds(130,300,90,25);
        pan.add(jchsprint);

        jchsaut=new JCheckBox("Saut");
        jchsaut.setBounds(240,300,90,25);
        pan.add(jchsaut);

        btajout=new JButton("Enregistrer");
        btajout.setBounds(150,360,150,30);
        btajout.setBackground(Color.orange);
        btajout.setFont(new Font("Arial",Font.BOLD,18));
        btajout.setForeground(Color.white);
        pan.add(btajout);

    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // programm�e le 17-11-2022 par chrislink.net

        Formulaire form=new Formulaire();
        form.setVisible(true);
    }

}
