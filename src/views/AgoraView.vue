<template>
  <div>
    <div>
      <h1>아고라</h1>
    </div>
    <div>
      <ul>
        <li v-for="name in roomList" :key="name" v-on:click="enterRoom(name.roomId)">
          {{name}}
        </li>
      </ul>
    </div>
    <ModalView v-if="isModalViewed" @close-modal="isModalViewed=false">
      <MakeRoomView/>
    </ModalView>
    <button @click="isModalViewed=true">토론방 개설하기</button>
  </div>
</template>

<script>
import MakeRoomView from "@/components/MakeRoomView";
import ModalView from "@/components/ModalView";
export default {
  name: 'AgoraView',
  components: {
    MakeRoomView,
    ModalView
  },
  data() {
    return {
      isModalViewed: false,
      roomList: []
    }
  },
  created() {
    this.getRoomList()
  },
  methods: {
     getRoomList: function () {
      this.axios.get("/chats/")
          .then(response => {
            console.log(response)
            this.roomList = response.data.data
          })
          .catch(error => {
            alert(error.message)
          })
    },
    enterRoom: function(roomId) {
       var sender = prompt('대화명을 입력해 주세요.');
       if (sender != "") {
         localStorage.setItem('wschat.sender', sender);
         localStorage.setItem('wschat.roomId', roomId);
         location.href="chat/room";
       }
    }
  }
};
</script>

<style scoped>
.background {
  background-color: black;
  opacity: 0.5;
}
</style>