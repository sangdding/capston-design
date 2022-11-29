<template>
  <h5>채팅방 생성</h5>
  <form>
    <div>
      <label for="name">이름</label>
      <input id="name" type="text" v-model="name">
    </div>
    <div>
      <label for="password">비밀번호</label>
      <input id="password" type="text" v-model="password">
    </div>
    <div>
      <button type="submit" @click="closePopup">뒤로가기</button>
      <button type="submit" @click="makeRoomForm">생성</button>
    </div>
  </form>
</template>

<script>
export default {
  name: "makeRoomView",
  data: function () {
    return {
      name: '',
      password: ''
    }
  },
  methods: {
    closePopup: function () {
      this.$emit('close-popup')
    },
    makeRoomForm: function () {
      var data = {
        name: this.name,
        password: this.password
      }
      this.axios.post("/chats/makeRoom", data)
          .then(function (response) {
            if (response.status === 200) {
              alert("성공적으로 저장되었습니다.")
            }
            console.log(response)
          })
          .catch(function (error) {
            console.log(error);
          });
    },
  }
}
</script>

<style scoped>

</style>