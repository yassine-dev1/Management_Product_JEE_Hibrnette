package service;

import java.util.List;

import dto.ProduitDTO;

public interface ProduitServiceInterface {
	 List<ProduitDTO> retreive();
	 void createProduit(ProduitDTO produitDTO) ;
	 ProduitDTO findProduitById(int id);
	 void updateProduit(ProduitDTO produitDTO) ;
	 void deleteProduit(int id) ;
	 
}
