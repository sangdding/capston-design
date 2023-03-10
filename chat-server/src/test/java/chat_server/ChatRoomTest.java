package chat_server;

import chat_server.dto.ChatRoomReqDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.CrossOrigin;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ChatRoomTest {

    @Autowired
    ObjectMapper mapper;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("채팅방 저장 테스트")
    public void saveRoom() throws Exception {
        //given
        ChatRoomReqDto chatRoomReqDto = new ChatRoomReqDto("name", "password");
        //when
        String body = mapper.writeValueAsString(
                chatRoomReqDto
        );
        //then
        mockMvc.perform(post("/chats/makeRoom")
                        .content(body)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }
}
