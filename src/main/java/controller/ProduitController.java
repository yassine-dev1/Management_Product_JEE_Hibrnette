package controller;

import java.util.List;

import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;
import dto.ProduitDTO;
import service.CommandeService;
import service.ProduitService;

public class ProduitController {
public List<ProduitDTO> getAllProduit(){
	ProduitService produitservice=new ProduitService();
	return produitservice.retreive();
}
public void decrease_stock(){
	
	ProduitService produitservice=new ProduitService();
	  produitservice.decrease_stock();
}

	// Nouveau traitement : ajuster le stock et calculer le sous-total
	public void ajusterStockEtSousTotal(int produitId, int quantite) {
		ProduitService produitService = new ProduitService();
		produitService.ajusterStockEtSousTotal(produitId, quantite);
	}

	// CREATE
	public void createProduit(ProduitDTO produitDTO) {
		ProduitService produitService = new ProduitService();
		produitService.createProduit(produitDTO);
	}

	// READ by ID
	public ProduitDTO findProduitById(int id) {
		ProduitService produitService = new ProduitService();
		return produitService.findProduitById(id);
	}

	// UPDATE
	public void updateProduit(ProduitDTO produitDTO) {
		ProduitService produitService = new ProduitService();
		produitService.updateProduit(produitDTO);
	}

	// DELETE
	public void deleteProduit(int id) {
		ProduitService produitService = new ProduitService();
		produitService.deleteProduit(id);
	}
}
