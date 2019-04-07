package abhi.coding.ch2;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Abhishek on 4/5/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BestGiftTest {

    @Autowired
    @Qualifier("bestGift")
    BestGift bg;

    @Test
    public void testSplitIntoTwo(){
        Integer[] prices = new Integer[]{500, 700, 1000, 1400, 2000, 6000};
        String[] items = new String[]{"Candy Bar", "Paperback Book", "Detergent", "Headphones", "Earmuffs", "Bluetooth Stereo"};

        GiftInfo info = bg.splitInToTwo(prices, items, 1200);
        Assert.assertEquals("Candy Bar 500", info.getGifts()[0]);
        Assert.assertEquals("Paperback Book 700", info.getGifts()[1]);

        GiftInfo info2 = bg.splitInToTwo(prices, items, 1300);
        Assert.assertEquals("Candy Bar 500", info2.getGifts()[0]);
        Assert.assertEquals("Paperback Book 700", info2.getGifts()[1]);

        GiftInfo info3 = bg.splitInToTwo(prices, items, 2500);
        Assert.assertEquals("Candy Bar 500", info3.getGifts()[0]);
        Assert.assertEquals("Earmuffs 2000", info3.getGifts()[1]);

    }
}
