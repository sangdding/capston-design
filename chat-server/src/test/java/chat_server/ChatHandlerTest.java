package chat_server;

import chat_server.handler.ChatHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChatHandlerTest {

    @Mock
    WebSocketSession session;

    private static final String URL = "ws://localhost:8080/chat";

    @BeforeEach
    void setUp() {
        this.session = mock(WebSocketSession.class);
    }

    @Test
    public void webSocketSessionTest() throws Exception {
        TextMessage textMessage = new TextMessage("Test Message".getBytes());
        ChatHandler chatHandler = new ChatHandler();
        chatHandler.afterConnectionEstablished(session);
        chatHandler.handleMessage(session, textMessage);
        chatHandler.afterConnectionClosed(session, CloseStatus.GOING_AWAY);
    }

}
