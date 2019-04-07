package abhi.coding.ch2.rest;

import abhi.coding.ch2.BestGift;
import abhi.coding.ch2.GiftInfo;
import abhi.coding.ch2.model.GiftRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Abhishek on 4/7/2019.
 */
@RestController
@RequestMapping("/gifts")
public class BestGiftResource {

    @Autowired
    @Qualifier("bestGift")
    BestGift bg;

    @RequestMapping(value = "/splitintotwo", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<GiftInfo> splitIntoTwo(@RequestBody GiftRequest request){
        GiftInfo info = bg.splitInToTwo(request.getPrices(), request.getItems(), request.getGiftCard());
        return new ResponseEntity<GiftInfo>(info, HttpStatus.OK);
    }

    @RequestMapping(value = "/splitintothree", produces = "application/json", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<GiftInfo> splitIntoThree(@RequestBody GiftRequest request){
        GiftInfo info = bg.splitInToThree(request.getPrices(), request.getItems(), request.getGiftCard());
        return new ResponseEntity<GiftInfo>(info, HttpStatus.OK);
    }

}
