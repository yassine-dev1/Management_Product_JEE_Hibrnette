package service;

import Model.Client;
import Model.Ligne_Commande;
import dto.ClientDTO;
import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;
import dto.ProduitDTO;

public class Ligne_CommandeService {

	public Ligne_CommandeDTO getNewLigne(int q,ProduitDTO p) {
		Ligne_CommandeDTO ligne = null;
		if(q<=p.getQtstock()) {
		ligne=new Ligne_CommandeDTO();
		ligne.setQuantite(q);
		ligne.setSous_total(ligne.getQuantite()*p.getPrix());
		ligne.setProduit(p);
		
		}
		return ligne;	
	}
	public Ligne_Commande toLigne(Ligne_CommandeDTO lignedto) {
		Ligne_Commande ligne=new Ligne_Commande();
		ligne.setQuantite(lignedto.getQuantite());
		ligne.setProduit(new ProduitService().toProduit(lignedto.getProduit()));
		ligne.setSous_total(lignedto.getSous_total());
		return ligne;
	}
	public boolean exists(ProduitDTO p) {
		CommandeDTO cmd=new CommandeService().getCommandeDTO();
		boolean trouve=false;
		
		for(Ligne_CommandeDTO l:cmd.getLignes()) 
		{
			if(l.getProduit().getId()==p.getId())
			{
				trouve=true;
				
				break;
			}
		}
		
		return trouve;
	}
}
