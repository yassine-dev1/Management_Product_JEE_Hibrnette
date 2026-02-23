package dto;

import java.util.List;

import dto.CommandeDTO;


public class ProduitDTO {
	
	private int id;
	private String libelle;
	private float prix;
	private int qtstock;
	private float sous_total;
	private int fournisseurId;
	public int getFournisseurId() { return fournisseurId; }
	public void setFournisseurId(int fournisseurId) { this.fournisseurId = fournisseurId; }

	// Méthode pour ajuster le stock
	public void ajusterStock(int quantite) {
		this.qtstock += quantite;
	}

	// Méthode pour calculer le sous-total
	public void calculerSousTotal(int quantite) {
		this.sous_total = this.prix * quantite;
	}

	private List<CommandeDTO> commandes;

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

	public List<CommandeDTO> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<CommandeDTO> commandes) {
		this.commandes = commandes;
	}

	public ProduitDTO(int id, String libelle, float prix, int qtstock) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.qtstock = qtstock;
		
	}

	public float getSous_total() {
		return sous_total;
	}

	public void setSous_total(float sous_total) {
		this.sous_total = sous_total;
	}

	public ProduitDTO() {
		super();
	}

	@Override
	public String toString() {
		return "id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qtstock=" + qtstock;
	}

}
