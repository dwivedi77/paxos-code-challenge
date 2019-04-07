package abhi.coding.ch1.model;

/**
 * Created by Abhishek on 3/24/2019.
 */
public class Digest {
    public Digest() {
    }

    public Digest(String digest) {
        this.digest = digest;
    }

    private String digest;

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    @Override
    public String toString() {
        return "Digest{" +
                "digest='" + digest + '\'' +
                '}';
    }
}
