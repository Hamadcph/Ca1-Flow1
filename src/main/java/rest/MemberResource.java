package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.GroupMember;
import utils.EMF_Creator;
import facades.MemberFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("Member")
public class MemberResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/member",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final MemberFacade FACADE =  MemberFacade.getMemberFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    
    
@Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMembers() {
        return GSON.toJson(FACADE.getAllMembers());
    }
}
