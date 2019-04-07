package abhi.coding.ch1.rest;

import abhi.coding.ch1.util.HashDigestUtil;
import abhi.coding.ch1.model.Digest;
import abhi.coding.ch1.model.Message;
import abhi.coding.ch1.service.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created by Abhishek on 3/24/2019.
 */
@RestController
@RequestMapping("/messages")
public class MessageDigesterResource {

    private final Log logger = LogFactory.getLog(MessageDigesterResource.class);

    @Autowired(required = true)
    @Qualifier(value = "inMemoryDigester")
    private Digester digester;

    @RequestMapping(value = "/", consumes = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Digest> digestMessage(@RequestBody Message message){
        logger.info("Request received to digest");
        String hash = digester.encode(message.getMessage());
        Digest digested = new Digest(hash);
        logger.info("Returning success response");
        return  new ResponseEntity<Digest>(digested, HttpStatus.OK);
    }

    @RequestMapping(value = "/{hash}", produces = "application/json", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Message> getDigestedMsg(@PathVariable("hash") String hash){
        logger.info("Request received for hash="+hash);
        String origMsg = digester.decode(hash);
        logger.info("Orig msg for hash="+hash);
        if (origMsg == null || "".equals(origMsg)){
            String err_msg = "Message not found";
            logger.info("Returning error response");
            return new ResponseEntity<Message>(new Message(err_msg), HttpStatus.NOT_FOUND);
        }
        logger.info("Returning success response");
        return new ResponseEntity<Message>(new Message(origMsg), HttpStatus.OK);
    }

}
