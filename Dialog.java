import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Dialog extends JFrame {
    Dialog(Main frame,Model base){
        this.setTitle("Ajouter Un Contact");
        this.setSize(350,250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(frame);

        JPanel contentPane = (JPanel) getContentPane();

        // Ici, nous allons créer un endroit pour remplir les informations
        JPanel panelText = new JPanel(new GridLayout(3,2,10,10));
        panelText.add(new JLabel("Nom :"));
        JTextField textNom = new JTextField();
        panelText.add(textNom);
        panelText.add(new JLabel("Prénom :"));
        JTextField textPrenom = new JTextField();
        panelText.add(textPrenom);
        panelText.add(new JLabel("Téléphone :"));
        JTextField textTele = new JTextField();
        panelText.add(textTele);
        contentPane.add(panelText, BorderLayout.NORTH);
        contentPane.setBorder(new EmptyBorder(30,15,30,15));

        // Ici nous allons créer l'emplacement des boutons
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        JButton enregistrer = new JButton("Enregistrer");
        enregistrer.addActionListener(e -> {
            Personne personne = new Personne(textNom.getText(),textPrenom.getText(),textTele.getText());
            base.addPersonne(personne);
            textNom.setText("");
            textPrenom.setText("");
            textTele.setText("");
        });
        JButton fermer = new JButton("Fermer");
        fermer.addActionListener(e -> {
            dispose();
        });
        panelButton.add(enregistrer);
        panelButton.add(fermer);
        contentPane.add(panelButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
