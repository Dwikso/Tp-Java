import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;


public class Exo2d {
    public static void main(String[] args) {
           JFrame fenetre = new JFrame("Jeux Mysterieux FlowLayout");
           fenetre.setVisible(true);
           fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           fenetre.setSize(700,700);
           JButton btnFin = new JButton("Fin");
           JButton btnCommencer = new JButton("Commencer");
           JLabel lblResultat = new JLabel("Trouver un nombre entre 0 et 99");
           JLabel lblNbCoups = new JLabel("0");
           JTextField txtSaisie = new JTextField(5);

           Container cont = fenetre.getContentPane();
           cont.setLayout(new GridBagLayout(3,2));

           LiaisonMystIG.setBtnFin(btnFin);
           LiaisonMystIG.setBtnCommencer(btnCommencer);
           LiaisonMystIG.setLblResultat(lblResultat);
           LiaisonMystIG.setLblNbCoups(lblNbCoups);
           LiaisonMystIG.setZoneSaisie(txtSaisie);

           cont.add(btnFin, BorderLayout.EAST);
           cont.add(btnCommencer, BorderLayout.WEST);
           cont.add(lblResultat, BorderLayout.NORTH);
           cont.add(lblNbCoups,BorderLayout.SOUTH);
           cont.add(txtSaisie, BorderLayout.CENTER);
    }
}