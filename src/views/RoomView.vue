<template>
  <h1>hi</h1>
  <body>
  <div>
    <h2>
      {{room.name}}
    </h2>
  </div>
  <input type="text" v-model="message" v-on:keypress.enter="sendMessage">
  <button type="button" @clic="sendMessage">보내기</button>
  <ul>
    <li v-for="message in messages" :key="message">
      {{message.sender}} - {{message.message}}
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
    this.findRoom();
    connect();
  },
  methods: {
    findRoom: function () {
      this.axios.get('/chat/room/' + this.roomId).then(response => {
        this.room = response.data;
      });
    },
    sendMessage: function () {
      ws.send("/pub/chat/message", {}, JSON.stringify({
        type: 'TALK',
        roomId: this.roomId,
        sender: this.sender,
        message: this.message
      }));
      this.message = '';
    },
    recvMessage: function (recv) {
      this.message.unshift({
        "type": recv.type,
        "sender": recv.type == 'ENTER' ? '[알림]' : recv.sender,
        "message": recv.message
      })
    }
  }
}

function connect() {
  ws.connect({}, function () {
    ws.subscribe("/sub/chat/room/" + this.data.roomId, function (message) {
      var recv = JSON.parse(message.body);
      this.recvMessage(recv);
    });
    ws.send("/pub/chat/message", {}, JSON.stringfy({type: 'ENTER', roomId: this.data.roomId, sender: this.data.sender}))
  }, function (error) {
    if (reconnect++ <= 5) {
      setTimeout(function () {
        console.log(error.message);
        sock = new SockJS("http://localhost:8080/ws-stomp");
        ws = Stomp.over(sock);
        connect();
      }, 10 * 1000);
    }
  })
}
</script>

<style scoped>

</style>