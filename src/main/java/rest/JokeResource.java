package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Joke;
import utils.EMF_Creator;
import facades.JokeFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//Todo Remove or change relevant parts before ACTUAL use
@Path("Joke")
public class JokeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/Joke",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final JokeFacade FACADE = JokeFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public String demo()
    {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("all")
    @GET
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public String getAllJokes()
    {
        return GSON.toJson(FACADE.getAllJokes());
    }

    @GET
    @Path("{id}")
    @Produces(
            {
                MediaType.APPLICATION_JSON
            })
    public String update(Joke entities, @PathParam("id") long id)
    {
        return GSON.toJson(FACADE.getJokeById(id));
    }

    @Path("/populate")
    @GET
    @Produces(
    {
        MediaType.APPLICATION_JSON
    })
    public String PopulateMembers()
    {
        FACADE.populateJokes();
        return "{\"msg\":\"Populated\"}";
    }

}
