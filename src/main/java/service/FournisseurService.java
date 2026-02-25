package service;

import java.util.List;
import java.util.stream.Collectors;

import Model.Fournisseur;
import dao.FournisseurDAO;
import dto.FournisseurDTO;

public class FournisseurService {
    private FournisseurDAO dao = new FournisseurDAO();

    public void createFournisseur(FournisseurDTO dto) {
        dao.create(fromDTO(dto));
    }

    public List<FournisseurDTO> retreive() {
        return dao.retreive().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public FournisseurDTO findById(int id) {
        Fournisseur f = dao.findById(id);
        return f != null ? toDTO(f) : null;
    }

    public void updateFournisseur(FournisseurDTO dto) {
        dao.update(fromDTO(dto));
    }

    public void deleteFournisseur(int id) {
        dao.delete(id);
    }

    private Fournisseur fromDTO(FournisseurDTO dto) {
        Fournisseur f = new Fournisseur();
        f.setId(dto.getId());
        f.setNom(dto.getNom());
        f.setContact(dto.getContact());
        f.setTelephone(dto.getTelephone());
        f.setEmail(dto.getEmail());
        f.setAdresse(dto.getAdresse());
        return f;
    }

    private FournisseurDTO toDTO(Fournisseur f) {
        FournisseurDTO dto = new FournisseurDTO();
        dto.setId(f.getId());
        dto.setNom(f.getNom());
        dto.setContact(f.getContact());
        dto.setTelephone(f.getTelephone());
        dto.setEmail(f.getEmail());
        dto.setAdresse(f.getAdresse());
        return dto;
    }
}
