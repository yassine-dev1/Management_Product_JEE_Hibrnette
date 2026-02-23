package dto;

public class FournisseurDTO {
    private int id;
    private String nom;
    private String contact;
    private String telephone;
    private String email;
    private String adresse;

    public FournisseurDTO() {}

    public FournisseurDTO(int id, String nom, String contact, String telephone, String email, String adresse) {
        this.id = id;
        this.nom = nom;
        this.contact = contact;
        this.telephone = telephone;
        this.email = email;
        this.adresse = adresse;
    }

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

    @Override
    public String toString() {
        return "FournisseurDTO [id=" + id + ", nom=" + nom + ", contact=" + contact + ", telephone=" + telephone + ", email=" + email + ", adresse=" + adresse + "]";
    }
}
