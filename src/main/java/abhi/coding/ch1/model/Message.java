package abhi.coding.ch1.model;

/**
 * Created by Abhishek on 3/24/2019.
 */
public class Message {
    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
