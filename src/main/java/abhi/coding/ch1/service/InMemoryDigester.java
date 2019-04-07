package abhi.coding.ch1.service;

import abhi.coding.ch1.util.HashDigestUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Abhishek on 4/4/2019.
 */
@Service("inMemoryDigester")
public class InMemoryDigester implements Digester {

    private final Log logger = LogFactory.getLog(InMemoryDigester.class);
    private static final Map<String, String> _theCache = new ConcurrentHashMap<>();

    @Autowired
    @Qualifier(value = "digesterUtil")
    private HashDigestUtil digestUtil;

    @Override
    public String encode(String message) {
        logger.info("InMemoryDigester.encode called");
        String hash = digestUtil.encode(message);
        _theCache.put(hash, message);
        logger.info("InMemoryDigester.encode completed");
        return hash;
    }

    @Override
    public String decode(String encodedMsg) {
        logger.info("InMemoryDigester.decode called");
        return _theCache.get(encodedMsg);
    }
}
