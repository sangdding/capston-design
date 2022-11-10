package chat_server.service;

import chat_server.dto.ChatRoomDto;
import chat_server.dto.ResultDto;
import chat_server.entity.ChatRoom;
import chat_server.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;

    public void createRoom(ChatRoomDto chatRoomDTO) throws Exception {
        chatRoomRepository.save(
                    ChatRoom.builder()
                        .name(chatRoomDTO.getName())
                        .password(chatRoomDTO.getPassword()).build());
    }

    public List<ChatRoomDto> findAllRoom() {
        return chatRoomRepository.findAll().stream().map(ChatRoomDto::new).collect(Collectors.toList());
    }

    public ResultDto<ChatRoomDto> findRoom(String name) {
        Optional<ChatRoom> room = chatRoomRepository.findByName(name);
        return room.map(chatRoom -> ResultDto.ofSuccess("success", new ChatRoomDto(chatRoom))).orElseGet(() -> ResultDto.ofFail("채팅방이 존재하지 않습니다."));
    }
}
