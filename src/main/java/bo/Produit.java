package bo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;

@Entity
public class Produit  implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String libelle;
private float prix;
private int qtstock;



@OneToMany(mappedBy = "produit")
private List<Ligne_Commande> lignes;

@ManyToOne
@JoinColumn(name = "id_fournisseur") // Le nom de la colonne physique dans la table Produit
private Fournisseur fournisseur;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}

public void setLibelle(String libelle) {
	this.libelle = libelle;
}

public float getPrix() {
	return prix;
}

public void setPrix(float prix) {
	this.prix = prix;
}

public int getQtstock() {
	return qtstock;
}

public void setQtstock(int qtstock) {
	this.qtstock = qtstock;
}

public List<Ligne_Commande> getLignes() {
	return lignes;
}

public void setCommandes(List<Ligne_Commande> lignes) {
	this.lignes = lignes;
}

public Fournisseur getFournisseur() { return fournisseur; }
public void setFournisseur(Fournisseur fournisseur) { this.fournisseur = fournisseur; }

public Produit(int id, String libelle, float prix, int qtstock) {
	super();
	this.id = id;
	this.libelle = libelle;
	this.prix = prix;
	this.qtstock = qtstock;
	
}

public Produit() {
	super();
}

@Override
public String toString() {
	return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qtstock=" + qtstock + "]";
}



}
