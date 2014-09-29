package za.co.blacklemon.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import za.co.blacklemon.ejb.IClientManager;
import za.co.blacklemon.entities.Client;

@Path("/clients")
@Stateless
public class ClientResource {
    @EJB
    private IClientManager manager;
    
    @GET
    @Produces("application/json")
    public List<Client> getAll() {
        return manager.getAll();
    }
    
    @GET
    @Produces("application/json")
    @Path("/{id}")
    public Client get(@PathParam("id") Long id) {
        return manager.get(id);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Client addClient(Client client) {
        return manager.save(client);
    }
    
    @GET
    @Produces("application/json")
    @Path("/example")
    public Client getExample() {
        Client c = new Client();
        c.setFirstName("Firstname");
        c.setSurname("Surname");
        c.setId(1L);
        c.setDescription("Description");
        c.setContactNumber("021-555-5555");
        return c;
    }

    @Path("/test")
    @GET
    @Produces("text/plain")
    public String test() {
        return "test";
    }
}
