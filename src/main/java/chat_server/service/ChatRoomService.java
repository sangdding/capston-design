package chat_server.service;

import chat_server.dto.ChatRoomReqDto;
import chat_server.dto.ChatRoomResDto;
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

    public void createRoom(ChatRoomReqDto chatRoomReqDTO) {
        chatRoomRepository.save(
                    ChatRoom.builder()
                        .name(chatRoomReqDTO.getName())
                        .password(chatRoomReqDTO.getPassword())
                            .roomId(chatRoomReqDTO.getRoomId()).build());
    }

    public List<ChatRoomResDto> findAllRoom() {
        return chatRoomRepository.findAll().stream().map(ChatRoomResDto::new).collect(Collectors.toList());
    }

    public ResultDto<ChatRoomResDto> findRoom(String name) {
        Optional<ChatRoom> room = chatRoomRepository.findByName(name);
        return room.map(chatRoom -> ResultDto.ofSuccess("success", new ChatRoomResDto(chatRoom))).orElseGet(() -> ResultDto.ofFail("채팅방이 존재하지 않습니다."));
    }
}
