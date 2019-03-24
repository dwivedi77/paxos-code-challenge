package abhi.coding.ch1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * Created by Abhishek on 3/22/2019.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class HashDigestUtilTest {

    HashDigestUtil util;
    @Before
    public void setUp() throws Exception {
        util = HashDigestUtil.getInstance();
    }

    @Test
    public void testEncode(){
        String msg = "Very very crypted msg";
        String encoded = util.encode(msg);
        System.out.println("encoded = " + encoded);
        String decoded = util.decode(encoded);
        Assert.assertEquals(decoded, msg);
    }
}
