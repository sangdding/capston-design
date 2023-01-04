package chat_server.dto;

import chat_server.entity.ChatRoom;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ChatRoomResDto {

    private String name;
    private String roomId;

    public ChatRoomResDto(ChatRoom chatRoom) {
        this.name = chatRoom.getName();
        this.roomId = chatRoom.getRoomId();
    }
}
