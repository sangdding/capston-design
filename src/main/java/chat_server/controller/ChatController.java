package chat_server.controller;

import chat_server.dto.ChatMessageDto;
import chat_server.repository.RedisRepository;
import chat_server.service.RedisPublishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
@Log4j2
public class ChatController {

    private final RedisPublishService redisPublishService;
    private final RedisRepository redisRepository;

    @MessageMapping("/chat/message")
    public void message(ChatMessageDto message) {
        if (ChatMessageDto.MessageType.ENTER.equals(message.getType())) {
            redisRepository.enterChatRoom(message.getRoomId());
            message.setMessage(message.getSender() + "님이 입장하셨습니다.");
        }
        redisPublishService.publish(redisRepository.getTopic(message.getRoomId()), message);
    }
}
