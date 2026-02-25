package service;

import java.util.Date;
import java.util.stream.Collectors;

import Model.Client;
import Model.Commande;
import dao.CommandeDAO;
import dto.ClientDTO;
import dto.CommandeDTO;
import dto.Ligne_CommandeDTO;

public class CommandeService {
	private static CommandeDTO cmd;
	public static CommandeDTO createCommandDTO() {
		if (cmd==null) cmd=new CommandeDTO();
		return cmd;
		
	}
	public CommandeDTO getCommandeDTO() {
		
		return cmd;
		
	}
	public void addLigne(Ligne_CommandeDTO ligne) {
		
		
		cmd.getLignes().add(ligne);
		float total=0;
		for(Ligne_CommandeDTO l:cmd.getLignes()) {
			total+=l.getSous_total();
		}
		cmd.setTotal(total);
			
		
	}
	public void addClient(ClientDTO dto) {
		
		cmd.setClient(dto);
		
		
	}
	public void save(CommandeDTO commandedto) {
		new CommandeDAO().create(this.toCommande(commandedto));
		
	}
	public Commande toCommande(CommandeDTO commandedto) {
		Commande commande=new Commande();
		commande.setDatecmd(commandedto.getDatecmd());
		
		commande.setClient(new ClientService().toClient(commandedto.getClient()));
		
		commande.setLignes(commandedto.getLignes().stream().map(ldto->new Ligne_CommandeService().toLigne(ldto)).collect(Collectors.toList()));
		commande.setTotal(commandedto.getTotal());
		return commande;
	}
	public void initialiserCommande() {
		cmd=null;
		createCommandDTO();
		
	}

}
