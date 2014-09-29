package za.co.blacklemon.ws;

import java.io.File;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import za.co.blacklemon.ejb.IClientManager;
import za.co.blacklemon.entities.Client;

@Path("/photos")
@Stateless
public class ClientPhotoResource {
    private static final String PATH = "/Data/Gym/";
    
    @EJB
    private IClientManager manager;

    @GET
    @Path("/{id}")
    @Produces("image/png")
    public Response getPhoto(@PathParam("id") Long id) {
        Client c = manager.get(id);

        String path = PATH + c.getPhoto();

        File img = new File(path);

        Response.ResponseBuilder response = Response.ok((Object) img);
        response.header("Content-Disposition", "attachment; filename=" + c.getPhoto());
        return response.build();

    }

}
