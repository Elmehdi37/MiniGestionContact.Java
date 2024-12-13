import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main(){
        this.setTitle("Gestion De Contact");
        this.setSize(500,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Ici, le menu a été créé qui se trouve en haut de l'application
        JMenuBar menu  = new JMenuBar();
        JMenu menuFile = new JMenu("Fichier");
        JMenuItem close = new JMenuItem("Fermer");
        close.addActionListener(e -> dispose());
        menuFile.add(close);
        JMenu aideFIle = new JMenu("Aide");
        JMenuItem about = new JMenuItem("A propos");
        aideFIle.add(about);
        menu.add(menuFile);
        menu.add(aideFIle);
        this.setJMenuBar(menu);

        // Ici pour créer le tableau
        Model database = new Model();
        JTable table = new JTable(database);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        // Ici, nous allons créer un emplacement pour les boutons
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER,10,10));
        JButton ajouter = new JButton("Ajouter");
        ajouter.addActionListener(e -> {
            new Dialog(this,database);
        });
        JButton supprimer = new JButton("supprimer");
        supprimer.addActionListener(e -> {
            if(database.sizeData() == 0){
                JOptionPane.showMessageDialog(this,"Il n'y a rien à supprimer dans la base de données");
            }
            else{
                Integer index = table.getSelectedRow();
                if(index.equals(-1)){
                    JOptionPane.showMessageDialog(this,"Vous n'avez sélectionné personne que vous souhaitez supprimer de la base de données","Errue",JOptionPane.ERROR_MESSAGE);
                }
                else {
                    int i = JOptionPane.showConfirmDialog(this,"Souhaitez-vous travailler dans un tel élément de la base de données ?","Attention",JOptionPane.WARNING_MESSAGE,JOptionPane.YES_NO_OPTION);
                    if(i == JOptionPane.YES_NO_OPTION){
                        database.removePersonne(index);
                        JOptionPane.showMessageDialog(this,"Cet élément a été supprimé avec succès");
                    }
                }
            }
        });
        panelButton.add(ajouter);
        panelButton.add(supprimer);
        this.add(panelButton, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args){
        new Main();
    }
}
