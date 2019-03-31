package abhi.coding.ch1.rest;

import abhi.coding.ch1.HashDigestUtil;
import abhi.coding.ch1.model.Digest;
import abhi.coding.ch1.model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Abhishek on 3/24/2019.
 */
@Path("messages")
public class MessageDigesterResource {

    private final HashDigestUtil util = HashDigestUtil.getInstance();

//    @Path("/hi")
//    @GET
//    public String getHello(){
//        return "Hi Hello";
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{hash}")
    public Response getDigestedMsg(@PathParam("hash") String hash){
        String origMsg = util.decode(hash);
        if (origMsg == null || "".equals(origMsg)){
            String err_msg = "kuchh to gabbad hai";
//            Response.
            return Response.status(404).entity(err_msg).build();
        }
//        Message msg = new Message();
//        msg.setMessage(origMsg);
        return Response.status(200).entity(origMsg).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/")
    public Response digestMessage(String message){
        String hash = util.encode(message);
        Digest digested = new Digest(hash);
        return Response.status(200).entity(digested).build();
    }
}
