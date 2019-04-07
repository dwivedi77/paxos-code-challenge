package abhi.coding.ch1;

import abhi.coding.AppConfig;
import abhi.coding.ch1.service.Digester;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Abhishek on 4/5/2019.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Import(AppConfig.class)
public class DigesterTest {

    @Autowired(required = true)
    @Qualifier(value = "inMemoryDigester")
    private Digester inMemoryDigester;

    @Test
    public void testInMemoryDigester(){
        String origMsg = "Some test messages";
        String hash = inMemoryDigester.encode(origMsg);

        assertNotEquals(origMsg, hash);

        String decoded = inMemoryDigester.decode(hash);

        assertEquals(decoded, origMsg);
    }

}
