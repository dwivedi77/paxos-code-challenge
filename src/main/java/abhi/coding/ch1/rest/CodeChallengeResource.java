package abhi.coding.ch1.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Abhishek on 3/24/2019.
 */
@Path("messages")
public class CodeChallengeResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getDigestedMsg(String message){
        return null;
    }
}
