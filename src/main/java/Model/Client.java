package Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private double capital;
	private String adresse;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getCapital() {
		return capital;
	}
	public void setCapital(double capital) {
		this.capital = capital;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", capital=" + capital + ", adresse=" + adresse + ", commandes="
				  + "]";
	}
	public Client(int id, String nom, double capital, String adresse, List<Commande> commandes) {
		super();
		this.id = id;
		this.nom = nom;
		this.capital = capital;
		this.adresse = adresse;
		this.commandes = commandes;
	}
	public Client() {
		super();
	}
	
	
	
	
	
}
