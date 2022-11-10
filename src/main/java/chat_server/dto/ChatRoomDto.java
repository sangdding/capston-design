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
//    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public ChatRoomDto(ChatRoom chatRoom) {
        this.name = chatRoom.getName();
    }
}
