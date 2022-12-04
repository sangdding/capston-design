package chat_server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "chatrooms")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "roomId")
    private String roomId;

    @Builder
    public ChatRoom(String name, String password, String roomId) {
        this.name = name;
        this.password = password;
        this.roomId = roomId;
    }
}
