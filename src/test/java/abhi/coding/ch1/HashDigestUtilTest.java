package abhi.coding.ch1;

import abhi.coding.AppConfig;
import abhi.coding.ch1.util.HashDigestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Abhishek on 3/22/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(AppConfig.class)
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
    }
}
