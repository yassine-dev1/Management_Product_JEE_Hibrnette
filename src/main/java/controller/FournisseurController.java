package controller;

import java.util.List;
import dto.FournisseurDTO ;
import service.FournisseurService;

public class FournisseurController {
    private FournisseurService service = new FournisseurService();

    public void createFournisseur(FournisseurDTO dto) {
        service.createFournisseur(dto);
    }

    public List<FournisseurDTO> retreive() {
        return service.retreive();
    }

    public FournisseurDTO findById(int id) {
        return service.findById(id);
    }

    public void updateFournisseur(FournisseurDTO dto) {
        service.updateFournisseur(dto);
    }

    public void deleteFournisseur(int id) {
        service.deleteFournisseur(id);
    }
}
