package chat_server.service;

import chat_server.dto.ChatRoomReqDto;
import chat_server.dto.ChatRoomResDto;
import chat_server.dto.ResultDto;
import chat_server.entity.ChatRoom;
import chat_server.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomService {

    private final ChatRoomRepository chatRoomRepository;
    private final RedisMessageListenerContainer redisMessageListenerContainer; // 채팅방에 발행되는 메시지를 처리할 Listener
    private final RedisSubscribeService redisSubscribeService; // 구독 처리 서비스
    private final RedisTemplate<String, Object> redisTemplate;
    /*
    채팅방의 대화 메시지를 발행하기 위한 redis topic 정보.
    서버별로 채팅방에 매치되는 topic 정보를 Map에 넣어 roomId로 찾을 수 있도록 한다.
     */
    private HashOperations<String, String, ChatRoom> opsHashChatRoom;
    private Map<String, ChannelTopic> topics;

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

    public void enterChatRoom(String roomId) {
        ChannelTopic topic = topics.get(roomId);
        if (topic == null) {
            topic = new ChannelTopic(roomId);
            redisMessageListenerContainer.addMessageListener(redisSubscribeService, topic);
            topics.put(roomId, topic);
        }
    }


}
