package za.co.blacklemon.ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import za.co.blacklemon.entities.Client;

@LocalBean
@Stateless
public class ClientManager implements IClientManager {
    @PersistenceContext(name = "puOpenJPA_Gym",type = PersistenceContextType.TRANSACTION)
    private EntityManager dao;

    @Override
    public Client get(Long id) {
        return dao.find(Client.class, id);
    }

    @Override
    public List<Client> getAll() {
        return dao.createNamedQuery(Client.SELECT_ALL).getResultList();
    }

    @Override
    public Client save(Client client) {
        dao.merge(client);
        dao.flush();
        return client;
    }
}
