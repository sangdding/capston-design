package chat_server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatMessageDto {

    public enum MessageType {
        ENTER, QUIT, TALK
    }

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
    private long userCount;

}