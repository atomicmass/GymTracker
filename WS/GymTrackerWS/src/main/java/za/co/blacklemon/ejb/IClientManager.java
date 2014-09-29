package za.co.blacklemon.ejb;

import java.util.List;
import javax.ejb.Local;
import za.co.blacklemon.entities.Client;

@Local
public interface IClientManager {
    public Client get(Long id);
    public List<Client> getAll();
    public Client save(Client client);
}
