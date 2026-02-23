package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.FournisseurController;
import dto.FournisseurDTO;

public class Form_Fournisseur extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNom;
    private JTextField txtContact;
    private JTextField txtTelephone;
    private JTextField txtEmail;
    private JTextField txtAdresse;
    private JTextField txtId;
    private FournisseurController controller;

    public Form_Fournisseur() {
        setTitle("Gestion Fournisseur");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNom = new JLabel("Nom :");
        lblNom.setBounds(30, 30, 80, 25);
        contentPane.add(lblNom);
        txtNom = new JTextField();
        txtNom.setBounds(120, 30, 200, 25);
        contentPane.add(txtNom);

        JLabel lblContact = new JLabel("Contact :");
        lblContact.setBounds(30, 70, 80, 25);
        contentPane.add(lblContact);
        txtContact = new JTextField();
        txtContact.setBounds(120, 70, 200, 25);
        contentPane.add(txtContact);

        JLabel lblTelephone = new JLabel("Téléphone :");
        lblTelephone.setBounds(30, 110, 80, 25);
        contentPane.add(lblTelephone);
        txtTelephone = new JTextField();
        txtTelephone.setBounds(120, 110, 200, 25);
        contentPane.add(txtTelephone);

        JLabel lblEmail = new JLabel("Email :");
        lblEmail.setBounds(30, 150, 80, 25);
        contentPane.add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(120, 150, 200, 25);
        contentPane.add(txtEmail);

        JLabel lblAdresse = new JLabel("Adresse :");
        lblAdresse.setBounds(30, 190, 80, 25);
        contentPane.add(lblAdresse);
        txtAdresse = new JTextField();
        txtAdresse.setBounds(120, 190, 200, 25);
        contentPane.add(txtAdresse);

        JLabel lblId = new JLabel("ID :");
        lblId.setBounds(30, 230, 80, 25);
        contentPane.add(lblId);
        txtId = new JTextField();
        txtId.setBounds(120, 230, 80, 25);
        contentPane.add(txtId);

        controller = new FournisseurController();

        JButton btnAjouter = new JButton("Ajouter");
        btnAjouter.setBounds(30, 270, 100, 30);
        contentPane.add(btnAjouter);
        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FournisseurDTO dto = new FournisseurDTO(
                        Integer.parseInt(txtId.getText()),
                        txtNom.getText(),
                        txtContact.getText(),
                        txtTelephone.getText(),
                        txtEmail.getText(),
                        txtAdresse.getText()
                    );
                    controller.createFournisseur(dto);
                    JOptionPane.showMessageDialog(null, "Fournisseur ajouté !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID invalide.");
                }
            }
        });

        JButton btnAfficher = new JButton("Afficher");
        btnAfficher.setBounds(140, 270, 100, 30);
        contentPane.add(btnAfficher);
        btnAfficher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                java.util.List<FournisseurDTO> fournisseurs = controller.retreive();
                StringBuilder sb = new StringBuilder();
                for (FournisseurDTO f : fournisseurs) {
                    sb.append(f.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(null, sb.toString(), "Liste des Fournisseurs", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        JButton btnModifier = new JButton("Modifier");
        btnModifier.setBounds(250, 270, 100, 30);
        contentPane.add(btnModifier);
        btnModifier.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FournisseurDTO dto = new FournisseurDTO(
                        Integer.parseInt(txtId.getText()),
                        txtNom.getText(),
                        txtContact.getText(),
                        txtTelephone.getText(),
                        txtEmail.getText(),
                        txtAdresse.getText()
                    );
                    controller.updateFournisseur(dto);
                    JOptionPane.showMessageDialog(null, "Fournisseur modifié !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID invalide.");
                }
            }
        });

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setBounds(30, 310, 100, 30);
        contentPane.add(btnSupprimer);
        btnSupprimer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.deleteFournisseur(Integer.parseInt(txtId.getText()));
                    JOptionPane.showMessageDialog(null, "Fournisseur supprimé !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID invalide.");
                }
            }
        });

        JButton btnRechercher = new JButton("Rechercher");
        btnRechercher.setBounds(140, 310, 100, 30);
        contentPane.add(btnRechercher);
        btnRechercher.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FournisseurDTO f = controller.findById(Integer.parseInt(txtId.getText()));
                    if (f != null) {
                        txtNom.setText(f.getNom());
                        txtContact.setText(f.getContact());
                        txtTelephone.setText(f.getTelephone());
                        txtEmail.setText(f.getEmail());
                        txtAdresse.setText(f.getAdresse());
                        JOptionPane.showMessageDialog(null, "Fournisseur trouvé.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fournisseur introuvable.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID invalide.");
                }
            }
        });
    }
}
