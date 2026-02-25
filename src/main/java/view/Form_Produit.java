package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EmptyBorder;
//import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.ProduitController;
import dto.ProduitDTO;

public class Form_Produit extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtLibelle;
    private JTextField txtPrix;
    private JTextField txtQtStock;
    private JComboBox<String> comboFournisseur;
    private java.util.List<bo.Fournisseur> fournisseursList;
    private ProduitController produitController;

    private JTable tableProduits;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public Form_Produit() {
        setTitle("Gestion Produit");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLibelle = new JLabel("Libellé :");
        lblLibelle.setBounds(30, 30, 80, 25);
        contentPane.add(lblLibelle);
        txtLibelle = new JTextField();
        txtLibelle.setBounds(120, 30, 200, 25);
        contentPane.add(txtLibelle);

        JLabel lblPrix = new JLabel("Prix :");
        lblPrix.setBounds(30, 70, 80, 25);
        contentPane.add(lblPrix);
        txtPrix = new JTextField();
        txtPrix.setBounds(120, 70, 200, 25);
        contentPane.add(txtPrix);

        JLabel lblQtStock = new JLabel("Qté Stock :");
        lblQtStock.setBounds(30, 110, 80, 25);
        contentPane.add(lblQtStock);
        txtQtStock = new JTextField();
        txtQtStock.setBounds(120, 110, 200, 25);
        contentPane.add(txtQtStock);

        JLabel lblFournisseur = new JLabel("Fournisseur :");
        lblFournisseur.setBounds(30, 150, 100, 25);
        contentPane.add(lblFournisseur);
        // Charger les fournisseurs
        fournisseursList = new dao.FournisseurDAO().retreive();
        comboFournisseur = new JComboBox<>();
        if (fournisseursList != null) {
            for (bo.Fournisseur f : fournisseursList) {
                comboFournisseur.addItem(f.getNom());
            }
        }
        comboFournisseur.setBounds(140, 150, 180, 25);
        contentPane.add(comboFournisseur);

        JButton btnAjouter = new JButton("Ajouter Produit");
        btnAjouter.setBounds(320, 190, 150, 30);
        contentPane.add(btnAjouter);

        produitController = new ProduitController();

        btnAjouter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ProduitDTO produit = new ProduitDTO();
                produit.setLibelle(txtLibelle.getText());
                try {
                    produit.setPrix(Float.parseFloat(txtPrix.getText()));
                    produit.setQtstock(Integer.parseInt(txtQtStock.getText()));
                    int selectedIndex = comboFournisseur.getSelectedIndex();
                    if (selectedIndex >= 0 && fournisseursList != null && selectedIndex < fournisseursList.size()) {
                        produit.setFournisseurId(fournisseursList.get(selectedIndex).getId());
                    }
                    produitController.createProduit(produit);
                    JOptionPane.showMessageDialog(null, "Produit ajouté avec succès !");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erreur de saisie : prix ou stock invalide.");
                }
            }
        });


        // Création du modèle de table
        String[] columnNames = {"ID", "Libellé", "Prix", "Qté Stock", "Fournisseur"};
        tableModel = new DefaultTableModel(columnNames, 0);
        tableProduits = new JTable(tableModel);
        scrollPane = new JScrollPane(tableProduits);
        scrollPane.setBounds(30, 280, 620, 150);
        contentPane.add(scrollPane);

        // Remplir la table dès l'ouverture
        remplirTableProduits();
    }

    private void remplirTableProduits() {
        tableModel.setRowCount(0);
        java.util.List<ProduitDTO> produits = produitController.getAllProduit();
        for (ProduitDTO p : produits) {
            String fournisseurNom = "";
            if (fournisseursList != null) {
                for (bo.Fournisseur f : fournisseursList) {
                    if (f.getId() == p.getFournisseurId()) {
                        fournisseurNom = f.getNom();
                        break;
                    }
                }
            }
            Object[] row = {p.getId(), p.getLibelle(), p.getPrix(), p.getQtstock(), fournisseurNom};
            tableModel.addRow(row);
        }

            // Champ pour l'ID du produit à modifier/supprimer/rechercher
            JLabel lblId = new JLabel("ID Produit :");
            lblId.setBounds(30, 230, 80, 25);
            contentPane.add(lblId);

            JTextField txtId = new JTextField();
            txtId.setBounds(120, 230, 80, 25);
            contentPane.add(txtId);

            // Bouton Modifier
            JButton btnModifier = new JButton("Modifier");
            btnModifier.setBounds(210, 230, 90, 25);
            contentPane.add(btnModifier);
            btnModifier.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(txtId.getText());
                        ProduitDTO produit = produitController.findProduitById(id);
                        if (produit != null) {
                            produit.setLibelle(txtLibelle.getText());
                            produit.setPrix(Float.parseFloat(txtPrix.getText()));
                            produit.setQtstock(Integer.parseInt(txtQtStock.getText()));
                            int selectedIndex = comboFournisseur.getSelectedIndex();
                            if (selectedIndex >= 0 && fournisseursList != null && selectedIndex < fournisseursList.size()) {
                                produit.setFournisseurId(fournisseursList.get(selectedIndex).getId());
                            }
                            produitController.updateProduit(produit);
                            JOptionPane.showMessageDialog(null, "Produit modifié avec succès !");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produit introuvable.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de saisie : ID, prix ou stock invalide.");
                    }
                }
            });

            // Bouton Supprimer
            JButton btnSupprimer = new JButton("Supprimer");
            btnSupprimer.setBounds(310, 230, 90, 25);
            contentPane.add(btnSupprimer);
            btnSupprimer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(txtId.getText());
                        produitController.deleteProduit(id);
                        JOptionPane.showMessageDialog(null, "Produit supprimé (si existant).");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de saisie : ID invalide.");
                    }
                }
            });

            // Bouton Rechercher
            JButton btnRechercher = new JButton("Rechercher");
            btnRechercher.setBounds(310, 30, 120, 25);
            contentPane.add(btnRechercher);
            btnRechercher.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        int id = Integer.parseInt(txtId.getText());
                        ProduitDTO produit = produitController.findProduitById(id);
                        if (produit != null) {
                            txtLibelle.setText(produit.getLibelle());
                            txtPrix.setText(String.valueOf(produit.getPrix()));
                            txtQtStock.setText(String.valueOf(produit.getQtstock()));
                            // Sélectionner le fournisseur dans la liste déroulante
                            if (fournisseursList != null) {
                                for (int i = 0; i < fournisseursList.size(); i++) {
                                    if (fournisseursList.get(i).getId() == produit.getFournisseurId()) {
                                        comboFournisseur.setSelectedIndex(i);
                                        break;
                                    }
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Produit trouvé et chargé dans le formulaire.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Produit introuvable.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Erreur de saisie : ID invalide.");
                    }
                }
            });
    }
}
