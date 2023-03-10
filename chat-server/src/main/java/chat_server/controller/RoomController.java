package chat_server.controller;

import chat_server.dto.ChatRoomReqDto;
import chat_server.dto.ChatRoomResDto;
import chat_server.dto.ResultDto;
import chat_server.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/chats")
@Log4j2
public class RoomController {

    private final ChatRoomService chatRoomService;

    // 채팅방 목록 조회
    @GetMapping(value = "/")
    public ResultDto<List<ChatRoomResDto>> rooms() {
        log.info("#All Chat Rooms");
        try {
            return ResultDto.ofSuccess(null, chatRoomService.findAllRoom());
        } catch (Exception e) {
            return ResultDto.ofFail(e.getMessage());
        }
    }

    // 채팅방 개설
    @PostMapping(value = "/makeRoom")
    public ResultDto<Object> create(@RequestBody ChatRoomReqDto chatRoomReqDTO) {
        log.info("#Make Rooms");
        try {
            chatRoomService.createRoom(chatRoomReqDTO);
            return ResultDto.ofSuccess("success", null);
        } catch (Exception e) {
            return ResultDto.ofFail(e.getMessage());
        }
    }

    // 채팅방 조회
    @GetMapping("/room")
    public ResultDto<ChatRoomResDto> getRoom(String name) {
        return chatRoomService.findRoom(name);
    }
}
