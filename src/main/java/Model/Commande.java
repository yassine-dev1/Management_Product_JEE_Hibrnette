package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
@Entity
public class Commande implements Serializable{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int idcmd;

private Date datecmd;

@Transient
private float total;

@ManyToOne
@JoinColumn(name="id")
private Client client;

@OneToMany(mappedBy = "commande")
private List<Ligne_Commande> lignes;

public int getIdcmd() {
	return idcmd;
}
public void setIdcmd(int idcmd) {
	this.idcmd = idcmd;
}
public Date getDatecmd() {
	return datecmd;
}
public void setDatecmd(Date datecmd) {
	this.datecmd = datecmd;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Commande(int idcmd, Date datecmd, Client client) {
	super();
	this.idcmd = idcmd;
	this.datecmd = datecmd;
	this.client = client;
}





@Override
public String toString() {
	return "Commande [idcmd=" + idcmd + ", datecmd=" + datecmd + ", client=" + client + "]";
}
public Commande() {
	super();
}
public float getTotal() {
	return total;
}
public void setTotal(float total) {
	this.total = total;
}
public List<Ligne_Commande> getLignes() {
	return lignes;
}
public void setLignes(List<Ligne_Commande> lignes) {
	this.lignes = lignes;
}

}
