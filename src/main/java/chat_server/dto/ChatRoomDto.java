package chat_server.dto;

import chat_server.entity.ChatRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class ChatRoomDto {

    private String name;
    private String password;

    public ChatRoomDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Builder
    public ChatRoomDto(ChatRoom chatRoom) {
        this.name = chatRoom.getName();
    }
}
