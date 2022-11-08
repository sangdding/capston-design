package chat_server.entity;

import javax.persistence.*;

@Entity
@Table(name = "CHATROOM")
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

}
