package chat_server.repository;

import chat_server.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

    List<ChatRoom> findAllRooms();

    Optional<ChatRoom> findRoomById(Long id);

    ChatRoom save(String name);
}
