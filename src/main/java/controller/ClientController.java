package controller;

import dto.ClientDTO;
import service.ClientService;
import java.util.List;

public class ClientController {
public void ajouterClient(ClientDTO clientdto) {
	ClientService clientservice=new ClientService();
	clientservice.create(clientdto);

}
public void modifierClient(ClientDTO clientdto, int id) {
	ClientService clientservice=new ClientService();
	clientservice.update(clientdto, id);

}
public boolean supprimerClient(int id) {
	ClientService clientservice=new ClientService();
	return clientservice.delete(id);

}
public ClientDTO getClientDTO(int id) {
	ClientService clientservice=new ClientService();
	return clientservice.getClientDTO(id);
	
}

public static List<ClientDTO> retreive()
{
    ClientService cs =  new ClientService() ;
	return cs.retreive() ;
}
}
