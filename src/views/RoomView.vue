<template>
  <h1>hi</h1>
  <body>
  <div>
    <h2>
      {{ room.name }}
    </h2>
  </div>
  <input type="text" v-model="message" v-on:keypress.enter="sendMessage">
  <button type="button" @clic="sendMessage">보내기</button>
  <ul>
    <li v-for="message in messages" :key="message">
      {{ message.sender }} - {{ message.message }}
    </li>
  </ul>
  </body>
</template>

<script>
import SockJS from 'sockjs-client'
import Stomp from 'stomp-websocket'

var sock = new SockJS("http://localhost:8080/ws-stomp");
var ws = new Stomp.over(sock);
var reconnect = 0;

export default {
  name: "RoomView",
  data: function () {
    return {
      roomId: '',
      room: {},
      sender: '',
      message: '',
      messages: []
    }
  },
  created() {
    this.roomId = localStorage.getItem('wschat.roomId')
    this.sender = localStorage.getItem('wschat.sender')
    this.connect();
  },
  methods: {
    sendMessage: function () {
      var t = this
      ws.send("/pub/chat/message", {}, JSON.stringify({
        type: 'TALK',
        roomId: t.roomId,
        sender: t.sender,
        message: t.message
      }));
      this.message = '';
    },
    recvMessage: function (recv) {
      this.messages.unshift({
        "type": recv.type,
        "sender": recv.type == 'ENTER' ? '[알림]' : recv.sender,
        "message": recv.message
      })
    },
    connect: function () {
      var t = this;
      ws.connect({}, () => {
        console.log(this)
        ws.subscribe("/sub/chat/room/" + t.roomId, function (message) {
          var recv = JSON.parse(message.body);
          t.recvMessage(recv);
        });
        ws.send("/pub/chat/message", {}, JSON.stringify({
          type: 'ENTER',
          roomId: t.roomId,
          sender: t.sender
        }))
      }, function (error) {
        if (reconnect++ <= 5) {
          setTimeout(function () {
            console.log(error.message);
            sock = new SockJS("http://localhost:8080/ws-stomp");
            ws = Stomp.over(sock);
            this.connect();
          }, 10 * 1000);
        }
      })
    }
  }
}
</script>

<style scoped>

</style>