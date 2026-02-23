package service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import bo.Client;
import bo.Produit;
import dao.ProduitDAO;
import dto.ClientDTO;
import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;
import dto.ProduitDTO;

public class ProduitService implements ProduitServiceInterface{

	@Override
	public List<ProduitDTO> retreive() {
		
		 List<ProduitDTO> produitdtos=new ProduitDAO().retreive().stream().map(p->fromProduit(p)).collect(Collectors.toList());
		 return produitdtos;
	}

	@Override
	public void createProduit(ProduitDTO produitDTO) {
		Produit produit = toProduit(produitDTO);
		new ProduitDAO().create(produit);
	}

	@Override
	public ProduitDTO findProduitById(int id) {
		Produit produit = new ProduitDAO().findById(id);
		if (produit != null) {
			return fromProduit(produit);
		}
		return null;
	}

	@Override
	public void updateProduit(ProduitDTO produitDTO) {
		Produit produit = toProduit(produitDTO);
		new ProduitDAO().update(produit);
	}

	@Override
	public void deleteProduit(int id) {
		new ProduitDAO().delete(id);
	}

		public ProduitDTO fromProduit(Produit produit) {
			ProduitDTO produitdto = new ProduitDTO();
			produitdto.setId(produit.getId());
			produitdto.setQtstock(produit.getQtstock());
			produitdto.setLibelle(produit.getLibelle());
			produitdto.setPrix(produit.getPrix());
			if (produit.getFournisseur() != null) {
				produitdto.setFournisseurId(produit.getFournisseur().getId());
			}
			return produitdto;
		}

		public Produit toProduit(ProduitDTO produitdto) {
			Produit produit = new Produit();
			produit.setId(produitdto.getId());
			produit.setQtstock(produitdto.getQtstock());
			produit.setLibelle(produitdto.getLibelle());
			produit.setPrix(produitdto.getPrix());
			if (produitdto.getFournisseurId() > 0) {
				// Charger le fournisseur depuis la base
				bo.Fournisseur fournisseur = new dao.FournisseurDAO().findById(produitdto.getFournisseurId());
				produit.setFournisseur(fournisseur);
			}
			return produit;
		}
	public void decrease_stock() {
		CommandeDTO cmd=new CommandeService().getCommandeDTO();
		for(Ligne_CommandeDTO l:cmd.getLignes()) {
			ProduitDTO p=l.getProduit();
			p.setQtstock(p.getQtstock()-l.getQuantite());
			new ProduitDAO().update(this.toProduit(p));
		}
		
	}

		// Nouveau traitement : ajuster le stock et calculer le sous-total
	public void ajusterStockEtSousTotal(int produitId, int quantite) {
		ProduitDTO produit = this.retreive().stream()
			.filter(p -> p.getId() == produitId)
			.findFirst()
			.orElse(null);
		if (produit != null) {
			produit.ajusterStock(-quantite);
			produit.calculerSousTotal(quantite);
			new ProduitDAO().update(this.toProduit(produit));
		}
	}
}
