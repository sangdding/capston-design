package chat_server.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
public class ChatRoomReqDto {

    private String name;
    private String password;
    private String roomId;

    public ChatRoomReqDto(String name, String password) {
        this.name = name;
        this.password = password;
        this.roomId = UUID.randomUUID().toString();
    }
}
