package Model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MessageNotebook extends RealmObject {

    @PrimaryKey
    private int message_id;

    private String message;

    public MessageNotebook() {
        this.message_id = 0;
        this.message = "Test message";
    }
    public MessageNotebook(int message_id, String message) {
        this.message_id = message_id;
        this.message = message;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
