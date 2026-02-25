
package Model ;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

@Entity
public class Fournisseur implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Identifiant du fournisseur
    
    private String nom;  // Nom de l'entreprise
    private String contact;  // Personne de contact
    private String telephone;  // Numéro de téléphone
    private String email;  // Adresse email
    private String adresse;  // Adresse physique
    
    
    /*
	* @OneToMany : un fournisseur peut fournir plusieurs produits.
	mappedBy = "fournisseur" :
	signifie que la clé étrangère est définie dans la classe Produit.
	dans Produit, tu dois avoir :
     */
    
    @OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
    // Un fournisseur peut fournir plusieurs produits
    private List<Produit> produits;  // Produits fournis

    // Constructeurs
    public Fournisseur() {
        super();
    }
    
    public Fournisseur(String nom, String contact, String telephone, String email, String adresse) {
        super();
        this.nom = nom;
        this.contact = contact;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

        public Fournisseur(int id, String nom, String adresse, String telephone) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    
    // Getters et Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }
    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
    
    @Override
    public String toString() {
        return "Fournisseur [id=" + id + ", nom=" + nom + "]";
    }
}

