package abhi.coding.ch1.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Abhishek on 3/17/2019.
 */
public final class HashDigestUtil {
    private static final Log logger = LogFactory.getLog(HashDigestUtil.class);

    private static MessageDigest digester;

    private static boolean initialized = false;
    private static HashDigestUtil instance = null;

    private HashDigestUtil(MessageDigest digester) {
        this.digester = digester;
    }

    public static HashDigestUtil getInstance(){
        if (!initialized){
            synchronized (HashDigestUtil.class){
                if (!initialized){
                    try {
                        MessageDigest digester = MessageDigest.getInstance("SHA-256");
                        instance = new HashDigestUtil(digester);
                        initialized = true;
                    } catch (NoSuchAlgorithmException e) {
                        logger.error("Error creating HashDigestUtil instance.", e);
                        throw new RuntimeException("Fatal Error, server can not start.");
                    }
                }
            }
            return instance;
        }else{
            return instance;
        }
    }

    public String encode(String message){
        digester.update(message.getBytes());
        byte[] hash = digester.digest();
        String hexValue = byteToHex(hash);
        return hexValue;
    }

    private String byteToHex(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

}
