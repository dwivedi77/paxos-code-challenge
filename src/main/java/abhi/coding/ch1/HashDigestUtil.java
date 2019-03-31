package abhi.coding.ch1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Abhishek on 3/17/2019.
 */
public final class HashDigestUtil {

    private static MessageDigest digester;

    private static final Map<String, String> _theCache = new ConcurrentHashMap<>();

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
                        // TODO handle it well.
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
        _theCache.put(hexValue, message);
        return hexValue;
    }

    private String byteToHex(byte[] hash) {
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public String decode(String encodedMsg){
        return _theCache.get(encodedMsg);
    }

}
